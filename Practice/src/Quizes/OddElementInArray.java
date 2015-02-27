package Quizes;

import java.util.*;

// Find odd element in array
 
public class OddElementInArray {

	public static <E> HashSet<E> findOddElement(E[] inArr) {
		HashSet<E> hs = new HashSet<E>();
		for (E e : inArr) {
			if (hs.contains(e)) {
				hs.remove(e);
			} else {
				hs.add(e);
			}
		}
		System.out.println("in method " + hs);
		return hs;
	}
	
	
	
	public static void main(String[] args) {
		String[] str = {"b", "a", "b"};
		Integer[] intg = {1,2,3,3,2};
		
		System.out.println(findOddElement(str).toString());
		System.out.println(findOddElement(intg).toString());
	}

}
