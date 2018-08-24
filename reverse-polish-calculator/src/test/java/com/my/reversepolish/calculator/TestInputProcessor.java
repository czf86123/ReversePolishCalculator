package com.my.reversepolish.calculator;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.my.reversepolish.exception.InvalidInputException;
import com.my.reversepolish.stack.ReversePolishCalculatorStack;

public class TestInputProcessor {
	
	InputProcessor test;
	InputParser parser;
	ReversePolishCalculatorStack stack;
	
	@Before
	public void setUp() {
		test = new InputProcessor();
		parser = new InputParser();
		stack = new ReversePolishCalculatorStack();
	}
	
	@Test
	public void case1() throws InvalidInputException {
		String input = "5 2";
		test.process(stack, parser.parse(input));
		assertEquals(2, stack.pop().intValue());
		assertEquals(5, stack.pop().intValue());
	}
	
	@Test
	public void case2() throws InvalidInputException {
		String input = "2 sqrt";
		test.process(stack, parser.parse(input));
		assertEquals("1.41421", stack.pop().setScale(5, BigDecimal.ROUND_HALF_UP).toPlainString());
		input = "clear 2 sqrt 9 sqrt";
		test.process(stack, parser.parse(input));
		assertEquals(3, stack.pop().intValue());
	}
	
	@Test
	public void case3() throws InvalidInputException {
		String input = "5 2 -";
		test.process(stack, parser.parse(input));
		assertEquals(3, stack.pop().intValue());
		input = "clear 5 2 - 3 -";
		test.process(stack, parser.parse(input));
		assertEquals(0, stack.pop().intValue());
	}
	
	@Test
	public void case4() throws InvalidInputException {
		String input = "5 4 3 2 undo undo *";
		test.process(stack, parser.parse(input));
		assertEquals(20, stack.pop().intValue());
		input = "clear 5 4 3 2 undo undo * 5 * undo";
		test.process(stack, parser.parse(input));
		assertEquals(5, stack.pop().intValue());
		assertEquals(20, stack.pop().intValue());
	}
	
	@Test
	public void case5() throws InvalidInputException {
		String input = "7 12 2 /";
		test.process(stack, parser.parse(input));
		assertEquals(6, stack.pop().intValue());
		assertEquals(7, stack.pop().intValue());
		input = "clear 7 12 2 / * 4 /";
		test.process(stack, parser.parse(input));
		assertEquals("10.5", stack.pop().stripTrailingZeros().toPlainString());
	}
	
	@Test
	public void case6() throws InvalidInputException {
		String input = "1 2 3 4 5 * * * *";
		test.process(stack, parser.parse(input));
		assertEquals(120, stack.pop().intValue());
	}
	
	@Test
	public void case7() throws InvalidInputException, IOException {
		String input = "1 2 3 * 5 + * * 6 5";
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		test.process(stack, parser.parse(input));
		assertEquals(11, stack.pop().intValue());
		assertEquals("Operator * (position:15): Insufficient parameters", outContent.toString().trim());
		outContent.close();
	}
	
	@Test
	public void case8() throws InvalidInputException, IOException {
		String input = "-1 sqrt";
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		test.process(stack, parser.parse(input));
		assertEquals(-1, stack.pop().intValue());
		assertEquals("Operator sqrt (position:4): sqrt cannot operate on negative number", outContent.toString().trim());
		outContent.close();
	}
	
}
