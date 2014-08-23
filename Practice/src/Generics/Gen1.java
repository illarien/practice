package Generics;

import java.util.Arrays;
import java.util.HashMap;

public class Gen1 {

	public static <E> void print(E obj) {
		System.out.println(obj.toString());
		if (obj instanceof Arrays) {
//			for (E e: obj) {
//				
//			}
		}
		
	}
	
	public class K extends Object {}
	public class V extends Object {}
	
	public static HashMap<K,V> hmkv;
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3};
		print("Test");
		print(arr);
		
		//hmkv.put(arr, arr);
		

	}

}
