package DataStructures.EmployeeTree;

import java.util.ArrayList;
import java.util.HashSet;

public class Employee {
	public String name;
	public String year;
	public String boss;
	public ArrayList<Employee> pointers = new ArrayList<Employee>();
	
	public Employee(String s) {
		String[] data = s.split(",");
		this.name = data[0];
		this.year = data[1];
		this.boss = (data.length>2) ? data[2] : "boss";
	}
	
	public String toString() {
		return name + " " + year + " " + boss + " " + ((pointers.size() == 0) ? "worker" : "manager");
	}
	
	public void findWorkers(HashSet<Employee> emps){
		for (Employee e: emps) {
			if ( name.equals(e.boss)) {
				pointers.add(e);
			}
		}
	}
	
	public void print() {
        print("", true);
    }

    private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + name);
        for (int i = 0; i < pointers.size() - 1; i++) {
            pointers.get(i).print(prefix + (isTail ? "    " : "│   "), false);
        }
        if (pointers.size() > 0) {
            pointers.get(pointers.size() - 1).print(prefix + (isTail ?"    " : "│   "), true);
        }
    }
}
