package QuizesOld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import android.net.NetworkInfo;

public class RunTests {

	public static void main(String[] args) {
		String installApp = "/Users/sergeic/Documents/android-sdk-macosx/platform-tools/adb install /Users/sergeic/Documents/android-sdk-macosx/platform-tools/Adobe_Reader_10.2.1.apk";
		String pushTest = "/Users/sergeic/Documents/android-sdk-macosx/platform-tools/adb push /Users/sergeic/git/androidautomation/bin/android-17.jar /data/local/tmp/";
		String runTest = "/Users/sergeic/Documents/android-sdk-macosx/platform-tools/adb shell uiautomator runtest android-17.jar -c ComplexTest";
		String pullScreenshot = "/Users/sergeic/Documents/android-sdk-macosx/platform-tools/adb pull /data/local/tmp/myscrshot.jpg";
		
		
//		isConnected();
		
		
		if (runProc(installApp, "Success")) {
			System.out.println("INSTALLED.");}
		else {System.out.println("INSTALLATION FAILED.");}
		
		if (runProc(pushTest,"")) {
			System.out.println("TEST PUSHED.");}
		else {System.out.println(" ");}
		
		
		runProc(runTest, "myscrshot.jpg");
		
	}

	public static boolean runProc(String toRun, String checkWord) {
//		----- RUN TEST -----		
		boolean ret = false;
		try {  
            Process p = Runtime.getRuntime().exec(toRun);  
            BufferedReader in = new BufferedReader(  
                                new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line); 
                if (line.equals(checkWord)) {
                	System.out.println("DONE!!! " + checkWord);
                	ret = true;
                }
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
//		----- END OF RUN TEST -----
		return ret;
	}
	
}
