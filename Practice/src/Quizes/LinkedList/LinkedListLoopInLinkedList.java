package Quizes.LinkedList;

import java.util.*;

// loop in linked list - sm ReverseLinkedList3

public class LinkedListLoopInLinkedList {

	public class Node{
	    public Object data;
	    public Node next;
	    
	    public Node(Object data, Node next)
	    {
	       this.data = data;
	       this.next = next;
	    }
	    
//	    public void addFirst(Object item)
//	    {
//	       head = new Node(item, head);
//	    }
	}
	
	boolean hasLoop(Node first) {

	    if(first == null) return false;
	    Node slow, fast;
	    slow = fast = first;
	    while(true) {
	        slow = slow.next;
	        if((fast.next != null) && (fast.next.next != null)) fast = fast.next.next;
	        else
	            return false;
	      
	        if(slow == null || fast == null) return false;

	        if(slow == fast) return true;
	    }
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			ll.add(i);
		}
		System.out.println(ll);
//		System.out.println(hasLoop(ll.getFirst()));
		
	}
	
	
/*	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		HashMap<Integer,Iterator> hm = new HashMap<Integer,Iterator>();
		for (int i = 0; i < 10; i++) {
			ll.add(i);
		}
		System.out.println(ll);
		
		for (int i = 0; i < ll.size(); i++) {
			System.out.println(ll.iterator());
		}
		
		int j = 0;
		Iterator<Integer> iter;
		while (j < ll.size()) {
			iter = ll.iterator();
			hm.put(ll.get(j),iter);
			j++;
		}
		
		System.out.println(hm);
		
	}
	
	*/
	
}
