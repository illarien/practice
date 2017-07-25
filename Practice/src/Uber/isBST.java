package Uber;

import java.util.ArrayList;

public class isBST {

	
	public static void main(String[] args) {
		System.out.println("BST");
		BST bst = new BST();
		bst.addValue(5);
		bst.addValue(3);
		bst.addValue(1);
		bst.addValue(7);
		bst.addValue(9);
		bst.addValue(18);
		bst.addValue(0);
		bst.addValue(25);
		bst.addValue(6);
		
//		isBST solution = new isBST();
		System.out.println(bst.inOrderTraversal());
		bst.levelOrderTraversal();
		System.out.println(bst.isBSTbyInOrderTraversal1());
		System.out.println(bst.isBSTOptimized());
	}
	
	
	
	public static class BST {
		private Node root = null;
		
		public void addValue(int value) {
			if (root == null) {
				root = new Node(value);
			} else {
				root.addValue(value);
			}
		}
		
		public boolean isBSTbyInOrderTraversal1() {
			ArrayList<Integer> result = inOrderTraversal(root);
			int temp = result.get(0);
			for (int i = 1; i < result.size(); i++) {
				if (temp > result.get(i)) {
					return false;
				}
				temp = result.get(i);
			}
			return true;
		}
		
		public boolean isBSTOptimized() {
			return isBSTOptimized(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		public boolean isBSTOptimized(Node node, int min, int max) {
			if(node == null) {
				return true;
			}
		    if(node.getValue() > min && node.getValue() < max
		        && isBSTOptimized(node.getLeft(), min, node.getValue())
		        && isBSTOptimized(node.getRight(), node.getValue(), max))
		        return true;
		    else { 
		    	return false;
		    }
		}
		
		public ArrayList<Integer> inOrderTraversal() {
			return inOrderTraversal(root);
		}
		// inOrder - left, root, right
		// preOrder - root, left, right
		// postOrder - left, right,root
		public ArrayList<Integer> inOrderTraversal(Node node) {
			ArrayList<Integer> result = new ArrayList<>();
			if (node != null) {
				result.addAll(inOrderTraversal(node.getLeft()));
				result.add(node.getValue());
				result.addAll(inOrderTraversal(node.getRight()));
			}
			return result;
		}
		
		// LevelOrder Traversal
		public void levelOrderTraversal() {
			int h = height(root);
		    int i;
		    for (i=1; i<=h; i++)
		    printGivenLevel(root, i);
		}
		
		public int height(Node root) {
	        if (root == null) {
	           return 0;
	        } else {
	        	/* compute  height of each subtree */
	            int lheight = height(root.left);
	            int rheight = height(root.right);
	             
	            /* use the larger one */
	            if (lheight > rheight)
	                return(lheight+1);
	            else return(rheight+1); 
	        }
	    }
		
		public void printGivenLevel (Node root ,int level) {
	        if (root == null) {
	            return;
	        }
	        if (level == 1) {
	            System.out.print(root.getValue() + " ");
	        }
	        else if (level > 1) {
	            printGivenLevel(root.left, level-1);
	            printGivenLevel(root.right, level-1);
	        }
	    }

	}
	
	
	
	public static class Node {
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public Node getRight() {
			return right;
		}
		
		public void addValue(int value) {
			if (value <= this.value) {
				// add left
				if (left == null) {
					left = new Node(value);
				} else {
					left.addValue(value);
				}
			} else {
				// add right
				if (right == null) {
					right = new Node(value);
				} else {
					right.addValue(value);
				}
			}
		}
	}
}
