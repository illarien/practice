package DataStructures.ArithmeticTree;

public class NodeValue extends Node {
	
	private double value;
	
	public NodeValue (double value) {
		this.value = value;
	}
	
	public NodeValue (String value) {
		this.value = Double.valueOf(value);
	}
	
//	public NodeValue (Node node)  {
//		this = node;
//	}
	
	public NodeValue () {
		
	}
	
	public double eval() {
		return value;
	}

}
