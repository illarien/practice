package QuizesOld;

/*	1.Find the immediate next largest number containing the same digits as the given number. 
Eg: 12389
O/P : 12398.
1234167
*/

import java.util.*;


public class NextLargestNumber {

	private static final int MAX_VALUE = 2099999999;

	public static Map<Integer,Integer> intToMap(int n) {
	    Map<Integer,Integer> m = new HashMap<Integer,Integer>();
	    while ( n > 0) {
	     if ( m.containsKey(n%10) ) {
	      m.put(n%10, (m.get(n%10)+1) );
	      }
	     else {
	         m.put(n%10, 1 );
	      }
	      n /=10;  
	    }
	    return m;
	    }


	public static int findNextInt(int num) {
	    if (num < 10 ) return -1;
	    Map<Integer,Integer> h = new HashMap<Integer,Integer>();
	    h = intToMap(num);
	    int max = num*10;
	    num++;
	    while ( num <= max ) {
	        if ( intToMap(num).equals(h) ) {return num;}
	        num++;
	    }
	    return -1;
	}

	
	
	
	public static void main(String[] args) {
		for (int i = 10; i < MAX_VALUE; i++) {
//			int n = 12389;
//			System.out.println(intToMap(i));
		
			System.out.println(i + " " + findNextInt(i));
		}
		
	}
	
}
