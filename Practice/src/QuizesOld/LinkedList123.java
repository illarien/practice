package QuizesOld;

import java.util.*;

public class LinkedList123 {

	
	
	public static void main(String[] args) {
		List<Integer> l = new LinkedList<Integer>();
		l.add(1);l.add(3);l.add(2);
		l.add(1);l.add(1);l.add(1);
		l.add(3);l.add(3);l.add(2);
		l.add(1);
		System.out.println(l);
		
		int i = 0, j = 0;
		while ( (i+j) < l.size()) {
		
			if ( l.get(i).equals(1) ) { l.remove(i); ((LinkedList<Integer>) l).addFirst(1);}
			if ( l.get(i).equals(3) ) { l.remove(i);  l.add(3);i--;j++;}
			
//			System.out.println(l);
			i++;
		}
		System.out.println(l);
	}

}
