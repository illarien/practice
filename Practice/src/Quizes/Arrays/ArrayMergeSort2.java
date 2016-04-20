package Quizes.Arrays;


public class ArrayMergeSort2 {

    private static int[] input = {1, -2, 3, -4, 6, 5};
    
    private static void printArray(int[] in) {
        for (int i =0; i < in.length; i++) {
            System.out.print(in[i] + " ");
        }
    }
    
    
    private static int[] mergeSort(int[] in) {
        if (in.length < 2) {
            return in;
        } else if (in.length == 2) {
            if (in[0] > in[1]) {
                int temp = in[0];
                in[0] = in[1];
                in[1] = temp;
            }
            return in;
        } else {
            int middlePosition = in.length/2;
            int[] firstPart = getsubArray(in, 0, middlePosition);
            int[] secondPart = getsubArray(in, middlePosition, in.length);
            System.out.println(middlePosition + " " + firstPart.length + " " + secondPart.length);
            in = mergeSortedArrays(mergeSort(firstPart), mergeSort(secondPart));
        }
        return in;
    }
    
    private static int[] getsubArray(int[] in, int start, int stop) {
        int[] result = new int[stop - start];
        for (int i = start; i < stop; i++) {
            result[i-start] = in[i];
        }
        return result;
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
    
    
    public static void main(String... args) {
        
//      printArray(bubbleSort(input));
        printArray(mergeSort(input));
        
    }
}