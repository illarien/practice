package WPrime;

import java.util.HashMap;

public class PowerCache {
	
	private HashMap<Integer, Sample> cache = new HashMap<>();
	
	public double getTimedSample(int power, int time) {
		cache.putIfAbsent(power, new Sample(power));
		return cache.get(power).get(time);
	}

}
