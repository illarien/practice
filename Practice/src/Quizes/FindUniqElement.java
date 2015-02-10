package Q;

import java.util.*;

// Find unique element


public class FindUniqElement {

	public static <T> void find (List<T> in) {
		HashSet<T> hs = new HashSet<T>();
		for (T elem: in) {
			if ( hs.contains(elem)) {
				hs.remove(elem);
			} else {
				hs.add(elem);
			}
		}
		System.out.println(hs);
	}
	
	
	public static void main(String[] args) {
		List<Integer> lin = new LinkedList<Integer>(Arrays.asList(1,2,3,2,3,1,7));
		
		find(lin);
		

	}

}
