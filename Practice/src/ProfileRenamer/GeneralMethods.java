package ProfileRenamer;

import java.io.File;


public class GeneralMethods {

//	public static String path = "/Users/chekhovs/Desktop/test/";
//	public static String path = Folders.US_profiles.en_US;
	public static final String PATH = Folders.profiles.en_US;
	
	public static final File FOLDER = new File (PATH);
	public static final File[] LIST_OF_FILES = FOLDER.listFiles();
	
	
	public static String fixSpaces (String in) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < in.length(); i++) {
			if ( in.charAt(i) == ' ' ) {
				out.append("\\ ");
			} else if ( in.charAt(i) == '&' ) {
				out.append("\\&");
			} else {
				out.append(in.charAt(i));
			}
		}
		return out.toString();
	}
	
	public static String removeFolder (String in) {
		return in.substring(PATH.length()+1);
	}
	
	public static String removeFolder2 (String in) {
		return in.substring(PATH.length());
	}
}