package Quizes.Strings;

public class StringReverse2 {
	
	private static String reverse (String input) {
		if (input == null) {
			throw new IllegalArgumentException();
		}
		if (input.isEmpty()) {
			return input;
		}
		char[] array = input.toCharArray();
		for (int i = 0; i < array.length/2; i++) {
			char tmp = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-1-i] = tmp;
		}
		return new String(array);
	}
	
	public static void main(String... args) {
		String input = "abcde";
		System.out.println(reverse(input));
	}
}
