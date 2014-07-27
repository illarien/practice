package QuizesOld;

import java.util.*;

public class Recursion {
	
	
	public static void main (String[] arg) {
		int[] input = {3,2,1,3,2,1,3,2,1};
		splitArray(input);
		for (int r = 0;  r< input.length; r++) {
			System.out.print(input[r] + " ");
		}
		
	}
	
	public static int[] splitArray(int[] arrayToSplit) {
		if (arrayToSplit.length > 0){
			int l = arrayToSplit.length;
			if (arrayToSplit.length <3) {
				return sort(arrayToSplit);
				}
			else {
				
				
				
				
				return arrayToSplit;
			}
			
			
		}
		return arrayToSplit;
	}
	
	
	
	public static int[] sort(int[] arrayToSort) {
		int c;
		if (arrayToSort[0]>arrayToSort[1]) {
			c = arrayToSort[0]; arrayToSort[0] = arrayToSort[1]; arrayToSort[1] = c;
		}
		return arrayToSort;
	}
	
	
}
