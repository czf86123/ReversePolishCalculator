package com.my.reversepolish.exception;

/**
 * 
 * @author Arron
 *
 */
public class InsufficientParametersException extends Exception {

	private static final long serialVersionUID = 6654845929595602787L;
	
	public InsufficientParametersException(String message){
		super(message);
	}
}
