/**
 * 
 */
package com.dqiAutomation.exception;

/**
 * In DQI Parameters section,
 * DQIInvalidExcelSheetException is thrown
 * if user uploads invalid excel sheet.
 * @author priyanka_gupta
 *
 */
public class DQIInvalidExcelSheetException extends Exception {


	/**
	 * @param errorMessage
	 */
	public DQIInvalidExcelSheetException(String errorMessage) {
		super(errorMessage);
		
	}
}
