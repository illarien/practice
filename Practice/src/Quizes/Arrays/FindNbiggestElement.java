package Quizes.Arrays;

import java.util.Arrays;

//ravikanth.konda@citrix.com
// find n-th biggest element in union of two sorted arrays
public class FindNbiggestElement {

	public static int findElement2(int[] a1, int[] a2, int n ) {		
		
		if (n > (a1.length + a2.length) || n == 0) {
			throw new WrongIndexException();
		}
		
		int c1 = 0, c2 = 0, out = a1[0] < a2[0] ? a1[0] : a2[0];
		
		for (int i = 0; i < n; i++) {
			if ( a1[c1] < a2[c2] ) {
				out = a1[c1];
				c1++;
				continue;
			} else {
				out = a2[c2];
				c2++;
			}
		}
		return out;
	}
	
	public static int findElement(int[] a1, int[] a2, int n ) {	
		if (n > (a1.length + a2.length) || n == 0) {
			throw new WrongIndexException();
		}
		
		int[] out = new int[a1.length + a2.length];
		
		for (int i = 0; i < a1.length; i++) {
			out[i] = a1[i];
		}
		for (int i = 0; i < a2.length; i++) {
			out[i+a1.length] = a2[i];
		}
		Arrays.sort(out);
		return out [n-1];
	}

	public static void main(String[] args) {         
		int[] array1 = {1, 4, 7, 17, 18, 19, 20};         
		int[] array2 = {5, 9, 13, 14, 17, 21};         
		System.out.println("element:" + findElement(array1, array2, 8));  
		System.out.println("element:" + findElement2(array1, array2, 8));  
	}
}


