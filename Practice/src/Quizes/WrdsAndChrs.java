package Quizes;

import java.util.*;

class WrdsAndChrs {

  static String[] wrds = {"abc", "baa", "caan", "ann", "an", "banc", "bank", "fff"};
  static String[] chr = {"a", "a", "n", "c", "b"};
  static HashMap<String,Integer> wrdsM, chrM;
  
  public static HashMap<String,Integer> toMap(String[] str) {
    HashMap<String, Integer> hm = new HashMap<String,Integer>();
    
    for (String s: str) {
      if (!hm.containsKey(s)) {
    	hm.put(s, 1);
      } else {
    	hm.put(s, (hm.get(s) + 1) );
      }
      //System.out.println("Map size: " + hm.size() + " " + s);
    }
    
    return hm;
  }
  
  public static boolean compareMaps(HashMap<String, Integer> lett, HashMap<String, Integer> words) {
	 
	  for(String s : words.keySet()) {
		  if ( !lett.keySet().contains(s)) {
			  return false;
		  }
		  if (lett.get(s) < words.get(s)) {
			  return false;
		  }
		  
	  }
	  
    return true;
  }
  
  public static void main(String[] args) {
	  
	  int counter = 0;
	  String out = "";
	  ArrayList<String> answ = new ArrayList<String>();
	  chrM = toMap(chr);
	  System.out.println("Character set: " + chrM);
	  
	  
	  for (String s : wrds) {
		  String[] ar = s.split("(?!^)");
		  wrdsM = toMap(ar);
		  System.out.println( s + " " + ar.length + " " + wrdsM + " " + compareMaps(chrM, wrdsM));
		  
		  if (compareMaps(chrM, wrdsM)) {
			 if (s.length() > counter) {
				 counter = s.length();
				 answ.clear();
				 answ.add(s);
			 } else if (s.length() == counter) {
				 answ.add(s);
			 }
		  }
		  
	  }
	  System.out.println("Answ: " + answ + " " + counter);
	  
	  
	  
	  
  }
}
