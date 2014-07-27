package QuizesOld;
/*
2.Validate a stream of parenthesis. 
()() - true
(()) - true
((() - false

Simple balanced line
*/
 

import java.util.*;


public class BalancedLineSimple {

	public static boolean check(String str) {
	    Stack<Character> st = new Stack<Character>();
	    for(int i = 0; i < str.length(); i++) {
	        Character ch = str.charAt(i);
	        if ( '(' == ch ) {st.push(ch);}
	        if (')' == ch ) { 
	            if (  st.size() > 0 && '(' == st.peek() ) {st.pop();}
	              else {return false;}
	        } 
	        System.out.println(st);
	    }
	    return (st.size() == 0) ;	
	}

	
	public static void main(String[] args) {
		String str = "((())))";
		System.out.println(check(str));
	}

}
