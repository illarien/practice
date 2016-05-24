import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class StringIsPalindromeTest {
	
	String s1 = "abcdcba";
	String s2 = "";
	String s3 = "abcd";
	String s4 = null;

	@Test
	public void test1() {
		assertTrue(StringPalindromeWU.isPalindrome1(s1));
	}

	@Test
	public void test2() {
		assertTrue(StringPalindromeWU.isPalindrome1(s2));
	}
	@Test
	public void test3() {
		assertFalse(StringPalindromeWU.isPalindrome1(s3));
	}
	
	@Test(expected = IllegalArgumentException.class)  
	public void test4() {
		assertTrue(StringPalindromeWU.isPalindrome1(s4));
	}
}
