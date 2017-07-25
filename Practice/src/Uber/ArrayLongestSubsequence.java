package Uber;

import java.util.Arrays;

/**
 * https://habrahabr.ru/post/113108/
 */
public class ArrayLongestSubsequence {
	
	public static void main(String[] args) {
		int[] arr = {2, 8, 5, 9, 12, 6};
//		int[] arr = {10, 8, 5, 9, 12, 6};
		int[] length = new int[arr.length]; // subs length for an element
		int[] path = new int[arr.length]; // path to restore subs
		
		//for first element
		length[0] = 1;
		path[0] = 0;
		
		for (int i = 1; i < arr.length; i++) { // candidate
			for (int j = 0; j < i; j++) { // potential subseq
				if (arr[i] > arr[j]) {
					length[i] = length[j]+1;
					path[i] = j;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(length));
		System.out.println(Arrays.toString(path));
		
		//get max length
		int maxSubPos = 0;
		int tmpLength = 0;
		for (int i = 0; i < length.length; i++) {
			if (length[i] > tmpLength) {
				maxSubPos = i;
				tmpLength = length[i];
			}
		}
		System.out.println("Max length: " + tmpLength + " for Element at poition: " + maxSubPos);
		
		// subsequence
		String seq = "";
		boolean continueFlag = true;
		while (maxSubPos >= 0 && continueFlag ) {
			continueFlag = maxSubPos != 0 && length[maxSubPos] > 0; // should add last element only once
			seq += arr[maxSubPos]+",";
			maxSubPos = path[maxSubPos];
		}
		System.out.println("Longest subsequence: " + seq);
	}

}
