package LogAnalizerForNate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.*;


public class LogAnalyzer2 {
	
	private static String path = "/Users/chekhovs/Desktop/Email Attachments/";
	
	public static String fullName = "";
	public static String command = "";
	public static int counter = 0;
	
	public static File folder = new File (path);
	public static File[] listOfFiles = folder.listFiles();
	
	private static Map<String, Data> Exceptions = new HashMap<String, Data>();
	
	public static String removeFolder (String in) {
		return in.substring(path.length());
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map ) {
		LinkedList<Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>( map.entrySet() );
		
		Collections.sort( list, Collections.reverseOrder(
				new Comparator<Map.Entry<K, V>>() {
					public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 ) {
						return (((Data) o1.getValue()).getCounter()).compareTo( ((Data) o2.getValue()).getCounter() );
					}
				} )
		);

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list){
			result.put( entry.getKey(), entry.getValue() );
		}
		return result;
		}
	
	public static String findExcInFiles (String specEx) {
		for (File f: listOfFiles) {
			try {
				FileInputStream fstream = new FileInputStream(f);
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

				String strLine;
				int linecounter = 0;

				while ((strLine = br.readLine()) != null)   {
				  linecounter++;
				  if (strLine.contains(specEx)) {
					  //System.out.println(specEx.trim() + " " + f.getCanonicalPath() + " line: " + linecounter);
					  return specEx.trim() + " " + removeFolder(f.getCanonicalPath()) + " line: " + linecounter;
				  }

				}
				br.close();
				
			} catch (Exception e) {return null;}	
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// --- Counting exceptions
		for (File f: listOfFiles) {
			try {
				FileInputStream fstream = new FileInputStream(f);
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
				String strLine;

				while ((strLine = br.readLine()) != null)   {
				  if (strLine.contains("$") && strLine.contains("Exception")) { 
					  String [] arr = strLine.split(" ");
					  for (String s: arr) {
						  if (s.contains("$") && s.contains("Exception")) {
							  if (Exceptions.containsKey(s)) {
								  Exceptions.get(s).increaseCount(); 
							  } else {
								  Exceptions.put(s.trim(), new Data(1, removeFolder(f.getCanonicalPath()), "", s.trim()));
							  }			  
//							  System.out.println (s);
							  counter++;
						  }
					  }
				  }
				}
				br.close();
				
			} catch (Exception e) {}	
		}
		System.out.println("Ended: Total number of exceptions: " + counter + " Total Number of files: " + listOfFiles.length);
		System.out.println("Unique exceptions: " + Exceptions.size());

		Exceptions = sortByValue(Exceptions);
		for (Map.Entry<String, Data> me : Exceptions.entrySet()) {
			System.out.println(me.getValue().toString());
		}
		
		
	}	
}
