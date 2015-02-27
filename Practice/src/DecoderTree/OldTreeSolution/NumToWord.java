package DecoderTree.OldTreeSolution;

import java.util.*;



public class NumToWord {

	public static boolean isnumber (String in) {
		HashSet<String> str = new HashSet<String>(Arrays.asList("1", "2","3","4","5","6","7","8","9","0")); 
		return str.contains(in);
	}
	
	
	public static String splitNext (String in) {
		String out = "";
		String[] sa = in.split("");
		
		for (int i = 1; i < sa.length; i++) {
			if (isnumber(sa[i])) {
				System.out.println("number");
				out += "n";
			} else {out += sa[i];}
		}
		
		System.out.println(out);
		return out;
	}
	
	public static ArrayList<String> decode (ArrayList<String> in) {
		ArrayList<String> out = new ArrayList<String>();
		for ( String s: in ) {
			String[] sta = s.split("");
			for (int i = 0; i < sta.length; i++) {
				//switch ( sta[i] ) {
				//case "1" :
				//}
			}
		}
		
		return in;
	}
	
	public static void main (String[] args) {
		String num = "1127";
		ArrayList<String> out = new ArrayList<String>();
		
		out.add(num);
		
		
		splitNext(num);
		
	}
	
	
}
