package QuizesOld;

// Find most frequently occurring element in an Array

import java.util.*;

public class ArrayFrequentOccuringElement {

	public static void fillAr(Integer[] ar) {
		Random randomGenerator = new Random();
		for (int i =0; i <ar.length; i++) {
			ar[i] = randomGenerator.nextInt(ar.length/10);
		}
	}
	
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[100];
		fillAr(arr);
		System.out.println(Arrays.toString(arr));
		
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		Integer c = 0;
		
		for (Integer i : arr) {
            c = hm.get(i);
            hm.put(i, (c == null) ? 1 : c + 1);
        }
		
		Integer maxval = 0;
		Integer kmv = 0;
		
		for(Integer k: hm.keySet()) {
			if ( maxval < hm.get(k) ) {
				kmv = k;
				maxval = hm.get(k);
			}
			
//			kmv = ( maxval < hm.get(k) ) ? k : kmv;
//			maxval = (maxval < hm.get(k) ) ? hm.get(k) : maxval;
		}
	
		
		System.out.println(hm);
		System.out.println("MAXVAL: " + kmv + " " + maxval);
	}

}
