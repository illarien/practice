import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("static-access")
public class BinarySumTest {

	BinarySum bs = new BinarySum();
	
	@Test(expected = IllegalArgumentException.class)
	public void testNull1() {
		bs.addBinary(null, "11");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNull2() {
		bs.addBinary("11", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmpty() {
		bs.addBinary("", "11");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmpty2() {
		bs.addBinary("11", "");
	}
	
	@Test
	public void test1() {
		String s1 = "1011", s2 ="10";
		String expected = bs.addBinary(s1, s2);
		assertEquals(expected, "1101");
	}
	
	@Test
	public void test2() {
		String s1 = "0", s2 ="0";
		String expected = bs.addBinary(s1, s2);
		assertEquals(expected, "0");
	}
	
	@Test
	public void test3() {
		String s1 = "1", s2 ="0";
		String expected = bs.addBinary(s1, s2);
		assertEquals(expected, "1");
	}
	
	@Test
	public void test4() {
		String s1 = "0", s2 ="1";
		String expected = bs.addBinary(s1, s2);
		assertEquals(expected, "1");
	}
	
	@Test
	public void test5() {
		String s1 = "1", s2 ="1";
		String expected = bs.addBinary(s1, s2);
		assertEquals(expected, "10");
	}
	
	@Test
	public void test6() {
		String s1 = "10", s2 ="1";
		String expected = bs.addBinary(s1, s2);
		assertEquals(expected, "11");
	}
	
	@Test
	public void test7() {
		String s1 = "11", s2 ="1";
		String expected = bs.addBinary(s1, s2);
		assertEquals(expected, "100");
	}
	
	@Test
	public void test8() {
		String s1 = "100", s2 ="1";
		String expected = bs.addBinary(s1, s2);
		assertEquals(expected, "101");
	}
	
	@Test
	public void test9() {
		String s1 = "100", s2 ="10";
		String expected = bs.addBinary(s1, s2);
		assertEquals(expected, "110");
	}
	
	@Test
	public void test10() {
		String s1 = "100", s2 ="11";
		String expected = bs.addBinary(s1, s2);
		assertEquals(expected, "111");
	}
	
	@Test
	public void test11() {
		String s1 = "100", s2 ="100";
		String expected = bs.addBinary(s1, s2);
		assertEquals(expected, "1000");
	}
	
	@Test
	public void test12() {
		String s1 = "111", s2 ="111";
		String expected = bs.addBinary(s1, s2);
		assertEquals(expected, "1000");
	}
	
	
	// check inputs contains only 0 and 1
	
}
