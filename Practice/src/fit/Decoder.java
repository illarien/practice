package fit;

import com.garmin.fit.*;
import com.garmin.fit.csv.MesgCSVWriter;
import com.garmin.fit.csv.MesgDataCSVWriter;
import com.garmin.fit.csv.MesgFilter;
import com.garmin.fit.test.Tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Decoder {
	
   public static void main(String args[]) {
      String in = "/Users/newbuyer/git/practice/Practice/src/fit/test.fit";
      String out = "/Users/newbuyer/git/practice/Practice/src/fit/";
      ArrayList<String> mesgDefinitionsToOutput = new ArrayList<String>();
      ArrayList<String> dataMessagesToOutput = new ArrayList<String>();
      boolean fitToCsv = false;
      boolean csvToFit = false;
      boolean test = false;
      boolean checkIntegrity = false;
      boolean showInvalidValues = false;
      boolean invalidsToEmpty = false;
      boolean hideUnknownData = false;
      int nextArgumentDefinition = 0;
      int nextArgumentData = 0;
      int numUnknownFields = 0;
      int numUnknownMesgs = 0;
      Decode decode = new Decode();

      int arg = 0;

      System.out.printf("FIT CSV Tool - Protocol %d.%d Profile %.2f %s\n", Fit.PROTOCOL_VERSION_MAJOR, Fit.PROTOCOL_VERSION_MINOR, Fit.PROFILE_VERSION / 100.0, Fit.PROFILE_TYPE);

      
      if ((out.length() >= 4) && (out.substring(out.length()-4, out.length()).compareTo(".csv") == 0))
	    out = out.substring(0, out.length()-4); // Remove .csv extension.

	 if (true) {
	    try {
	       if (!decode.checkFileIntegrity((InputStream) new FileInputStream(in))) {
	          if (!decode.getInvalidFileDataSize())
	             throw new RuntimeException("FIT file integrity failure.");
	          else {
	             System.out.println("FIT file integrity failure. Invalid file size in header.");
	             System.out.println("Trying to continue...");
	          }
	       }
	    } catch (java.io.IOException e) {
	       throw new RuntimeException(e);
	    }
	 }

	 if (true) {
	    Tests tests = new Tests();
	    System.out.println("Running FIT verification tests...");
	    if (tests.run(in))
	       System.out.println("Passed FIT verification.");
	    else
	       System.out.println("Failed FIT verification.");
	 }

	 try {
	    MesgCSVWriter mesgWriter = new MesgCSVWriter(out + ".csv");
	    FileInputStream fileInputStream = new FileInputStream(in);
	    if (showInvalidValues == true)
	       decode.showInvalidValues();

	    MesgFilter mesgFilter = new MesgFilter();
	    mesgFilter.setMesgDefinitionsToOutput(mesgDefinitionsToOutput);
	    mesgFilter.setDataMessagesToOutput(dataMessagesToOutput);

	    MesgDataCSVWriter dataMesgWriter = new MesgDataCSVWriter(out + "_data3.csv");
	    if (true) {
	       mesgWriter.showInvalidsAsEmptyCells();
	       dataMesgWriter.showInvalidsAsEmptyCells();
	    }

	    if (true) {
	       mesgWriter.hideUnknownData();
	       dataMesgWriter.hideUnknownData();
	    }

	    mesgFilter.addListener((MesgDefinitionListener) mesgWriter);
	    mesgFilter.addListener((MesgListener) mesgWriter);
	    mesgFilter.addListener((MesgListener) dataMesgWriter);

	    decode.addListener((MesgDefinitionListener) mesgFilter);
	    decode.addListener((MesgListener) mesgFilter);

	    while (decode.bytesAvailable((InputStream) fileInputStream)) { // Try to read a file while more data is available.
	       try {
	          decode.read((InputStream) fileInputStream);
//	          decode.nextFile(); // Initialize to read next file (if any).
	       } catch (FitRuntimeException e) {
//	          if (decode.getInvalidFileDataSize()) {
//	             decode.nextFile();
//	             continue;
//	          }
	       }
	    }

	    mesgWriter.close();
	    dataMesgWriter.close();

	    if ( !mesgWriter.csvHasData() )
	       System.out.println("Warning: No CSV has been written as this file does not contain FIT message data");

	    numUnknownFields = mesgWriter.getNumUnknownFields();
	    numUnknownMesgs = mesgWriter.getNumUnknownMesgs();

	 } catch (java.io.IOException e) {
	    throw new RuntimeException(e);
	 }

	 System.out.printf("FIT binary file %s decoded to %s*.csv files.\n", in, out);
   }
}
