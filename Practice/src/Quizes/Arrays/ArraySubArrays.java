package Quizes.Arrays;

import java.util.ArrayList;

public class ArraySubArrays {
	
	
	private static ArrayList<int[]> getSubArrays(int[] original) {
		// add null/empty check
		ArrayList<int[]> result = new ArrayList<int[]>();
		result.add(original);
		if (original.length < 2) {
//			result.add(original);
			return result;
		}
		for (int i = 0; i < original.length; i++) {
			result.addAll(getSubArrays(getSubArray(original, i)));
		}
		return result;
	}
	
	private static int[] getSubArray(int[] original, int i) {
		int[] result = new int[original.length-1];
		int pos = 0;
		for (int j = 0; j < original.length; j++) {
			if (j != i) {
				result[pos++] = original[j];
			}
		}
		return result;
	}
	
	private static void printArrayList(ArrayList<int[]> input) {
		for(int[] a: input) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
		}
	}
	
	public static void main (String...  args) {
		int[] input = {1,2,3};
		ArrayList<int[]> res = getSubArrays(input);
		
		System.out.println("Size: " + res.size());
		
		printArrayList(res);
		
		
	}

}
