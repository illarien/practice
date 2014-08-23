package Arithmetic;

public class NodeMultiplication extends NodeOperator {
	
	public NodeMultiplication (Node node1, Node node2) {
		super(node1, node2);
	}
	
	public double eval() throws EvaluationException {
		if (left != null && right != null) {
			return left.eval() * right.eval();
		}
		throw new EvaluationException();
	}

}
