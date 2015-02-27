package ArithmeticTree;

public abstract class Node {
	
	public abstract double eval() throws EvaluationException;
	
	public class EvaluationException extends Exception {

	}
}
