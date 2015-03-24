package DataStructures.EmployeeTree;

import java.util.HashSet;

public class Runner {

	private static String[] lines = {"EmpA,2007,EmpC", "EmpB,2004,EmpC", "EmpC,1990,", "EmpD,1989,EmpB", "EmpE,2000,EmpB",
		"EmpF,2000,EmpC", "EmpG,2000,EmpF", "EmpH,2000,EmpG"};
	
	public static void main(String[] args) {
		HashSet<Employee> emps = new HashSet<Employee>();
		for (String s: lines) {
			emps.add(new Employee(s));
		}		

		for (Employee e: emps) {
			e.findWorkers(emps);
		}		
		
		for (Employee e: emps) {
			System.out.println(e.toString());
		}
		
		System.out.println();
		
		for (Employee e: emps) {
			if (e.boss.equals("boss")) {
				e.print();
			}
		}

	}
}
