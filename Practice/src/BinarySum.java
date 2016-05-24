import java.util.ArrayList;

/**
 * FB 1st phone screen
 */
public class BinarySum {

	public static void main(String[] args) {
		String s1 = "100", s2 ="1"; // "1101"
		System.out.println("aaa " + s1 + "+" + s2);
		System.out.println(addBinary(s1, s2));
	}

	
	public static String addBinary(String s1, String s2) {   
	if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
	      throw new IllegalArgumentException();
	  }
	  
	  boolean extra = false;
	  ArrayList<String> result = new ArrayList<String>();
	  
	  int c1 = s1.length()-1, c2 = s2.length()-1; //c1 = 4, c2 = 2
	  
	  while (c1 > -1 && c2 > -1) {
	    if ( s1.charAt(c1) == '0' && s2.charAt(c2) == '0' ) {    // 1,0, false; 1,1,false
	        result.add(extra ? "1" : "0");
	        extra = extra ? false : false;
	    } else if ( (s1.charAt(c1) == '0' && s2.charAt(c2) == '1') || (s1.charAt(c1) == '1' && s2.charAt(c2) == '0')  ) {
	        result.add(extra ? "0" : "1");   // res:1,
	        extra = false;
	    } else {
	        if (extra) {
	          result.add("1");
	        } else {
	          result.add("0"); // res: 1,0 true;
	        }
	        extra = true;
	    }
	    c1--;
	    c2--;
	  }
	  
	  System.out.println("3: " + result.size() + " " + extra + " c1: " + c1);
	  
	  while (c1 > -1) { 
	    if (extra) {
	      if (s1.charAt(c1) == '0') {
	        result.add("1"); // res: 1,0,1 false
	        extra = false;
	      } else {
	    	  result.add("0");
	      }
	    } else {
	        result.add(s1.charAt(c1)+""); // res: 1,0,1,1, false
	    }
	    c1--;
	  }
	  
	  System.out.println("4: " + result.size() + " " + extra + " c1: " + c1);
	  
	  while (c2 > -1) {
	      if (extra) {
	    	  if (s2.charAt(c2) == '0') {
	    		  result.add("1");
	    		  extra = false;
	    	  }
	      } else {
	        result.add(s1.charAt(c2)+"");
	      }
	      c2--;
	  }
	  
	  System.out.println("5: " + result.size() + " " + extra);
	  
	  if (extra) {
	    result.add("1");
	  }
	  
	  System.out.println("6: " + result.size() + " " + extra);
	  
	  StringBuilder sb = new StringBuilder();
	  for (int i = result.size()-1; i >= 0; i--) { //1,0,1,1 -> 1101
	    sb.append(result.get(i));
	  }
	  
	  return sb.toString(); // "1101"
	}
}