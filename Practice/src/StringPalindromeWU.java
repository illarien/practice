
public class StringPalindromeWU {

	public static boolean isPalindrome1(String input) {
		if (input == null) {
			throw new IllegalArgumentException();
		}
		if (input.isEmpty()) {
			return true;
		}
		return input.equals(new StringBuilder(input).reverse().toString());
	}
	
	public static boolean isPalindrome2(String input) {
		if (input == null) {
			throw new IllegalArgumentException();
		}
		if (input.isEmpty()) {
			return true;
		}
		for (int i = 0; i < input.length()/2; i++) {
			if (input.charAt(i) != input.charAt(input.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "abcdcba";
		String s2 = "";
		String s3 = "abcd";
		String s4 = null;
		
		System.out.println(s1 + " " + isPalindrome1(s1));
		System.out.println(s2 + " " + isPalindrome1(s2));
		System.out.println(s3 + " " + isPalindrome1(s3));
//		System.out.println(s4 + " " + isPalindrome1(s4));
		
		System.out.println("---------------");
		
		System.out.println(s1 + " " + isPalindrome2(s1));
		System.out.println(s2 + " " + isPalindrome2(s2));
		System.out.println(s3 + " " + isPalindrome2(s3));
//		System.out.println(s4 + " " + isPalindrome2(s4));
	}

}
