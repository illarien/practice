package DataStructures.Trie2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Node<T> {

	private T mValue;
	private HashMap<Character, Node<T>> children;
	
	public Node (T value) {
		this.mValue = value;
		children = new HashMap<Character, Node<T>>();
	}
	
	public void addChild (Character key, T value) {
		children.put(key, new Node<T>(value));
	}
	
	public Node<T> getNode(Character key) {
		return children.get(key);
	}
	
	public T getValue() {
		return mValue;
	}
	
	public int size() {
		int size = 1;
		if (children.size() == 0) {
			return size;
		} else {
			for (Entry<Character, Node<T>> n: children.entrySet()) {
				size += n.getValue().size();
			}
		}
		return size;
	}
	
	public void setValue (T value) {
		mValue = value;
	}

	public HashSet<Character> getKeySet() {
		HashSet<Character> result = new HashSet<Character>();
		if (children.size() == 0) {
			return null;
		} else {
			for (Entry<Character, Node<T>> n: children.entrySet()) {
				result.add(n.getKey());
				if (n.getValue().getKeySet() != null) {
					result.addAll(n.getValue().getKeySet());
				}
			}
		}
		return result;
	}
	
	public HashSet<T> getValueSet() {
		HashSet<T> result = new HashSet<T>();
		if (children.size() == 0 && mValue != null) {
			result.add(mValue);
			return result;
		} else {
			for (Entry<Character, Node<T>> n: children.entrySet()) {
				if (mValue != null) {
					result.add(mValue);
				}
				result.addAll(n.getValue().getValueSet());
			}
		}
		return result;
	}
}
