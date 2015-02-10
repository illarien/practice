package QuizesOld;

// List Iterator

import java.util.*;

public class LinkedListIterator {

	public static void main(String[] args) {
		List<Integer> l = new LinkedList<Integer>();
		for (int i =0; i < 10; i++) {
			l.add(i);
		}
		System.out.println(l.iterator());
		System.out.println(l.iterator());
	}
	
}
