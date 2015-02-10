package QuizesOld;

// Sorting - merge

public class ArraysSortingMerge {

	public static void main(String[] args) {
//		int[] in1 = {5, 7, 56, 71, 101};
		int[] ar = {562, 68, 5, 101, 7411, 8, 11, 721, 70, 901, 99, 56, 7, 5, 131, 710, 8, 11, 71, 70, 90, 99};

		mergSort(ar, 0, ar.length-1);

		for (int z=0; z< ar.length;z++){System.out.print(ar[z] + " ");}	
	}

	public static void mergeSegm(int[] ar, int st1, int end1, int st2, int end2) {
		  
	    int aLength = end1 - st1 +1;
	    int bLength = end2 - st2 +1;
	    int cLength = aLength + bLength;
	    
	    int [] a = new int[aLength];
	    int [] b = new int[bLength];
	    
	    for (int v = 0; v < aLength; v++) {a[v] = ar[st1+v];};
	    for (int v = 0; v < bLength; v++) {b[v] = ar[st2+v];};
	    
	    int i = 0;
	    int j = 0;
	    int k = 0;
    
	    while (k < cLength && i<aLength && j<bLength) {
	    		if (a[i] <= b[j]) {ar[st1 + k] = a[i]; i++;}
	            else {ar[st1 + k] = b[j]; j++;};
	    	k++;
	    }

	    while (i < aLength){ar[st1 + k] = a[i]; 
	        k++; i++;}
	        
	    while (j < bLength){ar[st1 + k] = b[j]; 
	     	k++; j++;}    
	}
	
	public static void mergSort(int[] a, int p, int r) {
		if ( r-p <1 ) {return;}
		else if (r-p < 2) {compAndSwapXOR(a, p, r); return;}
		else {
			int q = (r-p)/2;
//			System.out.println("Q " + q);
			mergSort(a, p, p+q);
			mergSort(a, p+q+1, r);
			mergeSegm(a, p, p+q, p+q+1, r);
		}
	}

	public static void compAndSwapXOR(int [] a, int i, int j){
		if (i < j && a[i] > a[j]) {
			a[i] ^= a[j];
			a[j] = a[i] ^ a[j];
			a[i] ^= a[j];
		}
	}

}