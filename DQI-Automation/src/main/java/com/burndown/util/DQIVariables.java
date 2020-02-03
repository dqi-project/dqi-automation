package com.burndown.util;
/**
 * 
 * @author priyanka_gupta
 *
 */
public class DQIVariables {
	
	 private String jiraExcelSheetFilePath;// variable for jira sheet path
	 private String mannualExcelSheetFilePath;//variable for  manual sheet path
	 private String qaExcelSheetFilePath;	//variable for  qa sheet path	
	 private String dQISprintNumber;// variable for sprint number
	 private String dQIMonthYear;//variable for month year	
	 private String dQIfinalSheetPath;	// variable for dqi final sheet path	
	 private String fileName;
	 private int dQIStoryPoints;// variable for dqi story points
	 private int exceptionAtRowNumber;
	 private int exceptionAtColumnNumber;	
	 private boolean dQIjiraRadioButton;// variable for dqi jira radio button
	 private boolean dQImanualRadioButton;// variable for dqi manual radio button
	 private boolean openSaveFrame;
	 private boolean writeExcel;
	 static DQIVariables dQIVariables = new DQIVariables();
	 
	 /**
	  * Non-parameterized constructor
	  */
	 private DQIVariables() {}
	

	public static DQIVariables getInstance() {
		return dQIVariables;
	}
	public String getJiraExcelSheetFilePath() {
		return jiraExcelSheetFilePath;
	}
	public void setJiraExcelSheetFilePath(String jiraExcelSheetFilePath) {
		this.jiraExcelSheetFilePath = jiraExcelSheetFilePath;
	}
	public String getMannualExcelSheetFilePath() {
		return mannualExcelSheetFilePath;
	}
	public void setManualExcelSheetFilePath(String mannualExcelSheetFilePath) {
		this.mannualExcelSheetFilePath = mannualExcelSheetFilePath;
	}
	public String getQaExcelSheetFilePath() {
		return qaExcelSheetFilePath;
	}
	public void setQaExcelSheetFilePath(String qaExcelSheetFilePath) {
		this.qaExcelSheetFilePath = qaExcelSheetFilePath;
	}
	public String getdQISprintNumber() {
		return dQISprintNumber;
	}
	public void setdQISprintNumber(String dQISprintNumber) {
		this.dQISprintNumber = dQISprintNumber;
	}
	public String getdQIMonthYear() {
		return dQIMonthYear;
	}
	public void setdQIMonthYear(String dQIMonthYear) {
		this.dQIMonthYear = dQIMonthYear;
	}
	public int getdQIStoryPoints() {
		return dQIStoryPoints;
	}
	public void setdQIStoryPoints(int dQIStoryPoints) {
		this.dQIStoryPoints = dQIStoryPoints;
	}
	public String getdQIfinalSheetPath() {
		return dQIfinalSheetPath;
	}
	public void setdQIfinalSheetPath(String dQIfinalSheetPath) {
		this.dQIfinalSheetPath = dQIfinalSheetPath;
	}
	public boolean isdQIjiraRadioButton() {
		return dQIjiraRadioButton;
	}
	public void setdQIjiraRadioButton(boolean dQIjiraRadioButton) {
		this.dQIjiraRadioButton = dQIjiraRadioButton;
	}
	public boolean isdQImannualRadioButton() {
		return dQImanualRadioButton;
	}
	public void setdQImannualRadioButton(boolean dQImannualRadioButton) {
		this.dQImanualRadioButton = dQImannualRadioButton;
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

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	public boolean isOpenSaveFrame() {
		return openSaveFrame;
	}


	public void setOpenSaveFrame(boolean openSaveFrame) {
		this.openSaveFrame = openSaveFrame;
	}


	public boolean isWriteExcel() {
		return writeExcel;
	}


	public void setWriteExcel(boolean writeExcel) {
		this.writeExcel = writeExcel;
	}


	/**
	 * This function resets DQIVariables class variables.
	 */
	public void resetData()
	{
		DQIVariables.getInstance().setdQIjiraRadioButton(false);
		DQIVariables.getInstance().setdQImannualRadioButton(false);
		DQIVariables.getInstance().setdQIMonthYear(null);
		DQIVariables.getInstance().setdQISprintNumber(null);
		DQIVariables.getInstance().setdQIStoryPoints(0);
		DQIVariables.getInstance().setJiraExcelSheetFilePath(null);
		DQIVariables.getInstance().setManualExcelSheetFilePath(null);
		DQIVariables.getInstance().setQaExcelSheetFilePath(null);
		DQIVariables.getInstance().setdQIfinalSheetPath(null);
	}

}
