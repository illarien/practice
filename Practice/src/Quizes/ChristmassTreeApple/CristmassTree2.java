package Q;

public class CristmassTree2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}






class Node {
	int val;

	Node leftChild;
	Node rightChild;

	Node(int val) {
		this.val = val;
	}

	public String toString() {
		return String.valueOf(val);
	}
	
	public int getNodeValue() {
		return val;
	}
}