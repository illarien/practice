package Quizes;

import java.util.ArrayList;

public class Palindrome {
	
	static int counter = 0;
	static final int end = 10001;
	static ArrayList<Integer> palimdromes = new ArrayList<Integer>();
	
	static int reverseInt (int in) {
		int out = 0;
		while (in != 0) {
			out *= 10;
			out += in%10;
			in /= 10;
		}
		return out;
	}
	
	public static void main(String[] args) {
		for (int i = 1; i < end; i++) {		
			if ( (i^reverseInt(i)) == 0 ){
				counter++;
				palimdromes.add(i);
			}
		}
		System.out.println("Number of palindromes: " + counter);
		System.out.println(palimdromes);
	}

}
