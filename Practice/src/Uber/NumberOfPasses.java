package Uber;


/**
 * Дано прямоугольное поле размером n*m клеток. Можно совершать шаги длиной в одну клетку вправо или вниз.
 * Посчитать, сколькими способами можно попасть из левой верхней клетки в правую нижнюю.
 */
public class NumberOfPasses {
	
	private static void print2dArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] nOfPasses(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			
			for (int j = 0; j < array[i].length; j++) {
				if (i == 0 && j == 0) {
					array[i][j] = 1;
					continue;
				}
				if (i == 0) {
					array[i][j] = array[i][j-1];
					continue;
					
				}
				if (j == 0) {
					array[i][j] = array[i-1][j];
					continue;
				}
				
				array[i][j] = array[i-1][j] + array[i][j-1];
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int [][] array = new int [5][10];
//		print2dArray(array);
		
		print2dArray(nOfPasses(array));
	}

}
