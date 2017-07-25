package recaling1;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ThreeElementSum {

	private static int[] arr = {1,2,3,-1,5,-2,6,8,9};
	
	private static boolean hasSum(int[] arr, int sum) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length-2; i++) {
			int j = i+1;
			int k = arr.length-1;
			while (k >= j) {
				int tmpSum = arr[i] + arr[j] + arr[k];
				if (tmpSum == sum) {
					System.out.println( arr[i] + " " + arr[j] + " " + arr[k]);
					return true;
				}
				if (tmpSum > sum) {
					k-- ;
				} else {
					j++;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.print(hasSum(arr, 7));
	}
	
}
