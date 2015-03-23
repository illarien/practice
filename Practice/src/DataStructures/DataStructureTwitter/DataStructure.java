package DataStructures.DataStructureTwitter;

import java.util.*;

/**
 * Twitter
Design a single-threaded in-memory key-value store with simple read write operations:

Set(key, value)
Get(key)

In addition, the design should also support nested transactions by supporting:
Begin
Rollback
Commit

Set(a, 1) -- a,1
Set(b, 1) -- a,'1'   b,'1'
Set(b, 2) -- a,1   b,1->2
Begin#1     -- a,1   b,1->'2'
Set(a, 2) -- a,(1,0)->(2,1)  b,(2,0)
Set(a, 3) -- a,1->2->3  b,2
Begin#2     -- a,3  b,2
Set(a, 4) -- a,3->4  b,2
Rollback#2  -- a,1->2->3  b,2
Rollback#1  --

a, 1
b, 1->2
-- Begin
a, 1
b, 2
--
a, 1->2->3
b, 2
--

--
a, 1
b, 1
 *
 */
public class DataStructure {
	
	// Transaction id counter
	private static Integer txID = 0;
	// Rollbacks history
	private static Stack<Integer> rollbacks = new Stack<Integer>();
	// Main data structure
	private static HashMap<String, Stack<Transaction>> db;
	
	/**
	 * Add value to ds
	 * @param key
	 * @param value
	 */
	public void set(String key, String value) {
	    if (db == null) {
	        db = new HashMap<String, Stack<Transaction>>();
	    }
	    if (!db.containsKey(key)) {
	        db.put(key, new Stack<Transaction>());
	    }
	    txID++;
	    db.get(key).add(new Transaction(value, txID));
	} 

	/**
	 * Get value by key
	 * @param key
	 * @return
	 */
	public String get(String key) {
	    if (!db.containsKey(key)) {
	        return null;
	    }
	    return db.get(key).peek().getValue();
	}
	
	/**
	 * Set "begin" point
	 */
	public void begin() {
		rollbacks.push(txID);
		System.out.println("Set new rollback marker at tx#: " + txID);
	}
	
	/**
	 * Rollback all data to previous set point
	 */
	public void rollback() {
		if (rollbacks.isEmpty()) {
			System.out.println("No rollbacks points");
			return;
		}
		
		int txIdToRollback = rollbacks.pop();
		System.out.println("Rollback to tx#: " + txIdToRollback);
		Stack<String> keysToRemove = new Stack<String>();
		for (Map.Entry<String, Stack<Transaction>> e: db.entrySet()) {
			rollbackValues(e.getValue(), txIdToRollback);
			if (e.getValue().isEmpty()) {
				keysToRemove.push(e.getKey());
			}
		}
		while (!keysToRemove.isEmpty()) {
			db.remove(keysToRemove.pop());
		}
		txID = txIdToRollback;
	}
	
	/**
	 * DS to string.
	 */
	public String toString() {
		StringBuilder out = new StringBuilder();
		for (Map.Entry<String, Stack<Transaction>> e: db.entrySet()) {
			out.append(e.getKey().toString() + " " + getValueInList(e.getValue()) + "\n");
		}
		return out.toString();
	}

	/**
	 * Get history for value
	 * @param list
	 * @return
	 */
	private String getValueInList(List<Transaction> list) {
		StringBuilder out = new StringBuilder();
		ListIterator<Transaction> iterator = list.listIterator();
		while (iterator.hasNext()) {
			out.append(iterator.next().toString());
		}
		return out.toString();
	}
	
	/**
	 * Rollback value.
	 * @param stack
	 * @param txToRollback
	 */
	private void rollbackValues(Stack<Transaction> stack, int txToRollback) {
		while (!stack.isEmpty()) {
			if (stack.peek().getTxId() <= txToRollback ) {
				return;
			}
			if (stack.peek().getTxId() > txToRollback) {
				stack.pop();
			}
		}
	}
}

/**
 * Data structure for value + txId
 * @author chekhovs
 *
 */
class Transaction {
	private String value;
	private Integer txId;
	public Transaction(String value, Integer txId) {
		this.value = value;
		this.txId = txId;
	}
	public String getValue() {
		return value;
	}
	public Integer getTxId() {
		return txId;
	}
	public String toString() {
		return "val:" + value + "-txId:" + txId + " "; 
	}
}
