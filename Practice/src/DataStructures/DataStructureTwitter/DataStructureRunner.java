package DataStructures.DataStructureTwitter;

public class DataStructureRunner {

	public static void main(String[] args) {
		DataStructure ds = new DataStructure();
		ds.begin();
		ds.set("a", "1");
		ds.begin();
		ds.set("a", "2");
		ds.set("b", "11");
		ds.set("a", "3");
		System.out.println(ds.toString());
//		System.out.println(ds.get("a"));
		System.out.println("---");
		ds.begin();
		ds.set("a", "4");
		ds.set("b", "12");
		ds.set("c", "101");
		System.out.println(ds.toString());
//		System.out.println(ds.get("a"));
		System.out.println("---");
		ds.rollback();
		System.out.println(ds.toString());
		System.out.println("---");
		ds.rollback();
		System.out.println(ds.toString());
		System.out.println("---");
		ds.rollback();
		System.out.println(ds.toString());
		System.out.println("---");
		ds.rollback();
		System.out.println(ds.toString());
	}

}
