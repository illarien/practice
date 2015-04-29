package ProfileRenamer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.codehaus.jackson.map.*;

//import org.codehaus.jackson.map.ObjectWriter;
//
//import org.json.simple.JSONArray;



public class JsonEditor {

//	public static String in = "/Users/chekhovs/Documents/EclipseWS/tools/ProfileRenamer/assets/default_fake.json";
//	public static String out = "/Users/chekhovs/Documents/EclipseWS/tools/ProfileRenamer/assets/default_modified.json";
	public static FileReader input;
	public static FileWriter output;
	public static final String key = "url_help_library";
	public static final String value = "https://www.amazon.com/gp/help/customer/display.html?nodeId=201637470";
	
	
	public static void modifyJSON(String file) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			input = new FileReader(file);

			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(input);

			input.close();
			
//		    JSONObject config = mapper.readValue(input, JSONObject.class);    
		    JSONObject config = (JSONObject) jsonObject.get("config");
        	JSONObject modified = new JSONObject();

            String name = (String) config.get(key);
//            System.out.println(name);
            config.put(key, value);
//            System.out.println(config.get("url_help_library"));
        	          
//          modified.putAll(config);
            modified.put("config", config);
//        	jsonObject.putAll(config);
            
			mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
			
			output = new FileWriter(file);
            mapper.writeValue(output, modified);
//			mapper.writeValue(output, jsonObject);
			output.close();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	
	
	
//	@SuppressWarnings("unchecked")
//	public static void main(String[] args) {
//	
//        ObjectMapper mapper = new ObjectMapper();
//		try {
//			input = new FileReader(in);
//			output = new FileWriter(out);
//			JSONParser parser = new JSONParser();
//			JSONObject jsonObject = (JSONObject) parser.parse(input);
//			
////		    JSONObject config = mapper.readValue(input, JSONObject.class);    
//		    JSONObject config = (JSONObject) jsonObject.get("config");
//        	JSONObject modified = new JSONObject();
//
//            String name = (String) config.get("associate_tag_wifi");
//            System.out.println(name);
//            config.put("associate_tag_wifi", "modified");
//            System.out.println(config.get("associate_tag_wifi"));
//        	modified.putAll(config);
////            modified.put("a", "A");
////            modified.put("b", "B");
//		                        
//			mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
//            mapper.writeValue(output, modified);
//		    
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    }
}






//// this is Jackson 1.x API only: 
//ObjectWriter writer = mapper.defaultPrettyPrintingWriter();
//// ***IMPORTANT!!!*** for Jackson 2.x use the line below instead of the one above: 
//ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
//System.out.println(writer.writeValueAsString(modified));






//JSONParser parser = new JSONParser();
//
//try {     
//	JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("/Users/chekhovs/Documents/EclipseWS/tools/ProfileRenamer/assets/default_fake.json"));
//	JSONObject config = (JSONObject) jsonObject.get("config");
//	JSONObject modified = new JSONObject();
//
//	
//    String name = (String) config.get("associate_tag_wifi");
//    System.out.println(name);
//
//    config.put("associate_tag_wifi", "modified");
//    System.out.println(config.get("associate_tag_wifi"));
////	modified.putAll(config);
//    modified.put("a", "A");
//    modified.put("b", "B");
//    
//    try {
//    	 
//		FileWriter file = new FileWriter("/Users/chekhovs/Documents/EclipseWS/tools/ProfileRenamer/assets/default_modified.json");
//		//file.write(modified.toJSONString());//jsonObject.toJSONString());
//		modified.writeJSONString(file);
//		file.flush();
//		file.close();
// 
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//    
//    
//    
//} catch (Exception e) {
//    e.printStackTrace();
//} 

