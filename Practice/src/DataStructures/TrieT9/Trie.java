package DataStructures.TrieT9;

import java.util.HashMap;

public class Trie {
	
	private Node mRoot;
	private HashMap<String, Integer> letterTodigit;
	
	public Trie() {
		this.mRoot = new Node(0);
		this.letterTodigit = new HashMap<>();
		populateLTD();
	}
	
	public Node getRoot() {
		return mRoot;
	}
	
	public Node addNode(Integer value) {
		Node tmpNode = mRoot;
		String[] path = value.toString().split("");
		for (String c: path) {
			tmpNode = tmpNode.addChild(Integer.valueOf(c));
		}
		return tmpNode;
	}
	
	public void addWord(String word) {
		Integer path = wordToDigit(word);
		addNode(path).addWord(word);
	}
	
//	-------- Helper methods --------
	private void populateLTD() {
		letterTodigit.put("a", 2);
		letterTodigit.put("b", 2);
		letterTodigit.put("c", 2);
		letterTodigit.put("d", 3);
		letterTodigit.put("e", 3);
		letterTodigit.put("f", 3);
		letterTodigit.put("g", 4);
		letterTodigit.put("h", 4);
		letterTodigit.put("i", 4);
		letterTodigit.put("j", 5);
		letterTodigit.put("k", 5);
		letterTodigit.put("l", 5);
		letterTodigit.put("m", 6);
		letterTodigit.put("n", 6);
		letterTodigit.put("o", 6);
		letterTodigit.put("p", 7);
		letterTodigit.put("r", 7);
		letterTodigit.put("s", 7);
		letterTodigit.put("t", 8);
		letterTodigit.put("u", 8);
		letterTodigit.put("v", 8);
		letterTodigit.put("x", 9);
		letterTodigit.put("y", 9);
		letterTodigit.put("z", 9);
	}
	
	private Integer wordToDigit(String word) {
		String[] letters = word.split("");
		Integer result = 0;
		for (String l: letters) {
			result = result*10 + letterTodigit.get(l);
		}
		return result;
	}
	
//	-------- ForDebug -------
	public int size() {
		int size = 0; //do not count root
		size += mRoot.getNumberOfChildren();
		return size;
	}
	
}
