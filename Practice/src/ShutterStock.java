import java.util.Stack;

/**
 * implement Stack<Integer>, with returntMin() - O(1)
 */
public class ShutterStock {
	
	public static void main(String... args) {
		//Main    minstack
		MinStack minStack = new MinStack();
		//push 10           10
		minStack.push(10);
		System.out.println(minStack.returnMin());
		//pop  10            10
		System.out.println(minStack.pop());
		//push 8,10          8
		minStack.push(8);
		minStack.push(10);
		System.out.println(minStack.returnMin());
		//push 15,10        10,15
		minStack.push(6);
		minStack.push(15);
		System.out.println(minStack.returnMin());
		
		System.out.println(minStack.pop());
		System.out.println(minStack.returnMin());
		
		System.out.println(minStack.pop());
		System.out.println(minStack.returnMin());
		
		System.out.println(minStack.pop());
		System.out.println(minStack.returnMin());
		
		System.out.println(minStack.pop());
		System.out.println(minStack.returnMin());
		
		System.out.println(minStack.pop());
		System.out.println(minStack.returnMin());
		
		
		//pop  10           10 
		//pop  15,10        10
		//push 6,15,10       6,10,15
		//
		//
		//pop  empty
		//pop  10           10
	}

}

class MinStack {
	private Stack<Integer> mValues;
	private Stack<Integer> mMins;

	public MinStack() {
		this.mValues = new Stack<Integer>();
		this.mMins = new Stack<Integer>();
	}
	
	 public void push(Integer value) {
		 if (value == null) {
			 throw new IllegalArgumentException();
		 }
		 mValues.add(value);
  
		 if (mMins.size() > 0) {
			 if (mMins.peek() > value) {
				 mMins.add(value);
			 }
		 } else {
			 mMins.add(value);
		 }
	 }

	 public Integer returnMin() {
		 if (mMins.size() < 1) {
			 return null;
		 }
		 return mMins.peek();
	 }

	 public Integer pop() {
		 if (mMins.size() < 1 || mValues.size() < 1) {
			 return null;
		 }

		 if (mMins.peek() == mValues.peek()) {
			 mMins.pop();
		 }
		 return mValues.pop();
	 }
}

// Original implementation
////implement Stack<Integer>, implement returntMin() - O(1)
//
//
//class MinStack {
//
////   private int mMinValue;
// private Stack<Integer> mValues;
// private Stack<Integer> mMins;
// 
// public MinStack() {
//     this.mMinValue = Integer.MAX_INTEGER;
//     this.mValues = new Stack<Integer>();
//     this.mMins = new Stack<Integer>();
// }
//
// public add(Integer value) {
//     if (value == null) {
//         throw new IllegalArgumentException();
//     }
//     
//     mValues.add(value);
//     
//     if (mMins.size() > 0) {
//         if (mMins.peak() > value) {
//             mMins.add(value);
//         }
//     } else {
//         mMins.add(value);
//     }
// }
// 
// public returnMin() {
//     if (mMins.size < 1) {
//         return null;
//     }
//     return mMin.peak();
// }
//
// public Integer pop() {
//     if (mMins.size < 1 || mValues.size() < 1) {
//         return null;
//     }
// 
//     if (mMins.peak() == mValues.peak()) {
//         mMins.pop();
//     }
//     return mValues.pop();
// }
//} 
//
//
//
//
//12       
//15
//10      10
//Stack   Min
//
//
//
//Main    minstack
//pop  10            10
//push 8,10          8
//pop  10           10 
//pop  15,10        10
//push 6,15,10       6,10,15
//
//
//pop  empty
//pop  10           10
//push 15,10        10,15
//push 10           10
//
