package Quizes.Arrays;

import java.util.*;

// 2) Given an int array, write a program that returns an array with all duplicates removed (e.g. given [1, 2, 2, 3], return [1, 2, 3])



public class ArrayRemoveDuplicates {

	public static int[] arr = {1,2,2,3,4,5};
	public static HashSet<Integer> hs = new HashSet<Integer>();
	
	
	
	public static void main(String[] args) {
	
		for(int i : arr) {
			hs.add(i);
		}
		int[] arr2 = new int[hs.size()];
		Object[] arrObj = hs.toArray();
		
		for(int i=0; i < arrObj.length; i++) {
			arr2[i] = (Integer) arrObj[i];
		}
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
	}

}
