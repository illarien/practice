package Quizes.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class ArraysIntersection {

    private static void findIntersection(Integer[] a1, Integer[] a2) {
        HashSet<Integer> firstArray = new HashSet<Integer>();
        for (int i: a1) {
            firstArray.add(i);
        }
        for(int i: a2) {
            if (firstArray.contains(i)) {
                System.out.print(i + ", ");
                System.out.println();
            }
        }
    }
    
    
    private static void findIntersection2(Integer[] a1, Integer[] a2) {
        ArrayList<Integer> al1 = new ArrayList<Integer>(Arrays.asList(a1));
        ArrayList<Integer> al2 = new ArrayList<Integer>(Arrays.asList(a2));
        al1.retainAll(al2);
        System.out.println(al1);
    }
    
    public static void main(String[] args) {
        Integer[] array1 = {1,3,2,5,4};
        Integer[] array2 = {3,7,6,9,5};
        
        findIntersection(array1, array2);
        findIntersection2(array1, array2);
    }

}