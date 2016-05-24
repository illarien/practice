package Quizes.Strings;

import java.util.*;

/**
 *  BalancedLine - stack
 */
public class StringBalancedLineStack {
	
	public static void main(String[] args) {
		String str = "a{sdfs(dsf)[s]}";
		String[] ar = str.split("");
		Stack<String> st = new Stack<String>();
		String tmp = "";
		
		for (int i =0; i < ar.length; i++) {
			if ( ar[i].equals("(") || ar[i].equals("[") || ar[i].equals("{") ) {st.push(ar[i]); tmp = ar[i];}
		
			if ( ar[i].equals(")") ) {
				tmp = st.pop();
				if (!tmp.equals("(")) {
					st.push(tmp);
					System.out.println("NB");
					break;
				}
			}
			
			if ( ar[i].equals("]") ) {
				tmp = st.pop();
				if (!tmp.equals("[")) {
					st.push(tmp);
					System.out.println("NB");
					break;
					}
			}
			
			if ( ar[i].equals("}") ) {
				tmp = st.pop();
				if (!tmp.equals("{")) {
					st.push(tmp);
					System.out.println("NB");
					break;
				}
			}
			
//			System.out.println("Stack: " + st);
		}
	
		System.out.println("Stack: " + st);
		System.out.println("Size: " + st.size());
	}
}