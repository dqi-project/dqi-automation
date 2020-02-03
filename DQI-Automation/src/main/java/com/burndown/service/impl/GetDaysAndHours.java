package com.burndown.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import com.burndown.service.ExcelSheetHoursAndDaysReader;
import com.burndown.ui.errordialog.BurnDownChartInvalidExcelSheetErrorDialog;
import com.burndown.ui.errordialog.BurnDownNumberFormatExceptionErrorDialog;
import com.burndown.util.BurnDownVariables;
import com.burndown.util.Constant;
import com.burndown.util.ExcelFileReader;
import com.dqiAutomation.exception.BurnDownInvalidExcelSheetException;

/**
 * This class reads Day and Hours columns from user provided Excel Sheet.
 * 
 * @author priyanka_gupta
 * 
 */
public class GetDaysAndHours implements ExcelSheetHoursAndDaysReader {
	private static final Logger logger = Logger.getLogger(GetDaysAndHours.class);

	/*
	 * Non-parameterized constructor.
	 */

	String columnValues[] = new String[2];

	/**
	 * Non-parameterized constructor.
	 */
	public GetDaysAndHours() {
	}

	/**
	 * 
	 * @param excelFilePath
	 * @return daysAndHoursMap
	 */
	public Map<Double, Double> excelReadDaysAndHours(String excelFilePath) {

		Map<Double, Double> daysAndHoursMap = new LinkedHashMap<Double, Double>();

		double cellValue = 0.0;
		double remainingHours = BurnDownVariables.getInstance().getPlannedEffortsInHours();
		try {

			// FormulaEvaluator to evaluate cell type.
			FormulaEvaluator formulaEvaluator = new ExcelFileReader().get_HSSFWorkbook(excelFilePath)
					.getCreationHelper().createFormulaEvaluator();

			// for-each loop to iterate over the rows and columns.
			for (Row row : new ExcelFileReader().get_HSSFSheet(excelFilePath)) {

				for (Cell cell : row) {

					switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
					// If cell is a Numeric Format
					case NUMERIC: {
						// Inserting Days to Map
						if (BurnDownVariables.getInstance().getDayColumnIndexNumber() == cell.getColumnIndex()
								&& row.getCell(cell.getColumnIndex()) != null) {
							cellValue = cell.getNumericCellValue();// Get the
																	// value of
																	// the cell
																	// containing
																	// Day in
																	// Excel
																	// sheet as
																	// a number.

							/*
							 * If there is no key ==
							 * cell.getNumericCellValue()present in Mapthen
							 * create a key-value pair in Map with
							 * 
							 * value=remainingHours.
							 */

							if (daysAndHoursMap.containsKey(cell.getNumericCellValue()) != true) {
								daysAndHoursMap.put(cell.getNumericCellValue(), remainingHours);
							}

						}

						// Inserting Hours to Map
						if (BurnDownVariables.getInstance().getHoursColumnIndexNumber() == cell.getColumnIndex()
								&& null != row.getCell(BurnDownVariables.getInstance().getDayColumnIndexNumber())
								&& null != row.getCell(BurnDownVariables.getInstance().getHoursColumnIndexNumber())) {

							// Iterating Map.
							Set<Entry<Double, Double>> s = daysAndHoursMap.entrySet();
							Iterator<Entry<Double, Double>> itr = s.iterator();
							while (itr.hasNext()) {
								Map.Entry<Double, Double> m1 = (Entry<Double, Double>) itr.next();

								String stringKeyValue = m1.getKey().toString();
								double doubleKeyValue = Double.valueOf(stringKeyValue).doubleValue();

								if (doubleKeyValue == cellValue) {
									remainingHours = remainingHours - cell.getNumericCellValue();
									m1.setValue(remainingHours);
								}
							}

						}

					}

						break;
					// If cell is a String Format.
					case STRING: {
						if (Constant.COLUMN_VALUE_1.equalsIgnoreCase(cell.getStringCellValue())
								|| Constant.COLUMN_VALUE_3.equalsIgnoreCase(cell.getStringCellValue())) {
							columnValues[0] = cell.getStringCellValue();
							BurnDownVariables.getInstance().setColumnValues(columnValues);
							BurnDownVariables.getInstance().setDayColumnIndexNumber(cell.getColumnIndex());// Storing
																											// index
																											// number
																											// of
																											// Column
																											// containing
																											// Day
																											// in
																											// Excel

						}

						if (Constant.COLUMN_VALUE_2.equalsIgnoreCase(cell.getStringCellValue())
								|| Constant.COLUMN_VALUE_4.equalsIgnoreCase(cell.getStringCellValue())) {
							columnValues[1] = cell.getStringCellValue();
							BurnDownVariables.getInstance().setColumnValues(columnValues);
							BurnDownVariables.getInstance().setHoursColumnIndexNumber(cell.getColumnIndex());// Storing
																												// index
																												// number
																												// of
																												// Column
																												// containing
																												// Hours
																												// in
																												// Excel
																												// Sheet.

						}

						if (row.getRowNum() > 0
								&& (BurnDownVariables.getInstance().getDayColumnIndexNumber() == cell.getColumnIndex()
										|| BurnDownVariables.getInstance().getHoursColumnIndexNumber() == cell
												.getColumnIndex())) {
							
							BurnDownVariables.getInstance().setExceptionAtRowNumber(row.getRowNum() + 1);
							BurnDownVariables.getInstance().setExceptionAtColumnNumber(cell.getColumnIndex() + 1);
							Double.parseDouble(cell.getStringCellValue());
						}
					}
						break;
					default:
						break;
					}
				}
				logger.info("GetDaysAndHours class running successfully");
				
				if((false == Constant.COLUMN_VALUE_1
					.equalsIgnoreCase(BurnDownVariables.getInstance().getColumnValues()[0])
					&& false == Constant.COLUMN_VALUE_3
							.equalsIgnoreCase(BurnDownVariables.getInstance().getColumnValues()[0]))
					|| (false == Constant.COLUMN_VALUE_2
							.equalsIgnoreCase(BurnDownVariables.getInstance().getColumnValues()[1])
					&& false == Constant.COLUMN_VALUE_4
							.equalsIgnoreCase(BurnDownVariables.getInstance().getColumnValues()[1])))
				{					
					throw new BurnDownInvalidExcelSheetException(Constant.BURN_DOWN_INVALID_EXCEL_SHEET_EXCEPTION_MESSAGE);
				}

			}

		}catch (OfficeXmlFileException e) {				
			logger.error("Excel sheet is not valid", e);
			daysAndHoursMap=null;
			new BurnDownChartInvalidExcelSheetErrorDialog();
		} catch (BurnDownInvalidExcelSheetException e) {
			daysAndHoursMap=null;
			new BurnDownChartInvalidExcelSheetErrorDialog();
			logger.error("Exception in GetDaysAndHours class ", e);		
		} 
		catch (NumberFormatException errorMessage) {
			daysAndHoursMap=null;		
			new BurnDownNumberFormatExceptionErrorDialog();
			logger.error("Exception in GetDaysAndHours class ", errorMessage);

		} catch (Throwable e) {
			daysAndHoursMap=null;
			
			new BurnDownChartInvalidExcelSheetErrorDialog();
			logger.error("Exception in GetDaysAndHours class ", e);
		}

		return daysAndHoursMap;
	}

}
