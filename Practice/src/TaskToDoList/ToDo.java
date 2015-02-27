package TaskToDoList;

import java.util.ArrayList;

public class ToDo {
	
	public static void main(String[] args) {
		System.out.println("Add and print tasks");
		TaskList tl = new TaskList();
		tl.addTask("Task1", false, 0);
		tl.addTask("Task2", false, 1);
		tl.addTask("Task3", false, 2);
		tl.addTask("Task0", false, 0);
		tl.addTask("Task5", false, 5);
		tl.printAllTask();
		System.out.println("Remove Task");
		tl.removeTask(3);
		tl.removeTask("Task2");
		tl.printAllTask();
		System.out.println("Complete Task");
		tl.completeTask("Task0");
		tl.printAllTask();
		System.out.println("Remove Completed Task");
		tl.removeTask(true);
		tl.printAllTask();
		System.out.println("Rorder Tasks: before");
		tl.addTask("Task1", true, 0);
		tl.addTask("Task2", false, 1);
		tl.addTask("Task3", false, 2);
		tl.addTask("Task0", false, 0);
		tl.addTask("Task5", true, 5);
		tl.printAllTask();
		System.out.println("Rorder Tasks: after");
		tl.reorderTasks(4, 2);
		tl.printAllTask();
	}
	
}

class TaskList {
	public ArrayList<Task> todo;
	public TaskList() {
		 todo = new ArrayList<Task>();
	}

	public void addTask(String task, boolean completed, int position) {
		int listSize = todo.size();
		if ( position <= listSize) {
			todo.add(position, new Task(task, completed));
		} else {
			todo.add(listSize, new Task(task, completed));
		}	
	}
	
	public void removeTask(int position) {
		if ( todo.size() < 1) {
			System.out.println("List too short");
		} else {
			todo.remove(position);
		}
	}
	
	public void removeTask(String task) {
		if ( todo.size() < 1) {
			System.out.println("List too short");
		} else {
			for (Task t : todo) {
				if ( t.task.equals(task)) {
					todo.remove(t);
				}
			}
		}
	}
	
	public void removeTask(boolean completed) {
		if ( todo.size() < 1) {
			System.out.println("List too short");
		} else {
			ArrayList<Task> toRemove = new ArrayList<Task>();
			for (Task t : todo) {
				if ( t.completed == true) {
					toRemove.add(t);
				}
			}
			todo.removeAll(toRemove);
		}
	}
	
	public void completeTask(String task){
		if ( todo.size() < 1) {
			System.out.println("List too short");
		} else {
			for (Task t : todo) {
				if ( t.task.equals(task)) {
					t.completed = true;
				}
			}
		}
	}
	
	public void reorderTasks(int from, int to){
		if ( todo.size() < from ||todo.size() < to ) {
			System.out.println("List too short");
		} else {
			Task temp = todo.get(from);
			todo.remove(from);
			todo.add(to, temp);
		}
	}
	
	public void printFirst() {
		System.out.println(todo.get(0).task + " " + todo.get(0).completed);
	}
	
	public void printAllTask() {
		if ( todo.size() < 1) {System.out.println("List too short");}
		for (int i = 0; i< todo.size(); i++ ) {
			System.out.println(todo.get(i).task + " " + todo.get(i).completed);
		}
	}
}

class Task {
	String task;
	boolean completed;
	public Task(String task, boolean completed) {
		this.task = task;
		this.completed = completed;
	}
}