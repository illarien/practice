package QuizesOld;

// common words in two strings

import java.util.*;

public class WordsCommonWords {

	public static String commonWords(String s1, String s2) {
		String out = "";
		String[] sa1 = s1.split(" ");
		String[] sa2 = s2.split(" ");
		Set<String> hs1 = new HashSet<String>();
		
		for (String s: sa1) {
			hs1.add(s);
		}
		
		for (String s: sa2) {
			if (hs1.contains(s)) {out +=s; out +=" ";}
		}
		return out;
	}
	
	
	public static void main(String[] args) {
		String str1 = "i love cats";
		String str2 = "cats love me";
		
		System.out.println(commonWords(str1, str2));

		
		
		
	}

}
