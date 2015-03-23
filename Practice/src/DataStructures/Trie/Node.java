package DataStructures.Trie;

import java.util.HashMap;

public class Node<T> {
	
	public String mKey;
	private T mValue;
	private HashMap<String, Node<T>> children = new HashMap<String, Node<T>>();
	
	public Node (String key) {
		this(key, null, null);
	}
	
	public Node (String key, T value) {
		this(key, value, null);
	}
	
	public Node (String key, T value, Node<T> child) {
		this.mKey = key;
		this.mValue = value;
		children.put(key, child);
	}
	
	public void addChild(String key, Node<T> child) {
		children.put(key, child);
	}
	
	public void addValue(String key, T value) {
//		if () {
//			
//		}
	}
	
	public boolean hasChild(String key) {
		return children.containsKey(key);
	}

	public T getValue(String key) {
		if (key.length() == 1 && key.equals(mKey)) {
			return mValue;
		}
		if (key.length() > 1 && children.containsKey(key.charAt(0))) {
			return children.get(key.substring(0, 1)).getValue(key.substring(1));
		}
		return null;
	}
}
