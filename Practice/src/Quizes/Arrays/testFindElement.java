package Quizes.Arrays;
import static org.junit.Assert.*;

import org.junit.Test;


public class testFindElement {

	int[] array1 = {1, 4, 7, 17, 18, 19, 20};         
	int[] array2 = {5, 9, 13, 14, 17, 21};
	
	@Test
	public void test1() {
		for (int i = 1; i < (array1.length + array2.length); i++) {
			assertEquals(FindElement.findElement(array1, array2, i), FindElement.findElement2(array1, array2, i));
		}
	}
	
	@Test(expected=WrongIndexException.class)
	public void test2() {
		FindElement.findElement(array1, array2, (array1.length + array2.length+1));
	}
	
	@Test(expected=WrongIndexException.class)
	public void test3() {
		FindElement.findElement2(array1, array2, (array1.length + array2.length+1));
	}

}
