package DataStructures.DataStructureSumoL;



/*
 * Design data structure with add, remove, contains, recent, random complexity O(1)
 * + DeataStructure.java
 */

public class DataStructurRunner {

	public static void main(String[] args) {
		DataStructure d1 = new DataStructure(5);
		System.out.println("d1: " + d1.toString());
//		DataStructure d1 = new DataStructure();
//		System.out.println("d1: " + d1.toString());
		DataStructure2<Integer> d2 = new DataStructure2<>();		
		System.out.println("d2: " + d2.toString());

		
		d1.add(4);
		d1.add(3);
		d1.add(2);
		d1.add(1);
		System.out.println("d1: " + d1.toString());
		
		d2.add(5);
		d2.add(4);
		d2.add(3);
		d2.add(2);
		d2.add(1);
		System.out.println("d2: " + d2.toString());
		
		System.out.println("Random1: " + d1.getRandom());
		System.out.println("Random2: " + d2.getRandomEntry());
		
		d1.delete(2);
		System.out.println("d1: " + d1.toString());
		
		d2.remove(2);
		System.out.println("d2: " + d1.toString());
		
		System.out.println("d1: " + d1.contains(3) +" " +  d1.contains(2));
		System.out.println("d2: " + d2.contains(3) +" " +  d2.contains(2));
		
		System.out.println("d1-Recent: " + d1.getRecent());
//		System.out.println("d2-Recent: " + d2.getRecent());
		
		d1.delete(1);
		System.out.println("d1-Recent: " + d1.getRecent());
	}

}
