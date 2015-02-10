package Arithmetic;

public abstract class NodeTrig extends NodeOperator {
	
	Node node;
	
	public NodeTrig(Node node) {
		this.node = node;
	}
	
	public NodeTrig() {
		this.node = null;
	}

}
