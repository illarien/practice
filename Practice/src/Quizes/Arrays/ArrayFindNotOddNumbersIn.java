package Quizes.Arrays;

// not finished, may be wrong idea, just use map

public class ArrayFindNotOddNumbersIn {

	public static void main(String[] args) {
		int[] a = {2,3,2,3,3,4,5,4,2,2,5,6};
		Integer x1 = null, xa = null, vb = null;
		for(int i = 0; i < a.length; i++) {
			x1 = (x1 != null) ? x1^a[i]: a[i]; 
		}
		System.out.println(x1);
		System.out.println(x1^a[1]);
		
		for(int i = 0; i < a.length; i++) {
			
		}
	
	}

}
