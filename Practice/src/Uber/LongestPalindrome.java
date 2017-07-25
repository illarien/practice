package Uber;

import java.util.Arrays;

/**
 * Obyasnenie po ssylke
 * https://habrahabr.ru/post/113108/ Zadacha 5
 */
public class LongestPalindrome {
	
	private static void print2dArray(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	private static void print2dArray(String[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	private static int max(int[][] length, int i, int j, String[][] path) {
		if (i < 1 || j > length.length-2) {
			return 0;
		}
//		return length[i-1][j] > length[i][j+1] ? length[i-1][j] : length[i][j+1]; //right solution, but need to add path
		if (length[i-1][j] > length[i][j+1]) {
			path[i][j] = "down";
			return length[i-1][j];
		} else {
			path[i][j] = "left";
			return length[i][j+1];
		}
	}
	
	public static void main(String[] args) {
		String s = "ABACCBA";
		int[][] length = new int[s.length()][s.length()]; // massiv dlinn palindroma
		String[][] path = new String[s.length()][s.length()];
		
		//for s(i,i) - stroki zi odnogo simvola - zapolnim diagonal
		for (int i = 0; i < s.length(); i++) {
			length[i][i] = 1;
		}
		
		// dlya podstrok s(j,i)
		for (int i = 1; i < s.length(); i++) {
			for (int j = i-1; j >= 0; j--) {
				if (s.charAt(i) != s.charAt(j)) {
					length[i][j] = max(length, i,j, path); // 
				} else if (s.charAt(i) == s.charAt(j)) {
					length[i][j] = length[i-1][j+1] + 2;
					path[i][j] = "diag";
				}

			}
		}
		print2dArray(length);
		System.out.println("-------------");
		print2dArray(path);
	}
}