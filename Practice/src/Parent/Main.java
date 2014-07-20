package Parent;

public class Main extends Parent {

	public static void printDeleg() {
		Delegation d = new Delegation();
		d.printFromDelegation();
	}

	//Constructor - Composition
	public Main (Composition c) {
		System.out.println("Main constructor");
		composition = c;
	}
	private static Composition composition;	
	private static void printCompos() {
		composition.printFromComposition();
	}
	
	//Aggregation
	private static Aggregation agg;
	private void setPrintAgg (Aggregation agg) {
		this.agg = agg;
	}
	
	
	
	public static void main(String[] args) {
		
		printFromParent(); //inheritance
		
		System.out.println("-----");
		
		printDeleg(); //Delegation
		
		System.out.println("-----");
		
		Main main = new Main(new Composition()); // Composition
		printCompos();
		
		System.out.println("-----");
		
		new Main(new Composition()).setPrintAgg(new Aggregation()); //Aggregation
		//main.setPrintAgg(new Aggregation());
		agg.printFromAgregation();

	}

}
