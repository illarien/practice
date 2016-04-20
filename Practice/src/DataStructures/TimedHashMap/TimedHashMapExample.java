package DataStructures.TimedHashMap;

import java.util.HashMap;
import java.util.TreeMap;


public class TimedHashMapExample {
    
    public static void main(String... strings) {
        TimedHashMap<String, Double, String> testMap = new TimedHashMap<String, Double, String>();
        testMap.put("K",1.0,"K1");
        testMap.put("K",2.0,"K2");
        testMap.put("L",1.0,"L1");
        testMap.put("L",2.0,"L2");
        
        
        System.out.println(testMap.get(0.9, "K"));
        System.out.println(testMap.get(1.0, "K"));
        System.out.println(testMap.get(1.5, "K"));
        System.out.println(testMap.get(2.0, "K"));
        System.out.println(testMap.get(2.2, "K"));
        
        System.out.println(testMap.get(1.5, "L"));
        System.out.println(testMap.get(2.2, "L"));
        
    }

}


class TimedHashMap<K, T, V> {
    
    private HashMap<K, TreeMap<T, V>> mainMap = new HashMap<K, TreeMap<T,V>>();
    
    public V get(T time, K key) {
        final TreeMap<T, V> bsTree = mainMap.get(key);
        if (bsTree == null) {
            return null;
        }
        final T floorKey = bsTree.floorKey(time);
        return floorKey == null ? null : bsTree.get(floorKey);
    }
    
    public void put(K key, T time, V value) {
        if (!mainMap.containsKey(key)) {
            mainMap.put(key, new TreeMap<T,V>());
        }
        mainMap.get(key).put(time, value);
    }
    
}