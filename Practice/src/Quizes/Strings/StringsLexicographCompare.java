package Quizes.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StringsLexicographCompare {
	
	/**
	 * Comparator
	 */
	static class LexComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			int i=0;
			while (i < s1.length() && i < s2.length()) {
				if (s1.charAt(i) > s2.charAt(i)) {
					return 1;
				} else if (s1.charAt(i) < s2.charAt(i)) {
					return -1;
				} else {
					i++;
				}
			}
			return 0;
		}
	}
	
	public static void main(String[] args) {
		String s1 = "abcderrhrh";
		String s2 = "bcder";
		ArrayList<String> array = new ArrayList<String>();
		array.add(s2);
		array.add(s1);
		Collections.sort(array, new LexComparator());
		for(String s: array) {
			System.out.println(s);
		}
	}
}
