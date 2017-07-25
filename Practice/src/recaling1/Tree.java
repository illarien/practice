package recaling1;

import java.util.HashSet;

public class Tree {
	
	private static void preorderTraverseTree(Node start) {
		if (start != null) {
			System.out.println(start.getValue());
			if (start.getChildren() == null || start.getChildren().size() < 1) {
				return;
			}
			for(Node n: start.getChildren()) {
				preorderTraverseTree(n);
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(0);
		root.addChild(new Node(1));
		root.addChild(new Node(11));
		root.addChild(new Node(111));
		
		preorderTraverseTree(root);
	}
	
	private static class Node {
		private int value;
		private HashSet<Node> children;
		
		public Node (int val) {
			this.value = val;
		}
		
		public int getValue() {
			return value;
		}
		
		public HashSet<Node> getChildren() {
			return children;
		}
		
		public void addChild(Node node) {
			if (children == null) {
				children = new HashSet<>();
			}
			children.add(node);
		}
		
	}

}
