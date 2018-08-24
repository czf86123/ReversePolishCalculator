package com.my.reversepolish.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.my.reversepolish.exception.InvalidInputException;
import com.my.reversepolish.operation.Operator;
import com.my.reversepolish.stack.ReversePolishCalculatorStack;

/**
 * Reverse Polish Calculator implementation
 * 
 * @author Arron
 */

public class MyReversePolishCalculator 
{
    
	private InputProcessor inputPorcessor;
	private InputParser inputValidator;
	
	private ReversePolishCalculatorStack stack;
	
	private static final String EXIT = "exit";
	
	public static void main(String[] args){
		MyReversePolishCalculator calculator = new MyReversePolishCalculator();
		calculator.init();
		calculator.start();
	}
	
	public void start() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Welcome to my Reverse Polish Calculator!\nPlease give your input (input '" + EXIT + "' to terminate): ");
		
		while(true){
			try {
				String input = br.readLine();
				if (EXIT.equalsIgnoreCase(input.trim())){
					break;
				}
				List<Operator> operators = inputValidator.parse(input);
				inputPorcessor.process(stack, operators);
				stack.bottomUpPrint();
			} catch (IOException e) {
				System.out.println("Read input error! Please try again.");
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
			}
		}
		
		try {
			br.close();
			isr.close();
			System.exit(0);
		}catch (IOException e){
			System.exit(1);
		}
	}
	
	public void init(){
		this.inputPorcessor = new InputProcessor();
		this.inputValidator = new InputParser();
		this.stack = new ReversePolishCalculatorStack();
	}
}
