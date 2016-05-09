
public class ArrayMergeSortedArrays {

	
	private static int[] mergeArrays(int[] inp1, int[] inp2) {
		int[] result = new int[inp1.length + inp2.length];
		int i1 = 0, i2 = 0;
		
		while (i1 < inp1.length && i2 < inp2.length) {
			if (inp1[i1] < inp2[i2]) {
				result[i1+i2] = inp1[i1];
				i1++;
			} else {
				result[i1+i2] = inp2[i2];
				i2++;
			}
		}
		
		while (i1 < inp1.length) {
			result[i1+i2] = inp1[i1];
			i1++;
		}
		while (i2 < inp2.length) {
			result[i1+i2] = inp2[i2];
			i2++;
		}
		
		return result;
	}
	
	private static void printArray(String comment, int[] input) {
		StringBuilder sb = new StringBuilder();
		sb.append(comment);
		for (int i: input) {
			sb.append(i + ",");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		int[] a1 = {1,3,5,7,9};
		int[] a2 = {2,4,6,8,10};
		printArray("Input1: ", a1);
		printArray("Input2: ", a2);
		printArray("Output: ", mergeArrays(a1, a2));
	}

}
