import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;



public class LogParserTF {
	/**
	 * 127.8.8.1 HTTP/1.1 GET 200 /index.html?source=amazon
	 * 127.8.8.1 HTTP/1.1 GET 200 /index.html?source=google
	 *
	 * 12.4.8.1 HTTP/1.1 GET 200 /api/v2/users/1
	 * dfknkjdsnfjkdshfkdn kjdsjkhf jkdsfhjk ds
	 * 10.8.8.1 HTTP/1.1 POST 201 /api/v2/users/2
	 * 12.4.8.1 HTTP/1.1 GET 200 /api/v2/users/3
	 *
	 *  [127.8.8.1 -> ["/index.html", "/index.html"],
	 *  [12.4.8.1 -> ["/api/v2/users/1","/api/v2/users/3"],
	 *  [10.8.8.1 -> ["/api/v2/users/2"],
	 *  
	 *  "12.4.8.1 HTTP/1.1 GET 200 /api/v2/users/3"
	 *
	 **/
	 
	 public Map<String, List<String>> parseLogs (List<String> lines) {
	     if (lines == null) {
	         throw new IllegalArgumentException();
	     }
	     
	     HashMap<String, List<String>> result = new HashMap<String, List<String>>();
	     if (lines.size() < 1) {
	         return result;
	     }
	     
//	     Pattern ip = Pattern.compile(""); // \^\\d\{1-3\}\\.\\d\{1-3\}\\.\\d\{1-3\}\\.\d\{1-3\}");
//	     Regex pattern = ip.compile();
	     
	     boolean b = Pattern.matches("^\\d{1-3}\\.\\d{1-3}\\.d{1-3}\\.\\d{1-3}", "aaaaab");
	     
	     
	     for (String line: lines) {
	         if (Pattern.matches("^\\d{1-3}\\.\\d{1-3}\\.d{1-3}\\.\\d{1-3}", line)) {
	             String[] parts = line.split(" ");
	             String ip = parts[0];
	             
	             for(String part: parts) {
	                 if (part.startsWith(" /")) {
	                     if (part.contains("?")) {
	                         String[] subpart = part.split("?");
	                         addToMap(result, ip, subpart[0]);
	                     }
	                 
	                     addToMap(result, ip, part);
	                 }
	             }           
	         }
	     
	     }
	     
	     return result;
	 }
	 
	 public void addToMap(Map<String, List<String>> map, String key, String value) {
	     if (map.containsKey(key)) {
	         map.get(key).add(value);
	     } else {
	         List<String> list = new ArrayList<String>();
	         list.add(value);
	         map.put(key, list);
	     }
	 }
}