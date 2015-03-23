package DataStructures.Trie2;

import java.util.HashMap;
import java.util.HashSet;

public class Trie<T> {
	
	private Node<T> root = new Node<T>(null);
	
	public Trie () {
	}
	
	public void add(String key, T value) {
		Node<T> pointer = root;
		
		if (key.length() < 1) {
			return;
		}
		
		char[] k = key.toCharArray();
		for (int i =0; i < k.length; i++) {
			Node<T> tmp = pointer.getNode(k[i]);
			if (tmp == null) {
				pointer.addChild(k[i], null); //(T)(""+k[i]) );
				pointer = pointer.getNode(k[i]);
			} else {
				pointer = pointer.getNode(k[i]);
			}
		}
		pointer.setValue(value);
	}
	
	public Node<T> getNode (String key) {
		Node<T> pointer = root;
		if (key.length() < 1) {
			return null;
		}
		char[] k = key.toCharArray();
		for (int i =0; i < k.length; i++) {
			Node<T> tmp = pointer.getNode(k[i]);
			if (tmp == null) {
				return null;
			} else {
				pointer = pointer.getNode(k[i]);
			}
		}
		return pointer;
	}
	
	public T getValue(String key) {
		return getNode(key).getValue();
	}
	
	public int size() {
		return size(root) - 1; // minus 1 for root
	}
	
	public int size(Node<T> node) {
		return node.size();
	}

	public HashSet<Character> getKeySet() {
		return root.getKeySet();
	}
	
	public HashSet<T> getValueSet() {
		return getValueSet(root);
	}
	
	public HashSet<T> getValueSet(Node<T> node) {
		return node.getValueSet();
	}
}
