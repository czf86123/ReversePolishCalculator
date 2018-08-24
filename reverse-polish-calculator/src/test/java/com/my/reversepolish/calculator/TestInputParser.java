package com.my.reversepolish.calculator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.my.reversepolish.exception.InvalidInputException;
import com.my.reversepolish.operation.Operator;
import com.my.reversepolish.operation.OperatorEnum;

public class TestInputParser {
	
	InputParser test;
	
	@Before
	public void setUp() {
		test = new InputParser();
	}
	
	@Test
	public void testParseLegalInputStringReturnsListOfOperators() throws InvalidInputException {
		String input = "1 2 + 3 * CLEAR undo";
		List<Operator> result = test.parse(input);
		assertEquals("1", result.get(0).getInputString());
		assertEquals("+", result.get(2).getInputString());
		assertEquals("CLEAR", result.get(5).getInputString());
		assertEquals(OperatorEnum.CLEAR, result.get(5).getOperatorType());
		assertEquals(OperatorEnum.UNDO, result.get(6).getOperatorType());
	}
	
	@Test(expected = InvalidInputException.class)
	public void testParseIlegalInputStringThrowsException() throws InvalidInputException {
		String input = "1 2 + 3 * XXXX undo";
		test.parse(input);
	}
}
