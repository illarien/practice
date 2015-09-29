package WPrime;

import java.math.BigDecimal;

public class Tests {


	private final static int[] SAMPLES = {10,300,300,300,300,300,300,300,300,300,300,300,100,100,100,100,100,100,100,100,100};
	
	private final static int WP = 1000;
	
	public static void main(String[] args) {
		
		double Wprime = 1000;
		
//		for(int i = 0; i < SAMPLES.length; i++) {
//			Wprime = Functions.calculateWprime(SAMPLES[i], Wprime);
//			System.out.println(i + " " + SAMPLES[i] + " " + Wprime + " " + Functions.correction(Wprime));
//		}
		
//		for(int i = 0; i < 1000; i++) {
//			System.out.println(Functions.correction(i));
//		}

//		for (int i = 0; i < 600; i++) {
//			double tau = Functions.calculateTau(Statics.CP, i);
//			System.out.println(i + " - " + tau);
//		}
		
//		for (int i = 0; i < 100; i++) {
//			System.out.println(i + " " + i * 1.0 /516);
//		}
		
		
		
//		Sample testSample = new Sample(500);
//		System.out.println("Tau: " + testSample.getTau());
//		for (int i = 0; i < 600; i++) {
//			System.out.println(i + " " + testSample.get(i) + " W': " + (WP - testSample.get(i)));
//		}
		
		
		PowerCache powerCache = new PowerCache();
		for (int i = 0; i < 600; i++) {
			System.out.println(i + " " + powerCache.getTimedSample(i, 0));
		}
		
	}

}
