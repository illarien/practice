package Quizes.Arrays;


public class ArrayPermutationO1 {
    
    private static int[] input = {1,2,3,4};

    private static void swap(int i, int j) {
         input[i] ^= input[j] ^ (input[j] = input[j] ^ input[i] ^ input[j]);
    }
    
    private static void printArray(int[] array) {
        for(int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    private static int numberOfPermutations(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }
    
    private static void permutateRecursevly(int first, int last) {
        if (first == last) {
            printArray(input);
            return;
        }

        for (int p = first; p <= last; p++) {
            swap(first, p);
            permutateRecursevly(first+1, last);
            swap(first, p);
        }
    }
    
    //wrong solution
    private static void permutateInLoop() {
        for(int p1 = 0; p1 < input.length; p1++) {
            for(int p2 = 0; p2 < input.length; p2++) {
                swap(p1, p2);
                printArray(input);
                swap(p1, p2);
            }
        }
    }
    
    
    public static void main(String[] args) {
        printArray(input);
        System.out.println(numberOfPermutations(input.length));
        System.out.println("-----");
      permutateRecursevly(0, input.length-1);
        System.out.println("-----");
//        permutateInLoop();
        
    }
}