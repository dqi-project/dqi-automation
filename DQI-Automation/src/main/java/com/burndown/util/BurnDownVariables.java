package com.burndown.util;
/**
 * 
 * @author priyanka_gupta
 *
 */
public class BurnDownVariables
{
	
     private int exceptionAtRowNumber;//To store row number of the uploaded excel sheet where NumberFormatException has occurred.
	 private int exceptionAtColumnNumber;//To store column number of the uploaded excel sheet where NumberFormatException has occurred.
	 private String []columnValues = new String[2];//To validate that excel sheet uploaded by the user contains "Day"(or "Days) and "Hours"(or Hour) column.
	 private String excelFilePath;//To store Excel Sheet File Path
	 private String burnDownChartTitle; //To store Burn Down Chart Title
	 private double plannedEffortsInHours; //To store Planned Efforts in hours
	 private int DayColumnIndexNumber; //To save Column Index number containing "Day"(or "Days) in uploaded Excel Sheet.
	 private int HoursColumnIndexNumber; //To save Column Index number containing "Hours"(or Hour) in uploaded Excel Sheet.
	 private static BurnDownVariables burnDownVariablesObject = new BurnDownVariables();
	 
	/**
	 * Non-parameterized constructor.
	 */	 	
	private BurnDownVariables(){}
	
	/**
	 * 
	 * @return burnDownVariablesObject
	 */
	 public static BurnDownVariables getInstance() {
		 
			return burnDownVariablesObject;
		}	
	
	public int getExceptionAtRowNumber() {
		return exceptionAtRowNumber;
	}

	public void setExceptionAtRowNumber(int exceptionAtRowNumber) {
		this.exceptionAtRowNumber = exceptionAtRowNumber;
	}

	public int getExceptionAtColumnNumber() {
		return exceptionAtColumnNumber;
	}

	public void setExceptionAtColumnNumber(int exceptionAtColumnNumber) {
		this.exceptionAtColumnNumber = exceptionAtColumnNumber;
	}

	
	public  String[] getColumnValues() {
		return columnValues;
	}
	public  void setColumnValues(String[] columnValues) {
		this.columnValues = columnValues;
	}
	public  String getExcelFilePath() {
		return excelFilePath;
	}
	public void setExcelFilePath(String excelFilePath) {
		this.excelFilePath = excelFilePath;
	}
	public String getBurnDownChartTitle() {
		return burnDownChartTitle;
	}
	public void setBurnDownChartTitle(String burnDownChartTitle) {
		this.burnDownChartTitle = burnDownChartTitle;
	}
	public double getPlannedEffortsInHours() {
		return plannedEffortsInHours;
	}
	public void setPlannedEffortsInHours(double plannedEffortsInHours) {
		this.plannedEffortsInHours = plannedEffortsInHours;
	}
	public int getDayColumnIndexNumber() {
		return DayColumnIndexNumber;
	}
	public  void setDayColumnIndexNumber(int dayColumnIndexNumber) {
		DayColumnIndexNumber = dayColumnIndexNumber;
	}
	public int getHoursColumnIndexNumber() {
		return HoursColumnIndexNumber;
	}
	public void setHoursColumnIndexNumber(int hoursColumnIndexNumber) {
		HoursColumnIndexNumber = hoursColumnIndexNumber;
	}
	
	/**
	  * This function is used to reset variables of BurnDownVariables class.
	  */
	public void resetData()
	{
		getColumnValues()[0]="";
        getColumnValues()[1]="";
        setBurnDownChartTitle(null);
        setPlannedEffortsInHours(0.0);
		setExcelFilePath(null);	
}
}

