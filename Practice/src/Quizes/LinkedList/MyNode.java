package Quizes.LinkedList;

class MyNode<T> {
	public T mValue;
	public MyNode<T> mNext;
	
	public MyNode (T val) {
		this(val, null);	
	}
	
	public MyNode (T val, MyNode<T> node) {
		this.mValue = val;
		this.mNext = node;
	}
	
	public String toString() {
		return mValue.toString();
	}
}
