package Quizes.Strings;

// Reverse words in sentence


public class RevertWrdsInSentence {
	
	public static String in = "This is a test sentence";
	
	public static String revertWords(String in) {
		String[] arr = in.split(" ");
		String out = "";
		for (String s : arr) {
			out += " " + new StringBuilder(s).reverse().toString();
		}
		return out.trim();
	}
	
	
	public static void main(String[] args) {
		System.out.println(revertWords(in));

	}

}
