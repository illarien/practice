package QuizesOld;

// numbers with unique digits

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueDigitsInNumber {

	public static boolean checkNum(int num) {
		List<Integer> l = new ArrayList<Integer>();
		Set<Integer> s = new HashSet<Integer>();
		
		while ( num != 0 ) {
			int t;
			t = num%10;
			num /= 10;
			l.add(t);
			s.add(t);
		}
		return (l.size()==s.size());
	}
	
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10000000; i++) {
			if (checkNum(i)) System.out.println(i);
			l1.add(i);
			l2.add(i);
		}
		
		
		
		
		System.out.println("checked");
//		l2.add(55);
		
		if (!(l1.size() == l2.size())) System.out.println("Different size");
		System.out.println("Done");
	}

}
