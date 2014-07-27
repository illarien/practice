package QuizesOld;
// Equals parts in string 

public class WordsEqualsPartsInString {

	public static boolean symmetric(String str) {
		
		char[] ch = str.toCharArray();
		if (ch.length % 2 != 0) {
			return false;
		}
		else {
			int num = 0;
			for (int i = 0; i < ch.length; i++) {
				num ^= Character.getNumericValue(ch[i]);
			}
			return (num == 0);
		}
		// int num = Integer.parseInt(str);
	}
	
	
	public static void main(String[] args) {
		String str = "678876";
		if (symmetric(str)) {
			System.out.println("12345 " + str);
		}
	
	}
	
}
