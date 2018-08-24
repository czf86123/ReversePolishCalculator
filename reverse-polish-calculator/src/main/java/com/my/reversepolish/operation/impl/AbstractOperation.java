package com.my.reversepolish.operation.impl;

import java.math.BigDecimal;
import java.util.LinkedList;

import com.my.reversepolish.exception.InsufficientParametersException;
import com.my.reversepolish.operation.Operation;
import com.my.reversepolish.operation.Operator;
import com.my.reversepolish.stack.ReversePolishCalculatorStack;

public abstract class AbstractOperation implements Operation {

	protected boolean isHistorical = false;
	protected LinkedList<BigDecimal> usedNumbersStack = new LinkedList<BigDecimal>();
	
	@Override
	public void undo(ReversePolishCalculatorStack stack) {
		if (!isHistorical){
			return;
		}
		
		//Undo process is to pop all result numbers of this operation, then push back used numbers
		for (int i = 0; i < getNumberOfResultNumbers(); i++){
			stack.pop();
		}
		
		while (!usedNumbersStack.isEmpty()){
			stack.push(usedNumbersStack.pop());
		}
		isHistorical = false;
	}
	
	protected void validate(ReversePolishCalculatorStack stack, Operator operator) throws InsufficientParametersException {
		if (stack.depth() < getNumberOfRequiredNumbers()){
			throw new InsufficientParametersException("Operator " + operator.getInputString() 
				+ " (position:" + operator.getPosition() + "): Insufficient parameters");
		}
	}
	
	abstract protected int getNumberOfResultNumbers();
	
	abstract protected int getNumberOfRequiredNumbers();
}
