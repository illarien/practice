package Recalculator;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPInputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



/**
 * Created by SC on 7/19/14.
 */
public class WorkoutRecordData implements Serializable {

    private String mDate;
    private String mType = "Broken record";
    private String mDuration = "Click to fix it.";
    private String mDescription = "";
    private String mKey;
    private File mFile;
    private int mCP = 150;
    private int mAWC = 10000;
    private int mTotalwork = 0;
    private int mLengthOfRecords = 0;
    private boolean mIsWorkoutBroken = false;
    
	private static final JSONParser PARSER = new JSONParser();


    public WorkoutRecordData(File file) {
        this.mFile = file;
//        this.mDate = file.getName().length() > 10 ? file.getName().substring(0, 10) : file.getName();
        this.mDate = reformateDate(file.getName().length() > 10 ? file.getName().substring(0, 10) : file.getName());
        setIDAndDuration();
    }

    public File getFile() {
        return mFile;
    }
    public String getFileName () {
        return mFile.getName();
    }
    public String getDate() {
        return mDate;
    }
    public String getType() {
        return mType;
    }
    public String getKey() {
        return mKey;
    }
    public String getDuration() {
        return mDuration;
    }

    public JSONObject loadJSONFromAsset() {
        JSONObject toReturn = null;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(mFile)), Charset.forName("UTF-8")));
            JSONObject jsonObject = (JSONObject) PARSER.parse(rd);
            rd.close();
            
//            StringBuilder sb = new StringBuilder();
//            String inputLine;
//            while ((inputLine = rd.readLine()) != null){
//                sb.append(inputLine);
//            }
            
            toReturn = jsonObject; //new JSONObject(sb.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
//            rd.close();
        }
        return toReturn;
    }

    private void setIDAndDuration() {
        JSONObject json = loadJSONFromAsset();
        try {
            JSONObject uniObject = (JSONObject) json.get("RIDE");
            this.mType = (String) uniObject.get("IDENTIFIER");
            JSONArray array = (JSONArray) uniObject.get("SAMPLES");
            mLengthOfRecords = array.size() - 1;
            this.mDuration = String.format("%02d:%02d:%02d", mLengthOfRecords / 3600, (mLengthOfRecords % 3600) / 60, mLengthOfRecords % 60);
            this.mCP = Integer.valueOf((String) ((JSONObject) uniObject.get("TAGS")).get("CP"));
            this.mAWC = Integer.valueOf((String) ((JSONObject) uniObject.get("TAGS")).get("WPR"));
            
            JSONObject tw =(JSONObject) array.get(mLengthOfRecords - 2);
//            int tws = (int) tw.get("TOTALWORK");
            this.mTotalwork = ((Long) tw.get("TOTALWORK")).intValue(); //Integer.valueOf(tws);
            this.mDescription = (String) ((JSONObject) uniObject.get("TAGS")).get("Objective");
        } catch (Exception ex) {
            mIsWorkoutBroken = true;
            ex.printStackTrace();
        }

    }

    public int getCP() {
        return mCP;
    }

    public int getAWC() {
        return mAWC;
    }

    public int getTotalWork() {
        return mTotalwork;
    }

    public int getAvgPower() {
        return mTotalwork*1000/mLengthOfRecords;
    }

    public boolean isWorkoutBroken() {
        return mIsWorkoutBroken;
    }

    public String getDescription() {
        return mDescription.isEmpty() ? "WORKOUT DESCRIPTION (click to edit)" : mDescription;
    }

//    public void moveFile() {
//        if(mFile.exists()) {
//            File dir = new File(Environment.getExternalStorageDirectory(), Statics.CM_DIR_DELETED); // + mFile.getName());
//            dir.mkdirs();
//            File to = new File(dir.getAbsolutePath()+"/"+ mFile.getName());
//            mFile.renameTo(to);
//        }
//    }

    public void setWorkoutType (String type) {
        JSONObject json = loadJSONFromAsset();
        try {
            JSONObject uniObject = (JSONObject) json.get("RIDE");
            uniObject.put("IDENTIFIER", type);
            GzipWriter buffer = new GzipWriter(new BufferedOutputStream(new FileOutputStream(mFile)));
            buffer.write(json.toString());
            buffer.close();
        } catch (Exception ex) {
            mIsWorkoutBroken = true;
            ex.printStackTrace();
        }
    }

    public void setAthleteNameWorkoutCPandW (String name, String cp, String w) {
        JSONObject json = loadJSONFromAsset();
        try {
            JSONObject uniObject = (JSONObject) json.get("RIDE");
            JSONObject tags = (JSONObject) uniObject.get("TAGS");
            tags.put("Athlete", name);
//            tags.put("CP", cp);
//            tags.put("WPR", w);
            GzipWriter buffer = new GzipWriter(new BufferedOutputStream(new FileOutputStream(mFile)));
            buffer.write(json.toString());
            buffer.close();
        } catch (Exception ex) {
            mIsWorkoutBroken = true;
            ex.printStackTrace();
        }
    }

    public void setAthleteNameAndWorkoutName(String athlete, String workoutName) {
        JSONObject json = loadJSONFromAsset();
        try {
            JSONObject uniObject = (JSONObject) json.get("RIDE");
            uniObject.put("IDENTIFIER", workoutName);
            JSONObject tags = (JSONObject) uniObject.get("TAGS");
            tags.put("Athlete", athlete);
            GzipWriter buffer = new GzipWriter(new BufferedOutputStream(new FileOutputStream(mFile)));
            buffer.write(json.toString());
            buffer.close();
        } catch (Exception ex) {
            mIsWorkoutBroken = true;
            ex.printStackTrace();
        }
    }

    public void setDescription (String text) {
        JSONObject json = loadJSONFromAsset();
        try {
            JSONObject uniObject = (JSONObject) json.get("RIDE");
            JSONObject tags = (JSONObject) uniObject.get("TAGS");
            tags.put("Objective", text);
            GzipWriter buffer = new GzipWriter(new BufferedOutputStream(new FileOutputStream(mFile)));
            buffer.write(json.toString());
            buffer.close();
        } catch (Exception ex) {
            mIsWorkoutBroken = true;
            ex.printStackTrace();
        }
    }

    private String reformateDate (String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date testDate = null;
        try {
            testDate = sdf.parse(date);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
        return (testDate == null ? date : formatter.format(testDate));
    }
}