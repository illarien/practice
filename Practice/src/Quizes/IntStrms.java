package Quizes;

import java.util.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Twitter question sent by Yohan
 * See FB messages for details
 *
 */

public class IntStrms {

	/**
	 * Two arrays to create streams and List of streams
	 */
	static final int[] arr = {1,2,4,5,7,9,13};
	static final int[] arr2 = {0,3,6,8,10,11,12,14,15,16};
	static ArrayList<DataInputStream> streams = new ArrayList<DataInputStream>();
	
	/**
	 * Create Stream from array
	 * @param arr - source data array
	 * @param n - number of stream for file name
	 */
	private static void createStream(int[] arr, int n) {
		final String file = "tmp"+ n +".txt";
		try {
			final DataOutputStream s = new DataOutputStream(new FileOutputStream(file));
			for (int i = 0; i < arr.length; i++) {
				s.writeInt(arr[i]);
			}
			s.close();
		} catch (Exception e) {}

	}
	
	static ArrayList<Integer> cache;
	static int index;
	static int smallest;
	static List<Integer> output = new ArrayList<Integer>();
	
	/**
	 * Fill empty cache from given streams
	 * @param streams - List of Streams
	 * @return - List of Integer - cache
	 * @throws Exception
	 */
	private static ArrayList<Integer> fillCache(ArrayList<DataInputStream> streams) throws Exception {
		ArrayList<Integer> out = new ArrayList<Integer>();
		for (DataInputStream s: streams) {
			final int value;
			if ((value = s.readInt()) != -1) {
				out.add(value);
			}
		}
		return out;
	}
	
	/**
	 * Get smallest Integer from List
	 * @param lin - List of Integer
	 */
	private static void getSmallest(List<Integer> lin) {
		int tempIndex = 0;		
		for (int i = 1; i < lin.size(); i++) {
			if (lin.get(i) < lin.get(tempIndex) ) {
				tempIndex = i;
			}
		}
		index = tempIndex;
		smallest = lin.get(tempIndex);
	}
	
	/**
	 * Refill cache after getting smallest Integer
	 * @param ind - index of Integer(Stream) that was got
	 * @param streams - List of Streams
	 * @throws Exception
	 */
	private static void refillCache(int ind, ArrayList<DataInputStream> streams)  throws Exception {
		try {
			final int value = streams.get(ind).readInt();
			cache.set(ind, value);
		} catch (Exception e) {
			cache.remove(ind);
			streams.remove(ind);
		}
	}
	
	public static void main(String[] args) {
		
		createStream(arr, 1);
		createStream(arr2, 2);
		
		try {
			DataInputStream s1 = new DataInputStream(new FileInputStream("tmp1.txt"));
			DataInputStream s2 = new DataInputStream(new FileInputStream("tmp2.txt"));
			streams.add(s1);
			streams.add(s2);
			
					
			cache = fillCache(streams);
			
			while (streams.size() > 0) {
				System.out.println("Cache before: " + cache);
				getSmallest(cache);
				System.out.println("Smallest: index: " + index + " value: " + smallest);
				output.add(smallest);
//				System.out.println("added");
				refillCache(index, streams);
				System.out.println("Cache after: " + cache);
				System.out.println("Output: " + output);
			}
		} catch (Exception e) {}
	}
}
