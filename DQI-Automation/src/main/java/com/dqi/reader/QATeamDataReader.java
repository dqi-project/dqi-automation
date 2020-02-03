package com.dqi.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.burndown.util.Constant;
import com.burndown.util.DQIVariables;
import com.dqi.common.ApplicationConstants;
import com.dqi.common.ExcelSheetUtils;
import com.dqi.vo.QATeamMemberDetailsVO;
import com.dqiAutomation.exception.DQIInvalidExcelSheetException;

public class QATeamDataReader {
	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	private static final Logger logger = Logger.getLogger(QATeamDataReader.class);

	public List<QATeamMemberDetailsVO> readQaTeamData() throws DQIInvalidExcelSheetException {
		Row row = null;
		Cell cell = null ;
		List<QATeamMemberDetailsVO> membersList = null;

		// ------------------------The object of ExcelSheetUtils is used to
		// create a new workbook & sheet.
		ExcelSheetUtils sheetType = new ExcelSheetUtils();
		
		XSSFWorkbook workbook = sheetType.excelXSSFSheet(DQIVariables.getInstance().getQaExcelSheetFilePath());
		                                  
			// creating new sheet
			XSSFSheet sheet = workbook.getSheetAt(0);
			// List of type QATeamMemberDetailsVO
			membersList = new ArrayList<>();

			row = sheet.getRow(1);

			// creating cell
			Cell cell1 = row.getCell(0);
			Cell cell2 = row.getCell(1);
			Cell cell3 = row.getCell(2);
			Cell cell4 = row.getCell(3);
			Cell cell5 = row.getCell(4);
			Cell cell6 = row.getCell(5);
			Cell cell7 = row.getCell(6);
			Cell cell8 = row.getCell(7);
			Cell cell9 = row.getCell(8);
			Cell cell10 = row.getCell(9);
			Cell cell11 = row.getCell(10);
			Cell cell12 = row.getCell(11);
			
			try {
				if (cell1.getStringCellValue().equals(ApplicationConstants.QACELLONE)
						&& cell2.getStringCellValue().equals(ApplicationConstants.QACELLTWO)
						&& cell3.getStringCellValue().equals(ApplicationConstants.QACELLTHREE)
						&& cell4.getStringCellValue().equals(ApplicationConstants.QACELLFOUR)
						&& cell5.getStringCellValue().equals(ApplicationConstants.QACELLFIVE)
						&& cell6.getStringCellValue().equals(ApplicationConstants.QACELLSIX)
						&& cell7.getStringCellValue().equals(ApplicationConstants.QACELLSEVEN)
						&& cell8.getStringCellValue().equals(ApplicationConstants.QACELLEIGHT)
						&& cell9.getStringCellValue().equals(ApplicationConstants.QACELLNINE)
						&& cell10.getStringCellValue().equals(ApplicationConstants.QACELLTEN)
						&& cell11.getStringCellValue().equals(ApplicationConstants.QACELLELEVEN)
						&& cell12.getStringCellValue().equals(ApplicationConstants.QACELLTWELVE)

						&& cell1.getStringCellValue() != null && cell2.getStringCellValue() != null
						&& cell3.getStringCellValue() != null && cell4.getStringCellValue() != null
						&& cell5.getStringCellValue() != null && cell6.getStringCellValue() != null
						&& cell7.getStringCellValue() != null && cell8.getStringCellValue() != null
						&& cell9.getStringCellValue() != null && cell10.getStringCellValue() != null
						&& cell11.getStringCellValue() != null && cell12.getStringCellValue() != null) {

					for (int i = sheet.getFirstRowNum() + 2; i <= sheet.getLastRowNum(); i++) {

						QATeamMemberDetailsVO qATeamMemberDetailsVO = new QATeamMemberDetailsVO();
						// creating row
						row = sheet.getRow(i);
						if (row == null) {
							continue;
						}

						for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
							// creating cell
							cell = row.getCell(j);

							try
							{
								switch (j) {
							
								case ApplicationConstants.CELLZERO:// name

									qATeamMemberDetailsVO.setName(cell.getStringCellValue());
									
									break;
								case ApplicationConstants.CELLFOUR:// NumOfTestCaseDeveloped
									qATeamMemberDetailsVO.setNumOfTestCaseDeveloped((float) cell.getNumericCellValue());

									break;
								case ApplicationConstants.CELLFIVE:// TestCaseCreationEfforts
									qATeamMemberDetailsVO
											.setTestCaseCreationEfforts((float) cell.getNumericCellValue());
									break;
								case ApplicationConstants.CELLSIX:// NumOfTestCaseReviewed
									qATeamMemberDetailsVO.setNumOfTestCaseReviewed((float) cell.getNumericCellValue());

									break;

								case ApplicationConstants.CELLSEVEN:// TestCaseReviewEfforts
									qATeamMemberDetailsVO.setTestCaseReviewEfforts((float) cell.getNumericCellValue());
									break;

								case ApplicationConstants.CELLEIGHT:// NumOfTestCaseExecutedManually
									qATeamMemberDetailsVO
											.setNumOfTestCaseExecutedManually((float) cell.getNumericCellValue());
									break;

								case ApplicationConstants.CELLNINE:// ManualTestingEfforts

									qATeamMemberDetailsVO.setManualTestingEfforts((float) cell.getNumericCellValue());
									break;

								case ApplicationConstants.CELLTEN:// NumOfTestCaseExecutedThroughAutomation
									qATeamMemberDetailsVO.setNumOfTestCaseExecutedThroughAutomation(
											(float) cell.getNumericCellValue());
									break;

								case ApplicationConstants.CELLELEVEN:// AutomationTestingEfforts
									qATeamMemberDetailsVO
											.setAutomationTestingEfforts((float) cell.getNumericCellValue());
									break;

								default:
									break;
								}
							}catch (IllegalStateException errorMessage) {
								DQIVariables.getInstance().setFileName(
										new File(DQIVariables.getInstance().getQaExcelSheetFilePath()).getName());								
								DQIVariables.getInstance().setExceptionAtRowNumber(row.getRowNum() + 1);
								DQIVariables.getInstance().setExceptionAtColumnNumber(cell.getColumnIndex() + 1);
								logger.error(Constant.DQI_EXCEPTION_MESSAGE, errorMessage);
								throw new  IllegalStateException();	
							}
							

						}
 						membersList.add(qATeamMemberDetailsVO);

					}
				} else
					throw new DQIInvalidExcelSheetException(Constant.DQI_EXCEPTION_MESSAGE);
			} catch (IllegalStateException errorMessage) {				
				throw new  IllegalStateException();	
			}catch (DQIInvalidExcelSheetException e) {
				DQIVariables.getInstance()
						.setFileName(new File(DQIVariables.getInstance().getQaExcelSheetFilePath()).getName());

				logger.error(Constant.DQI_EXCEPTION_MESSAGE, e);
				throw new DQIInvalidExcelSheetException(Constant.DQI_EXCEPTION_MESSAGE);
			} catch (Exception e) {
				DQIVariables.getInstance()
						.setFileName(new File(DQIVariables.getInstance().getQaExcelSheetFilePath()).getName());
				
				logger.error(Constant.DQI_EXCEPTION_MESSAGE, e);

			}
		
		logger.info("QA team data has been read");
		
		return membersList;

	}

}