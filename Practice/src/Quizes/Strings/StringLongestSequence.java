package Quizes.Strings;

/**
 * Find the longest sequence of prefix shared by all the words in a string. 
 * "abcdef abcdxxx abcdabcdef abcyy" => "abc"
 */
public class StringLongestSequence {
	
	private static String str = "abcdef abcdxxxyyyy abcdrwwf abcdabcdef abcyy";
	
	private static String findSubString (String in) {
		String[] array = in.split(" ");
		String first = array[0];
		int l = first.length();
		
		for (int i = 0; i < l; i++) {
			for (int j = 1; j < array.length; j++) {
				if (first.charAt(i) != array[j].charAt(i)) {
					return first.substring(0, i);
				}
			}
		}
		return null;
	}
	
	public static void main(String... args) {
		System.out.println(findSubString(str));
	}
}