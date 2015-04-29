package ProfileRenamer;

import java.io.File;

public class CountFilesInFolder extends GeneralMethods{
	
//	private static String targetVersion = "-apple-";
	private static String targetVersion = "-4.3-"; // for 4.1
//	private static String targetVersion = "3.2.0";
	
	public static String fullName = "";
	public static String command = "";
	public static int counter = 0;
	
	public static void main(String[] args) {

		long time = System.nanoTime();
		
		for (File f : LIST_OF_FILES) {	
			command = "";
			
			try {
				fullName = f.getCanonicalPath();

				if (fullName.contains(targetVersion)) {	//& fullName.contains("at&t")
//					command += fixSpaces(removeFolder(fullName)); // not work
					command += removeFolder(fullName);// - not work w/o fixSpaces
					System.out.println(counter + " " + command);
					counter++;
				}	
			} catch (Exception e) {e.printStackTrace();}
		}
		time = System.nanoTime() - time;
		System.out.println("Ended: " + counter + " Total Number of files: " + LIST_OF_FILES.length + " Time, ms: " + time/1000000);
	}

}
