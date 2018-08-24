package com.my.reversepolish.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestReversePolishCalculatorUtil {
	
	@Test
	public void testIsNumberReturnFalseOnStringWithNonNmbericChar() {
		assertFalse(ReversePolishCalculatorUtil.isNumber("abc1"));
	}
	
	@Test
	public void testIsNumberReturnTrueOnStringAllNmbericChar() {
		assertTrue(ReversePolishCalculatorUtil.isNumber("1234"));
	}
	
	@Test
	public void testIsNumberReturnTrueOnStringWithNmbericCharAndDecimalPoint() {
		assertTrue(ReversePolishCalculatorUtil.isNumber("123.1"));
	}
	
	@Test
	public void testIsNumberReturnTrueOnStringWithNmbericCharAndNegative() {
		assertTrue(ReversePolishCalculatorUtil.isNumber("-123.1"));
	}
	
}
