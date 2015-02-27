package Quizes.Arrays;

import java.util.*;

public class ArraysSpiralArray {

	public static void printArr(int[][] array) {
		int deap = array[0].length;
		for(int i = 0; i < deap; i++) {
			for(int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		int[][] ar = new int[5][5];
		int deap = ar[1].length;
		
//		for(int i = 0; i < deap; i++) {
//			for(int j = 0; j < ar.length; j++) {
//				ar[i][j] = j+1;
//			}
//		}
		
//		printArr(ar);
//		System.out.println();
		
		int rowh = deap;
		int rowl = 0;
		int colh = deap;
		int coll = 0;
		int i = 0;
		int j = 0;
		int n = 1;
		
		while (n <= 25) {
			
			while (i < colh) {
				ar[j][i] = n;
//	1			System.out.print(n + " ");
				n++;
				i++;
			}
			colh--;
			i--;
			j++;
			System.out.println("\n");
			printArr(ar);
			Thread.sleep(2000);
			
			
			while(j < rowh) {
				ar[j][i] = n;
//		2		System.out.print(n + " ");
				n++;
				j++;
			}
			rowh--;
			j--;
			i--;
			System.out.println("\n");
			printArr(ar);
			Thread.sleep(2000);
			
			while (i >= coll) {
				ar[j][i] = n;
//	3			System.out.print(n + " ");
				n++;
				i--;
			}
			coll++;
			i++;
			j--;
			System.out.println("\n");
			printArr(ar);
			Thread.sleep(2000);
			
			while (j > rowl) {
				ar[j][i] = n;
//				System.out.print(n + " ");
				n++;
				j--;
			}
			rowl++;
			j++;
			i++;
			System.out.println("\n");
			printArr(ar);
			Thread.sleep(2000);
		}
		
		System.out.println("\n");
		printArr(ar);
		
		
	}
	
	
	
}
