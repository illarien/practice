package Quizes;

import java.util.HashSet;

public class OddElementGenerics {

	public static Integer[] integ = {1,2,3,4,3,2,4};
	public static String[] words = {"a", "b","c","a","b"};
	public static Object[] nul;
	
	
	public static <E> HashSet<E> getOddElement (E[] input ) {
		if (input == nul) {
			return null;
		}
		
		HashSet<E> hs = new HashSet<E>();
		
		for(E e: input) {
			if (hs.contains(e)) {
				hs.remove(e);
			} else {
				hs.add(e);
			}
		}
		//check size of hs
		return hs;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(getOddElement(integ));
		System.out.println(getOddElement(words));
		System.out.println(getOddElement(nul));
	}

}
