package Quizes.Palindromes.FindAllPalindromesSumoL;

import java.util.*;

/* 
 * Original solution, it works, but there is a better solution, please see Data2.
 * There is no need to keep all possible anagrams, just "fingerprint". 
 */

public class Data {
	String value;
	static HashSet<String> anagrams = new HashSet<String>();
	  
	public Data(String in) {
		this.value = in;
	    fill(in);
	}
	  
	public boolean isAnagram(String in) {
	  return anagrams.contains(in);
	}
	  
	private void fill(String in) {
		fill("", in);
	}
	  
	private void fill(String pref, String in) {
		int n = in.length();
		if (n == 0) {
			anagrams.add(pref);
		} else {
			for(int i = 0; i < n; i++) {
				fill(pref + in.charAt(i), in.substring(0, i) + in.substring(i+1, n));
			}
		}
	}
	
	
}
