package recaling1;

public class ReverseString {
	
	private static String str = "abcdef";
	
	private static String reverseString1(String input) {
		return new StringBuilder(input).reverse().toString();
	}
	
	private static String reverseString2(String input) {
		String result = "";
		for(int i = 0; i < input.length(); i++) {
			result = input.charAt(i) + result;
		}
		return result;
	}
	
	
	public static void main(String... args) {
		System.out.println(reverseString1(str));
		System.out.println(reverseString2(str));
	}

}
