package QJunit;

import org.junit.Assert.*;
import org.junit.Test;

public class OddTesting {

	Odd odd = new Odd();
	
//	@Test
//	public void testFindOdd() {
//		System.out.println(odd.findOdd(100));
//	}
	
	@Test
	public void testFixEscapes() {
		assertEquals("Should be abcde", "abcdef", odd.fixEscapes("abcdef"));
		assertEquals("Should be abcde", "ab\\ cdef", odd.fixEscapes("ab cdef"));
		assertEquals("Should be ab&cde", "ab\\&cdef", odd.fixEscapes("ab&cdef"));
	}

}
