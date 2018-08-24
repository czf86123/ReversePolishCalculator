package com.my.reversepolish.operation.impl;

import com.my.reversepolish.operation.Operation;
import com.my.reversepolish.operation.OperationFactory;
import com.my.reversepolish.operation.OperatorEnum;

/**
 * factory for minus operation.
 * 
 * @author Arron
 *
 */
public class OperationMinusFactory implements OperationFactory {

	@Override
	public Operation getOperation() {
		return new OperationMinus();
	}

	@Override
	public OperatorEnum getOperatorType() {
		return OperatorEnum.MINUS;
	}

}
