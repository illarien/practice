package recaling1;

import java.util.HashSet;

public class StringAllUniqueChars {
	
	private static boolean hasAllUnique(String s) {
		// null and empty check
		if (s == null) {
			return false;
		}
		if (s.length() <=1) {
			return true;
		}
		HashSet<Character> hs = new HashSet<>();
		for(int i =0; i < s.length(); i++) {
			if (hs.contains(s.charAt(i))) {
				return false;
			}
			hs.add(s.charAt(i));
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "wifb";
		String s2 = "jsnbowepw";
		System.out.println(hasAllUnique(s1));
		System.out.println(hasAllUnique(s2));
		System.out.println(hasAllUnique(null));
		System.out.println(hasAllUnique(""));
		System.out.println(hasAllUnique("a"));
	}

}
