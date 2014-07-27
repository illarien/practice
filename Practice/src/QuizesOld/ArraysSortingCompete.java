package QuizesOld;

// Sorting - comparing of types of sorting

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;

public class ArraysSortingCompete {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
//		int[] ar = {562, 68, 5, 101, 7411, 8, 11, 721, 70, 901, 99, 56, 7, 5, 131, 710, 8, 11, 71, 70, 90, 99};
//		writeArrayToFile("testarray.txt", ar);
//		System.out.println("1");
		int [] ar2 = readArrayFromFile("testarray.txt");
		int [] ar3 = readArrayFromFile("testarray.txt");
		int [] ar4 = readArrayFromFile("testarray.txt");
		System.out.println("N elements: " + ar2.length+ " " + isArraySorted(ar2));
		//		for (int z=0; z< ar2.length;z++){System.out.print(ar2[z] + " ");}	
		long q;
		long ct;

		ct = System.currentTimeMillis();
		ArraysSortingQuick.quickSort(ar2, 0, ar2.length-1);
		q = System.currentTimeMillis() - ct;
		System.out.println("Quick: " + ar2.length+ " " + q + " " + isArraySorted(ar2));
//		for (int i=0 ; i < ar2.length ; i++) System.out.print(ar2[i] + " ");
		
		ct = System.currentTimeMillis();
		ArraysSortingMerge.mergSort(ar3, 0, ar3.length-1);
		q = System.currentTimeMillis() - ct;
		System.out.println("Merge: " + ar3.length+ " " + q + " " + isArraySorted(ar3));
//		for (int i=0 ; i < ar3.length ; i++) System.out.print(ar3[i] + " ");
		
		
		ct = System.currentTimeMillis();
		ArraySortingBubble.bubbleSort(ar4, 0, ar4.length-1);
		q = System.currentTimeMillis() - ct;
		System.out.println("Bubble: " + ar4.length+ " " + q + " " + isArraySorted(ar4));
//		for (int i=0 ; i < ar4.length ; i++) System.out.print(ar4[i] + " ");
	
	
	}

	public static void writeArrayToFile (String file, int[] x) throws IOException{
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
		outputStream.writeObject(x);
		outputStream.flush();
		outputStream.close();
		System.out.println("Writing is Done");
		}

	public static int[] readArrayFromFile (String file) throws IOException, ClassNotFoundException{
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
		
		int [] x = (int[])inputStream.readObject();
		
		inputStream.close();
		System.out.println("Reading is Done");
		return x;
}

	public static boolean isArraySorted (int[] ar) {
		for (int i = 0; i < ar.length-1; i++) {
			if (ar[i] > ar[i+1]) return false;
		}
		
		return true;
		
	}
}