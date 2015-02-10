package Q;

import java.util.*;


// Check that Linkedlist is palindrome.


public class LinkedListPalindromeCheck {

	public static boolean checkP1 (String in) {
		return in.equals( new StringBuilder(in).reverse().toString());
	}
	
	public static boolean checkP2 (StringBuilder in) {
		int i= 0;
		int j = in.length()-1;
		while (i<j) {
			if (in.charAt(i) != in.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	
	public static void main(String[] args) {

		List<String> in = new LinkedList<String>(Arrays.asList("a", "bcd", "ef", "e","dc", "ba"));
		
		StringBuilder inStr = new StringBuilder("");
		for (int i =0; i < in.size(); i++) {
			inStr.append(in.get(i));
		}
		System.out.println(inStr);
		
		
		
		
		if (checkP1(inStr.toString())) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a palindrome");
		}

		if (checkP2(inStr)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a palindrome");
		}
		
	}

}
