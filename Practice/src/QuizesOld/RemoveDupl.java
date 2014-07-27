package QuizesOld;

import java.awt.List;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;
import java.lang.Object;



public class RemoveDupl {
//	private static Integer [] ar={1,2,3,3,2,3,4,2,4,3};
	private static Object [] t;
	
	static Object [] RemoveDups(Integer [] a){
		HashSet <Integer> hashSet = new HashSet <Integer>();
		for (int i: a)
			hashSet.add(i);
		Object [] arrOut = hashSet.toArray();		
		return arrOut;
	}
	
	public static ArrayList<Integer> returnArray(int[] arr) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for (int j = 0; j < arr.length; j++) {
				if(!arrList.contains(arr[j])) 
					arrList.add(arr[j]);	
		}
		return arrList;
	}

	public static TreeSet <Integer> returnTreeSet(int[] arr) {
		TreeSet <Integer> tree = new TreeSet <Integer>();
		for (int i: arr)
			tree.add(i);
		return tree;
	}
	
	public static void main(String [] args){
		
		int n = 5000000; // number of elements
		Integer [] array = new Integer[n];
		Random randomGenerator = new Random(10);
		System.out.println("0");
		//---
		for (int i =0; i <n; i++) {
			array[i] = randomGenerator.nextInt(10000);
		}
		System.out.println("1");
		//---
		int [] arrayI = new int[n];
		for (int i =0; i <n; i++) {
			arrayI[i] = randomGenerator.nextInt(10000);
		}
		System.out.println("2");
		//---
		int [] arrayII = new int[n];
		for (int i =0; i <n; i++) {
			arrayII[i] = randomGenerator.nextInt(10000);
		}
		System.out.println("3");
		
		long q;
		long ct;
		
		ct = System.currentTimeMillis();
		t = RemoveDups(array);
		q = System.currentTimeMillis() - ct;
		System.out.print("Hash: " + array.length+ " " + ct + " " + q + " " + t.length + " Contains: ");
//		for (Object b:t)	System.out.print(b+" ");
		System.out.println();
		
		ct = System.currentTimeMillis();
		ArrayList<Integer> w = returnArray(arrayI);
		q = System.currentTimeMillis() - ct;
		System.out.print("List: " + arrayI.length+ " " + ct + " " + q+ " " + w.size() + " Contains: ");
//		for (int r = 0; r < w.size(); r++)	System.out.print(w.get(r)+" ");
		System.out.println();
		
		ct = System.currentTimeMillis();
		TreeSet<Integer> treeS = returnTreeSet(arrayII);
		q = System.currentTimeMillis() - ct;
		System.out.print("Tree: " + arrayII.length + " " + ct + " " + q+ " " + treeS.size() + " Contains: ");
//		Iterator<Integer> iterator = treeS.iterator();
//       while (iterator.hasNext()) {
//            System.out.print(iterator.next() + " ");
 //       }
        System.out.println();
		
	}

	
	
	
	
}
