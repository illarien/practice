package recaling1;

public class GetAllSubarrays {

	private static int[] arr = {1,2,3};
	
	private static void printArray(int[] in) {
		for(int i = 0; i < in.length; i++) {System.out.print(in[i] + ",");}
		System.out.print("\n");
	}
	
	private static int[] getArrayWitoutElement(int[] in, int p) {
		int[] res = new int[in.length-1];
		int c = 0;
		for(int i = 0; i < in.length; i++) {
			if (i == p) {continue;}
			res[c++] = in[i];
		}
		return res;
	}
	
	private static void getSubArrays(int[] in) {
		printArray(in);
		for(int i = 0; i < in.length; i++) {
			getSubArrays(getArrayWitoutElement(in, i));
		}
	}
	
	
	public static void main(String... args) {
		getSubArrays(arr);
	}
}
