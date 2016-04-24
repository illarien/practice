package DataStructures.TrieT9;

public class Runner {

	public static void main(String[] args) {
		
		Trie t9trie = new Trie();
//		t9trie.addNode(123);
//		t9trie.addNode(224);
//		t9trie.addNode(244);
//		t9trie.addNode(24479);
		
		t9trie.addWord("privet");
		t9trie.addWord("utro");
		t9trie.addWord("poka");
		t9trie.addWord("pok");
		t9trie.addWord("poka"); // duplicate test
		t9trie.addWord("pokeda");
		
		System.out.println("Root: " + t9trie.getRoot().getValue() + ", #trieSize: " + t9trie.size());
		t9trie.getRoot().print();
		
		System.out.println(t9trie.getRoot().getNode(765).getWords());
		System.out.println(t9trie.getRoot().getNode(765).getWords().size());
	}

}
