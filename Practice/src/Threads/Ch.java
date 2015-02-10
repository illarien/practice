package Q;

public class Ch {

	public static void main(String[] args) {
		Pr p1 = new Pr();
		Pr p2 = new Pr() {
			@Override
			public int retOne() {
				return 3;
			}
		};
		System.out.println(p1.retOne());
		System.out.println(p2.retOne());
		System.out.println(
				new Pr() {
					@Override
					public int retOne() {
						return 4;
					}
				}.retOne());
	
		
	
	}
}
