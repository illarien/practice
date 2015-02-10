package Q;

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

	static int[] arr = {1,2,4,5,7,9,13};
	static int[] arr2 = {0,3,6,8,10,11,12,14,15,16};
	static ArrayList<DataInputStream> streams = new ArrayList<DataInputStream>();
	
	private static void createStream(int[] arr, int n) {
		String file = "tmp"+ n +".txt";
		try {
			DataOutputStream s = new DataOutputStream(new FileOutputStream(file));
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
	
	private static ArrayList<Integer> fillCache(ArrayList<DataInputStream> streams) throws Exception {
		ArrayList<Integer> out = new ArrayList<Integer>();
		for (DataInputStream s: streams) {
			int value;
			if ((value = s.readInt()) != -1) {
				out.add(value);
			}
		}
		return out;
	}
	
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
	
	private static void refillCache(int ind, ArrayList<DataInputStream> streams)  throws Exception {
		try {
			int value = streams.get(ind).readInt();
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
			
//			int val;
//			while ( (val = s2.readInt()) != -1) {
//				System.out.println("S: " + val);
//			}
			
					
			cache = fillCache(streams);
			
			while (streams.size() > 0) {
				System.out.println("Cache: " + cache);
				getSmallest(cache);
				System.out.println(index + " " + smallest);
				output.add(smallest);
//				System.out.println("added");
				refillCache(index, streams);
				System.out.println("Ch2: " + cache);
				System.out.println("Output: " + output);
			}
			
			
		} catch (Exception e) {}
			

	}

}
