/**
 * 
 */
package com.dqiAutomation.exception;

/**
 * In Burn Down Chart section,
 * BurnDownInvalidExcelSheetException is thrown
 * if user uploads invalid excel sheet.
 * @author priyanka_gupta
 *
 */
public class BurnDownInvalidExcelSheetException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param errorMessage
	 */
	public BurnDownInvalidExcelSheetException(String errorMessage) 
	{
		super(errorMessage);
	}
}
