package Quizes;

public class StringReverse {

	public static String reverseStringOne (String input) {
		int len = input.length();
		String out = "";
		for (int i = len-1; i >= 0; i--) {
			out += input.charAt(i);
		}	
		return out;
	}
	
	
	
	public static void main(String[] args) {
		final String input = "abcdefg";
		String output = reverseStringOne(input);
		System.out.println(input);
		System.out.println(output);
		
		// reverse through:
		// charAt - reverseOne
		// arrays
		// queue
		

	}

}
