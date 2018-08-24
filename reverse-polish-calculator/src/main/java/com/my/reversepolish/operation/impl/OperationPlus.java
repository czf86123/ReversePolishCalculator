package com.my.reversepolish.operation.impl;

import java.math.BigDecimal;

import com.my.reversepolish.exception.InsufficientParametersException;
import com.my.reversepolish.operation.Operator;
import com.my.reversepolish.stack.ReversePolishCalculatorStack;

/**
 * Operation for "+"
 * 
 * @author Arron
 *
 */
public class OperationPlus extends AbstractOperation {

	@Override
	public void execute(ReversePolishCalculatorStack stack, Operator operator) throws InsufficientParametersException {
		validate(stack, operator);
		BigDecimal first = stack.pop();
		BigDecimal second = stack.pop();
		stack.push(first.add(second));
		usedNumbersStack.push(first);
		usedNumbersStack.push(second);
		isHistorical = true;
	}

	@Override
	protected int getNumberOfResultNumbers() {
		return 1;
	}

	@Override
	protected int getNumberOfRequiredNumbers() {
		return 2;
	}

}
