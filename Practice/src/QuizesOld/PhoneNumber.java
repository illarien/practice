package QuizesOld;

import java.util.*;

public class PhoneNumber {

	public static void main(String[] args) {
		String pL = "1-800-COMCAST";
		String out = "";
		char[] in = pL.toCharArray();
		
		for(int i = 0; i < in.length; i++) {
			out += (in[i] == '1') ? "1" : (in[i] == '8') ? "8" : (in[i] == '0') ? "0" : "";
			out += (in[i] == 'A'||in[i] == 'B'||in[i] == 'C') ? "2" : "";
			out += (in[i] == 'D'||in[i] == 'E'||in[i] == 'F') ? "3" : "";
			out += (in[i] == 'G'||in[i] == 'I'||in[i] == 'H') ? "4" : "";
			out += (in[i] == 'J'||in[i] == 'K'||in[i] == 'L') ? "5" : "";
			out += (in[i] == 'M'||in[i] == 'N'||in[i] == 'O') ? "6" : "";
			out += (in[i] == 'P'||in[i] == 'Q'||in[i] == 'R'||in[i] == 'S') ? "7" : "";
			out += (in[i] == 'T'||in[i] == 'U'||in[i] == 'V') ? "8" : "";
			out += (in[i] == 'W'||in[i] == 'X'||in[i] == 'Y'||in[i] == 'Z') ? "9" : "";
			
		}
		
		System.out.println("Out: " + out);

	}

}
