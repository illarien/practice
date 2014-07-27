package QuizesOld;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorialRec {

	public static void main(String[] args) throws IOException {
		int n = 10;
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String str1 = bfr.readLine();
		System.out.println(str1);
		
		
		int Res = factorialN(n);
		System.out.println("Res: " + n + "! = " + Res);
		

	}

	public static int factorialN (int n) {
		if (n < 2) {return n;}
		else {n *= factorialN(n-1);
			System.out.println("iter: " + n);
			return n;
		}
	}
	
	
}
