package ProfileRenamer;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashSet;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.codehaus.jackson.map.*;


public class JsonEditor2 {

	private static FileReader input;
	private static FileWriter output;
	private static final String HTTP = "http:";
	private static final String HTTPS = "https:";
	private static final String[] KEYS = {"device_registration_exception_uri", 
		"url_base", "url_tos", 
		"url_album_detail", 
		"url_lookup",
		"url_sample_track", 
		"url_genre_hierarchy", 
		"url_search", 
		"url_artist_tracks", 
		"url_artist_albums", 
		"url_top_tracks", 
		"url_top_albums", 
		"url_merchandising", 
		"url_help_generic", 
		"url_help_library",
		"url_help_store",
		"url_new_customer",
		"url_contact_us",
		"url_account_setup",
		"url_claim_code_terms"};
	private static final HashSet<String> KEYSET = new HashSet<String>(Arrays.asList(KEYS));
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final JSONParser PARSER = new JSONParser();
	
	
	public static void modifyJSON(String file) {		
		try {
			 // Read file and get JSONObject
			input = new FileReader(file);
			JSONObject jsonObject = (JSONObject) PARSER.parse(input);
			input.close(); 
		    JSONObject config = (JSONObject) jsonObject.get("config");
        	JSONObject modified = new JSONObject();
        	
        	boolean hasUpdates = false;

        	for (String k: KEYSET) {
        		String value = (String) config.get(k);
        		if (value != null && value.contains(HTTP)) {
        			System.out.println(k + " " + value);
        			value = value.replace(HTTP, HTTPS);
                    config.put(k, value);
                    hasUpdates = true;
        			System.out.println(k + " " + value + " has updates: " + hasUpdates);
        		}
        	}
        	
			// Write result
            if (hasUpdates) {
            	modified.put("config", config);  
            	MAPPER.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
            	output = new FileWriter(file);
            	MAPPER.writeValue(output, modified);
            	output.close();
            }
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}