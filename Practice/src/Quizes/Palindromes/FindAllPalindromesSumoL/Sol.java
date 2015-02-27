package Quizes.Palindromes.FindAllPalindromesSumoL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* Sumologic
 * Given an array of Strings as the input, e.g. [BAC, EFG, GFE, ABC, GEF, X, GEFF,XX]
 * Output [X,BAC,EFG,GEFF, XX] 
 */

public class Sol {
	
	private static String[] arg = StringArrayGenerator.generateArray(1000);
	//String[] arg = {"BAC", "EFG", "GFE", "ABC", "GEF", "X", "GEFF", "XX"};
	
	// Solution 1
	public static String[] findPerms (String[] arg) {
		// After some thoughts I decided to use HashMap as a parent data structure,
		// because it has O(1) for insert and search operations and it's scalable
		HashMap<String, Data> hm = new HashMap<String, Data>();
		
		hm.put(arg[0], new Data(arg[0]));
		
		for (int i = 1; i < arg.length; i++) {
			// to avoid ConcurrentModificationException
			Set<String> keySet = hm.keySet();
			HashMap<String, Data> hm2 = new HashMap<String, Data>();
			
			for (String s: keySet) {
				if ( !hm.get(s).isAnagram(arg[i]) ) {
//					System.out.println("Not anagram: " + arg[i]);
					hm2.put(arg[i], new Data(arg[i]));
				}
			}
			hm.putAll(hm2);
		}
		
		return hm.keySet().toArray(new String[hm.keySet().size()]);	
	}
	
	// Solution 2
	public static String[] findPerms2 (String[] arg) {
		ArrayList<Data2> arr = new ArrayList<Data2>();
		
		for (int i = 0; i < arg.length; i++) {
			boolean hasAnagram = false;
			for (int j = 0; j < arr.size(); j++) {
				if ( arr.get(j).isAnagram(arg[i]) ) {
					hasAnagram = true;
					break;
				}
			}
			if (!hasAnagram) {
				arr.add(new Data2(arg[i]));
			}

		}
		
		String[] out = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			out[i] = arr.get(i).value;
		}	
		return out;
	}
	
	public static void printArr(String[] arr) {
		for (String s: arr) {
			System.out.print(s + " ");
		}
		System.out.println("");
	}
	
	
	public static void main (String[] args) {
		System.out.println("Anagrams");
		
		System.out.print("Input: ");
		printArr(arg);
//		System.out.print("Output1: "); - realy slow on long strings, cause OutOfMemoryError.
//		printArr(findPerms(arg));
		System.out.print("Output2: ");
		printArr(findPerms2(arg));
		
	}

}
