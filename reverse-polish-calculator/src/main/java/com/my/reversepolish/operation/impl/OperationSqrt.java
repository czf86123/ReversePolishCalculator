package com.my.reversepolish.operation.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.my.reversepolish.exception.InsufficientParametersException;
import com.my.reversepolish.operation.Operator;
import com.my.reversepolish.stack.ReversePolishCalculatorStack;
import com.my.reversepolish.util.ReversePolishCalculatorUtil;

/**
 * Operation for "sqrt"
 * 
 * @author Arron
 *
 */
public class OperationSqrt extends AbstractOperation {
	
	private static final BigDecimal SQRT_DIG = new BigDecimal(ReversePolishCalculatorUtil.INPUT_SCALE + 1);
	private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());
	
	@Override
	public void execute(ReversePolishCalculatorStack stack, Operator operator) throws InsufficientParametersException {
		validate(stack, operator);
		BigDecimal number = stack.pop();
		if (-1 == number.signum()){
			stack.push(number);
			throw new InsufficientParametersException("Operator " + operator.getInputString() 
				+ " (position:" + operator.getPosition() + "): sqrt cannot operate on negative number");
		}
		stack.push(sqrtNewton(number, new BigDecimal(1), new BigDecimal(1).divide(SQRT_PRE)));
		usedNumbersStack.push(number);
		isHistorical = true;
	}

	@Override
	protected int getNumberOfResultNumbers() {
		return 1;
	}

	@Override
	protected int getNumberOfRequiredNumbers() {
		return 1;
	}
	
	/**
	 * Newton square root algorithm to keep enough precision for big numbers
	 * 
	 * @param number
	 * @param xn
	 * @param precision
	 * @return
	 */
	private BigDecimal sqrtNewton(BigDecimal number, BigDecimal xn, BigDecimal precision){
		BigDecimal fx = xn.pow(2).add(number.negate());
		BigDecimal fpx = xn.multiply(new BigDecimal(2));
		BigDecimal xn1 = fx.divide(fpx, 2*SQRT_DIG.intValue(), RoundingMode.HALF_DOWN);
		xn1 = xn.add(xn1.negate());
		BigDecimal currentSquare = xn1.pow(2);
		BigDecimal currentPrecision = currentSquare.subtract(number);
		if (currentPrecision.compareTo(precision) <= -1){
			return xn1;
		}
		return sqrtNewton(number, xn1, precision);
	}

}
