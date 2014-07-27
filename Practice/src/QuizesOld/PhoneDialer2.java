package QuizesOld;

import java.util.*;

public class PhoneDialer2 {

	public static int[] intToArr(int n) {
		String s = "";
		s += n;
		int[] out = new int[s.length()];
		for (int i = 0; i < out.length; i++) {
			out[s.length() - i - 1] = n%10;
			n /=10;
		}
		return out;
	}
	
	public static void permut(int[] n, Map<Integer, String[]> m) {
		int[] c = new int[n.length];
		String out = "";
		int counter = 0;
		while (c[n.length-1] < (n.length) ) {
			if ( c[0] == -1 ) break;
			out ="";
			for (int i = 0 ; i < n.length; i++) {
				out += m.get(n[i])[c[i]];
			}
			System.out.println(out);
			counter++;
			addCounter(c, 0);
		}
		System.out.println(counter);
	}
	
	public static int[] addCounter(int[] co, int n) {
		if (n == co.length ) {co[0] = -1; return co;} 
		if ( co[n] < 2) {co[n]++; return co;}
		else { 
			for (int j = 0; j <= n; j++) {co[j] = 0;} 
			addCounter(co, n+1); return co;}
	}
	
	public static void main(String[] args) {
		
		Map<Integer, String[]> m = new HashMap<Integer, String[]>();
		m.put(1, new String[] {"a","b","c"});
		m.put(2, new String[] {"d","e","f"});
		m.put(3, new String[] {"g","h","i"});
		m.put(4, new String[] {"j","k","l"});
		m.put(5, new String[] {"m","n","o"});
		m.put(6, new String[] {"p","q","r"});
		m.put(7, new String[] {"s","t","u"});
		m.put(8, new String[] {"v","w","x"});
		m.put(9, new String[] {"y","z"});
		
		int num = 12357;
		String out = "";
		int[] n = intToArr(num);
		
		out = m.get(1)[0];
	
		permut(n, m);
		
	}

}
