package Recalculator;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import com.garmin.fit.Decode;
import com.garmin.fit.FileIdMesgListener;
import com.garmin.fit.MesgBroadcaster;
import com.garmin.fit.RecordMesgListener;
import com.garmin.fit.UserProfileMesgListener;

/**
 * Created by SC on 1/18/16.
 */
public class FitFileImporter {

    private static String mInputFileName;
    private JsonFormat mFileWriter;
    private Decode mDecode;
    private MesgBroadcaster mMesgBroadcaster;
    private FitListener mListener;


    public FitFileImporter(JsonFormat fileWriter, String fileName) {
        this.mFileWriter = fileWriter;
        this.mDecode = new Decode();
        this.mMesgBroadcaster = new MesgBroadcaster(mDecode);
        this.mListener = new FitListener();
        this.mInputFileName = fileName;
    }

    public void importFitFile() {
        System.out.println("ZZZZ: Importing file...");
        FileInputStream in = getInputStream(getFile(mInputFileName)); // works!

        mMesgBroadcaster.addListener((FileIdMesgListener) mListener);
        mMesgBroadcaster.addListener((UserProfileMesgListener) mListener);
        mMesgBroadcaster.addListener((RecordMesgListener) mListener);

        try {
            mDecode.read(in, mMesgBroadcaster, mMesgBroadcaster);
        } catch (Exception ioe) {
            System.out.println(ioe);
        }

        close(in);
        ArrayList<Bundle> data = mListener.getBundles();
        for (int i = 0 ; i < data.size(); i++) {
            mFileWriter.writeValues(data.get(i));
        }
        mFileWriter.writeFooter();
    }

    private File getFile(String fileName) {
        if (fileName.isEmpty()) {
            return null; //getFile();
        }
      
        return new File(fileName);
    }

    private FileInputStream getInputStream(File file) {
        if (file == null) {
            return null;
        }

        FileInputStream in;
        try {
            in = new FileInputStream(file);
        } catch (java.io.IOException e) {
            throw new RuntimeException("ZZZ: Error opening file " + file.getName());
        }
        return in;
    }

    private void close(FileInputStream in) {
        try {
            in.close();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
}