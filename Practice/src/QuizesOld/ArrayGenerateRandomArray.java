package QuizesOld;

import java.io.IOException;
import java.util.*;

public class ArrayGenerateRandomArray {

	public static void main(String[] args) throws IOException {
		int n = 200000; // number of elements
		int [] array = new int[n];
		Random randomGenerator = new Random();
		for (int i =0; i <array.length; i++) {
			array[i] = randomGenerator.nextInt();
		}
		ArraysSortingCompete.writeArrayToFile("testarray.txt", array);
		
	}

}
