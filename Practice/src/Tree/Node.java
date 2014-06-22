package Tree;

public class Node {
	int key;
	String name;

	Node leftChild;
	Node rightChild;

	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public String toString() {
		return name + " has the key " + key;
	}

	public String getNodeValue() {
		return name;
	}

	public int getNodeKey() {
		return key;
	}

	public boolean hasLeft() {
		return leftChild != null;
	}
	
	public boolean hasRight() {
		return rightChild != null;
	}

	public Node addLeft(Node node) {
		leftChild = node;
		return leftChild;
	}
}
