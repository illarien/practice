package Quizes.LinkedList;

import java.util.*;

public class LinkedListObjects {

	public static <E> void findUnique(List<E> l) {
		HashMap<E, Integer> hm = new HashMap<E, Integer>();
		for (E e: l) {
			if ( !hm.containsKey(e) ) {hm.put(e, 1); continue;}
			if ( ( hm.get(e)).equals(1) ) { hm.remove(e); continue;}
		}
		System.out.println("HM: " + hm);
	}
	
	public static void main(String[] args) {
		List<String> l = new LinkedList<String>();
		
		l.add("asd");
		l.add("dfg");
		l.add("asd");
		l.add("dfg");
		l.add("asd");
		
		System.out.println("List: "+ l);
		
		findUnique(l);
	}
	
}
