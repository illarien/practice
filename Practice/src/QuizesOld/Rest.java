package QuizesOld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Rest {
	public static void main(String[] args) throws Exception {
	String resp;
	String[] pN = {"defaultBundle", "RAPTenant"};
	String[] pV = {"defaultBundle", "sch2"};
	resp = httpPost("https://loadtest.appsensemobile.com/rest/bundle/debug/defaultBundle?&RAPTenant=sch2",
				pN, pV);
	
	}
	
	public static String httpPost(String urlStr, String[] paramName, String[] paramVal) throws Exception {
		  URL url = new URL(urlStr);
		  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		  conn.setRequestMethod("POST");
		  conn.setDoOutput(true);
		  conn.setDoInput(true);
		  conn.setUseCaches(false);
		  conn.setAllowUserInteraction(false);
		  conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		  // Create the form content
		  OutputStream out = conn.getOutputStream();
		  Writer writer = new OutputStreamWriter(out, "UTF-8");
		  for (int i = 0; i < paramName.length; i++) {
		    writer.write(paramName[i]);
		    writer.write("=");
		    writer.write(URLEncoder.encode(paramVal[i], "UTF-8"));
		    writer.write("&");
		  }
		  writer.close();
		  out.close();

		  if (conn.getResponseCode() != 200) {
		    throw new IOException(conn.getResponseMessage());
		  }

		  // Buffer the result into a string
		  BufferedReader rd = new BufferedReader(
		      new InputStreamReader(conn.getInputStream()));
		  StringBuilder sb = new StringBuilder();
		  String line;
		  while ((line = rd.readLine()) != null) {
		    sb.append(line);
		  }
		  rd.close();

		  conn.disconnect();
		  return sb.toString();
		}

}
