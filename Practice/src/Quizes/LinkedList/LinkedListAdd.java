package Quizes.LinkedList;

import java.util.LinkedList;

public class LinkedListAdd {

	public static void main (String args[]) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Integer num = -7;
		for (int i = 0; i < 10; i++) {
			ll.add(i);
		}
		
		for (int i =0; i < ll.size();i++) {
			System.out.print(ll.get(i) + " ");
		}
		System.out.println("\n" + ll.size() + "\n");
		
		
		for (int i =0; i < ll.size(); i++){
			if (ll.get(i) > num) {ll.add(i,num);
				break;}
			System.out.print(i + " ");
			
		}
		System.out.println("\n" + ll.size() + "\n");
	
		for (int i =0; i < ll.size();i++) {
			System.out.print(ll.get(i) + " ");
		}
	}
	
}
