package recaling1;

public class findUniqueElement {

	private static int[] arr = {1,3,2,5,3,1,2};
	
	private static int findUnique(int[] in) {
		int res = 0;
		for (int i: in) {
			res=res^i;
		}
		return res;
	}
	
	public static void main(String...strings) {
		System.out.println(findUnique(arr));
	}
	
}
