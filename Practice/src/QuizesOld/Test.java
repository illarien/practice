package QuizesOld;

import java.util.*;

public class Test {

	    public int solution(int[] A) {
	        int l = A.length;
	        TreeSet<Integer> s = new TreeSet<Integer>();
	        if ( l < 1 || l > 100000 ) { return 1;}
	        
	        for (int i = 1; i < l+2; i++ ) {
	            s.add(i);
	        }
	        
	        for (int e:A) {
	            s.remove(e);
	        }
	        
	        return s.first();
	    }

	
	
	
	
	public static void main(String[] args) {
		int[] a = new int[10];
		TreeSet<Integer> s = new TreeSet<Integer>();
		s.add(1);
		s.first();

		

	}

}
