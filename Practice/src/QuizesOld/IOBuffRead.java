package QuizesOld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class IOBuffRead {

	// override public String toString () {
	//	return "name";
	// }
	
	public int cacAdd () {
		return 4;
	}
	
	public static void main(String[] args) throws IOException {
		String str1 = new String ();
		String str2 = new String ("stop");
	/*	str1 = "abcd";
		str2 = "de";
		System.out.println(str2.compareTo(str1)); */
		BufferedReader bfr = new BufferedReader(new InputStreamReader(
				System.in));

		while (!str1.equals(str2)) {
			str1 = bfr.readLine();
			System.out.println(str1);
		}

	}

}
