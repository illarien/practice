package QuizesOld;

import java.util.*;

public class ArraysCompareThreeArrays3 {

	public static void printArray(int[] a) {
		for(int e: a) {
			System.out.print(e + " ");
		}
	}
	
	public static int[] setToInt(Set<Integer> set) {
		  int[] a = new int[set.size()];
		  int i = 0;
		  for (Integer val : set) a[i++] = val;
		  return a;
		}
	
	
	public static int[] findDuplicates(int[] a1, int[] a2) {
		Map<Integer,Integer> m = new HashMap<Integer,Integer>(15, 1);
		Set<Integer> s = new HashSet<Integer>();
		for(int e:a1) {
			if(m.get(e) == null) {m.put(e, 1);}
			else {m.put(e, (m.get(e) + 1)); }
		}
		for(int e:a2) {
			if(m.get(e) == null) {m.put(e, 1);}
			else {m.put(e, (m.get(e) + 1)); }
		}
	    Iterator it = m.entrySet().iterator();
	    while (it.hasNext()) {
	    	Map.Entry pairs = (Map.Entry)it.next();
	    	if( pairs.getValue().equals(1) ) {
	    	    it.remove();
	        }
	    	else {
	    		s.add((Integer)pairs.getKey());
	    	}
	    }
	    return setToInt(s);
	}
	
	
	public static int[] findUnique(int[] a1, int[] a2) {
		Map<Integer,Integer> m = new HashMap<Integer,Integer>(15, 1);
		Set<Integer> s = new HashSet<Integer>();
		for(int e:a1) {
			if(m.get(e) == null) {m.put(e, 1);}
			else {m.put(e, (m.get(e) + 1)); }
		}
		for(int e:a2) {
			if(m.get(e) == null) {m.put(e, 1);}
			else {m.put(e, (m.get(e) + 1)); }
		}
	    Iterator it = m.entrySet().iterator();
	    while (it.hasNext()) {
	    	Map.Entry pairs = (Map.Entry)it.next();
	    	if( pairs.getValue().equals(1) ) {
	    		s.add((Integer)pairs.getKey());
	        }
	    	else {
	    		 it.remove();
	    	}
	    }
	    return setToInt(s);
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
