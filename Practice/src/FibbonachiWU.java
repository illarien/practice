
public class FibbonachiWU {

	private static long fibonachi(int i) {
		// edge cases: null, negative input, greater than max_integer
		return i <= 2 ? i : fibonachi(i-1) + fibonachi(i-2);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(fibonachi(i));
		}
	}
}