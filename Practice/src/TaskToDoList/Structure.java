package TaskToDoList;

import Tree.Node;

//Create a ToDo list app.
//
//Should be able to add, remove, reorder, and mark as complete tasks on the list.
//
//-list of objects already exists
//----
//1. Input req: �Buy a bicycle�
//�Go to the mall�
//
//List: 0
//List: 1 - �Buy a Bicycle�
//List: 2 -  �Buy a Bicycle�, �Go to the mall�

public class Structure {
	
	public static void main(String[] args) {
		TaskList tl = new TaskList();
		
		System.out.println("add t1");
		tl.addItem(new ListItem("Task1") );
		
		System.out.println("add t2");
		tl.addItem(new ListItem("Task2") );
		
		System.out.println("add t3");
		tl.addItem(new ListItem("Task3") );
		
		//tl.printFirstTask();
		System.out.println("Print all");
		tl.printAllTasks();
		
		//tl.printSecond();
	}
	
}

class TaskList {
	ListItem firstTask;	
	//ListItem current; //iterator
	//ListItem nextTask;
	int index;
	
	public void addItem(ListItem item) {
		//ListItem listItem = new ListItem(task, state);
		
		if (firstTask == null) {
			firstTask = item;
			firstTask.nextTask = null;
			System.out.println("1 task");
			return;
		}
		if (firstTask != null) {
			
			ListItem focus = firstTask;
			ListItem parent;
			while (true) {
				System.out.println("SSS");
				parent = focus;
				focus = focus.nextTask;
				if ( focus == null) {
					parent.nextTask = item;
					return;
				}
			}
		}
	
	}
	
	public void add(ListItem item, int position) {
//		check correctness of position;
//		iterate to �pos-1� element;
//		change pointer �pos-1� (nextTask) to item
//		set pointer (nextTask) for item to �posision� item 
	}
	
	public void findTask(String task) { }
	
	public void remove(String taskToRemove) {}
	public void reorder () {}
	public void markAsComplete() {}
	
	// added by me for debugging
	public void printFirstTask() {
		System.out.println(firstTask.taskToString(firstTask));
	}
	public void printSecond() {
		System.out.println(firstTask.taskToString(firstTask.nextTask));
	}
	public void printAllTasks() {
		ListItem current = firstTask;
		while ( current != null) {
			System.out.println(current.taskToString(current));
			current = current.nextTask;
		}
		
	}
}


class ListItem {
	boolean state;
	String task;
	// upustil reference na sled item?
	ListItem nextTask;
	
	ListItem(String task, boolean state) {
		this.task = task;
		this.state = state;
	}
	ListItem(String task) {
		this.task = task;
		this.state = false;
	}
	
	// added by me for debugging
	public String taskToString (ListItem item) {
		return item.task + " " + item.state;
	}
}

