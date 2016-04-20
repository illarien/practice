package Recalculator;

import java.util.HashMap;
import java.util.Set;

public class Bundle {

	private HashMap<String, Integer> mData = new HashMap<>();
	
	public int size() {
		return mData.size();
	}
	
	
	public Set<String> keySet() {
		return mData.keySet();
	}
	
	public Object getSerializable(String key) {
		return mData.get(key);
	}
	
	public void putSerializable(String key, Integer value) {
		mData.put(key, value);
	}
}
