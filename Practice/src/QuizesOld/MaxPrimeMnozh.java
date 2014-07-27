package QuizesOld;

import java.math.BigInteger;
import java.util.*;

public class MaxPrimeMnozh {

/*	public ArrayList<BigInteger> prime(BigInteger num) {
		
		BigInteger fnd = num.divide();
		int m;
		boolean f;

		for (int i = 2; i <= num; i++) {
			f = true;
			m = Math.round(i/2);
			for (int j = 2; j<=m; j++) {
				if (i % j == 0) f = false;
			}
			if (f) System.out.print(i + " ");
		}
		
	}
	
	
	public int findMaxPrime (int num) {
		
	}
	
*/	
	
	public static void main(String[] args) {
		BigInteger number = new BigInteger("600851475143");
		BigInteger divider = number.divide(BigInteger.valueOf(2));
		System.out.println(divider);
		
		
		while (divider.compareTo(BigInteger.valueOf(2)) == 2) {
			if (divider.isProbablePrime((int) 0.75)) {
				System.out.println(divider);
				break;
			}
			divider.subtract(BigInteger.valueOf(1));
		}
		
	}

}
