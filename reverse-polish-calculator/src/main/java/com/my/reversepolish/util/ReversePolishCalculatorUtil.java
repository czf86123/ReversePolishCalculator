package com.my.reversepolish.util;

/**
 * Util class for shared helper methods
 * @author Arron
 *
 */
public class ReversePolishCalculatorUtil {
	
	public static final int INPUT_SCALE = 15;
	public static final int OUTPUT_SCALE = 10;
	
	/**
	 * check if input string represents a number, number can have "-" or "." as optional
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){  
        String reg = "-?\\d+(\\.\\d+)?";
        return str.matches(reg);
    }   
	
}
