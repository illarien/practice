package Recalculator;

/**
 * Created by SC on 10/5/15.
 */
import java.util.concurrent.ConcurrentHashMap;

public class PowerCache {

    private ConcurrentHashMap<Long, Sample> cache = new ConcurrentHashMap<Long, Sample>();

    public double getTimedSample(long power, int timeOffset) {
//
//        if (power <= Statics.CP) {
//            return 0;
//        }

        cache.putIfAbsent(power, new Sample(power));
        return cache.get(power).get(timeOffset);
    }

    public int size() {
        return cache.size();
    }
}
