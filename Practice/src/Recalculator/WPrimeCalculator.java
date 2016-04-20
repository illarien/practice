package Recalculator;

import java.util.ArrayList;

/**
 * Created by SC on 10/5/15.
 */
public class WPrimeCalculator {

    private ArrayList<Long> mSamples = new ArrayList<Long>();
    private PowerCache powerCache = new PowerCache();
    private int samplesSize = 0;
    private double summ = 0;

    public double getWPrime (long power) {

        mSamples.add(power);
        samplesSize = mSamples.size();
        summ = 0;

        for (int i = 0; i < samplesSize; i++) {
            Long sample = mSamples.get(i);
            summ = summ + powerCache.getTimedSample(sample, samplesSize - i);
        }

        return Statics.W - summ;
    }
}