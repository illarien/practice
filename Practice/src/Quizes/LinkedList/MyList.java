package Quizes.LinkedList;

class MyList<T> {
	private MyNode<T> mHead;
	private MyNode<T> mTail;
	private int mSize = 0;

	public MyList () {
		mHead = null;
		mTail = mHead;
	}
	
	public void add(T val) {
		if (mHead == null) {
			mHead = new MyNode<T> (val, null);
			mTail = mHead;
			mSize++;
		} else {
			mTail.mNext = new MyNode<T> (val, null);
			mTail = mTail.mNext;
			mSize++;
		}
	}
	
	public void addFirst(T val) {
		mHead = new MyNode<T> (val, mHead);
		mSize++;
	}
	
	public void removeFirst() {
		mHead = mHead.mNext;
		mSize--;
	}
	
	public void reverse(){
		 mHead = reverse (getHead());
	}
	
	public MyNode<T> reverse (MyNode<T> entry) {
		 MyNode<T> prev = null;
		 MyNode<T> current = entry;
		 MyNode<T> next;
		 while (current != null) {
			 next  = current.mNext;
		     current.mNext = prev;
		     prev = current;
		     current = next;
		 }
		 return prev;
	 }
	 
	public MyNode<T> getHead () {
		return mHead;
	}
	
	public void setHead(MyNode<T> n) {
		mHead = n;
	}
	 
	public int size() {
		return mSize;
	}
	
	public String toString() {
		return toString(getHead());
	}
	
	public String toString(MyNode <T> head) {
		StringBuilder result = new StringBuilder();
		if (head == null) {
			return "null";
		}
		MyNode<T> pointer = head;
		while (pointer != null) {
			result.append(pointer.mValue.toString());
			pointer = pointer.mNext;
		}
		return result.toString();
	}

	public MyNode<T> getMiddleNode() {
		if (mHead == null && mHead.mNext == null ) {
			return null;
		}
		
		MyNode<T> slow = mHead;
		MyNode<T> fast = mHead;
		while (fast.mNext != null && fast.mNext.mNext != null) {
			slow = slow.mNext;
			fast = fast.mNext.mNext;
		}
		if (fast == null) {
			return slow;
		}
		return slow.mNext;
	}
}