package QuizesOld;

// No duplicates in number

import java.util.*;

public class NoDuplicateNumbers {

	public static boolean notContainsDupbilates(int i) {
		int j;
		List<Integer> l = new ArrayList<Integer>();
		Set<Integer> s = new HashSet<Integer>();
		while (i>0) {
			j = i%10;
			i /=10;
			l.add(j);
			s.add(j);
		}
		return (l.size() == s.size());
	}
	
	
	public static void main(String[] args) {
		int min = 10;
		int max = 5000;
	
		for (int i = min; i <= max; i++) {
			if ( notContainsDupbilates(i) ) {
				System.out.print(i + " ");
			}
		}

	}

}
