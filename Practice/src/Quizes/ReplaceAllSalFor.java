package Q;

/** Implement #replaceAll.
// You are only allowed to use the length() and charAt(int i) methods on the String class.
 */
 
public class SalFor {


    /**
     * Replaces each non-overlapping occurrence of the exact pattern in the source string
     * with the replacement string.
     * 
     * @param source
     * @param pattern
     * @param replacement
     * @return
     */
	public static String replaceAll(String source, String pattern, String replacement) {
        // validate inputs
        String subStr = "";
        String out = "";
        
        for (int i = 0; i < source.length() ; i++ ) { // error 1: no need to minus pattern.length. originally i didn't put -1
//        	System.out.println( (pattern.length() < (source.length()-i+1)) + " " + (source.charAt(i) == pattern.charAt(0)));
        	if ( pattern.length() < (source.length()-i+1) && source.charAt(i) == pattern.charAt(0) ) { // error 2: need +1  
            	subStr = source.substring(i, i+pattern.length());               
//                System.out.println(":::subout1 " + i + " " + subStr + " " + out);             
                if ( subStr.equals(pattern) ) {
                    out += replacement;
                    i += pattern.length()-1; // error 3: add -1  
//                    System.out.println(":::subout2 " + i + " " + subStr + " " + out);
                    continue; //err3
                }
            } else {
                out += source.charAt(i);  
//                System.out.println(":::subout3 " + i + " " + subStr + " " + out);
            }
        }     
        return out;
 }


	public static void main(String[] args) {
		System.out.println(replaceAll("abcfgh", "b", "d"));
		System.out.println(replaceAll("abcfgh", "bc", "d"));
		System.out.println(replaceAll("abcfgh", "bcf", "d"));
		System.out.println("---");
		System.out.println(replaceAll("aab", "b", "a"));
		System.out.println(replaceAll("bab", "b", "c"));
		System.out.println(replaceAll("bcfabcfghbcf", "bcf", "d"));
	}
  	
        // In some junit 3 test class 	
//        assertEquals("aaa", replaceAll("aab", "b", "a"));
//        assertEquals("cac", replaceAll("bab", "b", "c"));
//       // Add more tests
//       // 
//       assertEquals("cac", replaceAll("", "b", "c")); // empty 
//       assertEquals("cac", replaceAll("bab", "b", "c")); 
//       // try alpha-numeric assertEquals("ba45c23%#$%", replaceAll("ba45b#%#$%", "b#", "c23"));
//       // capital and small letters case assertEquals("bac", replaceAll("baAb", "aB", "c"));
//       // "long" inputs assertEquals("bacsdfsdfsdfdsfsdfs", replaceAll("baAbsdfsdfsfsdfsdfsdf", "aB", "c"));
//       // case patter.size > source.size() assertEquals(error, replaceAll("baAb", "aBsdgsdfg", "c"));
//       assertEquals("aaac", replaceAll("aaac", "acb", "a"));
   // }
	
	
	
	
	
}
