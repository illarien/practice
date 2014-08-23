package QuizesOld;


//1) Given two ints, write a method to print out all odd numbers between those values, inclusive (e.g. given 1 and 11, print 1, 3, 5, 7, 9, 11)

public class OddNumbersInDiapason {

	public static int start = 1;
	public static int end = 11;
	
	public static void main(String[] args) {
		
		for (int i = start; i<=end; i++) {
			if ( i%2 == 1) {
				System.out.println(i);
			}
		}
		
	}

}
