package recaling1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IsPalindrome {
	
	
	private static class Animal {}
	private static class Dog extends Animal{}
	private static class Cat extends Animal{}
	
	private static List<String> list1 = new ArrayList<>(Arrays.asList("a","b","a"));
	private static List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,2,4));
	private static List<Animal> list3 = new ArrayList<>(Arrays.asList(new Cat(), new Dog(), new Cat()));
	
	private static <T> boolean isPalindrome(List<T> list) {
		if (list == null) {
			return false;
		} else if (list.size() < 2) {
			return true;
		} else if (list.get(0) == list.get(list.size()-1)) {
			list.remove(0);
			list.remove(list.size()-1);
			return isPalindrome(list);
		}
		return false;
	}
	
	
	public static void main(String...strings){
		System.out.println(isPalindrome(list1));
		System.out.println(isPalindrome(list2));
		System.out.println(isPalindrome(list3)); // false because 2 cats are different obj
	}

}
