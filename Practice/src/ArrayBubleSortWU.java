
public class ArrayBubleSortWU {

	private static void printArray(int[] input) {
		StringBuilder sb = new StringBuilder();
		for(int i: input) {
			sb.append(i);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
	
	private static void bubleSort(int[] input) {
		if (input == null || input.length < 1) {
			return;
		}
		for (int i = 0; i < input.length; i++) {
			for (int j = i+1; j < input.length; j++) {
				if (input[i] > input[j]) {
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
	}
	
	private static int[] mergeSort(int[] input) {
		if (input.length < 2) {
		} else if (input.length == 2 && input[0] > input[1]) {
			int tmp = input[0];
			input[0] = input[1];
			input[1] = input[0];
			return input;
		} else {
			int middlePosition = input.length/2;
			int[] arr1 = getSubArray(input, 0, middlePosition);
			int[] arr2 = getSubArray(input, middlePosition+1, input.length);
			input = mergeSortedArrays(mergeSort(arr1), mergeSort(arr2));
		}
		return input;
	}
	
    private static int[] mergeSortedArrays(int[] in1, int[] in2) {
        int totalLength = in1.length + in2.length;
        int[] result = new int[totalLength];
        int i = 0, j = 0;
        while(i+j <= totalLength && i < in1.length && j < in2.length) {
            if (in1[i] < in2[j] ) {
                result[i+j] = in1[i++];
            } else {
                result[i+j] = in2[j++];
            }
        }
        while (i < in1.length) {
            result[i+j] = in1[i++];
        }
        while (j < in2.length) {
            result[i+j] = in2[j++];
        }
        return result;
    }
	
    private static int[] getSubArray(int[] in, int start, int stop) {
        int[] result = new int[stop - start];
        for (int i = start; i < stop; i++) {
            result[i-start] = in[i];
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] array = {1,3,5,7,9,8,6,5,4,2};
		printArray(array);
//		bubleSort(array);
//		mergeSort(array);
		printArray(mergeSort(array));
	}
}
