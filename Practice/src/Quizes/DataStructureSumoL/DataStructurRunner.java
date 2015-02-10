package Q;

/*
 * Design data structure with add, remove, contains, recent, random complexity O(1)
 * + DeataStructure.java
 */

public class DataStructurRunner {

	public static void main(String[] args) {
		DataStructure d1 = new DataStructure();
		System.out.println(d1.toString());

		DataStructure d2 = new DataStructure(5);
		System.out.println(d2.toString());
		
		d2.add(4);
		d2.add(3);
		d2.add(2);
		d2.add(1);
		System.out.println(d2.toString());
		
		System.out.println("Random: " + d2.getRandom());
		
		
		d2.delete(2);
		System.out.println(d2.toString());
		
		System.out.println(d2.contains(3) +" " +  d2.contains(2));
		
		System.out.println("Recent: " + d2.getRecent());
		d2.delete(1);
		System.out.println("Recent: " + d2.getRecent());
	}

}
