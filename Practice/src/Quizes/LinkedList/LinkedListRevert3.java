package Quizes.LinkedList;


public class LinkedListRevert3 {

	public static <T> boolean isPalindrome(MyNode<T> one, MyNode<T> two) {
		while (one != null && two != null) {
			if ( !one.mValue.equals(two.mValue) ) {
				return false;
			}
			one = one.mNext;
			two = two.mNext;
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		MyList<Character> ll = new MyList<Character>();
		ll.add('a');
		ll.add('b');
		ll.add('c');
//		ll.add('d');
		ll.add('c');
		ll.add('b');
		ll.add('a');
		System.out.println(ll.toString());		
		System.out.println(ll.size());
//		ll.addFirst('1');
//		System.out.println(ll);		
//		System.out.println(ll.size());
//		ll.reverse();//ll.getHead());
//		System.out.println(ll.toString());		
//		System.out.println(ll.size());
		System.out.println(ll.getMiddleNode());	
		System.out.println(ll.toString(
				ll.reverse(ll.getMiddleNode())) );
//		System.out.println(isPalindrome(ll.getHead(), ll.reverse(ll.getMiddleNode())) );
		System.out.println(ll.toString());	
		// Reconstruct list
		// fix bug in reverse - cut 1 symbol from original list
	}
}