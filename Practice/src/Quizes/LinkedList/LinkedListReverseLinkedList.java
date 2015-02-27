package Quizes.LinkedList;

// reverse LinkedList

import java.util.LinkedList;
import java.util.List;

public class LinkedListReverseLinkedList {

//	first realization	
	public static LinkedList<Integer> reverseLL(LinkedList<Integer> llist) {
		LinkedList<Integer> newll = new LinkedList<Integer>();
		
		for (int i = 0; i < llist.size(); i++) {
			newll.addFirst(llist.get(i));
		};
		return newll;
	}

//	second realization-recursively
	public class Node{
	    public Object data;
	    public Node next;
	}
	
	public Node recursiveReverse(Node p)
	{
	    return helperReverse(p, null);
	} 

	private Node helperReverse(Node p, Node previous)
	{
	    if (p == null)
	    {
	        return p;
	    }
	    else if (p.next == null)
	    {
	        p.next = previous;
	        return p;
	    }
	    else
	    {
	        Node next = p.next;
	        p.next = previous;
	        return helperReverse(next, p);
	    }
	}
	
	
	
	
	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			l1.add(i);
		}
		System.out.println(l1);
		System.out.println(reverseLL(l1));
	}
}
