package Arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArithmeticParser {
	
	public static final String[] SET_VALUES = new String[] { "+", "-", "*", "/", "(", ")" };
	public static final HashSet<String> OPS_SET = new HashSet<String>(Arrays.asList(SET_VALUES));
	
	public static ArrayList<Element> parse(String expr) {
		String cache = "";
		ArrayList<Element> stack = new ArrayList<Element>();
		
		for (int i = 0; i < expr.length(); i++) {
			if ( !OPS_SET.contains(expr.charAt(i)) ) {
				cache += expr.charAt(i);
			} else {
				if (expr.charAt(i) == '+') {
					stack.add(new Numb(Integer.valueOf(cache)));
					stack.add(Oper.Plus);
//					stack.addAll(parse(expr.substring(i+1, expr.length())) );
					return stack;
				}
			}
		}
		return stack;
		
	}

}
