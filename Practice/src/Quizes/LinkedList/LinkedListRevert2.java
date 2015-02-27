package Quizes.LinkedList;



// List To revert
//Element of list
class Element {
	int value;
	Element next;
	public Element (int data) {
		this.value=data;
	}
}
//LinkedList
class LList {
	private Element first;
	public LList() {
		first = null;
	}
	public void ins(int data) {
		Element elem = new Element(data);
		elem.next = first;
		first = elem;
	}
	
	public void printLL() {
		System.out.print("Elements in LList: ");
		Element el = first;
		while (el != null) {
			System.out.print(el.value + ", ");
			el = el.next;
		}
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public void revertLL() {
		Element el = first;
		if (el == null) {
			return;
		}
		Element el2 = el.next;
		Element temp = el2;
		el2 = el;
		el = temp;
	}
}

public class LinkedListRevert2 {
	public static void main(String[] args) {
		LList llist = new LList();
		llist.ins(1);
		llist.ins(2);
		llist.ins(3);

		
		System.out.println(llist.isEmpty());
		llist.printLL();
		llist.revertLL();
		llist.printLL();
	}

}
