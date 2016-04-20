package Recalculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RecalcRunner {

    private static JsonFormat mFileWriter;
    private static File mFile = null;
    private static File mFileRecalculated = null;
    private static WorkoutRecordData mData = null;
    
    private static int mAWC = 15000;
    private static int mCP = 390;
    private static int mSWC = 9000;
    private static int mGP = 460;
    private static final String mWorkoutname = "Imported workout";
    private static String inputFile = "/Users/newbuyer/Desktop/Tsv2016/MSR.fit"; // original file
	
    
	public static void main(String... args) {
		// Get Properties
		System.out.println("Printing properties:");
		Properties properties = new Properties();
		try {
		  properties.load(new FileInputStream("/Users/newbuyer/Desktop/Tsv2016/recalcproperties")); // Change path here before compilation, leave only "recalcproperties"
		} catch (Exception e) {
			System.out.println(e);
		}
		for(String key : properties.stringPropertyNames()) {
			  String value = properties.getProperty(key);
			  System.out.println(key + " => " + value);
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {}
		// Comment it out to use defaults
		mAWC = Integer.valueOf(properties.get("AWC").toString());
		mSWC = Integer.valueOf(properties.get("SWC").toString());
		mCP = Integer.valueOf(properties.get("CP").toString());
		mGP = Integer.valueOf(properties.get("GP").toString());
		inputFile = properties.get("fit").toString();
		
		// Convert .fit to .json
		mFileWriter = new JsonFormat();
        mFile = mFileWriter.createFileWithName("2016-01-21_16-00-01"); //imported file /Users/newbuyer/Desktop/TdSL2016/2016-01-21_16-00-01
        mFileWriter.writeHeader(mCP, mAWC, mGP, mSWC, mWorkoutname);
		(new FitFileImporter(mFileWriter, inputFile)).importFitFile();
		mFileWriter = null;
		// Recalculate .json
		mFileWriter = new JsonFormat();
		mFileRecalculated = mFileWriter.createFileWithName("2016-01-22_16-00-02"); // recalculated file /Users/newbuyer/Desktop/TdSL2016/2016-01-22_16-00-02
        mFileWriter.writeHeader(mCP, mAWC, mGP, mSWC, "Recalculated imported workout");
        recalculateAWC(new WorkoutRecordData(mFile));
        mFileWriter.writeFooter();
        System.out.println("Done.");
	}
	
	
    private static void recalculateAWC(WorkoutRecordData data) {
        WPrimeCalculator awcCalculator = new WPrimeCalculator();
        WPrimeCalculator swcCalculator = new WPrimeCalculator();
        int totalWork = 0;
        try {
            JSONArray array = (JSONArray) ((JSONObject) data.loadJSONFromAsset().get("RIDE")).get("SAMPLES");
            for (int i = 1; i < array.size(); i++) {
                JSONObject object = (JSONObject) array.get(i);
                int watts = ((Long) object.get(Statics.WATTS)).intValue();
                int awcPower = (watts <= mGP ? (watts - mCP) : (mGP - mCP));
                int swcPower = (watts > mGP ? (watts - mGP) : (watts < mCP ? (watts - mCP) : 0) );
                totalWork += watts;
                Bundle bundle = new Bundle();
                bundle.putSerializable(Statics.SECS, ((Long) object.get(Statics.SECS)).intValue());
                bundle.putSerializable(Statics.HR, ((Long) object.get(Statics.HR)).intValue());
                bundle.putSerializable(Statics.WATTS,  ((Long) object.get(Statics.WATTS)).intValue());
                bundle.putSerializable(Statics.CAD, ((Long) object.get(Statics.CAD)).intValue());
                bundle.putSerializable(Statics.WPR, (mAWC + (int) awcCalculator.getWPrime(awcPower)));
                bundle.putSerializable(Statics.SWCCAP, (mSWC + (int) swcCalculator.getWPrime(swcPower)) );
                bundle.putSerializable(Statics.TOTALWORK, totalWork/1000);
                bundle.putSerializable(Statics.AWCSER, 0);
                bundle.putSerializable(Statics.PWRSER, 0);
                bundle.putSerializable(Statics.SWCSER, 0);
                mFileWriter.writeValues(bundle);
                System.out.println("Progress:  " + (i * 100)/array.size());
            }
        } catch (Exception e) {e.printStackTrace();}
    }
}
