package Recalculator;

import com.garmin.fit.FileIdMesg;
import com.garmin.fit.FileIdMesgListener;
import com.garmin.fit.RecordMesg;
import com.garmin.fit.RecordMesgListener;
import com.garmin.fit.UserProfileMesg;
import com.garmin.fit.UserProfileMesgListener;

import java.util.ArrayList;

/**
 * Created by SC on 1/18/16.
 */
public class FitListener implements FileIdMesgListener, UserProfileMesgListener, RecordMesgListener {

    private ArrayList<Bundle> mBundles = new ArrayList<Bundle>();
    private int mTimer = 0;

    public FitListener() {
    }

    public void onMesg(FileIdMesg mesg) {
        if (mesg.getTimeCreated() != null) {
            System.out.print("ZZZZ: Time Created: " + mesg.getTimeCreated());
        }
    }

    public void onMesg(UserProfileMesg mesg) {
        if ((mesg.getFriendlyName() != null)) {
            System.out.print("Friendly Name: ");
            System.out.println(mesg.getFriendlyName());
        }
    }

    public void onMesg(RecordMesg mesg) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Statics.SECS, mTimer++);
        bundle.putSerializable(Statics.HR, (mesg.getHeartRate() != null ? (int)mesg.getHeartRate() : 0));
        bundle.putSerializable(Statics.WATTS, (mesg.getPower() != null ? mesg.getPower() : 0));
        bundle.putSerializable(Statics.CAD, (mesg.getCadence() != null ? (int)mesg.getCadence() : 0));
        bundle.putSerializable(Statics.WPR, 0);
        bundle.putSerializable(Statics.SWCCAP, 0);
        bundle.putSerializable(Statics.TOTALWORK, 0);
        bundle.putSerializable(Statics.AWCSER, 0);
        bundle.putSerializable(Statics.SWCSER, 0);
        bundle.putSerializable(Statics.PWRSER, 0);
        mBundles.add(bundle);
    }

    public ArrayList<Bundle> getBundles() {
        return mBundles;
    }
}