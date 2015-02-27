package Quizes;

public class Static {

	static {
		System.out.println("Static");
	}
	{
		System.out.println("Non-Static");
	}
	
	
	public static void main(String[] args) {
		Static st = new Static();
		Static s2t = new Static();
		Static st3 = new Static();
	}

}
