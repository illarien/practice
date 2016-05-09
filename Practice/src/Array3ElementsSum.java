import java.util.Arrays;

/**
 * Given an array, write a function that return true if any 3
 * elements of this array can sum to 0. O(n^2)
 *
 */
public class Array3ElementsSum {

	private static boolean containsSumOf3Elements(int[] input, int sum) {
		Arrays.sort(input);
		for (int i = 0; i < input.length-2; i++) {
			int j = i+1, k = input.length-1;
			
			while (k >= j) {
				int tmpSum = input[i] + input[j] + input[k];
				if (tmpSum == sum) {
					System.out.println( input[i] + " " + input[j] + " " + input[k]);
					return true;
				}
				if (tmpSum > sum) {
					k-- ;
				} else {
					j++;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] array = {1,-1,2,-2,3,-3,0,4,5,6,7};
		System.out.println(containsSumOf3Elements(array, 0));
	}

}
