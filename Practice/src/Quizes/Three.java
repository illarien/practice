package Quizes;
import java.util.Arrays;
import java.util.Random;


public class Three {

	private static int[] generateArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			 Random r = new Random();
			 arr[i] = r.nextInt(100);
		}
		return arr;
	}
	
	private static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = generateArray(100);
		final int[] b = new int[50],c = new int[50];
		printArray(a);
		for(int i = 0; i < a.length; i++) {
			if (i < 50) {b[i] = a[i];}
			else {c[i-50] = a[i];}
		}
		printArray(b);
		printArray(c);
		System.out.println("----------------");
		
		Thread t1 = new Thread( new Runnable() {
			@Override
			public void run() {
				Arrays.sort(b);
				System.out.print("B: ");
				printArray(b);
				System.out.println("----------");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Arrays.sort(c);
				System.out.print("C: ");
				printArray(c);
				System.out.println("---------");
			}
		});
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("B: ");
		printArray(b);
		System.out.println("----------");
		System.out.print("C: ");
		printArray(c);
		System.out.println("---------");
		
		
	}

}
