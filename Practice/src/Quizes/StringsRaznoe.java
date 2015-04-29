package Quizes;

// Strings - reverse, reverse words in string, remove char from string

public class StringsRaznoe {

	public static String reverseString (String in) {
		return new StringBuilder(in).reverse().toString();
	}
	
	public static String reverseWords (String in) {
		final String[] arr = in.split(" ");
		String out = "";
		for (int i = arr.length-1; i >= 0; i--) {
			out +=arr[i];
			out += " ";
		}
		return out.trim();
	}

	public static String removeChar(String str, char ch) {
		String out = "";
		for (int i = 0; i < str.length(); i++) {
			if (ch != str.charAt(i)) {
				out += str.charAt(i);
			}
		}
		return out;
	}
	
	public static void main(String[] args) {
		System.out.println(reverseString("a b c d e f"));
		System.out.println(reverseWords("ab cde fg"));
		System.out.println(removeChar("google", 'g'));
	}

}
