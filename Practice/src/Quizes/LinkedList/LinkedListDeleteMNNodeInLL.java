package Quizes.LinkedList;

// Delete m nodes after n nodes

import java.util.*;


public class LinkedListDeleteMNNodeInLL {
	
	public static void main(String[] args) {
		List<Integer> ll = new LinkedList<Integer>();
		int n = 3;
		int m = 2;
		
		for (int i = 0; i < 20; i++) {
			ll.add(i+1);
		}
		System.out.println(ll);
		
		
		int i =0;
		while (i < ll.size()) {
			i+=n;
			int j = 0;
			while (j < m ) {
				ll.remove(i);
				j++;
			}
		}
		
		System.out.println(ll);
	}
	
}
