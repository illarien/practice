package Quizes.DataStructureSumoL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Random;

/*
 * Design a data structure which has following operations:
 * 1. void add(e)
 * 2. void delete(e)
 * 3. boolean contains(e)
 * 4. e getRandom()
 * 5. e getMostRecent()
 * All operations should be preferably O(1)
 */

public class DataStructure {
	
//	private static HashSet<Object> value = new HashSet<Object>();
//	private static LinkedHashMap<Object, Integer> hashes = new LinkedHashMap<Object, Integer>();
	private static int size = 0;
//	private static Object recent = null;
	
	LinkedHashSet<Object> values = new LinkedHashSet<Object>();
	
	public DataStructure() {
	}
	
	public DataStructure(Object value) {
		this.size = 1;
//		this.recent = value;
		this.values.add(value);
//		hashes.put(value, value.hashCode());
	}
	
	public void add(Object value) {
		size++;
//		recent = value;
		this.values.add(value);
//		hashes.put(value, value.hashCode());
	}
	
	public void delete(Object value) {
		size--;
		this.values.remove(value);
//		hashes.remove(value);
	}

	public boolean contains(Object value) {
		return this.values.contains(value);
	}

	//-----
	public Object getRecent() {
		final Object [] entries = new Object[size];
		values.toArray(entries);
		return entries[size-1];
	}
	
	public Object getRandom() {
		final Object [] entries = new Object[size];
		values.toArray(entries);
//		int item = new Random().nextInt(size);
		return entries[new Random().nextInt(size)];
	}
	
	
	//-----
	public String toString() {
		String output = "Size: " + size + " Elements: " + values.toString();
		return output;
	}
	
}
