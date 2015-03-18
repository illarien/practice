package Quizes;

import java.util.*;

/**
 * Find unique element in List<Object>
 * 1,2,3,2,3,1,7 -> 7
 * #Amazon
 */
public class FindUniqElement {

	/**
	 * find unique element in List<T>
	 * @param input - list of elements
	 */
	public static <T> void find (List<T> input) {
		HashSet<T> hs = new HashSet<T>();
		for (T elem: input) {
			if ( hs.contains(elem)) {
				hs.remove(elem);
			} else {
				hs.add(elem);
			}
		}
		System.out.println(hs);
	}
	
	
	public static void main(String[] args) {
		final List<Integer> lin = new LinkedList<Integer>(Arrays.asList(1,2,3,2,3,1,7));
		
		find(lin);
		

	}

}
