package Quizes;

public class PasssBy {
	
	public static int addTwo (Integer val) {
		val = val + 2;
		return val;
	}

	public static void main(String[] args) {
		
		Integer n = 3;
		addTwo(n);
		System.out.println(n);

	}

}
