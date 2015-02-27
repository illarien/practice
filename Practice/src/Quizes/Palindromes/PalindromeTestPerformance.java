package Quizes.Palindromes;

// Palindrome performance test

public class PalindromeTestPerformance {

	public static boolean checkP1 (String in) {
		return in.equals( new StringBuilder(in).reverse().toString());
	}
	
	public static boolean checkP2 (String in) {
		char[] word = in.toCharArray();
		int i1 = 0;
	    int i2 = word.length - 1;
	    while (i2 > i1) {
	        if (word[i1] != word[i2]) {
	            return false;
	        }
	        i1++;
	        i2--;
	    }
	    return true;
	}
	
	public static boolean checkP3 (String input) {
	    char[] in = input.toCharArray();
	    int j = input.length()-1;
	    for (int i =0; i < input.length()/2; i++) {
	        if ( in[i] != in[j-i] ) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
	public static void main(String[] args) {
		String str = "abcdcba";
		long start;
//		------		
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			checkP2(str);
		}
		start = System.currentTimeMillis() - start;
		System.out.println("" + start );
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			checkP2(str);
		}
		start = System.currentTimeMillis() - start;
		System.out.println("" + start );
//		------			
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			checkP1(str);
		}
		start = System.currentTimeMillis() - start;
		System.out.println("" + start );
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			checkP1(str);
		}
		start = System.currentTimeMillis() - start;
		System.out.println("" + start );
//		------			
		System.out.println(checkP3("abchcba"));
//		------			
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			checkP3(str);
		}
		start = System.currentTimeMillis() - start;
		System.out.println("" + start );
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			checkP3(str);
		}
		start = System.currentTimeMillis() - start;
		System.out.println("" + start );

	}

}
