package Quizes;

public class Yahoo {

	// 3 => "dog"
	// 5 => "cat"
	// 3 and 5 => "dogcat"
	// output: 1 2 dog 4 cat ....14 dogcat ....
	// just print
	public static void dogCat(int n) {

	    for (int i = 1; i <=n; i++) {

	        if (i%3 == 0 & i%5 == 0) {
	            System.out.println("dogcat");
	            continue;
	        } else if (i%3 == 0) {
	            System.out.println("dog");
	            continue;
	        } else if (i%5 == 0) {
	            System.out.println("cat");
	            continue;
	        } else {
	        	System.out.println(i);	
	        }
	        
	    }
	}


	// method to check is string polindrome or not
	// return true/false
	public static boolean checkPolindrome (String input) {

	    if (input.equals( new StringBuilder(input).reverse().toString() ) ) {
	        return true;
	    } else {
	        return false;
	    }


	}

	public static boolean checkPolindrome2 (String input) {

	    char[] in = input.toCharArray();
	    char[] out = new char[input.length()];
	    int j = 0;
	    for (int i = input.length()-1; i > 0; i--) {
	        out[j] = in[i];
	        j++;
	    }
	    for (int i = 0; i < in.length; i++){
	        if (in[i] != out[j]) {
	            return false;
	        }
	    }
	    return true;
	}


	// aBcba ?
	public static boolean checkPolindrome3 (String input) {
	    // check for empty
	    input = input.toLowerCase(); // abcba

	    char[] in = input.toCharArray();
	    int j = input.length()-1;
	    for (int i =0; i < input.length(); i++) {
	        if ( in[i] != in[j-i] ) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
	
	public static <E> boolean checkPolGen (E in) {
		return (in.toString()).equals( new StringBuilder( in.toString() ).reverse().toString() );
	}
	
	
	
	
	public static void main(String[] args) {
		
//		dogCat(15);
		
		System.out.println(checkPolindrome("abc"));
		System.out.println(checkPolindrome2("abc"));
		System.out.println(checkPolindrome3("abc"));
		
		System.out.println(checkPolGen("aba"));
		System.out.println(checkPolGen(121));
		
	}

}
