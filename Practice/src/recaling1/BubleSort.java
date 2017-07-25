package recaling1;

public class BubleSort {

	private static int[] sort(int[] inp) {
		for (int i = 0; i < inp.length; i++) {
			for (int j = i; j < inp.length; j++) {
				if (inp[i] > inp[j]) {
					int tmp = inp[i];
					inp[i] = inp[j];
					inp[j] = tmp;
				}
			}
		}		
		return inp;
	}
	
	public static void main(String... args) {	
		int[] arr = {5,8,2,4,9,8,2,1};
		int[] res = sort(arr);
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + ",");
		}
	}
}