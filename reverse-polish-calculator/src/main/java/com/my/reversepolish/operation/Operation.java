package com.my.reversepolish.operation;

import com.my.reversepolish.exception.InsufficientParametersException;
import com.my.reversepolish.stack.ReversePolishCalculatorStack;

/**
 * 
 * @author Arron
 *
 */
public interface Operation {
	
	/**
	 * Method for executing this operation. If the stack doesn't contain enough numbers for operation, InsufficientParametersException will be thrown.
	 * After execution, the numbers used will be saved within the operation instance, and the operation will be marked historical for any further undo operation.
	 * @param stack
	 * @param operator
	 * @throws InsufficientParametersException
	 */
	public void execute(ReversePolishCalculatorStack stack, Operator operator) throws InsufficientParametersException;
	
	/**
	 * Method for undo this operation. It will only take effect if this operation is marked historical.
	 * It will use the numbers stored in this operation to restore the stack. 
	 * @param stack
	 */
	public void undo(ReversePolishCalculatorStack stack);
}
