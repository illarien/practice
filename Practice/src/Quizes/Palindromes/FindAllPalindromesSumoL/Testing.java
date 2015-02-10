package SumoL;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Testing {


	
	@Test
	public void testA1() {
//		String[] arg = {"BAC", "EFG", "GFE", "ABC", "GEF", "X", "GEFF", "XX"};
		String[] arg = StringArrayGenerator.generateArray(20);
		String[] a1 = Sol.findPerms(arg);
		String[] a2 = Sol.findPerms2(arg);
		Arrays.sort(a1);
		Arrays.sort(a2);
		
		assertArrayEquals(a1, a2);
	}
	
}
