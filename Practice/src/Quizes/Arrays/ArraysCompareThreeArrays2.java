package Quizes.Arrays;

import java.util.*;

public class ArraysCompareThreeArrays2 {

	public static boolean in(int e, int[] ar) {
		for (int i:ar) {
			if (e == i) return true;
		}
		return false;
	}
	
	public static void printArray(int[] a) {
		for(int e: a) {
			System.out.print(e + " ");
		}
	}
	
	public static Set<Integer> addToSet (int[] a) {
		Set<Integer> out = new HashSet<Integer>();
		for (int i:a) {
			out.add(i);
		}
		return out;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7,9,11}; 
		int[] arr2 = {1,2,3,5,4,1,8,9,7,11};
		int[] arr3 = {1,3,5,7,9,2,1,4,6,5,8};
		
		Arrays.sort(arr1);
		
		Set<Integer> elem = new HashSet<Integer>();
		Set<Integer> out = new HashSet<Integer>();
		Set<Integer> out2 = new HashSet<Integer>();
		for (int i:arr1) {
			elem.add(i);
		}
		for (int i:arr2) {
			elem.add(i);
		}

		System.out.println(elem);
		
		for(int e:elem) {
			if (in(e,arr1) & in(e,arr2) ) out.add(e);
		}
		System.out.println(out.size() + " " + out);
		
		
	
	}

}
