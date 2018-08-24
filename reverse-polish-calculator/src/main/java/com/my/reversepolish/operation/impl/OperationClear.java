package com.my.reversepolish.operation.impl;

import com.my.reversepolish.exception.InsufficientParametersException;
import com.my.reversepolish.operation.Operator;
import com.my.reversepolish.stack.ReversePolishCalculatorStack;

/**
 * Operation for "clear"
 * 
 * @author Arron
 *
 */
public class OperationClear extends AbstractOperation {
	
	@Override
	public void execute(ReversePolishCalculatorStack stack, Operator operator) throws InsufficientParametersException {
		while (!stack.isEmpty()){
			usedNumbersStack.push(stack.pop());
		}
		isHistorical = true;
	}

	@Override
	protected int getNumberOfResultNumbers() {
		return 0;
	}

	@Override
	protected int getNumberOfRequiredNumbers() {
		return 0;
	}

}
