package ProfileRenamer;

import java.io.File;

public class UpdaterAndroid extends GeneralMethods {
	
	private static String targetVersion = "-4.2-";
	
	public static String fullName = "";
	public static String command = "";
	public static int counter = 0;
	
	public static void main(String[] args) {

		for (File f : LIST_OF_FILES) {	
			command = "";
			
			try {
				fullName = f.getCanonicalPath();

				if (fullName.contains(targetVersion)) {
//					command += fixSpaces(removeFolder(fullName)); // not work
//					command += removeFolder(fullName);// - not work w/o fixSpaces
					command += fullName;
					counter++;
					System.out.println(counter + " " + command);
					
					JsonEditor.modifyJSON(fullName);
				}	
			} catch (Exception e) {e.printStackTrace();}
		}
		System.out.println("Ended: " + counter + " Total Number of files: " + LIST_OF_FILES.length);
	}
}
