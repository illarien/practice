package Quizes.LinkedList;

// Merge two sorted linkedlist

import java.util.*;

public class LinkedListMergeSortedLinkedList {

	public static LinkedList<Integer> fillLL(LinkedList<Integer> ll) {
		Random randomGenerator = new Random();
		for(int i = 0; i < 10; i++) {
			ll.add(randomGenerator.nextInt(10));
		}
		return ll;
	}
	
	
	public static void main(String[] args) {
		LinkedList <Integer> ll1 = new LinkedList<Integer>();
		ll1 = fillLL(ll1);
		LinkedList <Integer> ll2 = new LinkedList<Integer>();
		ll2 = fillLL(ll2);
		List<Integer> newList = new LinkedList<Integer>();
		
		System.out.println("LL1: " + ll1);
		System.out.println("LL1: " + ll2);
//		Collections.sort(ll1);
//		Collections.sort(ll2);
//		System.out.println("Sorted LL1: " + ll1);
//		System.out.println("Sorted LL2: " + ll2);
		
		
		newList.addAll(ll1);
		newList.addAll(ll2);
		Collections.sort(newList);
		System.out.println("Sorted newLL: " + newList);
		
	}
	
}
