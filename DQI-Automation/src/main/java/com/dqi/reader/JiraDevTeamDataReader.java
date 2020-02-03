package com.dqi.reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.burndown.util.Constant;
import com.burndown.util.DQIVariables;
import com.dqi.common.ApplicationConstants;
import com.dqi.common.ExcelSheetUtils;

import com.dqi.jira.DevTeamDataReader;
import com.dqi.vo.DevTeamMemberDetailsVO;
import com.dqiAutomation.exception.DQIInvalidExcelSheetException;

/**
 * This class is reading the data of the Development team from the jira excel
 * sheet.
 * 
 * @author akansha.chaudhary
 *
 */
public class JiraDevTeamDataReader implements DevTeamDataReader {
	private static final Logger logger = Logger.getLogger(JiraDevTeamDataReader.class);

	Row row = null;

	public List<DevTeamMemberDetailsVO> readDevTeamData() throws IOException, DQIInvalidExcelSheetException {
		// ------------------------The object of ExcelSheetUtils is used to
		// create a new workbook & sheet.
		ExcelSheetUtils sheetType = new ExcelSheetUtils();

		HSSFWorkbook workbook = sheetType.excelHSSFSheet(DQIVariables.getInstance().getJiraExcelSheetFilePath());
		// creating sheet
		HSSFSheet sheet = workbook.getSheetAt(0);
		// List of type DevTeamMemberDetailsVO
		List<DevTeamMemberDetailsVO> membersList = new ArrayList<>();

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
		try {

			if (cell1.getStringCellValue().equals(ApplicationConstants.JIRACELLONE)
					&& cell2.getStringCellValue().equals(ApplicationConstants.JIRACELLTWO)
					&& cell3.getStringCellValue().equals(ApplicationConstants.JIRACELLTHREE)
					&& cell4.getStringCellValue().equals(ApplicationConstants.JIRACELLFOUR)
					&& cell5.getStringCellValue().equals(ApplicationConstants.JIRACELLFIVE)
					&& cell6.getStringCellValue().equals(ApplicationConstants.JIRACELLSIX)
					&& cell7.getStringCellValue().equals(ApplicationConstants.JIRACELLSEVEN)
					&& cell8.getStringCellValue().equals(ApplicationConstants.JIRACELLEIGHT)
					&& cell1.getStringCellValue() != null && cell2.getStringCellValue() != null
					&& cell3.getStringCellValue() != null && cell4.getStringCellValue() != null
					&& cell5.getStringCellValue() != null && cell6.getStringCellValue() != null
					&& cell7.getStringCellValue() != null && cell8.getStringCellValue() != null) {

				logger.info("jira collection reader running successfully");

				for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {

					DevTeamMemberDetailsVO devTeamMemberDetailsVO = new DevTeamMemberDetailsVO();
					// creating row
					Row row = sheet.getRow(i);
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

							switch (j) {
							case ApplicationConstants.CELLFIVE:// summary
								devTeamMemberDetailsVO.setSummary(cell.getStringCellValue());

								break;
							case ApplicationConstants.CELLSIX:// name
								devTeamMemberDetailsVO.setName(cell.getStringCellValue());
								break;
							case ApplicationConstants.CELLSEVEN:// hours
								devTeamMemberDetailsVO.setHours((float) cell.getNumericCellValue());
								break;

							default:
								break;
							}
						} catch (IllegalStateException errorMessage) {
							DQIVariables.getInstance().setFileName(
									new File(DQIVariables.getInstance().getJiraExcelSheetFilePath()).getName());
							DQIVariables.getInstance().setExceptionAtRowNumber(row.getRowNum() + 1);
							DQIVariables.getInstance().setExceptionAtColumnNumber(cell.getColumnIndex() + 1);
							logger.error(Constant.DQI_EXCEPTION_MESSAGE, errorMessage);
							throw new IllegalStateException();
							
						} 
					}

					membersList.add(devTeamMemberDetailsVO);

					for (i = 0; i < membersList.size(); i++) {

						if (membersList.get(i).getSummary().startsWith(ApplicationConstants.DEVELOPMENT)
								|| membersList.get(i).getSummary().startsWith(ApplicationConstants.DEV)) {
							devTeamMemberDetailsVO.setDev(membersList.get(i).getHours());
							devTeamMemberDetailsVO.setAnalysis(0);
							devTeamMemberDetailsVO.setUt(0);
							devTeamMemberDetailsVO.setCodeReview(0);

						} else if (membersList.get(i).getSummary().startsWith(ApplicationConstants.ANALYSIS)) {
							devTeamMemberDetailsVO.setAnalysis(membersList.get(i).getHours());
							devTeamMemberDetailsVO.setUt(0);
							devTeamMemberDetailsVO.setCodeReview(0);
							devTeamMemberDetailsVO.setDev(0);
							devTeamMemberDetailsVO.setDev(0);
						} else if (membersList.get(i).getSummary().startsWith(ApplicationConstants.UNITTESTING)
								|| membersList.get(i).getSummary().startsWith(ApplicationConstants.UT)) {
							devTeamMemberDetailsVO.setUt(membersList.get(i).getHours());
							devTeamMemberDetailsVO.setDev(0);
							devTeamMemberDetailsVO.setAnalysis(0);
							devTeamMemberDetailsVO.setCodeReview(0);

						} else if (membersList.get(i).getSummary().startsWith(ApplicationConstants.CODEREVIEW)) {
							devTeamMemberDetailsVO.setCodeReview(membersList.get(i).getHours());
							devTeamMemberDetailsVO.setDev(0);
							devTeamMemberDetailsVO.setAnalysis(0);
							devTeamMemberDetailsVO.setUt(0);

						}

					}

				}

				Map<String, DevTeamMemberDetailsVO> totalByEmployee1 = new HashMap<>();

				for (DevTeamMemberDetailsVO devTeamMemberDetailsVO : membersList) {

					String name = devTeamMemberDetailsVO.getName();
					{

						if (totalByEmployee1.containsKey(name)) {
							DevTeamMemberDetailsVO devTeamMemberDetailsVO1 = totalByEmployee1.get(name);
							devTeamMemberDetailsVO1.setName(name);
							devTeamMemberDetailsVO1.setAnalysis(
									devTeamMemberDetailsVO1.getAnalysis() + devTeamMemberDetailsVO.getAnalysis());
							devTeamMemberDetailsVO1
									.setDev((devTeamMemberDetailsVO1.getDev() + devTeamMemberDetailsVO.getDev()));
							devTeamMemberDetailsVO1
									.setUt(devTeamMemberDetailsVO1.getUt() + devTeamMemberDetailsVO.getUt());
							devTeamMemberDetailsVO1.setCodeReview(
									devTeamMemberDetailsVO1.getCodeReview() + devTeamMemberDetailsVO.getCodeReview());

							totalByEmployee1.put(name, devTeamMemberDetailsVO1);
						} else {
							DevTeamMemberDetailsVO devTeamMemberDetailsVO1 = new DevTeamMemberDetailsVO();
							devTeamMemberDetailsVO1.setName(name);

							devTeamMemberDetailsVO1.setAnalysis(devTeamMemberDetailsVO.getAnalysis());
							devTeamMemberDetailsVO1.setDev(devTeamMemberDetailsVO.getDev());
							devTeamMemberDetailsVO1.setUt(devTeamMemberDetailsVO.getUt());
							devTeamMemberDetailsVO1.setCodeReview(devTeamMemberDetailsVO.getCodeReview());

							totalByEmployee1.put(name, devTeamMemberDetailsVO1);
						}

					}
				}

				List<DevTeamMemberDetailsVO> jiraDevMemberList = new ArrayList<>(totalByEmployee1.values());

				return jiraDevMemberList;

			} else
				throw new DQIInvalidExcelSheetException(Constant.DQI_EXCEPTION_MESSAGE);
		} catch (DQIInvalidExcelSheetException e) {
			DQIVariables.getInstance()
					.setFileName(new File(DQIVariables.getInstance().getJiraExcelSheetFilePath()).getName());

			logger.error(Constant.DQI_EXCEPTION_MESSAGE, e);
			throw new DQIInvalidExcelSheetException(Constant.DQI_EXCEPTION_MESSAGE);
		} catch (IllegalStateException errorMessage) {			
			throw new IllegalStateException();
			
		} catch (Exception e) {
			DQIVariables.getInstance()
					.setFileName(new File(DQIVariables.getInstance().getJiraExcelSheetFilePath()).getName());
			
			logger.error(Constant.DQI_EXCEPTION_MESSAGE, e);

		}
		logger.info("Jira reader running successfully");

		return membersList;

	}

}
