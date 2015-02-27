package Quizes.Arrays;

// merge sorted array old

public class ArrayMergeSortedArraysOld {

	public static void main(String[] args) {
		int[] in1 = {5, 7, 56, 71, 101};
		int[] in2 = {8, 11, 67, 70, 90, 99};
		int[] out = merge(in1, in2);
	//	System.out.println(out[0] + " ");
		for (int z=0; z< out.length;z++){System.out.print(out[z] + " ");}
	}

	
	public static int[] merge(int[] a, int[] b) {
	  
	    int aLength = a.length;
	    int bLentgh = b.length;
	    int cLength = aLength + bLentgh;
	    
	    int i = 0;
	    int j = 0;
	    int k = 0;
	    int[] c = new int[cLength];
	    System.out.println("a");
	    
	    while (k < cLength && i<aLength && j<bLentgh) {
//		    System.out.println("b" + cLength);
//	    	if (i < aLength && j < bLentgh) {
	    		if (a[i] <= b[j]) {c[k] = a[i]; i++;}
	            	else {c[k] = b[j]; j++;};
//	        }
	    	k++;
	    }
	    
	    
	    System.out.println("c");
	   
	    while (i < aLength){c[k] = a[i]; 
//	        System.out.println(c[k]);
	        k++; i++;}
	        
	    while (j < bLentgh){c[k] = b[j]; 
//	     	System.out.println(c[k]);
	     	k++; j++;}    
	    
	    return c;
	}

	public static void compAndSwapXOR(int [] a, int i, int j){
		if (i < j && a[i] > a[j]) {
			a[i] = a[i] ^ a[j];
			a[j] = a[i] ^ a[j];
			a[i] = a[i] ^ a[j];
		}
	}

}