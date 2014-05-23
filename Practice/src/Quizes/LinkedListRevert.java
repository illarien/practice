package Quizes;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.print.attribute.standard.QueuedJobCount;

public class LinkedListRevert {

	
	
	public static void main(String[] args) {
		//input
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = 1; i < 10; i++) {
			ll.add(i);
		}
		System.out.println(ll);
		//solution
		Stack<Integer> q = new Stack<Integer>();
		LinkedList<Integer> lo = new LinkedList<Integer>();
		
		for (int i = 0; i < ll.size(); i++) {
			q.push(ll.get(i));
		}
		System.out.println(q);
		while (!q.isEmpty()) {
			lo.add(q.pop());
		}
		System.out.println(lo);
		
	}

}
