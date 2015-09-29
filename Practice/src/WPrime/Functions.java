package WPrime;

public class Functions {


	public static double calculateTau(int CP, int Pt) {
		final double power = -0.01 * (Pt - CP);
		return Statics.A * Math.exp(power) + Statics.B;
	}
	
	public static double correction(double Wprime) {
		return Math.exp(-4 * Wprime / Statics.W);
	}
	
	public static double calculateWprime(int Pt, double Wprime) {
		if ( Pt >= Statics.CP ) {
			return Wprime - (Pt-Statics.CP);
		} else {
			return Wprime + (Statics.CP-Pt) * correction(Wprime);
		}
	}
	
}
