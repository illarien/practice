package Recalculator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class JsonFormat {

    private GzipWriter mBuffer;
    private String mFileName = "";

    public JsonFormat() {}

    public File createFile() {
        File dir = new File(mFileName);
        dir.mkdirs();
        Date startDate = new Date(System.currentTimeMillis());
        SimpleDateFormat filef = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        mFileName = filef.format(startDate) + ".json";
        File newFile = new File(dir, mFileName);
        try {
            mBuffer = new GzipWriter(new BufferedOutputStream(new FileOutputStream(newFile)));
        } catch (Exception e) {}
        return newFile;
    }

    public File createFileWithName (String fName) {
//        File dir = new File(mFileName);
//        dir.mkdirs();
//        Date startDate = new Date(System.currentTimeMillis());
//        SimpleDateFormat filef = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        mFileName = fName + ".json";
        File newFile = new File(mFileName); // new File(dir, mFileName);
        try {
            mBuffer = new GzipWriter(new BufferedOutputStream(new FileOutputStream(newFile)));
        } catch (Exception e) {}
        return newFile;
    }

    public void writeHeader(int cp, int awc, int gp, int swc) {
        writeHeader(cp, awc, gp, swc, "WORKOUT");
    }

    public void writeHeader(int cp, int awc, int gp, int swc, String name) {
        Date startDate              = new Date(System.currentTimeMillis());

        SimpleDateFormat startTimef = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat filef      = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        SimpleDateFormat month      = new SimpleDateFormat("MMMMM");
        SimpleDateFormat year       = new SimpleDateFormat("yyyy");
        SimpleDateFormat day        = new SimpleDateFormat("EEEEE");

        startTimef.setTimeZone(TimeZone.getTimeZone("UTC"));
        filef.setTimeZone(TimeZone.getTimeZone("UTC"));
        month.setTimeZone(TimeZone.getTimeZone("UTC"));
        year.setTimeZone(TimeZone.getTimeZone("UTC"));
        day.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            mBuffer.write("{" +
                    "\"RIDE\":{" +
                    "\"STARTTIME\":\"" + startTimef.format(startDate) + " UTC\"," +
                    "\"RECINTSECS\":1," +
                    "\"DEVICETYPE\":\"Android\"," +
                    "\"IDENTIFIER\":\"" + name + "\"," +
                    "\"TAGS\":{" +
                    "\"Athlete\":\"" + "NAME" + "\"," +
                    "\"CP\":\"" + Integer.toString(cp) + "\"," +
                    "\"WPR\":\"" + Integer.toString(awc) + "\"," +
                    "\"GP\":\"" + Integer.toString(gp) + "\"," +
                    "\"SWC\":\"" + Integer.toString(swc) + "\"," +
                    "\"Calendar Text\":\"Bike\"," + // TODO: put workout type here
                    "\"Change History\":\"\"," +
                    "\"Data\":\"\"," +
                    "\"Device\":\"\"," +
                    "\"Device Info\":\"\"," +
                    "\"File Format\":\"\"," +
                    "\"Filename\":\"JSON (*.json)\"," +
                    "\"Filename\":\"" + mFileName + "\"," +
                    "\"Month\":\"" + month.format(startDate) +"\"," +
                    "\"Notes\":\"\"," +
                    "\"Objective\":\"\"," +
                    "\"Sport\":\"Bike\"," +
                    "\"Weekday\":\"" + day.format(startDate) + "\"," +
                    "\"Workout Code\":\"\"," +
                    "\"Year\":\"" + year.format(startDate) + "\"" +
                    "}," +
                    "\"SAMPLES\":[{\"SECS\":0}");
        } catch (Exception e) {}
    }

    public void writeValues(Bundle bundle) {
        try {
            synchronized (mBuffer) {
                int bundleSize = bundle.size();
                mBuffer.write(",{");

                for (String key: bundle.keySet()) {
                    if (key.equals(Statics.AWCSER) || key.equals(Statics.PWRSER) || key.equals(Statics.SWCSER)) {
//                        bundleSize--;
                        continue;
                    }
                    mBuffer.write("\"");
                    mBuffer.write(key);
                    mBuffer.write("\":");
                    int time = ((Integer) bundle.getSerializable(key));
                    mBuffer.write(Integer.toString(time));
                    if (bundleSize > 4) { // 4 because of AWC, SWC and PWR series in bundle
                        mBuffer.write(",");
                        bundleSize--;
                    }
                }

                mBuffer.write("}");
            }
        } catch (Exception e) {}
    }

    public void writeFooter() {
        try {
            mBuffer.write("]}}");
            mBuffer.close();
        } catch (Exception e) {}
    }
}