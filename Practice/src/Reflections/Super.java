package Reflections;

public class Super {
	
	public void print() {
		prnt();
	}
	
	private void prnt() {
		System.out.println("Super");
	}
	
	
	class Child extends Super {
		public void print() {
			prnt();
		}
		private void prnt() {
			System.out.println("Child");
		}
	}
	
}
