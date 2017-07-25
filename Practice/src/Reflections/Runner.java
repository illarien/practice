package Reflections;

import Reflections.Super.Child;

public class Runner {
	
	public static void main(String[] args) {
		Super supr = new Super();
		Child chld = supr.new Child();
		supr.print();
		chld.print();
	}

}
