package QuizesOld;

// Sorting - bubble

public class ArraySortingBubble {

	public static void main(String[] args) {
		int[] ar = {562, 68, 5, 101, 7411, 8, 11, 721, 70, 901, 99, 56, 7, 5, 131, 710, 8, 11, 71, 70, 90, 99};

		bubbleSort(ar, 0, ar.length-1);

		for (int z=0; z< ar.length;z++){System.out.print(ar[z] + " ");}	

	}

	public static void bubbleSort(int[] ar, int st, int end) {
		for (int i = st; i <= end; i++) {
			for (int j = st; j <= end; j++) {
				ArraysSortingMerge.compAndSwapXOR(ar, i, j);
			}
		}
	}
	
}
