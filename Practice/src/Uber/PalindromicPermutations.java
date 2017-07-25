package Uber;

import java.util.HashSet;

/**
 * given string s, return all palindromic permutations (without duplicates),
 * Return empty array if no combinations can be formed 
 *
 */
public class PalindromicPermutations {
	
	private static HashSet<String> permutations = new HashSet<>();
	
	private static void permutation(String str){
		permutation("", str);
	}
	
	/**
	 * Recursion permutation
	 * @param pref
	 * @param str
	 */
	private static void permutation(String pref, String str) {
		int n = str.length();
		if (n == 0) {
			if (isPalindrome(pref)) {
				permutations.add(pref);
			}
		} else {
			for(int i = 0; i < n; i++) {
				permutation(pref + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
			}
		}
	}
	
	private static boolean isPalindrome(String s) {
		return s.equals(new StringBuilder(s).reverse().toString());
	}

	public static void main(String[] args) {
		String input = "abcab";
		char[] chars = input.toCharArray();
		permutation(input);
		System.out.println(permutations);
		String[] arr = permutations.toArray(new String[permutations.size()]);
		System.out.println(arr.length);
		// return arr; // per requirments.
	}
}