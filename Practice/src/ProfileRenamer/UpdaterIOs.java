package ProfileRenamer;

import java.io.File;
import java.io.IOException;


public class UpdaterIOs {
	
	private static String path = Folders.profiles.en_US;
	private static String[] carrier = {"t-mobile", 
		"at\\&t", 
		"verizon", 
		"sprint", 
		"unknown"};
	private static String manufacturer = "apple";
	private static String[] model = {"iphone2,1", "iphone3,1", "iphone3,3", "iphone4,1", 
		"iphone5,1", 
		"iphone5,2", 
		"iphone5,3", 
		"iphone5,4", 
		"iphone6,1", 
		"iphone6,2", 
		"iphone7,1", 
		"iphone7,2", 
		"iphone7,3", 
		"iphone7,4", 
		"iphone7,5", 
		"ipod5,1", 
		"ipod4,1", 
		"ipod3,1", 
		"ipad4,5", 
		"ipad4,4", 
		"ipad4,2", 
		"ipad4,1", 
		"ipad2,7", 
		"ipad2,6", 
		"ipad2,5", 
		"ipad3,6", 
		"ipad3,5", 
		"ipad3,4", 
		"ipad3,2", 
		"ipad3,3", 
		"ipad3,1", 
		"ipad2,3", 
		"ipad2,2", 
		"ipad2,1", 
		"ipad2,4" 
};
	private static String appVer = "3.2.0";
	private static String[] osVer = {"iphone os7.0", 
		"iphone os7.0.1", 
		"iphone os7.0.2", 
		"iphone os7.0.3", 
		"iphone os7.0.4", 
		"iphone os7.0.5", 
		"iphone os7.0.6", 
		"iphone os7.1", 
		"iphone os7.1.1", 
		"iphone os7.1.2", 
		"iphone os6.0", 
		"iphone os6.0.1", 
		"iphone os6.0.2", 
		"iphone os6.1", 
		"iphone os6.1.1", 
		"iphone os6.1.2", 
		"iphone os6.1.3", 
		"iphone os6.1.4", 
		"iphone os6.1.5", 
		"iphone os6.1.6", 
		"iphone os8.0", 
		"iphone os8.0.1", 
		"iphone os8.0.2", 
		"iphone os8.1" };
	
	private static String outPath = path; // change to path/outPath to copy in the same folder
	private static File folder = new File (path);
	//private static File outFolder = new File (outPath); 
	
	private static File[] listOfFiles = folder.listFiles();
	
	private static String originalVersion = "Ulamcorper-Mattis-Vivamus-9.9.9-9.9.9.json";
	private static String targetVersion = "4.1";
	
	public static String fullName = "";
	public static String command = "";
	public static String command2 = "";
	public static int counter = 0;
	
	public static Process p;
	
	public static String constructIOSname() {
		return carrier[0]+"-"+manufacturer+"-"+model[0]+"-"+appVer+"-"+osVer[0]+".json";
	}
	
	public static String reconstractName (String in) {
		String[] arr = in.split("-");
		String out = "";
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].equals(originalVersion)) {
				out += targetVersion;
				out += "-";
			} else {
				out += arr[i];
				out += "-";
			}
		}
		out += arr[arr.length - 1];
		return out;
	}
	
	public static String removeFolder (String in) {
		return in.substring(path.length() + 1);
	}
	
	public static String fixSpaces (String in) {
		String out = "";
		for (int i = 0; i < in.length(); i++) {
			if ( in.charAt(i) == ' ' ) {
				out += "\\ ";
			} else if ( in.charAt(i) == '&' ) {
				out += "\\&";
			} else {
				out += in.charAt(i);
			}
		}
		return out;
	}
	
	public static void main(String[] args) {
		for (File f : listOfFiles) {	
			command = "cp ";
			try {
				fullName = f.getCanonicalPath();
				command = command + fixSpaces(fullName) + " " + outPath  + "/";
			} catch (IOException e) {e.printStackTrace();}
			
			if (fullName.contains(originalVersion)) {	
				for (String c: carrier) {
					for (String m: model) {
						for (String o: osVer) {
							fullName = c+"-"+manufacturer+"-"+m+"-"+appVer+"-"+o+".json";
							command2 = command + fixSpaces(fullName);
							System.out.println(counter + " " + command2);
							try {	
								p = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", command2});
								p.waitFor();
							} catch (Exception e) {e.printStackTrace();}
							counter++;
						}
					}
				}
				
//				command += fixSpaces(removeFolder(reconstractName(fullName))); // construct name here
//				System.out.println(command);
				System.out.print(counter + " ");
				break;
			}
	
		}
		
		System.out.println(counter);
	}

}
