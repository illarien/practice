package Quizes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Google: Iterate thru list of iterators
 */
public class IterateIterators {
	
	static LinkedList<Integer> l1 = new LinkedList<Integer>();
	static LinkedList<Integer> l2 = new LinkedList<Integer>();
	static LinkedList<Integer> l3 = new LinkedList<Integer>();
	static LinkedList<Integer> l4 = new LinkedList<Integer>();
	
	static LinkedList<Iterator> iterators = new LinkedList<Iterator>();

	
	
	public static void iterateIterators(LinkedList<Iterator> li) {
		Iterator mainIterator; 
		Integer tmp;
		
		while (li.size() > 0) {
			mainIterator = li.listIterator();
			while(mainIterator.hasNext()) {
				// important ne pisat odnoi strokoi tipa
				// (mainIterator.next()).next() - eto vedet k Exception
				Iterator i = (Iterator) mainIterator.next();
				
				if ( i.hasNext() ) {
					tmp = (Integer) i.next();
					System.out.println(tmp);
				} else {
					mainIterator.remove();
				}

			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		l1.addAll(Arrays.asList(new Integer[]{1,1,1,1}));
		l2.addAll(Arrays.asList(new Integer[]{2}));
		l3.addAll(Arrays.asList(new Integer[]{3,3,3,3,3,3}));
		l4.addAll(Arrays.asList(new Integer[]{4,4,4}));
		iterators.addAll(Arrays.asList(new Iterator[]{l1.listIterator(), l2.listIterator(),l3.listIterator(), l4.listIterator()}));
				
		iterateIterators(iterators);

	}

}