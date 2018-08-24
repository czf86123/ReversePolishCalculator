package com.my.reversepolish.exception;

/**
 * 
 * @author Arron
 *
 */
public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 2951331454397373195L;
	
	public InvalidInputException(String message){
		super(message);
	}
}
