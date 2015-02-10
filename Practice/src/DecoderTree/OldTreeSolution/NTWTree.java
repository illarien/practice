package Tree;

import java.util.Arrays;
import java.util.HashSet;

public class NTWTree {

	static BinaryTree tree = new BinaryTree();
	
	public static boolean isnumber (String in) {
		HashSet<String> str = new HashSet<String>(Arrays.asList("1", "2","3","4","5","6","7","8","9","0")); 
		return str.contains(in);
	}

	public static String numToLet(String in) {
		String[] alp = {"a","b","c","d","e","f","g","h","i","j","k"};
		return alp[Integer.valueOf(in)-1];
	}
	
	public static void decode(Node node) {
		String value[] = node.getNodeValue().split("");
		
		if (isnumber(value[1])) {
			tree.addNode(node.getNodeKey()+1, numToLet(value[1]) + value[2]+value[3]+value[4] );
			decode(tree.findNode(2));
		}
		if (isnumber(value[1])&&isnumber(value[2])) {
			tree.addNode(tree.findNode(1).getNodeKey()+1, numToLet(value[1]+value[2]) + value[3]+value[4] );
		}
	}
	
	public static void main(String[] args) {
		tree.addNode(1, "1127");
		
		decode(tree.findNode(1));
		
		tree.inOrderTraverseTree(tree.findNode(1));

	}

}
