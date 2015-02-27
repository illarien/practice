package Quizes.LinkedList;

// Reverse LinkedList - stack

import java.util.*;

public class LinkedListReverseLinkedList2 {

	public static List<Integer> reverseLL(List<Integer> li) {
		Stack<Integer> st = new Stack<Integer>();
		while(li.size() > 0) {
			st.push(li.get(0));
			li.remove(0);
		}
		while (!st.empty()) {
			li.add(st.pop());
		}
		return li;
	}
	
	
	public static void main(String[] args) {
		List<Integer> l = new LinkedList<Integer>();
		for(int i = 0; i< 10; i++) {
			l.add(i);
		}
		System.out.println("Original: " + l);
		l = reverseLL(l);
		System.out.println("Reversed: " + l);
		
		
	}

}
