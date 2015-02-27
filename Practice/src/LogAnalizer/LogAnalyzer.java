package LogAnalizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;


public class LogAnalyzer {
	
	private static String path = "/Users/chekhovs/Desktop/Email Attachments/";
	private static String targetVersion = "log";
	
	public static String fullName = "";
	public static String command = "";
	public static int counter = 0;
	
	public static File folder = new File (path);
	public static File[] listOfFiles = folder.listFiles();
	
	private static Map<String, Integer> Exceptions = new LinkedHashMap<String,Integer>();
	private static Map<String, Integer> out = new LinkedHashMap<String,Integer>();
	
	public static String removeFolder (String in) {
		return in.substring(path.length());
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map ) {
		LinkedList<Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>( map.entrySet() );
		
		Collections.sort( list, Collections.reverseOrder(
				new Comparator<Map.Entry<K, V>>() {
					public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 ) {
						return (o1.getValue()).compareTo( o2.getValue() );
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
								  Exceptions.put(s, (Exceptions.get(s)+1) ); 
							  } else {
								  Exceptions.put(s, 1);
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
//		System.out.println(sortByValue(Exceptions));
		
		// --- find specific exception
		
		
		
		for (Map.Entry<String, Integer> entry: Exceptions.entrySet()) {
			out.put(findExcInFiles(entry.getKey()), entry.getValue());
//			System.out.println(entry.getValue() + " " + findExcInFiles(entry.getKey()));
		}
		System.out.println(sortByValue(out));
		
		for (Map.Entry<String, Integer> entry: out.entrySet()) {
			System.out.println(entry.getValue() + " " + entry.getKey());
		}
	}


	private class Data {
		int counter;
		String file;
		String line;
		
		public void increaseCount() {
			counter++;
		}
		
		
	}
	
	
	
}
