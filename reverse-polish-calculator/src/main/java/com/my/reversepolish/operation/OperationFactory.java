package com.my.reversepolish.operation;

/**
 * 
 * @author Arron
 *
 */
public interface OperationFactory {
	
	/**
	 * Generate corresponding operation of this factory
	 * @return
	 */
	public Operation getOperation();
	
	/**
	 * Operator type associated with this factory
	 * @return
	 */
	public OperatorEnum getOperatorType();
}
