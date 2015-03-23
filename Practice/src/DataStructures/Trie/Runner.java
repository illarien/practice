package DataStructures.Trie;

public class Runner {

	public static void main(String[] args) {
		Trie<Integer> trie = new Trie<Integer>();
		trie.add("ab", 12);
		trie.add("bc", 14);
		System.out.println(trie.rootsNumber());
		
		System.out.println(trie.get("ab"));
	}

}
