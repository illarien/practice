package QuizesOld;

import java.util.*;

public class WordsFirstNonRepeat {

	public static void main(String[] args) {
		String in = "asdfghjklasdghшjkiopqыыыыыwfууem";
		char[] inc = in.toCharArray();
		HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
		
		for(int i = 0; i < inc.length; i++) {
			if (hs.get(inc[i]) == null) {hs.put(inc[i], 1);}
			else {hs.put(inc[i], hs.get(inc[i])+1);}
		}
		System.out.println(hs);
		
		for (char c: inc) {
			if (hs.get(c) == 1) {
				System.out.println("FU: " + c);
			}
		}
		
	}

}
