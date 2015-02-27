package Quizes;

import java.util.HashSet;
/**
 * Overlapping intervals.
 * [1,2], [1,6], [8,9] -> 6
 */
public class OverlappingIntervals {

	/**
	 * Add all points inside interval to HashSet of covered points.
	 * @param intervals - array of beginning and ending of intervals
	 * @return
	 */
	public static HashSet<Integer> coveredCoordinates (int[][] intervals) {
		HashSet<Integer> out = new HashSet<Integer>();
		
		for (int i = 0; i < intervals.length; i++) {
			for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
				out.add(j);
			}
		}
		return out;
	}

	/**
	 * Get max covered diapason of coordinates.
	 * @param intervals - array of intervals
	 * @return - max covered diapason
	 */
	public static int diapason (int[][] intervals) {
		int min = intervals[0][0]; //begin of interval
		int max = intervals[0][1]; //end of interval
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][0] < min) {
				min = intervals[i][0];
			}
		}
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][1] > max) {
				max = intervals[i][1];
			}
		}
		return max-min;
	}
	
	
	public static void main(String[] args) {
		// create intervals array
		int[][] intervals = new int[3][2];
		intervals[0][0] = 1;
		intervals[0][1] = 2;
		intervals[1][0] = 1;
		intervals[1][1] = 6;
		intervals[2][0] = 8;
		intervals[2][1] = 9;
		
		// solution
		HashSet<Integer> hsi = coveredCoordinates(intervals);
		System.out.println("Covered coopdinates: " + hsi);
		
		int size = hsi.size();
		int dia = diapason(intervals);
		System.out.println("Number of coveres coordinates: " + size);
		System.out.println("Number of covered diapasons: " + dia);
		int numberofintervals = size - 1; // t.k. kol-vo intervalov vsegda menshe k-va granichnyh tochek
		if (size == dia) {
			numberofintervals--;
		}
		if (size < dia) {
			numberofintervals = numberofintervals - 2*(dia-size);
		}

		System.out.println("Number of covered intervals: " + numberofintervals);
		

	}

}