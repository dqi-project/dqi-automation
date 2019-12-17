package com.burn.service;

import java.util.Map;
/**
 *  This interface contains abstract method to read Days and Hours from an excel sheet.
 * @author priyanka_gupta
 *
 */
public interface ExcelSheetHoursAndDaysReader
{
	public  Map excelReadDaysAndHours(String excelFilePath);
}
