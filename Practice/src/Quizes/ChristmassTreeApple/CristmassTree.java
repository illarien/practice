package Quizes;

public class CristmassTree {

	final static int[] levels = {3,5,7};
	final static int levelLength = levels.length;
	final static int wide = 17; // calculate it
	final static int base = 0;
	static int n = 0;
	static String out = "";
		
	
	static String addChar (String str, int n, String add) {
		for (int i = 0; i < n; i++) {
			str += add;
		}
		return str;
	}
	
		
//	static String level (int base, int level ) {
//		int n = base + 2*level;
//		String out = "";	
//		return out;
//	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < levelLength; i++) {
			for (int j = 0; j < levels[i]; j++) {
				n = 2*i + 2*j + 1;
				out = addChar( addChar("", (wide - n)/2, " "), n, "x");
				System.out.println(out);
			}
		}
		for (int i = 0; i < 2; i++) {
			n = 3;
			out = addChar( addChar("", (wide - n)/2, " "), n, "=");
			System.out.println(out);
		}
		

	}

}
