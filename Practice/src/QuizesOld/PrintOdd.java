package QuizesOld;


public class PrintOdd {

	public static void printOdd (int i, int j) {
		for (int k = i; k <= j;k++) {
			if ((k % 2) != 0) {
				System.out.print(k + " ");
			}
		}
	}
	

	public static void main(String[] args) {
		int N = 11;
		printOdd(1,21);
	}

}
