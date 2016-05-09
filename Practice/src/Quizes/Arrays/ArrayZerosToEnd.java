package Quizes.Arrays;

public class ArrayZerosToEnd {
	
	private static void print(int[] input) {
		for (int i: input) {
			System.out.print(i + " ");
		}
	}
	
	private static void zeroToEnd(int[] input) {
		int b = 0, e = input.length-1;
		while (b < e) {
			if (input[b] > 0) {
				b++;
				continue;
			}
			while (input[e] == 0) {
				e--;
			}
			
			int tmp = input[b];
			input[b] = input[e];
			input[e] = tmp;
		}
	}
	

	public static void main(String[] args) {
		int[] array = {0,2,3,0,4,5,0,0}; 
		print(array);
		System.out.println();
		zeroToEnd(array);
		print(array);	
	}

}
