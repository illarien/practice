package Quizes;

public class Two extends Thread{

	int i;
	
	public Two(int i) {this.i = i;}
	
	@Override
	public void run() {
		for (int j = 0; j < 10; j++) {
			System.out.println("T"+ i + ": step: " + j);
		}
	}
	
	public static void main(String[] args) {
		new ChildeOfInnerOne();
		System.out.println("---");
		new Innerone();
		System.out.println("---Thread test---");
		(new Two(1)).start();
		(new Two(2)).start();
	}	
}


class Innerone {
	protected Innerone() {
		System.out.println("Inner-one");
	}
}

class ChildeOfInnerOne extends Innerone {
	protected ChildeOfInnerOne() {
		System.out.println("Child of Inner-one");
	}
}