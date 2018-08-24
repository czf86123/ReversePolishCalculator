package com.my.reversepolish.operation;

/**
 * Enumerations for supported operators
 * 
 * @author Arron
 *
 */
public enum OperatorEnum {
	
	PLUS("+"),
	MINUS("-"),
	MULTIPLY("*"),
	DIVIDE("/"),
	SQRT("sqrt"),
	UNDO("undo"),
	CLEAR("clear"),
	NUMBER("number");
	
	private String value;
	
	OperatorEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static OperatorEnum fromValue(String value){
        for (OperatorEnum o : values()){
    		if (o.getValue().equals(value)){
    			return o;
    		}
    	}
        return null;
    }
}
