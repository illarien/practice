package QuizesOld;

import java.util.*;

public class Cards {

	public static List<Integer> swap(List<Integer> in) {
		List<Integer> out = new LinkedList<Integer>();
		while (in.size() > 0) {
			out.add( in.get(0)); in.remove(0);
			if ( in.size() > 1 ) {in.add( in.get(0) ); in.remove(0); }
		}
		return out;
	}
	
	
	public static void main(String[] args) {
		int n = 52;
		int c = 0;
		List<Integer> l = new LinkedList<Integer>();
		List<Integer> e = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++) {e.add(i+1);}
		l.addAll(e);
		l = swap(l);
		System.out.println(l);
		c++;
		
		while ( !l.equals(e) ) {
			l = swap(l);
			System.out.println(l);
			c++;
		}
		System.out.println( c );
	}

}
