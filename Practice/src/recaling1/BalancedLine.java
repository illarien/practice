package recaling1;

public class BalancedLine {

	private static String s1 = "(s)(sds)(())";
	private static String s2 = "a*(b/(c+d))";
	private static String s3 = "())";
	
	private static boolean isBalanced(String in) {
		int c1 = 0;
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == '(') {
				c1++;
			} else if (in.charAt(i) == ')') {
				c1--;
			}
			if (c1 < 0) {return false;}
		}
		return c1 == 0;
	}
	
	
	public static void main(String...strings ) {
		System.out.println(isBalanced(s1));
		System.out.println(isBalanced(s2));
		System.out.println(isBalanced(s3));
	}
	
}
