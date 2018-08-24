package com.my.reversepolish.operation.impl;

import java.util.HashSet;
import java.util.Set;

import com.my.reversepolish.operation.Operation;
import com.my.reversepolish.operation.OperationFactory;
import com.my.reversepolish.operation.OperatorEnum;

/**
 * Manager class for all factories
 * 
 * @author Arron
 *
 */
public class OperationFactoryManager {
	
	private static OperationFactoryManager instance;
	
	private Set<OperationFactory> factories;
	
	private OperationFactoryManager() {
		factories = new HashSet<OperationFactory>();
		factories.add(new OperationClearFactory());
		factories.add(new OperationPlusFactory());
		factories.add(new OperationMinusFactory());
		factories.add(new OperationMultiplyFactory());
		factories.add(new OperationDivideFactory());
		factories.add(new OperationSqrtFactory());
		factories.add(new OperationNumberFactory());
	}
	
	static{
		instance = new OperationFactoryManager();
	}
	
	public static OperationFactoryManager getInstance() {
		return instance;
	}
	
	public Operation getOperation(OperatorEnum inputOperatorType){
		for (OperationFactory factory : factories){
			if (factory.getOperatorType().equals(inputOperatorType)){
				return factory.getOperation();
			}
		}
		return null;
	}
	
}
