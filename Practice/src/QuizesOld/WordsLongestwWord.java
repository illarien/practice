package QuizesOld;

public class WordsLongestwWord {

	public static void main(String[] args) {
		String sentence = "fsfsdf sdfsfsd qqehjvkjhvjkhvjhvqw s qfqffq sgswewe iiiiiifiiii";
		String[] array = sentence.split(" ");
		int length = array.length;
		String resWord = array[0];
		int resLength = array[0].length();
		int i;
		for(i=1;i < length; i++) {
			if (resLength < array[i].length()) {
				resWord = array[i];
				resLength = array[i].length();
			}
		}
		
		System.out.println("RES WORD: " + resWord);
		System.out.println("RES WORD LENGTH: " + resLength);
		
	}

}
