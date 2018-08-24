package com.my.reversepolish.operation.impl;

import com.my.reversepolish.operation.Operation;
import com.my.reversepolish.operation.OperationFactory;
import com.my.reversepolish.operation.OperatorEnum;

/**
 * factory for sqrt operation
 * 
 * @author Arron
 *
 */
public class OperationSqrtFactory implements OperationFactory {

	@Override
	public Operation getOperation() {
		return new OperationSqrt();
	}

	@Override
	public OperatorEnum getOperatorType() {
		return OperatorEnum.SQRT;
	}

}
