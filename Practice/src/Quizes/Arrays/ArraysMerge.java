package Quizes.Arrays;

//Given two sorted integer arrays (with duplicates in each array possible),
//return the union of the two arrays in sorted order with no duplicates.
//For example: {1, 2, 3, 4, 5} + {2, 4, 6, 8, 10} => {1, 2, 3, 4, 5, 6, 8, 10}

import java.util.*;

public class ArraysMerge {

	public static Set<Integer> mergeArrays(int[] a1, int[] a2) {
        Set<Integer> out = new TreeSet<Integer>();
        for (int e: a1) {
            out.add(e);
        }
        for (int e: a2) {
        out.add(e);
        }
    //    System.out.println(out);
        return out;
    }
	
	
    public static int[] mergeArrays2 (int[] a1, int[] a2) {
    	int outLength = a1.length + a2.length;
	    int [] out = new int [outLength];
// oshibka, nado ispolzovat arraylist ili removit dupblicates potom	        
	    int i = 0; // first
	    int j = 0; // second
	    int k = 0; // main
	        
	    while (k < outLength && i < a1.length && j < a2.length) {
	    	if (a1[i] < a2[j] ) { 
	    		if (out[k] < a1[i]) out[k] = a1[i];
	    		i++; k++;
	    		continue;}
	    	
	        else {
	        	if (out[k] < a2[j]) out[k] = a2[j];
	        	j++; k++;
	        	continue;}
	        	
//	        k++;
	    }
	     
	    System.out.println(i +"-i"+ j + k);
	    
	    while (i < a1.length) {
	    	out[k] = a1[i];
	    	i++;
	        k++;
	    }
	        
	    while (j < a2.length) {
	    	out[k] = a2[j];
	    	j++;
	    	k++;
	    }
	    return out;
    }
	
	
	public static void main(String[] args) {
		int[] in1 = {5, 7, 11, 56, 71, 101};
		int[] in2 = {8, 11, 56, 67, 70, 90, 99};
		System.out.println(mergeArrays(in1, in2));
		int[] out2 = mergeArrays2(in1, in2);
		
		for (int i = 0; i < out2.length; i++) {
			System.out.print(out2[i] + " ");
		}
		
	}

}
