package Q;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Given LinkedList 2-8-9... like integer 289, add 1. to get 290 (2-9-0)
 * Time and Space complexity O(n) 
 *
 */
public class AddOneToLinkedList {
	
	public static LinkedList<Integer> list = new LinkedList<Integer>();
	
	public static void addOne() {
		// check for null input
		if (list == null) {
			return;
		}
		
		// initialize first iterator and position marker
		ListIterator<Integer> iter = list.listIterator();
		int position = 0;
		
		// iterate until get position of first "9" of "999...9" last section
		while (iter.hasNext()) {
			if ( !(iter.next()).equals(9) ) {
				position = iter.nextIndex();
			}
		}
		
		// re-initialize iterator from found position-1 to get last non 9 digit
		iter = list.listIterator(--position);
		// increase this digit by 1
		iter.set(iter.next() + 1);
		
		// iterate till the end of the list and replace 9 with 0
		while (iter.hasNext()) {
			iter.next();
			iter.set(0);
		}
	}
	
	
	
	public static void main(String[] args) {
		list.add(2);
		list.add(8);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(8);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(8);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		System.out.println(list);
		
		addOne();
		System.out.println(list);
		
		addOne();
		System.out.println(list);
		
		addOne();
		System.out.println(list);
	}

}
