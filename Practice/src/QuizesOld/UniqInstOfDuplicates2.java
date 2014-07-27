package QuizesOld;

//Unique instance of duplicates - 2

import java.util.*;
import java.util.Map.Entry;

public class UniqInstOfDuplicates2 {

	public static int[] mapToArray(Map<Integer, Integer> m) {
		int i = 0;
		int[] out = new int[m.size()];
		Iterator<Entry<Integer, Integer>> itr = m.entrySet().iterator();
		Map.Entry<Integer, Integer> pairs;
		while (itr.hasNext()) {
			 pairs = (Map.Entry<Integer, Integer>)itr.next();
			 out[i] = (int)pairs.getKey();
			 i++;
		}
		return out;
	}
	
	public static int[] instOfDupl(int[] ar) {
		HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
		for (int e: ar) {
			if ( !m.containsKey(e) ) { m.put(e, 1); continue;}
			if ( m.containsKey(e) ) { m.put(e, (m.get(e) + 1) ); continue;}
		}
		
		System.out.println("Before: " + m);
		
		Iterator<Entry<Integer, Integer>> itr = m.entrySet().iterator();
		Map.Entry<Integer, Integer> pairs;
		while (itr.hasNext()) {
			 pairs = (Map.Entry<Integer, Integer>)itr.next();
			 if ( (int)pairs.getValue() < 2) { itr.remove();}
		}
	
//		for( Map.Entry<Integer, Integer> ent : m.entrySet() ) {
//			if ( ent.getValue() < 2) {m.remove( ent.getKey() );}
//		}
			
		System.out.println("After: " + m);
		
		
		
		return mapToArray(m);
	}
	
	
	public static void main(String [] args) {
		int[] a = {2,1,2,4,3,1,5,1,9,9,11,11,7,7};
		int[] b = instOfDupl(a);

		
		
		System.out.print("Res: ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		
	}
	
	
}
