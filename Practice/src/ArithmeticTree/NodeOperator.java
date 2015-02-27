package ArithmeticTree;

public abstract class NodeOperator extends Node {

	protected Node left, right;
	
	public NodeOperator (Node left, Node right) {
		this.left = left;
		this.right = right;
	}
	
	public NodeOperator () {
		this.left = null;
		this.right = null;
	}
	
	//public abstract double eval() throws EvaluationException; 
}
