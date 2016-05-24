package Quizes.Strings;

public class StringPermutation {

	/**
	 * Main method
	 * @param str
	 */
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
			System.out.println(pref);
		} else {
			for(int i = 0; i < n; i++) {
				permutation(pref + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
			}
		}
	}
	
	
	public static void main(String[] args) {
		permutation("abcdef");

	}
}