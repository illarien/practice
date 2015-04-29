package ProfileRenamer;

import java.io.File;
import java.util.Map;

/*
 * Class to implement "add to P4 file"
 * Not actual since repository was moved to Git.
 */

public class AddToP4 extends GeneralMethods {

	//private static String targetVersion = "-apple-";
	private static String targetVersion = "-4.2-"; // for 4.1
	public static String fullName = "";
	public static String command = "";
	public static int counter = 0;
	
	public static Process p;

	public static void main(String[] args) {

		for (File f : LIST_OF_FILES) {	
//			command = "/usr/local/bin/p4 add "; //to perform adding
			command = "/usr/local/bin/p4 edit "; //to perform check out
			
			try {
				fullName = f.getCanonicalPath();

				if (fullName.contains(targetVersion)) {	
					
					command += fixSpaces(removeFolder2(fullName)); // for US profiles
//					command += fixSpaces(removeFolder(fullName)); // for non US
					System.out.println(counter + " " + command);
				
					ProcessBuilder pb = new ProcessBuilder(new String[] {"/bin/bash", "-c", command});
					
					Map<String, String> env = pb.environment();
				    env.put("P4CLIENT", "chekhovs_US");
//				    env.put("P4CLIENT", "chekhovs_non_US");
				    pb.directory(new File (PATH));
				    
				    //System.out.println(pb.directory());
					//pb.command("/bin/sh", "-c", command);
				    
					p = pb.start();
					
					//BufferedReader output = new BufferedReader( new InputStreamReader(p.getErrorStream()) );
					//String str = "";
					//while ((str = output.readLine()) != null) {
					//    System.out.println(str);
					//}
					
					p.waitFor();
					counter++;
				}
			} catch (Exception e) {e.printStackTrace();}
		}
		System.out.println("Ended: " + counter);
	}
}
