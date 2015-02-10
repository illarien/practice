package QJunit;

import java.util.*;

public class Odd {

	public List<Integer> findOdd(int n) {
		List<Integer> out = new LinkedList<Integer>();
		for (int i = 0; i <= n; i++) {
			if (i%2 == 1) {
				out.add(i);
			}
		}
		return out;
	}
	
	public String fixEscapes (String in) {
		String out = "";
		for (int i = 0; i < in.length(); i++) {
			if ( in.charAt(i) == ' ' ) {
				out += "\\ ";
			} else if ( in.charAt(i) == '&' ) {
				out += "\\&";
			} else {
				out += in.charAt(i);
			}
		}
		return out;
	}
}
