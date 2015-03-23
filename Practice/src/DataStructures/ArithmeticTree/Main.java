package DataStructures.ArithmeticTree;

import DataStructures.ArithmeticTree.Node.EvaluationException;

public class Main {

	public static Node parseExpr(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+') {
//				String left = s.substring(0, i);
//				String right = s.substring(i+1, s.length());
//				Node leftNode = parseExpr(s.substring(0, i));
//				Node rightNode = parseExpr(s.substring(i+1, s.length()));
				return new NodeAddition( parseExpr(s.substring(0, i)), parseExpr(s.substring(i+1, s.length())) );
			}
			if (s.charAt(i) == '-') {
//				String left = s.substring(0, i);
//				String right = s.substring(i+1, s.length());
//				Node leftNode = parseExpr(s.substring(0, i));
//				Node rightNode = parseExpr(s.substring(i+1, s.length()));
				return new NodeSubstration( parseExpr(s.substring(0, i)), parseExpr(s.substring(i+1, s.length())) );
			}
			if (s.charAt(i) == '*') {
				for (int j = i+1; j < s.length(); j++) {
					if (s.charAt(j) == '-'||s.charAt(j) == '*') {
						System.out.println(s.substring(0, j));
						return new NodeSubstration( new NodeMultiplication( parseExpr(s.substring(0, i)), parseExpr(s.substring(i+1, j)) ),
																			parseExpr(s.substring(j+1, s.length())) );
					}
				}

				//return new NodeMultiplication( parseExpr(s.substring(0, i)), parseExpr(s.substring(i+1, s.length())) );
			}
		}
		return new NodeValue(s);
	}
	
	
	
	public static void main(String[] args) throws EvaluationException {
		Node vn2 = new NodeValue("2.0");
		Node vn7 = new NodeValue(7.0);
		Node vn4 = new NodeValue(4.0);
		Node vn3 = new NodeValue(3.0);
		
		Node pi = new NodeValue(3.14);
		Node vn22 = new NodeValue(2.0);
		Node sn2 = new NodeDivision(pi, vn22);
		Node sin1 = new NodeTrigSinus(sn2);
		
		Node mn1 = new NodeMultiplication(vn4, vn3);
		Node an1 = new NodeAddition(vn7, mn1);
		Node sn1 = new NodeSubstration(an1, vn2);
		System.out.println(sn1.eval() + " " + sin1.eval());
		
		Node expr = parseExpr("7+3*4*1-2");
		System.out.println(expr.eval());
	}

}
