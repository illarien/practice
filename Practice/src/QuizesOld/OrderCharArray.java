package QuizesOld;

// Order string/char array

import java.util.*;

public class OrderCharArray {

	
	public static void main(String[] args) {
		String[] oa = {"C","A","B"};
		String[] ia={"A", "C", "B", "B", "C", "A", "B", "C", "C", "A", "A", "B", "A", "B", "C", "B", "B"};
		String[] out = new String[ia.length];
		Map<String, Integer> m = new HashMap<String,Integer>();
		
		for(int i = 0; i < ia.length; i++) {
			if ( m.containsKey(ia[i]) ) {
				m.put(ia[i], (m.get(ia[i]) + 1) );
			}
			else {
				m.put(ia[i], 1 );
			}
		}
		System.out.println(m);
		
		int position = 0;
		for(int i = 0; i < oa.length; i++) {
			int counter = m.get(oa[i]);
			for (int j = 0; j < counter; j++) {
				out[position++] = oa[i];
			}
		}
		
		for(String e: out) {
			System.out.print(e + " ");
		}
		
	}

}
