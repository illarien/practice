package Quizes.Strings;

public class StringReverse {
	
	/**
	 * Fancy way to reverse String
	 * @param input
	 * @return
	 */
	private static String reverseFancy (String input) {
		return new StringBuilder(input).reverse().toString();
	}
	
	
	/**
	 * Fastest and efficient way to reverse String 
	 * @param input
	 * @return
	 */
	private static String reverse (String input) {
		if (input == null) {
			throw new IllegalArgumentException();
		}
		if (input.isEmpty()) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = input.length()-1; i >= 0; i--) {
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}
	
	public static void main(String... args) {
		String input = "abcde";
		System.out.println("reverse(): " + reverse(input));
		System.out.println("reverseFancy(): " + reverseFancy(input));
	}
}