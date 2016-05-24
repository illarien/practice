package Quizes.Strings;

/**
 *  Reverse words in sentence
 */
public class RevertWrdsInSentence {
	
	private static String in = "This is a test sentence";
	
	/**
	 * Reverts even words - wrong
	 * @param in
	 * @return
	 */
	private static String revertWordsWrong(String in) {
		String[] arr = in.split(" ");
		String out = "";
		for (String s : arr) {
			out += " " + new StringBuilder(s).reverse().toString();
		}
		return out.trim();
	}
	
	/**
	 * Correct solution 
	 * @param in
	 * @return
	 */
	private static String revertWords(String in) {
		String[] words = in.split(" ");
		StringBuilder result = new StringBuilder();
		for(int i = words.length-1; i >= 0; i--) {
			result.append(words[i]);
			result.append(" ");
		}
		result.deleteCharAt(result.length()-1);
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("Original: " + in);
		System.out.println("Wrong: " + revertWordsWrong(in));
		System.out.println("Right: " + revertWords(in));
	}
}