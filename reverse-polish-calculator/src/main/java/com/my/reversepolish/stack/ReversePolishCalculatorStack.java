package com.my.reversepolish.stack;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;

import com.my.reversepolish.util.ReversePolishCalculatorUtil;

/**
 * Main stack for the calculator. Contains a LinkedList for data storage.
 * @author Arron
 *
 */
public class ReversePolishCalculatorStack{
	
	private LinkedList<BigDecimal> stack;
	
	public ReversePolishCalculatorStack() {
		stack = new LinkedList<BigDecimal>();
	}
	
	/**
	 * input BigDecimal will be set scale to pre-defined input scale (15 as default), with rounding method as BigDecimal.ROUND_HALF_UP
	 * @param number
	 */
	public void push(BigDecimal number){
		stack.push(number.setScale(ReversePolishCalculatorUtil.INPUT_SCALE, BigDecimal.ROUND_HALF_UP));
	}
	
	public BigDecimal pop(){
		return stack.pop();
	}
	
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
	public int depth(){
		return stack.size();
	}
	
	public void bottomUpPrint(){
		StringBuffer sb = new StringBuffer("stack: ");
		Iterator<BigDecimal> iterator = stack.descendingIterator();
		while (iterator.hasNext()){
			sb.append(iterator.next().setScale(ReversePolishCalculatorUtil.OUTPUT_SCALE, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
