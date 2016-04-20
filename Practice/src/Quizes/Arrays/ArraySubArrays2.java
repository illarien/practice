package Quizes.Arrays;

import java.util.ArrayList;
import java.util.HashSet;


public class ArraySubArrays2 {
    
    /**
     * Recursive solution based on ArrayList<String>
     * @param input
     * @return
     */
    private static ArrayList<String> getAllSubArrays1(int[] input) {
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(arrayToString(input));
        if (input.length == 1) {
            return temp;
        }
        for (int i = 0; i < input.length; i++) {
            temp.addAll(getAllSubArrays1(getPartialArray(input, i)));
        }
        return temp;
    }
    
    private static int[] getPartialArray(int[] input, int ind) {
        int[] result = new int[input.length-1];
        int counter = 0;
        for (int i = 0; i < input.length; i++) {
            if (i != ind) {
                result[counter++] = input[i];
            }
        }
        return result;
    }
    
    private static String arrayToString(int[] input) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i: input) {
            sb.append(i+",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }

    /**
     * Recursive solution based on ArrayList<int[]>
     * @param input
     * @return
     */
    private static ArrayList<int[]> getAllSubArrays2(int[] input) {
        ArrayList<int[]> temp = new ArrayList<int[]>();
        temp.add(input);
        if (input.length == 1) {
            return temp;
        }
        for (int i = 0; i < input.length; i++) {
            temp.addAll(getAllSubArrays2(getPartialArray(input, i)));
        }
        return temp;
    }
    
    /**
     * ArrayList<int[]> contains duplicates, we need to get rid of them.
     * so wee need to convert it to ArrayList<Integer> and put to Set
     * because int[].equals(int[]) always returns false.
     * @param input
     * @return
     */
    private static HashSet<ArrayList<Integer>> removeDuplicates(ArrayList<int[]> input) {
        HashSet<ArrayList<Integer>> result = new HashSet<>();
        for (int[] array: input) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int i : array) {
                tmp.add(i);
            }
            result.add(tmp);
        }
        System.out.println("Set size: " + result.size());
        return result;
    }
    
    /**
     * Converts HashSet<ArrayList<Integer>> to String
     * @param input
     * @return
     */
    private static String hashSetToString(HashSet<ArrayList<Integer>> input) {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Integer> al: input) {
            sb.append("{");
            for (Integer i: al) {
                sb.append(i);
            }
            sb.append("}");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        int[] original = {1,2,3,4};
        System.out.println("Original: " + arrayToString(original));
        
        //String solution
        ArrayList<String> result1 = getAllSubArrays1(original);
        System.out.println(result1.size() + ": " + result1.toString());
        
        // ArrayList solution
        ArrayList<int[]> result2 = getAllSubArrays2(original);
//      System.out.println(result2.size() + ": " + result2.toString());
        HashSet<ArrayList<Integer>> noDups = removeDuplicates(result2);
        System.out.println(noDups.size() + ": " + hashSetToString(noDups));
        
    }
}

