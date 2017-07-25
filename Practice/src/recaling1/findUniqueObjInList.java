package recaling1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class findUniqueObjInList {
	
	private static List<Integer> list = new LinkedList<Integer>(Arrays.asList(1,2,3,2,3,1,7));
	
	private static <T> HashSet<T> findUnique(List<T> in) {
		HashSet<T> hs = new HashSet<T>();
		for (T t: in) {
			if (hs.contains(t)) {
				hs.remove(t);
			} else {
				hs.add(t);
			}
		}
		return hs;
	}
	
	
	public static void main(String...strings) {
		
		System.out.println(findUnique(list));
		
	}

}
