package DataStructures.Trie2;

public class Runner {

	public static void main(String[] args) {

		Trie<String> trie = new Trie<String>();
		System.out.println(trie.size());
		trie.add("a", "A");
		trie.add("b", "B");
		trie.add("ab", "AB");
		trie.add("abc", "ABC");
		trie.add("ac", "AC");
		trie.add("work", "WORK");
		trie.add("sience", "SCIENCE");
		trie.add("walk", "WALK");
		trie.add("wall", "WALL");
		
		
		System.out.println(trie.size() );
		System.out.println(trie.getValue("a"));
		System.out.println(trie.getValue("b"));
		System.out.println(trie.getValue("ab"));
		System.out.println(trie.getKeySet());
		System.out.println(trie.getValueSet());
		System.out.println(trie.getValueSet( trie.getNode("w")) + " : " + trie.size(trie.getNode("w")) );
	}

}
