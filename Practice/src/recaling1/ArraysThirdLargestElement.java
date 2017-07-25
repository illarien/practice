package recaling1;

import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Comparator;

public class ArraysThirdLargestElement {

	public static void main(String[] args) {
		int n = 10; // number of elements
		int [] array = new int[n];
		Random randomGenerator = new Random();
		for (int i =0; i <array.length; i++) {
			array[i] = randomGenerator.nextInt(10);
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(3, new IntComparator());
		for (int i: array) {
			pq.offer(i);
		}
		System.out.println(pq); // pq doen not sort element on toString()
		for (int i = 0; i < 3; i++) {
			System.out.println(pq.poll());
		}
	}
	
	private static class IntComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
		        return o2-o1;
		}
	}
	
}
