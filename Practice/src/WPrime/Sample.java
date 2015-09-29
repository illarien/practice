package WPrime;

import java.util.ArrayList;

public class Sample {
	private int deltaPower = 0;
	private double tau = 0;
	private ArrayList<Double> timeline = new ArrayList<>();
	
	Sample (int power) {
		this.deltaPower =  power - Statics.CP; //Statics.CP - power; //power; power - Statics.CP;
		this.tau = calculateTau(power);
//		timeline.add((double) power);
		fillTimelineTillN(100);
	}

	private double calculateTau(int power) {
		return Statics.A * Math.exp(-0.01 * (deltaPower)) + Statics.B;
	}
	
	private double calculateImpulse(int n) {
		if (deltaPower >= 0) {
			return deltaPower * Math.exp( - n * 1.0 / tau );
		}
		return 0; //deltaPower * 0.9;
	}
	
	public double get(int n) {
		if (n < timeline.size()) {
			return timeline.get(n);
		} else {
			fillTimelineTillN(n);
			return timeline.get(n);			
		}
	}
	
	private void fillTimelineTillN (int end) {
		for (int i = timeline.size(); i <= end; i++) {
			timeline.add(calculateImpulse(i));
		}
	}
	
	public double getTau() {
		return tau;
	}
	
}
