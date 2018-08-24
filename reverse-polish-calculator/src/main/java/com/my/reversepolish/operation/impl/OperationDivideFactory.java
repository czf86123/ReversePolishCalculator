package com.my.reversepolish.operation.impl;

import com.my.reversepolish.operation.Operation;
import com.my.reversepolish.operation.OperationFactory;
import com.my.reversepolish.operation.OperatorEnum;

/**
 * factory for divide operation
 * 
 * @author Arron
 *
 */
public class OperationDivideFactory implements OperationFactory {

	@Override
	public Operation getOperation() {
		return new OperationDivide();
	}

	@Override
	public OperatorEnum getOperatorType() {
		return OperatorEnum.DIVIDE;
	}

}
