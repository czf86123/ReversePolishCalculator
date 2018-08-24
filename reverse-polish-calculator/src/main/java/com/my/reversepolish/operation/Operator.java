package com.my.reversepolish.operation;

/**
 * Class for operator expression, contains its position, operator type and original input string
 * @author Arron
 *
 */
public class Operator {
	
	private int position;
	private OperatorEnum operatorType;
	private String inputString;
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public OperatorEnum getOperatorType() {
		return operatorType;
	}
	
	public void setOperatorType(OperatorEnum operatorType) {
		this.operatorType = operatorType;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public Operator(int position, OperatorEnum operatorType, String inputString){
		this.position = position;
		this.operatorType = operatorType;
		this.inputString = inputString;
	}
}
