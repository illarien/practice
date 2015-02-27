package Quizes.Arrays;

import java.util.*;

public class ArrayAnagramm {

	public static ArrayList<String> strToList(String word) {
		String[] arr1 = word.split("");
		ArrayList<String> lst = new ArrayList<String>();
		for(int i = 1; i < arr1.length; i++) {
			lst.add(arr1[i]);
		}
//		System.out.println(lst);
		return lst;
	}
	
	public static boolean isAnagramm(String word1, String word2) {
		char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        HashMap<Character,Integer> hm1 = new HashMap<Character,Integer>();
        HashMap<Character,Integer> hm2 = new HashMap<Character,Integer>();
        
        for(char c : c1){
        	if (hm1.get(c) == null) {hm1.put(c, 1);}
        	else {hm1.put(c, (hm1.get(c) + 1));};
 
        	}
        System.out.println("Hash1: " + hm1);
        
        for(char c : c2){
        	if (hm2.get(c) == null) {hm2.put(c, 1);}
        	else {hm2.put(c, (hm2.get(c) + 1));};
        	
        	}
        System.out.println("Hash1: " + hm1);
       
        if (hm1.equals(hm2)) return true;
        else return false;
	}
	
	
	public static boolean isAnagrammChar(String word1, String word2) {
		if ( word1.length() != word2.length() ) {
            return false;
        }

        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String sc1 = new String(c1);
        String sc2 = new String(c2);
        return sc1.equals(sc2);
	}
	
	public static boolean isAnagrammList(String word1, String word2){
		if (word1.length() < 1 || word2.length() < 1) return false;
		if (word1.length() != word2.length()) return false;
			
		ArrayList<String> l1 = strToList(word1);		
		ArrayList<String> l2 = strToList(word2);
		System.out.println(l1);
		System.out.println(l2);
		
		int iter1 = 0;
		int iter2 = 0;
		while ((l1.size() > 0 ) && (iter1 < l1.size()) ) {
			iter2 = 0;
			while ((l2.size() > 0 ) && (iter2 < l2.size()) ) {
				if (l1.get(iter1).equals(l2.get(iter2))) {l1.remove(iter1); l2.remove(iter2); iter1--;}
				else {iter2++;}
			}
			iter1++;
		}

		if (l1.size() == 0 && l2.size() == 0) return true;
		else return false;
	}
	
	public static int findAnagramm(String word, ArrayList<String> al) {
		for (int i = 0; i < al.size(); i++ ) {
			if (isAnagramm(word, al.get(i))) {return i;}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		
//		strToList("word");
		isAnagramm("words", "sword");
		
		
				
		String[] arr = {"bu", "an", "tar", "rat", "nanaba", "ub", "atr", "banana", "na"};
		ArrayList<String> ls = new ArrayList<String>();
		ArrayList<String> lo = new ArrayList<String>();
		for (int i =0; i < arr.length; i++) {
			ls.add(arr[i]);
		}
		
		
		System.out.print(ls);
		System.out.println(ls.size());
		System.out.print(lo);
		System.out.println(lo.size());
		
		System.out.println(isAnagramm(ls.get(0),ls.get(3)));
		System.out.println(isAnagramm(ls.get(0),ls.get(6)));
		System.out.println("wwwww");
		
		
		while (ls.size() > 0) {
			String temp = ls.get(0);
			lo.add(temp);
			ls.remove(0);
			
			int n = 0;
			while (n < ls.size()) {
				
				if (isAnagramm(temp, ls.get(n))) {
					lo.add(ls.get(n));
					ls.remove(n);
				}
				else n++;
			}
			System.out.println("lotemp : " + lo);
		}
		
		
		
		System.out.println(ls);
		System.out.println(lo);

}
}
