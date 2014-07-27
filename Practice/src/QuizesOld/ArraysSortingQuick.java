package QuizesOld;

// Sorting - quick

import java.io.*;
import java.util.*;

public class ArraysSortingQuick
{
	
	public static void main(String argv[]) throws InterruptedException
	   {
		  int [] a = {19, 4, 5, 21, 8, 3434, 4, 8 ,9, 2, 7};
		  quickSort(a, 0, a.length-1);

	//      System.out.println(a.toString());
	      for (int i=0 ; i < a.length ; i++) System.out.print(a[i] + " ");
	     
	   }
	

   public static void swap (int a[], int x, int y)
   {
      if (!(a[x] == a[y])) {
	  a[x] ^= a[y];
      a[y] = a[x] ^ a[y];
      a[x] ^= a[y];
      }
   }
                   
   public static int partition(int a[], int p, int r) throws InterruptedException
   {
     int x = a[p];
     int i = p;
     int j = r;
     while (true) {
//    	 i++;
    	 while ( i < r && a[i] < x ) {i++;}
    	 while ( j > p && a[j] > x ) {j--;}
    	 
    	 if ( i < j ) { swap(a, i, j); i++; j--;}
    	 else {
//    		   for (int s = p ; s < r+1 ; s++) System.out.print("R" + a[s] + " ");
    		 return j;}
    	 }
     
   }

   public static void quickSort(int a[], int p, int r) throws InterruptedException
   {
     if ( p < r ) {
    	 int q = partition(a, p, r);
 //   	 System.out.println(p + " " + r + " " + q);
    	 quickSort(a,p,q);
 //   	 System.out.println("---");
    	 quickSort(a,q+1,r);
     }
   }
}