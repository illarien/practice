package ProfileRenamer;

import java.io.File;

public class UpdateHttpsEveryWhere extends GeneralMethods {
	
	private static final String TARGET_VERSION = "Amazon";
	
	public static String fullName = "";
	public static String command = "";
	public static int counter = 0;
	
	public static void main(String[] args) {
		for (File f : LIST_OF_FILES) {	
			if ( counter > 95000) {
				break;
			}
			StringBuilder command = new StringBuilder();
			
			try {
				fullName = f.getCanonicalPath();

				if ( true ) { //fullName.contains(TARGET_VERSION)
					command.append(fullName);
					counter++;
					System.out.println(counter + " " + command);			
					JsonEditor2.modifyJSON(fullName);
				}	
			} catch (Exception e) {e.printStackTrace();}
		}
		System.out.println("Processed: " + counter + " Total Number of files: " + LIST_OF_FILES.length);
	}
}
