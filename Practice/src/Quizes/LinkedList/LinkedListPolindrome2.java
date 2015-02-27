package Quizes.LinkedList;

import java.util.*;


public class LinkedListPolindrome2 {

	public static String listToString(List<String> in) {
		String out = "";
		Iterator<String> itr = in.iterator();
		while (itr.hasNext()) {
			out += itr.next();
		}
		System.out.println("Str: " + out);
		return out;
	}
	
	public static String reverseString(String in) {
		String out = "";
		for (int i = in.length(); i > 0; i--) {
			out += in.charAt(i-1);
		}
		System.out.println("Rev: " + out);
		return out;
	}
	
	
	public static void main(String[] ars) {
		List<String> l = new LinkedList<String>();
		l.add("a");
		l.add("bcd");
		l.add("ef");
		l.add("g");
		l.add("f");
		l.add("ed");
		l.add("cba");
		
		System.out.println(
				reverseString( listToString(l) ).compareTo( listToString(l) ));
		
		
		
	}
	
	
}
