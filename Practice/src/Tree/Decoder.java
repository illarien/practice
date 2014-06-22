package Tree;
import java.util.*;

public class Decoder {

	public static Node root;
	public static Tree tree = new Tree();
	
	public static boolean isnumber (String in) {
		HashSet<String> str = new HashSet<String>(Arrays.asList("1", "2","3","4","5","6","7","8","9","0")); 
		return str.contains(in);
	}
	
	public static String numToLet(String in) {
		String[] alp = {"a","b","c","d","e","f","g","h","i","j","k"};
		return alp[Integer.valueOf(in)-1];
	}

	public static String rest(int j, String[] s) {
		String out = "";
		for (int i = j+1; i < s.length; i++ ) {
			out += s[i];
		}
		return out;
	}
	
	public static void decodeNode (Node node) {
		int k = node.getNodeKey();
		String[] v = node.getNodeValue().split("");
		String out = "";
		for (int i = 0; i < v.length; i++) {
			if (isnumber(v[i])) {
				
				out += numToLet(v[i]);
				out += rest(i, v);
				Node newNode = new Node(k+1, out);
				node.addLeft(newNode);
				//decodeNode(node.addLeft(newNode));
				
			} else {
				out += v[i];
			}
			if (k > 5) return;
			System.out.println(k);
		}
		
		
	}
	
	public static void printNodes(Node node) {
		System.out.println(node.toString());
		if (node.hasLeft()) {
			printNodes(node.leftChild);
		}
		if (node.hasRight()) {
			printNodes(node.rightChild);
		}
	}
	
	public static void main(String[] args) {
		String word = "1127";
		//tree.addNode(1, word);
		root = new Node(1, word);
		//root.leftChild = new Node(2, "aaa");
		
		
		decodeNode(root);
		
		printNodes (root);
		//System.out.println(root.toString());
		//System.out.println(root.leftChild);
	}

}