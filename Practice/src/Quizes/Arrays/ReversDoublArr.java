package Q;

public class ReversDoublArr {

	public static int[][] fillArray(int n, int m) {
		int[][] result = new int[n][m];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = i+1;
			}
		}
		return result;
	}
	
	public static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
	
	// vertical revert
	public static int[][] revertArrayVertical(int[][] toRevert) {
		int heigst = toRevert.length/2;
		for (int i = 0; i < heigst; i++) {
			int[] tmp = toRevert[i];
			toRevert[i] = toRevert[toRevert.length - i - 1];
			toRevert[toRevert.length - i - 1] = tmp;
		}
		return toRevert;
	}
	
	// horizontal revert
	public static int[][] revertArrayHorizontal(int[][] toRevert) {
		int leng = toRevert[0].length/2;
		for (int i = 0; i < toRevert.length; i++) {
			for (int j = 0; j < leng; j++) {
				int tmp = toRevert[i][j];
				toRevert[i][j] = toRevert[i][toRevert[0].length - j - 1];
				toRevert[i][toRevert[0].length - j - 1] = tmp;
			}
		}
		return toRevert;
	}
	
	public static void main(String[] args) {
		int[][] toRevert = fillArray(4,9);
		printArray(toRevert);
		
//		printArray(revertArrayVertical(toRevert));
		printArray(revertArrayHorizontal(toRevert));
	}

}
