package Quizes;

import java.util.*;

public class Brackets {

	public static HashSet<String> hs = new HashSet<String>();
	
	public static void permutation(String str){
		permutation("", str);
	}
	
	public static void permutation(String pref, String str) {
		int n = str.length();
		
		
		if (n == 0) {
						
			//System.out.println(pref);
			if (checkBrackets(pref)) { hs.add(pref);}

		} else {
			for(int i = 0; i < n; i++) {
				permutation(pref + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
			}
		}
	}
	
	
	
	public static boolean checkBrackets (String str) {
		if (str.length() < 2) { return false; }
		//System.out.println(str);
		Stack<Character> stack = new Stack<Character>();
		char[] brackets = str.toCharArray();
		for (int i = 0; i<brackets.length;i++) {
			if ( brackets[i] == '(' ) {
				stack.push('(');
			}
			if (brackets[i] == ')' ) {
				if ( stack.size() > 0 && stack.peek().equals('(') ) { 
					stack.pop(); 
					}
				else { 
					return false; 
					}
			}
			//System.out.println(stack);
		}
		return (stack.size() == 0 );
	}
	
	
	public static void main(String[] args) {
		permutation("((()))");
		System.out.println(hs);
	}

}
