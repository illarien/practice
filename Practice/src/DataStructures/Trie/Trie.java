package DataStructures.Trie;

import java.util.HashMap;

public class Trie<T> {
	
	private HashMap<String, Node<T>> roots = new HashMap<String, Node<T>>();
	
	
	public Trie () {
		
	}
	
	public int rootsNumber() {
		return roots.size();
	}

	public void add(String key, T value) {
		
		if (roots.containsKey(key.charAt(0))) {
			roots.get(key.substring(0,1)).addValue(key.substring(1), value);
		} else {
			roots.put(key.substring(0,1), new Node<T>(key.substring(1), value));
		}
		
		
		
	}

	public int get(String key) {
		char[] k = key.toCharArray();
		if ( !roots.containsKey(k[0])) {
			return 0;
		}
		Node<T> pointer = roots.get(k[0]);
//		for (int i = 1; i < k.length; i++) {
//			if (pointer.hasChild(k[i])) {
//				
//			}
//		}
		
		return 111;
	}

}
