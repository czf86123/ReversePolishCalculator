package com.my.reversepolish.operation.impl;

import com.my.reversepolish.operation.Operation;
import com.my.reversepolish.operation.OperationFactory;
import com.my.reversepolish.operation.OperatorEnum;

/**
 * Factory for number input operation
 * 
 * @author Arron
 *
 */
public class OperationNumberFactory implements OperationFactory {

	@Override
	public Operation getOperation() {
		return new OperationNumber();
	}

	@Override
	public OperatorEnum getOperatorType() {
		return OperatorEnum.NUMBER;
	}

}
