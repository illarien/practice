package ProfileRenamer;

import java.io.File;
import java.util.HashSet;
import java.util.Set;


public class GetCarriers extends GeneralMethods {

	private static String targetVersion = "-apple-";
	public static String fullName = "";
	public static String command = "";
	public static int counter = 0;		
	public static Set<String> carriers = new HashSet<String>();
	
	
	public static void main(String[] args) {
		for (File f : LIST_OF_FILES) {	
			command = "";
			
			try {
				fullName = f.getCanonicalPath();

				if (fullName.contains(targetVersion)) {	
					String name =removeFolder(fullName);
					String[] arr = name.split("-");
					carriers.add(arr[0]);			
					System.out.println(counter + " " + name + " " + arr[0]);
					counter++;
				}
			} catch (Exception e) {e.printStackTrace();}
		}
		System.out.println("Ended: " + counter + " Total Number of files: " + LIST_OF_FILES.length);
		System.out.println(carriers);
	}
}