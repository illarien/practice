package QuizesOld;

import java.util.*;

// Polindrome in string

public class WordsPolindrome {

	public static int polindrome(String str) {
		boolean ret = false;
		int sl = str.length();
		String[] ar = new String[sl];
		ar = str.split("");
	
		for (int i = 1; i < ar.length-2; i++) {
			if (ar[i-1].equals(ar[i+1])) {
		//		ret = true; break;
				return i;};
			if ( ar[i].equals(ar[i+1]) || ar[i-1].equals(ar[i+2]) ) {
		//		ret = true; break;
				return i;}
		}
		return 0;
		//		ret;
	}
	
	public static ArrayList<Integer> locateAllPolindrmesIndex(String str) {
		ArrayList<Integer> out = new ArrayList<Integer>();
		List<String> ar = new ArrayList<String>(Arrays.asList(str.split("")));
		for (int i = 1; i < ar.size()-1; i++) {
			if (ar.get(i-1).equals(ar.get(i+1))) {out.add(i);};
			if ( ar.get(i).equals(ar.get(i+1)) ) {out.add(i);}
		}
		return out;
	}
	
	
	
	public static List<String> getPolindrome(String str, int center, int len) {
		List<String> out = new ArrayList<String>();
		ArrayList<String> strar = new ArrayList<String>(Arrays.asList(str.split("")));
		
		// not implemented yet
		for (int i = center - len + 1; i < center + len; i++) {
			out.add(strar.get(i));
			
		}
		
		
		System.out.println("Inline: " + strar);
		System.out.println("Out: " + out);
		return out;
	}
	
	public String returnPolindromes(String str) {
		String out = "";
		boolean chet = false;
		int sl = str.length();
		String[] ar = new String[sl];
		ar = str.split("");
		
		for (int i = 1; i < ar.length-2; i++) {
			if (ar[i-1].equals(ar[i+1])) {chet = false; break;};
			if ( ar[i].equals(ar[i+1]) || ar[i-1].equals(ar[i+2]) ) {chet = true; break;}
		}
		
		
		
		
		if (chet) {}
		if (!chet) {}
		
		
		
		return out;
	}
	

	public static int polindromeLength(String str, int center) {
		int k = 1;
		int cOfStr = center-1;
		System.out.println("Center: " + str.charAt(cOfStr));
		while (true) {
			if ( (str.length() > cOfStr+k) && str.charAt(cOfStr-k) == str.charAt(cOfStr+k) ) {k++;}
			else break;
		}
		System.out.println("length: " + k);
		return k;
	}
	
	
	
	public static void main(String[] args) {
		String example = "abcedAdesweRewsfgHg";
		ArrayList<Integer> located = new ArrayList<Integer>();
//		System.out.println(polindrome(example));
		located = locateAllPolindrmesIndex(example);
		System.out.println("N of pol: " + located.size() + " " + located);

		int offset = polindromeLength(example, 6);
		
		getPolindrome(example, 6, offset);

		for (int i = 0; i < located.size(); i++){
			offset = polindromeLength(example, located.get(i));
			getPolindrome(example, located.get(i), offset);
		}
	}

}
