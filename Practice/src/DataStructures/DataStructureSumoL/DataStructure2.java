package DataStructures.DataStructureSumoL;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

/*
 * Asked by SutterStock.
 * Design a data structure which has following operations:
 * 1. void add(e)
 * 2. void delete(e)
 * 3. boolean contains(e)
 * 4. e getRandom()
 * All operations should be O(1)
 */
public class DataStructure2 <T extends Object> {
	    
	    private LinkedHashMap<T, Integer> mMap;  // why not just use HashMap
	    private ArrayList<T> mAL;
	    private int size = 0; 
	    
	    public DataStructure2() {
	        this.mMap = new LinkedHashMap<T,Integer>();
	        this.mAL = new ArrayList<T>();
	    }
	    
	    // O(1)
	    public boolean contains(T item) {
	        return mMap.containsKey(item);
	    }
	    
	    // O(1)
	    public void add(T item) {
	        mMap.put(item, size);
	        mAL.add(item);
	        size++;
	    }
	    
	    // O(1)
	    public boolean remove(T item) {
	        if (contains(item)) { 
	            int position = mMap.get(item);
	            if (position == mAL.size()-1) {
	                mAL.remove(position);
	                mMap.remove(item);
	                return true;
	            }
	            
	            T lastItem = mAL.get(mAL.size() - 1);
	            mAL.set(position, lastItem);
	            mAL.set(mAL.size() - 1, item);
	            mAL.remove(mAL.size() - 1);
	            mMap.remove(item);
	            mMap.put(lastItem, position); // NPE
	            return true;
	            
	        } else {
	            return false;
	        }  
	    }
	    
	    // O(1)
	    public T getRandomEntry() {
	        int random = (new Random()).nextInt(mAL.size()); // 0 <= rand <= size
	        return mAL.get(random);
	    }
	    
		//-----
		public String toString() {
			String output = "Size: " + size + " Elements: " + mMap.toString();
			return output;
		}
}