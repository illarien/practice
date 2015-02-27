package Quizes.Strings;

//Find the longest sequence of prefix shared by all the words in a string. 
//"abcdef abcdxxx abcdabcdef abcyy" => "abc"


public class StringLongestSequence {
	
	static String str = "abcdef abcdxxxyyyy abcdrwwf abcdabcdef abcdyy";
	
	public static String findSubString (String in) {
		String[] array = in.split(" ");
		String first = array[0];
		int l = first.length();
		
		for (int i = 0; i < l; i++) {
			System.out.println(": " + first.charAt(i));
			for (int j = 1; j < array.length; j++) {
				System.out.println(array[j].charAt(i));
				if (first.charAt(i) != array[j].charAt(i)) {
					System.out.println("::: " + first.substring(0, i));
					return first.substring(0, i+1);
				}
				
			}
			
		}
		return null;
	}
	
	
	public static void main(String... args) {

		findSubString(str);

		
	}
	
	
	
	
	
//	wrong solution
//	public static void main(String[] args) {
//		String str = "abcdef abcdxxxyyyy acbrwwf abcdabcdef abcyy";
//		String pref = "abc";
//		String[] arr = str.split(" ");
//		int max = 0;
//		String longest = "";
//		for (String s : arr) {
//			if (s.substring(0, 3).equals(pref)) {
//				System.out.println(s);
//				if (s.length() > max) {
//					max = s.length();
//					longest = s;
//				}
//			} 
//		}
//		System.out.println(longest + " " + max);
//		
//
//	}

}
