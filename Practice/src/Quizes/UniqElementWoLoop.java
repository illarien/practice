package Quizes;

/*
 * Write a program to find the distinct elements out of an array but not using loop, using XOR
 */

import java.util.Arrays;

public class UniqElementWoLoop {

	public static int[] arr = {1,2,2,7,8,9,8,7,9};
	
	public static int uniqInstatce (int[] in) {
		if (in.length == 1) {
			return in[0];
		}
		return in[0]^uniqInstatce(Arrays.copyOfRange(in, 1, in.length));
	}
	
	public static void main(String[] args) {
		System.out.println(uniqInstatce(arr));
	}
}
