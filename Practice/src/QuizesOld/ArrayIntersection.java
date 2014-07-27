package QuizesOld;

// Intersection of to arrays

import java.util.*;



public class ArrayIntersection {

	public static HashSet<Integer> intersection(int[] a1, int[] a2) {
	
		HashSet<Integer> s = new HashSet<Integer>();
		HashSet<Integer> out = new HashSet<Integer>();
		for(int e : a1) {
			s.add(e);
		}
		
		for(int e: a2) {
			if (s.contains(e)) {
				out.add(e);
			}
		}
		
		return out;
	}
	
	
	
	
	public static void main(String[] args) {
		int[] ar1 = {1,2,3,5,2,4,1,8,9,7,11};
		int[] ar2 = {1,3,5,7,9,2,1,4,6,5,8};
		
		System.out.println(intersection(ar1, ar2));
		
		

	}

}
