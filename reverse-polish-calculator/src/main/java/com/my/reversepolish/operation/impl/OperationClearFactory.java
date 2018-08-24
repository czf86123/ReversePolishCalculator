package com.my.reversepolish.operation.impl;

import com.my.reversepolish.operation.Operation;
import com.my.reversepolish.operation.OperationFactory;
import com.my.reversepolish.operation.OperatorEnum;

/**
 * factory for clear operation
 * 
 * @author Arron
 *
 */
public class OperationClearFactory implements OperationFactory {

	@Override
	public Operation getOperation() {
		return new OperationClear();
	}

	@Override
	public OperatorEnum getOperatorType() {
		return OperatorEnum.CLEAR;
	}

}
