package QuizesOld;
// Unique instance of duplicates

import java.util.*;


public class UniqInstOfDuplicates {

	
	public static HashSet<Integer> remove(HashMap<Integer, Integer> hm) {
		Set<Integer> s = hm.keySet();
		HashSet<Integer> out = new HashSet<Integer>();
		System.out.println(s);
		int c;
		
		for (Integer e: s) {
			c = hm.get(e);
			if ( c > 2) { out.add(e); }
		}
		return out;
	}
	
	public static int[] setToArray(Set<Integer> s) {
		int[] out = new int[s.size()];
		int i = 0;
		for(int e: s ) {
			out[i] = e;
			i++;
		}
		return out;
	}
	
	public static int[] instOfDupl(int[] ar) {
		HashMap<Integer,Integer> m = new HashMap<Integer,Integer>(ar.length);
		for (int e: ar) {
			if ( !m.containsKey(e) ) { m.put(e, 1); continue;}
			if ( m.containsKey(e) ) { m.put(e, (m.get(e) + 1) ); continue;}
		}
		return setToArray(remove(m));
	}
	
	
	
	
	public static void main(String [] args) {
		int[] a = {2,1,2,4,3,1,5,1};
		int[] b = instOfDupl(a);
		System.out.print("Res: ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		
	}
	
	
}
