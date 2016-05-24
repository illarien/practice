package Quizes.Strings;

public class StringBalancedLine {
	
	private static boolean isBalanced(String input) {
		if (input == null) {
			throw new IllegalArgumentException();
		}
		if (input.isEmpty()) {
			return true;
		}
		
		int counter = 0, counter2 = 0;
		for (char c: input.toCharArray()) {
			if (c == '(') {
				counter++;
			} else if (c == ')') {
				counter--;
			}
			if (c == '[') {
				counter2++;
			} else if (c == ']') {
				counter2--;
			}
			if (counter < 0 || counter2 < 0){
				return false;
			}
		}
		return counter == 0  && counter2 == 0;
	}

	public static void main(String[] args) {
		String s1 = "()()(())";
		String s2 = "(()";
		String s3 = ")()(";
		String s4 = "((a))[[]";
		System.out.println(isBalanced(s1));
		System.out.println(isBalanced(s2));
		System.out.println(isBalanced(s3));
		System.out.println(isBalanced(s4));
	}
}
