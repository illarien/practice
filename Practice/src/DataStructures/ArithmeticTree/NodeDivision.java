package DataStructures.ArithmeticTree;

public class NodeDivision extends NodeOperator {
	
	public NodeDivision (Node node1, Node node2) {
		super(node1, node2);
	}
	
	public double eval() throws EvaluationException {
		if (left != null && right != null) {
			return left.eval() / right.eval();
		}
		throw new EvaluationException();
	}

}
