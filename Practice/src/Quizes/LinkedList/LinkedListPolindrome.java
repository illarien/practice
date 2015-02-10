package QuizesOld;
// check List for polindrome

import java.util.*;

public class LinkedListPolindrome {

	public static List<Character> listToString(List<String> in) {
		String out = "";
		List<Character> lout = new LinkedList<Character>();
		Iterator<String> itr = in.iterator();
		while (itr.hasNext()) {
			out += itr.next();
		}
		System.out.println(out);

		for(int i =0; i < out.length(); i++) {
			lout.add(out.charAt(i));
		}
		
		return lout;
	}
	
	public static boolean chechForPolindrome(List<Character> in)  {
		boolean out = true;
		while (in.size() > 1) {
			if ( in.get(0).equals(in.get(in.size()-1)) ) {
				in.remove(0);
				in.remove(in.size()-1);
				System.out.println(in);
			}
			else {out = false; break;}
		}
		System.out.println(out);
		return out;
	}
	
	public static void main(String[] args) {
		List<String> l = new LinkedList<String>();
		l.add("a");
		l.add("bcd");
		l.add("ef");
		l.add("g");
		l.add("f");
		l.add("ed");
		l.add("cba");
		
		chechForPolindrome( listToString(l) );
	}
	
}
