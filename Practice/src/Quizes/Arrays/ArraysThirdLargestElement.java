package QuizesOld;

// find third largest element of a array in a single pass?

import java.util.*;


public class ArraysThirdLargestElement {

	public static void main(String[] args) {

		int n = 10; // number of elements
		int [] array = new int[n];
		Random randomGenerator = new Random();
		for (int i =0; i <array.length; i++) {
			array[i] = randomGenerator.nextInt(10);
			System.out.print(array[i] + " ");
		}

		int m1 = array[0];
		int m2 = m1, m3 = m1;
		
		for(int i = 0; i < array.length; i++) {
			if (array[i] > m1) {
				m3 = m2;
				m2 = m1;
				m1 = array[i];
				continue;
			}
			if (array[i] > m2) {
				m3 = m2;
				m2 = array[i];
				continue;
			}
			
			if (array[i] > m3) {
				m3 = array[i];
			}
		}
		
		System.out.println();
		System.out.println(m1 + " " + m2 + " " + m3);

	}

}
