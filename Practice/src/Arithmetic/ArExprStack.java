package ArithmeticalExpressiion;

import java.util.ArrayList;


public class ArExprStack {

	static ArrayList<Element> stack = new ArrayList<Element>();
	
	public static void parseExpr (String expr) {
		// if there are no operations add rest to stack
		if ( !expr.contains("+") & !expr.contains("*") & !expr.contains("-") & !expr.contains("/")) {
			stack.add(new Numb(Integer.valueOf(expr)));
			return;
		}
				
		for (int i = 0; i < expr.length(); i++) {
//			if (expr.charAt(i) == '(') {
//				stack.add(Oper.Left);
//				parseExpr(expr.substring(i+1, expr.length()));
//				return;
//			}
//			if (expr.charAt(i) == ')') {
//				stack.add(Oper.Right);
//				parseExpr(expr.substring(i+1, expr.length()));
//				return;
//			}
			if (expr.charAt(i) == '+') {
				stack.add(new Numb(Integer.valueOf(expr.substring(0, i))));
				stack.add(Oper.Plus);
				parseExpr(expr.substring(i+1, expr.length()));
				return;
			}
			if (expr.charAt(i) == '*') {
				stack.add(new Numb(Integer.valueOf(expr.substring(0, i))));
				stack.add(Oper.Mult);
				parseExpr(expr.substring(i+1, expr.length()));
				return;
			}
			if (expr.charAt(i) == '-') {
				stack.add(new Numb(Integer.valueOf(expr.substring(0, i))));
				stack.add(Oper.Mins);
				parseExpr(expr.substring(i+1, expr.length()));
				return;
			}
			if (expr.charAt(i) == '/') {
				stack.add(new Numb(Integer.valueOf(expr.substring(0, i))));
				stack.add(Oper.Divd);
				parseExpr(expr.substring(i+1, expr.length()));
				return;
			}

		}
		
	}
	
	public static void evalSecondExpr () {
		// iterate through stack and evaluate all * and /
		for (int i = 0; i < stack.size(); i++) {
			if (stack.get(i).equals(Oper.Mult)) {
				int tmpVal = stack.get(i).evaluate(Oper.Mult, stack.get(i-1).getValue(), stack.get(i+1).getValue());
				System.out.println(tmpVal);
				stack.set(i, new Numb (tmpVal) );
				stack.remove(i-1);
				stack.remove(i);
				--i;
			}
			if (stack.get(i).equals(Oper.Divd)) {
				int tmpVal = stack.get(i).evaluate(Oper.Divd, stack.get(i-1).getValue(), stack.get(i+1).getValue());
				System.out.println(tmpVal);
				stack.set(i, new Numb (tmpVal) );
				stack.remove(i-1);
				stack.remove(i);
				--i;
			}
		}

	}

	public static void evalThirdExpr () {
		// iterate through stack and evaluate + and -
		for (int i = 0; i < stack.size(); i++) {
			if (stack.get(i).equals(Oper.Plus)) {
				int tmpVal = stack.get(i-1).getValue() + stack.get(i+1).getValue();
				System.out.println(tmpVal);
				stack.set(i, new Numb (tmpVal) );
				stack.remove(i-1);
				stack.remove(i);
				--i;
			}
		}
	}
	
	
	public static void main(String[] args) {
	
		String expression = "2+3*3/3+1";
		parseExpr(expression);
		System.out.println(stack.toString());
		evalSecondExpr();
		System.out.println(stack.toString());
		evalThirdExpr();
		System.out.println(stack.toString());
		
		String expression2 = "2+3+1";
		System.out.println(ArithmeticParser.parse(expression2).size());

	}

	
}

interface Element {
	public abstract int getValue();
	public int evaluate(Oper op, int x, int y);
}

enum Oper implements Element {
	Plus,
	Mins,
	Mult,
	Divd,
	Left,
	Right;
	
	public int getValue() {
		return 0;
	}
	
	public int evaluate(Oper op, int x, int y) {
		switch (op) {
		case Plus:
			return x + y;
		case Mult:
			return x * y;
		case Divd:
			return x / y;
		default:
			return -1;
		}
	}
}

class Numb implements Element {
	
	int value;
	
	public Numb (int n) {
		this.value = n;
	}
	
	public String toString() {
		return ""+value;
	}
	
	public int getValue() {
		return value;
	}
	public int evaluate(Oper op, int x, int y) {
		return getValue();
	}
}