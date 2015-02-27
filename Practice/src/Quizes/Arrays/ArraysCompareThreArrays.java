package Quizes.Arrays;

// duplicates in arrays

import java.util.*;

public class ArraysCompareThreArrays {

	public static int[] findDuplicates(int[] a1, int[] a2) {
		Set<Integer> a3 = new LinkedHashSet<Integer>();
		for (Integer e: a1) {
			for (Integer d: a2) {
				if ( e.equals(d) ) {
					a3.add(e);
				}
			}	
		}	
		int[] a = setToInt(a3);
		return a;
	}
	
	public static int[] findUnique(int[] a1, int[] a2) {
		int[] dupl = findDuplicates(a1, a2);
		Set<Integer> out = new HashSet<Integer>();
		for (int i:a1) {
			out.add(i);
		}
		for (int i:a2) {
			out.add(i);
		}
		for (int i:dupl) {
			out.remove(i);
		}
		return setToInt(out);
	}
	
	public static int[] setToInt(Set<Integer> set) {
		  int[] a = new int[set.size()];
		  int i = 0;
		  for (Integer val : set) a[i++] = val;
		  return a;
		}
	
	public static void printArray(int[] a) {
		for(int e: a) {
			System.out.print(e + " ");
		}
	}
	
	public static void main(String[] args) {
		 int[] arr1 = {1,3,5,7,9,11}; 
		 int[] arr2 = {1,2,3,5,4,1,8,9,7,11};
		 int[] arr3 = {1,3,5,7,9,2,1,4,6,5,8};
		 int[] arr4 = findDuplicates(arr1, arr2);
		 printArray(arr4);
		 System.out.println("aaa");
		 printArray(arr3);
		 System.out.println("bbb");
		 printArray(findUnique(arr3, arr4));
	}

}
