package QuizesOld;

import java.math.*;
import java.util.*;

// Fibonachi - print

public class Fibonachi {

	public static void main(String[] args) {
		long a = 0;
		long b = 1;
		long c = 0;
		int i = 0;
		long ct = System.currentTimeMillis();
		
		List<Long> l = new LinkedList<Long>();
		
		while (c < 1000000000000000000l) {
			c = a + b;
			a = b;
			b = c;
			i++;
		//	System.out.print(c + " ");
			l.add(c);
		}
		
		ct = System.currentTimeMillis() - ct;
		System.out.println();
		System.out.println("Time: " + ct);
		System.out.println(i);
		System.out.println(l);
	}
	
	
}
