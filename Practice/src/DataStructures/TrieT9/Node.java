package DataStructures.TrieT9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Node {
	
	private Integer mValue;
	private ArrayList<String> mWords;
	private HashMap<Integer, Node> mChildren;
	
	public Node (Integer value) {
		this.mValue = value;
		this.mWords = new ArrayList<String>();
		this.mChildren = new HashMap<>();
	}

	public Integer getValue() {
		return mValue;
	}
	
	public ArrayList<String> getWords() {
		if (mChildren.size() < 1) {
			return mWords;
		}
		ArrayList<String> result = mWords;
		for (Node node: mChildren.values()) {
			result.addAll(node.getWords());
		}
		return result;
	}
	
	public Node getChild(Integer key) {
		return mChildren.get(key);
	}
	
	public void addWord(String word) {
		if (word != null && !word.isEmpty() && !mWords.contains(word)) {
			mWords.add(word);
		}
	}

	public Node addChild(Integer key) {
		if (mChildren.containsKey(key)) {
			return mChildren.get(key);
		}
		Node newNode = new Node(key);
		mChildren.put(key, newNode);
		return newNode;
	}
	
	public Node getNode(Integer value) {
		if (value < 10) {
			return mChildren.get(value);
		}
		if (mChildren.containsKey(Integer.valueOf(value.toString().substring(0, 1)))) {
			return mChildren.get(Integer.valueOf(value.toString().substring(0, 1)))
					.getNode(Integer.valueOf(value.toString().substring(1)));
		}
		return null;
		
		
//		Node tmpNode = this;
//		String[] path = value.toString().split("");
//		for (String c: path) {
//			tmpNode = tmpNode.getNode(value);
//		}
	}
	
	
//	------ ForDebug ---------
	public int getNumberOfChildren() {
		if (mChildren.size() < 1) {
			return 0;
		}
		int size = mChildren.size();
		for (Node node: mChildren.values()) {
			size += node.getNumberOfChildren();
		}
		return size;
	}
	
	public void print() {
        print("", true);
    }

    private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + (mValue == null? "no value" : mValue.toString()) );       
        Iterator<Entry<Integer, Node>> iter = mChildren.entrySet().iterator();
        for (int i = 0; i < mChildren.size() - 1; i++) {
        	if (iter.hasNext()) {
        		Map.Entry<Integer, Node> pair = (Map.Entry<Integer, Node>)iter.next();
                ((Node) pair.getValue()).print(prefix + (isTail ? "    " : "│   "), false);
        	}
        }
        if (mChildren.size() > 0 && iter.hasNext()) {
        	Map.Entry<Integer, Node> pair = (Map.Entry<Integer, Node>)iter.next();
        	((Node) pair.getValue()).print(prefix + (isTail ?"    " : "│   "), true);
        }
    }

}
