import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LRU2 extends LinkedHashMap<Integer, Integer>{
	
	private int mCapacity;
	
	public LRU2 (int capacity) {
		this.mCapacity = capacity;
	}
	
	@Override
	public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > mCapacity;
	}
	
    public void set(int key, int value) { // O(1)
    	// duplicate key -> replace it
    	if (this.containsKey(key)) {
    		this.remove(key);
    		this.put(key, value);
        }
        if (this.size() <= mCapacity) {
        	this.put(key, value);
        }
        this.put(key, value);
    }

    public int get(int key) { // return value O(1)
        if (!containsKey(key)) {
            return -1;
        }
        int value = get(key);
        remove(key);
        put(key, value);
        return get(key); 
    }
    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	for (Entry<Integer, Integer> entry: this.entrySet()) {
    		sb.append("(" + entry.getKey() + "," + entry.getValue() + ")" + ",");
    	}
    	sb.deleteCharAt(sb.length()-1);
    	return sb.toString();
    }

	public static void main(String[] args) {
    	LRU2 lru = new LRU2(3);
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
