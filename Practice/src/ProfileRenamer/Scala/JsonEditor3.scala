package ProfileRenamer.Scala

import java.io.FileReader;
import java.io.FileWriter;
import scala.collection.immutable.HashSet
import scala.actors.threadpool.Arrays;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.codehaus.jackson.map._;



object JsonEditor3 {
 
  val HTTP = "http:"
  val HTTPS = "https:"
  val KEYS  = List("device_registration_exception_uri", 
    "url_base", 
    "url_tos",
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
    "url_claim_code_terms")
  val KEYSET = HashSet() ++ KEYS;
  val MAPPER = new ObjectMapper()
  val PARSER = new JSONParser()
  
  
  def modifyJSON(file: String): Unit = {    
      var input = new FileReader(file);
      val jsonObject = PARSER.parse(input).asInstanceOf[JSONObject]
      input.close() 
      val config = jsonObject.get("config").asInstanceOf[JSONObject]
      val modified = new JSONObject()

          for (k <- KEYSET) {
            var value = config.get(k).asInstanceOf[String]
            
            if (value != null && value.contains(HTTP)) {
              System.out.println(k + " " + value)
              value = value.replace(HTTP, HTTPS)
              System.out.println(k + " " + value)
//              config.put(k, value);
            }
          }
          
      // Write result
//      modified.put("", "") //"config", config)  
      MAPPER.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
      var output = new FileWriter(file);
      MAPPER.writeValue(output, modified);
      output.close();
  }
}