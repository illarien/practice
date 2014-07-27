package QuizesOld;

// reverse LinkedList

public class LinkedListReverseLinkedList3 {

	
	
	public static class ListNode{
	    int value;
	    ListNode next;  
	    public ListNode(int value, ListNode next){
	        this.value = value;
	        this.next = next;
	    }       
	    public ListNode next(){
	        return next;
	    }
	    public void setNext(ListNode next){
	        this.next = next;
	    }
	    public int value(){
	        return value;
	    }
	}

	public static class SinglyLinkedList {

	    private ListNode head;

	    public SinglyLinkedList(ListNode head){
	        this.head = head;
	    }

	    public void reverse(){
	        ListNode current = head;
	        head = null;
	        while (current!=null){
	            ListNode temp = current;
	            current = current.next;
	            temp.next = head;
	            head = temp;
	        }
	    }
	}

	    public static boolean isCircular(SinglyLinkedList list){
	        ListNode counter1 = list.head;
	        ListNode counter2 = list.head;
	        while (counter1!=null && counter2!=null){
	            counter1 = counter1.next;
	            counter2 = counter2.next;
	            if (counter2.next!=null){
	                counter2 = counter2.next;
	            } else 
	                return false;
	            if (counter1 == counter2)
	                return true;
	        }
	        return false;
	    }

	    public static void printSinglyLinkedList(ListNode head){
	        ListNode temp = head;
	        while(temp!=null){
	            System.out.print(temp.value + " ");
	            temp = temp.next;
	        }
	        System.out.println();
	    }

	    public static void main(String[] s){
	        ListNode a4 = new ListNode(4, null);
	    	ListNode a3 = new ListNode(3, a4);
	        ListNode a2 = new ListNode(2, a3);
	        ListNode a1 = new ListNode(1, a2);
//	        a4.setNext(a1);

	        SinglyLinkedList list1 = new SinglyLinkedList(a1);
	        
	        System.out.println(isCircular(list1));
	//      printSinglyLinkedList(list1.head);
	        
	        if (!isCircular(list1))
	            printSinglyLinkedList(list1.head);
	        
	        list1.reverse();
	        if (!isCircular(list1))
	            printSinglyLinkedList(list1.head);




	    }
	}
	

