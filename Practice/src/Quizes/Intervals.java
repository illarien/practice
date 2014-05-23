package Quizes;

import java.util.HashSet;

public class Intervals {

	public static HashSet<Integer> toHS (int[][] intervals) {
		HashSet<Integer> out = new HashSet<Integer>();
		
		for (int i = 0; i < 3; i++) {
			for (int j = intervals[i][0]; j <= intervals[i][1] ;j++) {
				out.add(j);
			}
		}
		return out;
	}

	public static int diapason (int[][] intervals) {
		int min = intervals[0][0]; 
		int max = intervals[0][1]; 
		int out = 0;
		for (int i = 0; i < 3; i++) {
			if (intervals[i][0] < min) { min = intervals[i][0];}
		}
		for (int i = 0; i < 3; i++) {
			if (intervals[i][1] > max) { max = intervals[i][1];}
		}
		return max-min;
	}
	
	
	public static void main(String[] args) {
		// inputs
		int[][] intervals = new int[3][2];
		intervals[0][0] = 1;
		intervals[0][1] = 2;
		intervals[1][0] = 4;
		intervals[1][1] = 6;
		intervals[2][0] = 8;
		intervals[2][1] = 9;
		// solution
		HashSet<Integer> hsi = toHS(intervals);
		System.out.println(hsi);
		
		int size = hsi.size();
		int dia = diapason(intervals);
		System.out.println(size);
		System.out.println(dia);
		int numberofintervals = size - 1; // t.k. kol-vo intervalov vsegda menshe k-va granichnyh tochek
		if (size == dia) numberofintervals--;
		if (size < dia) {numberofintervals = numberofintervals - 2*(dia-size);}
		
		
		System.out.println(numberofintervals);
		

	}

}
