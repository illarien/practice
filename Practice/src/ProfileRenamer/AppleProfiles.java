package ProfileRenamer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Map;

/*
 * To do something with apple profiles
 */

public class AppleProfiles {
	
	private static String path = "/Users/chekhovs/Desktop/EE/out2";
	//private static String path = Folders.US_profiles.en_US;
	//private static String path = Folders.Non_US_profiles.en_UK;
	
	private static File folder = new File (path);
	
	private static File[] listOfFiles = folder.listFiles();

	private static String targetVersion = "-apple-";
	//private static String targetVersion = "-4.0-"; // for 4.0
	
	public static String fullName = "";
	public static String command = "";
	public static int counter = 0;
	
	public static Process p;
	
	
	public static String removeFolder (String in) {
		return in.substring(path.length() + 1);
	}
	
	public static String fixSpaces (String in) {
		String out = "";
		for (int i = 0; i < in.length(); i++) {
			if ( in.charAt(i) == ' ' ) {
				out += "\\ ";
			} else {
				out += in.charAt(i);
			}
		}
		return out;
	}
	
	public static void main(String[] args) {

		for (File f : listOfFiles) {	
			//command = "/usr/local/bin/p4 add ";
			//command = "cl ";
			command = "";
			
			try {
				fullName = f.getCanonicalPath();

				if (fullName.contains(targetVersion)) {	
					//command += fixSpaces(removeFolder(fullName)); // not work
					command += removeFolder(fullName);// - not work w/o fixSpaces
					
					//command += fixSpaces(fullName); // work
				
					System.out.println(counter + " " + command);
				
					//ProcessBuilder pb = new ProcessBuilder(new String[] {"/bin/bash", "-c", command});
					ProcessBuilder pb = new ProcessBuilder(new String[] {"/bin/bash", "-c"});
					
					Map<String, String> env = pb.environment();
				    env.put("P4CLIENT", "chekhovs_US_profiles"); // !!!!
				    pb.directory(new File (path));
				    
				    //System.out.println(pb.directory());
				    
					//pb.command("/bin/sh", "-c", command);
				    
					p = pb.start();
					
					BufferedReader output = new BufferedReader( new InputStreamReader(p.getErrorStream()) );
					String str = "";
					while ((str = output.readLine()) != null) {
					    System.out.println(str);
					}
					
					// now add lines to new file
					BufferedReader inFile = new BufferedReader( new FileReader(fullName) );
					
					String line;
					while ((line = inFile.readLine()) != null) {
					   System.out.println(line);
					}
					inFile.close();
					
					// and add two lines
					BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fullName), true));
					bw.write("text-text-text");
					bw.newLine();
					bw.close();
					
					p.waitFor();
					counter++;
					
					//if (counter > 1) break;
				}
	
			} catch (Exception e) {e.printStackTrace();}
		}
		
		System.out.println("Ended: " + counter);

	}

}
