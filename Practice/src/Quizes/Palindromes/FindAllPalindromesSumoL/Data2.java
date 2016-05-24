package Quizes.Palindromes.FindAllPalindromesSumoL;

import java.util.HashMap;

/*
 * Second solution, faster than first one
 */

public class Data2 {
	public String value;
	HashMap<Character, Integer> fingerprint = new HashMap<Character, Integer>();
	
	public Data2(String in) {
		this.value = in;
	    this.fingerprint = getFP(in);
	}
	  
	public boolean isAnagram(String in) {
	  return fingerprint.equals(getFP(in));
	}
	  
	private HashMap<Character, Integer> getFP(String in) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < in.length(); i++) {
			if (hm.get(in.charAt(i)) != null) {
				hm.put(in.charAt(i), hm.get(in.charAt(i))+1 );
			} else {
				hm.put(in.charAt(i), 1);
			}
		}
		return hm;
	}
}