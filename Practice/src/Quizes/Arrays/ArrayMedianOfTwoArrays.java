package Q;

import java.util.Arrays;

public class ArrayMedianOfTwoArrays {

	public static void main(String[] args) {
		int[] ar1 = {1,3,5,7,9,11};
		int[] ar2 = {0,2,4,6,8,10};
		Arrays.sort(ar1);
		Arrays.sort(ar2);
		
		int n = ar1.length;
		int a=0,b=0;
		// n-1 !!!
		for (int i = 0; i<n-1; i++) {
			if (ar1[a] <= ar2[b]) {
				a++;
			} else if (ar1[a] > ar2[b]) {
				b++;
			}
		}
		
		float m = (float)(ar1[a] + ar2[b])/2;
		
		System.out.println(a + " " + b);
		System.out.println(ar1[a] + " " + ar2[b] + " " + m );

	}

}
