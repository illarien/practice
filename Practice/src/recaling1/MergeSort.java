package recaling1;

public class MergeSort {
	
	
	public static int[] sort(int[] inp) {
		if (inp.length < 2) {
			return inp;
		} else if (inp.length == 2) {
			if (inp[0] > inp[1]) {
				int t = inp[0];
				inp[0] = inp[1];
				inp[1] = t;
			}
			return inp;
		} else {
			int middlePos = inp.length/2;
			int[] sub1 = getSubArray(inp, 0, middlePos);
			int[] sub2 = getSubArray(inp, middlePos, inp.length);
			inp = mergeSortedArr(sort(sub1), sort(sub2));
			return inp;
		}
	}
	
	public static int[] getSubArray(int[] arr, int start, int end) {
		int[] res = new int[end-start];
        for (int i = start; i < end; i++) {
            res[i-start] = arr[i];
        }
        return res;
	}

	public static int[] mergeSortedArr(int[] a1, int[] a2) {
		int res[] = new int[a1.length + a2.length];
		int i = 0, j = 0;
		while (i < a1.length && j < a2.length) {
			if (a1[i] < a2[j]) {
				res[i+j] = a1[i++];
			} else {
				res[i+j] = a2[j++];
			}
		}
		while (i < a1.length) {
			res[i+j] = a1[i++];
		}
		while (j < a2.length) {
			res[i+j] = a2[j++];
		}
		return res;
	}
	
	
	public static void main(String... args) {
		int[] arr = {5,8,2,4,9,7,8,2,1};
		int[] res = sort(arr);
		for (int i = 0; i < res.length; i++) {System.out.print(res[i] + ",");}
	}
}