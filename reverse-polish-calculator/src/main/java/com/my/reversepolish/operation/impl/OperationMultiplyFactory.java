package com.my.reversepolish.operation.impl;

import com.my.reversepolish.operation.Operation;
import com.my.reversepolish.operation.OperationFactory;
import com.my.reversepolish.operation.OperatorEnum;

/**
 * Factory for multiply operation
 * 
 * @author Aaron
 *
 */
public class OperationMultiplyFactory implements OperationFactory {

	@Override
	public Operation getOperation() {
		return new OperationMultiply();
	}

	@Override
	public OperatorEnum getOperatorType() {
		return OperatorEnum.MULTIPLY;
	}

}
