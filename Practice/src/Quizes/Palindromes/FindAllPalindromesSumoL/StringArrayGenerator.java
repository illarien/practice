package Quizes.Palindromes.FindAllPalindromesSumoL;

import java.util.Random;

public class StringArrayGenerator {

	public static String[] generateArray(int length) {
		String[] out = new String[length];
		
		Random randomGenerator = new Random();
		
		for (int i =0; i < out.length; i++) {
			out[i] = Integer.toString(randomGenerator.nextInt());
		}
		
		return out;
	}
}
