package com.dqi.reader;

import java.io.File;
import java.io.IOException;
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
import com.dqi.jira.DevTeamDataReader;
import com.dqi.vo.DevTeamMemberDetailsVO;
import com.dqiAutomation.exception.DQIInvalidExcelSheetException;

/**
 * This class is reading the data of the Development team from the manual excel
 * sheet.
 * 
 * @author akansha.chaudhary
 *
 */
public class DataCollectionReader implements DevTeamDataReader {
	
	List<DevTeamMemberDetailsVO> membersList;
	Row row = null;
	private static final Logger logger = Logger.getLogger(DataCollectionReader.class);

	public List<DevTeamMemberDetailsVO> readDevTeamData() throws IOException, DQIInvalidExcelSheetException,IllegalStateException  {

		// ------------------------The object of ExcelSheetUtils is used to
		// create a new workbook & sheet.
		ExcelSheetUtils sheetType = new ExcelSheetUtils();
		XSSFWorkbook workbook = sheetType.excelXSSFSheet(DQIVariables.getInstance().getMannualExcelSheetFilePath());
		// Creating new sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		// List of type DevTeamMemberDetailsVO
		membersList = new ArrayList<>();

		String name = "";

		// creating row
		row = sheet.getRow(0);

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

			if (cell1.getStringCellValue().equals(ApplicationConstants.MANUALCELLONE)
					&& cell2.getStringCellValue().equals(ApplicationConstants.MANUALCELLTWO)
					&& cell3.getStringCellValue().equals(ApplicationConstants.MANUALCELLTHREE)
					&& cell4.getStringCellValue().equals(ApplicationConstants.MANUALCELLFOUR)
					&& cell5.getStringCellValue().equals(ApplicationConstants.MANUALCELLFIVE)
					&& cell6.getStringCellValue().equals(ApplicationConstants.MANUALCELLSIX)
					&& cell7.getStringCellValue().equals(ApplicationConstants.MANUALCELLSEVEN)
					&& cell8.getStringCellValue().equals(ApplicationConstants.MANUALCELLEIGHT)
					&& cell9.getStringCellValue().equals(ApplicationConstants.MANUALCELLNINE)
					&& cell10.getStringCellValue().equals(ApplicationConstants.MANUALCELLTEN)
					&& cell11.getStringCellValue().equals(ApplicationConstants.MANUALCELLELEVEN)
					&& cell12.getStringCellValue().equals(ApplicationConstants.MANUALCELLTWELVE)
					&& cell1.getStringCellValue() != null && cell2.getStringCellValue() != null
					&& cell3.getStringCellValue() != null && cell4.getStringCellValue() != null
					&& cell5.getStringCellValue() != null && cell6.getStringCellValue() != null
					&& cell7.getStringCellValue() != null && cell8.getStringCellValue() != null
					&& cell9.getStringCellValue() != null && cell10.getStringCellValue() != null
					&& cell11.getStringCellValue() != null && cell12.getStringCellValue() != null) {


				for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {

					DevTeamMemberDetailsVO devTeamMemberDetailsVO = new DevTeamMemberDetailsVO();// object
					// creating row

					row = sheet.getRow(i);
					if (row == null) {
						continue;
					}

					
					for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
						// creating cell
						Cell cell = row.getCell(j);
						if (cell == null) {
							continue;
						}
						try {
							// Reading cells
							switch (j) {

							case ApplicationConstants.CELLZERO:// name

								devTeamMemberDetailsVO.setSprintName(cell.getStringCellValue());

								if (!cell.getStringCellValue().equals("")) {
									name = cell.getStringCellValue();
									devTeamMemberDetailsVO.setName(name);
								} else
									devTeamMemberDetailsVO.setName(name);

								break;

							case ApplicationConstants.CELLONE:// jira ticket
																// number
								devTeamMemberDetailsVO.setJiraTicketNo(cell.getStringCellValue());
								break;

							case ApplicationConstants.CELLTWO:// analysis
								devTeamMemberDetailsVO.setAnalysis((float) cell.getNumericCellValue());
								break;
							case ApplicationConstants.CELLTHREE:// Development
								devTeamMemberDetailsVO.setDev((float) cell.getNumericCellValue());
								break;
							case ApplicationConstants.CELLFOUR:// UT
								devTeamMemberDetailsVO.setUt((float) cell.getNumericCellValue());
								break;
							case ApplicationConstants.CELLFIVE:// Code review
								devTeamMemberDetailsVO.setCodeReview((float) cell.getNumericCellValue());
								break;
							case ApplicationConstants.CELLSIX:// InternalReviewDefects
								devTeamMemberDetailsVO.setInternalReviewDefects((float) cell.getNumericCellValue());
								break;
							case ApplicationConstants.CELLSEVEN:// ExternalReviewDefects
								devTeamMemberDetailsVO.setExternalReviewDefects((float) cell.getNumericCellValue());
								break;
							default:
								break;
							}
						} catch (IllegalStateException errorMessage) {
							DQIVariables.getInstance().setFileName(
									new File(DQIVariables.getInstance().getMannualExcelSheetFilePath()).getName());
							DQIVariables.getInstance().setExceptionAtRowNumber(row.getRowNum() + 1);
							DQIVariables.getInstance().setExceptionAtColumnNumber(cell.getColumnIndex() + 1);
							
							logger.error(Constant.DQI_EXCEPTION_MESSAGE, errorMessage);
							throw new IllegalStateException();
					
							} 
					}
					if(devTeamMemberDetailsVO.getName()!=null){
					membersList.add(devTeamMemberDetailsVO);
					}
				} logger.info("Data collection reader running successfully");

			
			}
			else
				throw new DQIInvalidExcelSheetException(Constant.DQI_EXCEPTION_MESSAGE);
		} 
		
		catch (IllegalStateException errorMessage) {				
			throw new  IllegalStateException();	
		}
		catch (DQIInvalidExcelSheetException e) {
			DQIVariables.getInstance().setFileName(new File(DQIVariables.getInstance().getMannualExcelSheetFilePath()).getName());
		
			logger.error(Constant.DQI_EXCEPTION_MESSAGE, e);
			throw new DQIInvalidExcelSheetException(Constant.DQI_EXCEPTION_MESSAGE);
		}
		catch (Exception e) {
			DQIVariables.getInstance().setFileName(new File(DQIVariables.getInstance().getMannualExcelSheetFilePath()).getName());
		
			logger.error(Constant.DQI_EXCEPTION_MESSAGE, e);

		}              

		return membersList;
	}
}
