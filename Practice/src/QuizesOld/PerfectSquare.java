package QuizesOld;

public class PerfectSquare {

	public static void main(String[] args) {
		int n = 121;
		
		if (n < 4) {
			System.out.println("not a square");
		}

		int i = 1;
		int s = 1;
		while (s <= n) {
			s += (2*i + 1);
			System.out.println(s);
			if ( s == n ) System.out.println("Perfect square");
			i++;
		}
		System.out.println("Done.");
	}

}
