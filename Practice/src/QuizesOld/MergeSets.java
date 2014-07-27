package QuizesOld;

import java.util.*;

public class MergeSets {

	public static void main (String[] args) {
		HashSet hs1 = new HashSet<Integer>();
		HashSet hs2 = new HashSet<Integer>();
		Random randomGenerator = new Random();
		
		for (int i = 0; i < 10; i++) {
			hs1.add(randomGenerator.nextInt(20));
			hs2.add(randomGenerator.nextInt(20));
		}
		System.out.println("HS1: " + hs1);
		System.out.println("HS2: " + hs2);
		
		Object[] arr = hs1.toArray();
		
		

		
		System.out.println("HS3: " + hs2);
	}
	
	
}
