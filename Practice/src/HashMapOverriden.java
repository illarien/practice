import java.util.HashMap;

public class HashMapOverriden {

	public static void main(String[] args) {
		HashMap<Integer, Integer> integers = new HashMap<>();
		HashMap<Integer, String> strings = new HashMap<Integer, String>(){
			public <K, V> void putAll(HashMap<K, V> hm) {
				
			}
			
		};

	}

}
