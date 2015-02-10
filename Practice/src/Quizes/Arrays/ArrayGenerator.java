package Q;
import java.util.*;


public class Arr {

	public static int[] generateArray(int leng) {
		int[] out = new int[leng];
		Random generator = new Random();
		for (int i = 0; i < leng; i++) {
			out[i] = generator.nextInt(10);
		}
		return out;
	}
	
	public static void main(String[] args) {
		Object[] arrOb = new Object[10];
		
		int[] arr = generateArray(10);
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
//		Arrays.sort(arr, Collections.reverseOrder());
		

	}

}
