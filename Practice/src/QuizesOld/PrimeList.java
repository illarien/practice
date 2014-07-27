package QuizesOld;

public class PrimeList {

	public static void main(String[] args) {
		int num = 10000;
		int m;
		boolean f;

		for (int i = 2; i <= num; i++) {
			f = true;
			m = Math.round(i/2);
			for (int j = 2; j<=m; j++) {
				if (i % j == 0) f = false;
			}
			if (f) System.out.print(i + " ");
		}
		

	}

	
	
}
