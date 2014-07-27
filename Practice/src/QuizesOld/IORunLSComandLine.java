package QuizesOld;

import java.io.*;


public class IORunLSComandLine {

	public static void execut() {
		        try {  
		            Process p = Runtime.getRuntime().exec("ls");  
		            BufferedReader in = new BufferedReader(  
		                                new InputStreamReader(p.getInputStream()));  
		            String line = null;  
		            while ((line = in.readLine()) != null) {  
		                System.out.println(line);  
		            }  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		 }  
	

}

