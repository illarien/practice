package DataStructures.DecoderTree;
import java.util.*;

public class Decoder {

	public static Node root;
	public static Tree tree = new Tree();

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
		DecodeLib decoder = new DecodeLib();
        String word = "1126";
		//tree.addNode(1, word);
		root = new Node(1, word);
		//root.leftChild = new Node(2, "aaa");

		decoder.decodeNode(root);
		
		printNodes (root);
		//System.out.println(root.toString());
		//System.out.println(root.leftChild);
	}

}