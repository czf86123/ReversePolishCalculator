package com.my.reversepolish.calculator;

import java.util.LinkedList;
import java.util.List;

import com.my.reversepolish.exception.InsufficientParametersException;
import com.my.reversepolish.operation.Operation;
import com.my.reversepolish.operation.Operator;
import com.my.reversepolish.operation.OperatorEnum;
import com.my.reversepolish.operation.impl.OperationFactoryManager;
import com.my.reversepolish.stack.ReversePolishCalculatorStack;

/**
 * Processor for user input. It is responsible for calculate with user input numbers and operators, and store result in the stack. 
 * The processor also stores all history operations for undo process.
 * @author Arron
 *
 */
public class InputProcessor {
	
	private LinkedList<Operation> historyOperations;
	
	public InputProcessor() {
		historyOperations = new LinkedList<Operation>();
	}
	
	public void process(ReversePolishCalculatorStack stack, List<Operator> operators){
		for (Operator o : operators){
			if (OperatorEnum.UNDO.equals(o.getOperatorType())){
				handleUndo(stack);
				continue;
			}
			
			Operation operation = OperationFactoryManager.getInstance().getOperation(o.getOperatorType());
			
			try {
				operation.execute(stack, o);
				historyOperations.push(operation);
			} catch (InsufficientParametersException e) {
				System.out.println(e.getMessage());
				break;
			}
		}
	}
	
	private void handleUndo(ReversePolishCalculatorStack stack){
		if (!historyOperations.isEmpty()){
			Operation operation = historyOperations.pop();
			operation.undo(stack);
		}
	}
}
