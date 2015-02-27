package ArithmeticTree;

public class NodeTrigSinus extends NodeTrig {
	
	public NodeTrigSinus(Node node) {
		super(node);
	}
	
	public double eval() throws EvaluationException {
		if (node != null) {
			return Math.sin(node.eval());
		}
		throw new EvaluationException();
	}
}
