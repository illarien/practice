package WPrime;

import java.util.ArrayList;


public class Prototype {
	
//	private final static int[] SAMPLES = {300,300,300,300,300,300,300,300,300,300,200,200,100,100,100,100,100,100,100,100,100,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private final static int[] SAMPLES = {500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,100,100,100,100,100,100,100,0,0,0,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100,100};
	
//	private static final int tau = 400;
//	private static final int CP = 200;
	private final static int WP = 5000;
	
//	private static double calculateImpWithOffset(int Pn, int offSet) {
//		int dP = Pn - CP;
//		double k = - offSet * 1.0 / tau;
//		double exponent = Math.exp(k); 
//		return dP * exponent;
//	}
	
	public static void main(String[] args) {
		
//		for (int i = 0; i < 1000; i++) {
//			System.out.println( calculateImpWithOffset(300, i) );
//		}
		
//		ArrayList<Sample> timeline = new ArrayList<>();
//		for (int i=0; i < SAMPLES.length; i++) {
//			timeline.add(new Sample(SAMPLES[i]));
//			System.out.println("From Sample: " + timeline.get(i).get(1));
//		}
		
		double summ = 0;
		int end = SAMPLES.length;
		
		PowerCache powerCache = new PowerCache();
		
		for (int j = 0; j < end; j++) {
			summ = 0;
			for (int i = 0; i <= j; i++) {
				summ = summ + powerCache.getTimedSample(SAMPLES[i], j-i); //timeline.get(i).get(j-i);
//			System.out.println(timeline.get(i).get(1) + " " + timeline.get(i).get(end-i) + " " + summ);
				
			}
			System.out.println("Wbal: " + j + " " + (WP - summ) );			
		}
		
	}

	
}
