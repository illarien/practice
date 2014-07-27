package QuizesOld;

// continuous consequence

import java.util.*;

public class WordsCountCons {

	
	public static void main(String[] args) {
		String inStr = "aaabbbbddfzzzzzzzzzaa";
		String[] ch = inStr.split("");
		int k = 1;
		int kMax = 0;
		String out ="";
		
		for (int i=0; i < ch.length-1; i++) {
			if (ch[i].equals(ch[i+1]) ) { k++; }
			else {k=1; };
			
			if (k > kMax) {kMax = k; out = ch[i]; };
			
			System.out.println(out + kMax);
		}
		System.out.println(out + " " + kMax);

	}

}
