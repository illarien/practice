package Fibonacci;

public class FibSimple {

	public int[] calculateFib (int n, int depth) {
		int[] fib = new int[n+1];	
		for (int i = 0; i <= n; i++) {
			if (i <= depth) {
				fib[i] = i;
				continue;
			}
			for (int j = 1; j <= depth; j++) {
				fib[i] += fib[i-j];
			}
		}
		return fib;
	}
	
	public static void main(String[] args) {
		int[] result = new FibSimple().calculateFib(10, 3);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
