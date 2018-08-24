package com.my.reversepolish.operation.impl;

import com.my.reversepolish.operation.Operation;
import com.my.reversepolish.operation.OperationFactory;
import com.my.reversepolish.operation.OperatorEnum;

/**
 * factory for plus operation
 * 
 * @author Arron
 *
 */
public class OperationPlusFactory implements OperationFactory {

	@Override
	public Operation getOperation() {
		return new OperationPlus();
	}

	@Override
	public OperatorEnum getOperatorType() {
		return OperatorEnum.PLUS;
	}

}
