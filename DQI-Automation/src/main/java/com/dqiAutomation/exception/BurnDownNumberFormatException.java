/**
 * 
 */
package com.dqiAutomation.exception;

/**
 * In Burn Down Chart Section BurnDownNumberFormatException
 * is thrown when string is found instead of numeric values in the uploaded excel sheet.
 * @author priyanka_gupta
 *
 */
public class BurnDownNumberFormatException extends Exception {


	/**
	 * @param errorMessage
	 */
	public BurnDownNumberFormatException(String errorMessage) {
		super(errorMessage);
		
	}
}
