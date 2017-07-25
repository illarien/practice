package Uber;

/**
 *  uber-interview-questions
3
of 3 votes
40
Answers

Given an input string and ordering string, need to return true if the ordering string is present in Input string.

input = "hello world!"
ordering = "hlo!"
result = FALSE (all Ls are not before all Os)

input = "hello world!"
ordering = "!od"
result = FALSE (the input has '!' coming after 'o' and after 'd', but the pattern needs it to come before 'o' and 'd')

input = "hello world!"
ordering = "he!"
result = TRUE

input = "aaaabbbcccc"
ordering = "ac"
result = TRUE
 *
 */

public class OrderingPattern {
	public static void main(String[] args) {
		String s = "hello world!" ;	//"hlo!";
		String pattern = "he!";
		System.out.println("Ordered: " + iskOrdered(s, pattern));
	}
	
	public static boolean iskOrdered(String s, String orderingPattern){
		for(int i=0; i<orderingPattern.length()-1; i++){
			if( !(s.lastIndexOf(orderingPattern.charAt(i)) < s.indexOf(orderingPattern.charAt(i+1))) ){
				return false;
			}
		}
		return true;
	}
}
