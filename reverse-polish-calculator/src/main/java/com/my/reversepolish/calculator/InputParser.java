package com.my.reversepolish.calculator;

import java.util.ArrayList;
import java.util.List;

import com.my.reversepolish.exception.InvalidInputException;
import com.my.reversepolish.operation.Operator;
import com.my.reversepolish.operation.OperatorEnum;
import com.my.reversepolish.util.ReversePolishCalculatorUtil;

/**
 * Parser for user input string. The string will be split by space character, and if any sub-string is not number or allowed operator, an exception will be thrown. 
 * If all sub-strings are legal, then a list of Operator will be returned.
 * 
 * @author Arron
 *
 */
public class InputParser {
	
	public List<Operator> parse(String input) throws InvalidInputException{
		List<Operator> result = new ArrayList<Operator>();

		input = " " + input + " ";
		int i = 0;
		int j = 1;
		int subStringStartMark = 0;
		
		//extract all sub-strings from the input and record the position. If position is not required then prefer to use StringTokenizer.
		while (j < input.length()){
			if (input.charAt(i) == ' ' && input.charAt(j) != ' '){
				subStringStartMark = j;
			}else if (input.charAt(i) != ' ' && input.charAt(j) == ' '){
				String subString = input.substring(subStringStartMark, j);
				if (getOperatorTypeFromString(subString.toLowerCase()) == null){
					throw new InvalidInputException("Invalid input - " + subString + ". Please try again.");
				}else {
					result.add(new Operator(subStringStartMark, 
							getOperatorTypeFromString(subString.toLowerCase()),
							subString));
				}
			}
			i++;
			j++;
		}
		
		return result;
	}
	
	private OperatorEnum getOperatorTypeFromString(String operator){
		if (ReversePolishCalculatorUtil.isNumber(operator)){
			return OperatorEnum.NUMBER;
		}else {
			return OperatorEnum.fromValue(operator);
		}
	}
	
}
