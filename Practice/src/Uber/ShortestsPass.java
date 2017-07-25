package Uber;

/**
 * Дано прямоугольное поле размером n*m клеток. Можно совершать шаги длиной в одну клетку вправо, 
 * вниз или по диагонали вправо-вниз. В каждой клетке записано некоторое натуральное число. 
 * Необходимо попасть из верхней левой клетки в правую нижнюю. 
 * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток. 
 * Необходимо найти маршрут с минимальным весом.
 */

public class ShortestsPass {
	
//	private static ArrayList<String> path = new ArrayList<>();
	private static char[][] path = new char[5][5];

	private static int[][] findPass(int[][] input) {
		int[][] weights = new int [input.length][input[0].length];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				weights[i][j] = minWeight(weights, i, j, input);
			}
		}
		
		return weights;
	}
	
	private static int minWeight(int[][] weights, int i, int j, int[][] input) {
		if (i == 0 && j == 0) {
			path[i][j] = 's'; // start
			return input[i][j];
		}
		if (i == 0) {
			path[i][j] = 'l'; //backtrack to left
			return weights[i][j-1] + input[i][j];
		}
		if (j == 0) {
			path[i][j] = 't'; // backtrack to top
			return weights[i-1][j] + input[i][j];
		}
		// from top
		if (weights[i-1][j] < weights[i][j-1] && weights[i-1][j] < weights[i-1][j-1]) {
			path[i][j] = 't';
			return weights[i-1][j] + input[i][j];
		}	
		// from left
		if (weights[i][j-1]< weights[i-1][j] && weights[i][j-1]<weights[i-1][j-1] ) {
			path[i][j] = 'l';
			return weights[i][j-1] + input[i][j];
		}
		// else - from diagonal
		path[i][j] = 'd'; // backtrack diagonal
		return weights[i-1][j-1] + input[i][j];
		
	}
	
	private static void print2dArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void print2dArray(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] arg) {
		int[][] array = {{2,5,3,7,5},
						{3,6,3,1,8},
						{5,7,3,7,3},
						{7,8,1,13,4},
						{4,7,2,7,8}};
//		int[][] array = {{2,5,3},{3,6,3},{5,7,3}};
		
		print2dArray(array);
		System.out.println("-----");
		print2dArray(findPass(array));
		System.out.println("-----");
		print2dArray(path);	
	}
}