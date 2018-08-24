package com.my.reversepolish.operation.impl;

import java.math.BigDecimal;

import com.my.reversepolish.exception.InsufficientParametersException;
import com.my.reversepolish.operation.Operator;
import com.my.reversepolish.stack.ReversePolishCalculatorStack;

/**
 * Operation for number input
 * 
 * @author Arron
 *
 */
public class OperationNumber extends AbstractOperation {

	@Override
	public void execute(ReversePolishCalculatorStack stack, Operator operator) throws InsufficientParametersException {
		BigDecimal b = new BigDecimal(operator.getInputString());
		stack.push(b);
		isHistorical = true;
	}

	@Override
	protected int getNumberOfResultNumbers() {
		return 1;
	}

	@Override
	protected int getNumberOfRequiredNumbers() {
		return 0;
	}

}
