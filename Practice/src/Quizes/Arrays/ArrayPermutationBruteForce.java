package Quizes.Arrays;

import java.util.HashSet;
import java.util.Random;


public class ArrayPermutationBruteForce {
    
    private static int[] input = {1,2,3};

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
    
    private static void printSet(HashSet<int[]> set) {
        for(int[] elemetn: set) {
            printArray(elemetn);
        }
    }
    
    private static void permutateBruteForce() {
        HashSet<int[]> permutations = new HashSet<int[]>();
        Random generator = new Random();
        int numberOfPermutations = numberOfPermutations(input.length);
        permutations.add(input);
        int iterationCounter = 1;
        
        while(permutations.size() < numberOfPermutations) {
            int p1 = generator.nextInt(input.length); 
            int p2 = generator.nextInt(input.length); 
            swap(p1, p2);
            permutations.add(input.clone());
            swap(p1, p2);
            iterationCounter++;
        }
        System.out.println("# of iteretions: " + iterationCounter);
        printSet(permutations);
    }
    
    
    public static void main(String[] args) {
        printArray(input);
        System.out.println("# of permutations: " + numberOfPermutations(input.length));
        System.out.println("-----");
        permutateBruteForce();
    }
}