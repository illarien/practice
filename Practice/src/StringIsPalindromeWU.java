
public class StringIsPalindromeWU {

	private static boolean isPalindrome(String input) {
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
		String s1 = "abcba";
		String s2 = "abcd";
		String s3 = null;
		String s4 = "";
		
		System.out.println(isPalindrome(s1));
		System.out.println(isPalindrome(s2));
//		System.out.println(isPalindrome(s3));
		System.out.println(isPalindrome(s4));
	}

}
