package com.my.reversepolish.stack;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.my.reversepolish.util.ReversePolishCalculatorUtil;

public class TestReversePolishCalculatorStack {
	
	ReversePolishCalculatorStack test;
	ByteArrayOutputStream outContent;
	
	@Before
	public void setUp(){
		test = new ReversePolishCalculatorStack();
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void tillDown() throws IOException {
		System.setOut(null);
		outContent.close();
	}
	
	@Test
	public void testPushIntoReversePolishCalculatorStackWillKeepPreDefinedDecimalPlaces() {
		BigDecimal number = new BigDecimal("1.1").setScale(1, BigDecimal.ROUND_HALF_UP);
		test.push(number);
		BigDecimal number1 = test.pop();
		assertEquals(ReversePolishCalculatorUtil.INPUT_SCALE, number1.scale());
	}
	
	@Test
	public void testBottomUpOutput() {
		test.push(new BigDecimal("1"));
		test.push(new BigDecimal("2"));
		test.push(new BigDecimal("3"));
		test.bottomUpPrint();
		assertEquals("stack: 1 2 3", outContent.toString().trim());
	}
}
