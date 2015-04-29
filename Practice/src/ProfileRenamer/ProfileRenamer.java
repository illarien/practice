package ProfileRenamer;

import java.io.File;

public class ProfileRenamer extends GeneralMethods {
	
	private static String outPath = PATH; // change to path/outPath to copy in the same folder
	
	private static String originalVersion = "4.3";
	private static String originalVersion2 = "-4.3-";
	private static String targetVersion = "4.4";
	
	public static String fullName = "";
	public static String command = "";
	public static int counter = 0;
	
	public static Process p;
	
	
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
	
	
	public static void main(String[] args) {
		for (File f : LIST_OF_FILES) {	
			try {
				fullName = f.getCanonicalPath();
				if (fullName.contains(originalVersion2)) {	
					command = "cp " + fixSpaces(fullName) + " " + outPath;
					command += fixSpaces(removeFolder2(reconstractName(fullName)));
					System.out.println(command);

					//Comment this to test copy process and get files counted
						p = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", command});
						p.waitFor();
					
					counter++;
					System.out.print(counter + " ");
				}
			} catch (Exception e) {e.printStackTrace();}
		}
		System.out.println(counter);
	}
}