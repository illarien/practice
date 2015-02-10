package QuizesOld;

import java.util.*;

public class ArrayPrintSpiral {


	public static int[] getArr(int[][] arr) { 

		int deap = arr[1].length;
		int rowh = deap;
		int rowl = 0;
		int colh = deap;
		int coll = 0;
		int i = 0;
		int j = 0;
		int n = 0;
		int total = deap * arr.length;
		
		int[] out = new int[total];
		
		while (n < total) {
			
			while (i < colh) {
				out[n] = arr[j][i];
//				System.out.println(out[n] + " " + j + " " + i + " " + n);
				n++;
				i++;
			}
			colh--;
			i--;
			j++;

			while(j < rowh) {
				out[n] = arr[j][i];
//				System.out.println(out[n] + " " + j + " " + i + " " + n);
				n++;
				j++;
			}
			rowh--;
			j--;
			i--;

			
			while (i >= coll) {
				out[n] = arr[j][i];
//				System.out.println(out[n] + " " + j + " " + i + " " + n);
				n++;
				i--;
			}
			coll++;
			i++;
			j--;

			
			while (j > rowl) {
				out[n] = arr[j][i];
//				System.out.println(out[n] + " " + j + " " + i + " " + n);
				n++;
				j--;
			}
			rowl++;
			j++;
			i++;
		}
		
		System.out.println("\n");

        return out;
    
    }
	
	
	
	
	public static void main(String[] args) {
		
		int[][] arr = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
		int[] out = getArr(arr);
		
		for (int i = 0; i < out.length; i++) {
			System.out.print (out[i] + " ");
		}
		
	}
	
	
	
}
