import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/** LRU Cache
    class LRU {
        int capacity = 3;
        void set(int key, int value);
        int get(int key); // return value
    }
    
    LRU(3);
    set(1,2); - 1
    set(4,55); - 4,1
    set(3,12); - 3,4,1
    set(7,32); // evict the element with key 1. now cache contains 4,3,7 - 7,3,4, (1)
    get(4) -> 55 - 4,7,3
    set(6,6); // evict the element with key 3. now cache contains 4,7,6 - 6,4,7, (3)
    get(100) -> -1

*/
public class LRU {
	int capacity; // N-elements
	private LinkedHashMap<Integer, Integer> lru;
    
	/**
	 * Constructor
	 * @param capacity
	 */
	public LRU(final int capacity) {
    	this.capacity = capacity;
        this.lru = new LinkedHashMap<Integer, Integer>(capacity) {
			private static final long serialVersionUID = 1L;
        	public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        		return size() > capacity;
        	}
        };
    }
    
	/**
	 * Add key-value pair to LRU
	 * Time complexity O(1), because in LinkedHashMap we enabled auto removing the first element
	 * @param key
	 * @param value
	 */
    public void set(int key, int value) { // O(1)
    	// duplicate key -> replace it
    	if (lru.containsKey(key)) {
            lru.remove(key);
            lru.put(key, value);
        }
        if (lru.size() <= capacity) {
            lru.put(key, value);
        }
        lru.put(key, value);
    }
    
    /**
     * Get value from LRU by key
     * Time complexity - O(1);
     * @param key
     * @return
     */
    public int get(int key) { // return value O(1)
        if (!lru.containsKey(key)) {
            return -1;
        }
        
        int value = lru.get(key);
        lru.remove(key);
        lru.put(key, value);
        
        return lru.get(key); 
    }
    
    /**
     * toString()
     */
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for (Entry<Integer, Integer> entry: lru.entrySet()) {
    		sb.append("(" + entry.getKey() + "," + entry.getValue() + ")" + ",");
    	}
    	sb.deleteCharAt(sb.length()-1);
    	return sb.toString();
    }
    
    /**
     * Test cases
     * @param args
     */
    public static void main(String... args) {
    	LRU lru = new LRU(3);
    	lru.set(1, 2);
    	lru.set(4, 55);
    	lru.set(3,12);
    	System.out.println("oldest <-> newest");
    	System.out.println(lru.toString());
    	lru.set(7,32);
    	System.out.println(lru.toString());
    	lru.get(4);
    	System.out.println(lru.toString());
    	lru.set(6,6);
    	System.out.println(lru.toString());
    	System.out.println(lru.get(100));
    	lru.set(4,77);
    	System.out.println(lru.toString());
    }
}

/**
 * Original solution
 * class LRU {
    
    int capacity = 3; // N
    
    puclic LRU() {
        LinkedHashMap<Integer, Integer> lru = new LinkedHashMap<>(capacity);
    }
    
        
    void set(int key, int value) { // O(1)
        // null & empty check
        // duplicate key
        if (lru.contains(key)) {
            lru.remove(key);
            lru.addFirst(key, value);
        }
        // 
        // 
        if (lru.size() <= capacity) {
            lru.addFirst(key, value);
        }
        lru.remove(capacity-1);
        lru.addFirst(key, value);
 
    }
        
    int get(int key); // return value O(1)
        if (!lru.contains(key)) {
            return -1;
        }
        
        int value = lru.get(key);
        lru.remove(key);
        lru.addFirst(key, value);
        
        return lru.get(key); 
        
    }
 */