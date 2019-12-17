package com.dqi.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.burn.down.util.Variables;
import com.dqi.common.ApplicationConstants;
import com.dqi.common.ExcelSheetUtils;
import com.dqi.vo.QATeamMemberDetailsVO;


public class QATeamDataReader {
/**
 * 
 * @return
 * @throws IOException
 * @throws FileNotFoundException
 */
	public List<QATeamMemberDetailsVO> readQaTeamData() throws IOException, FileNotFoundException {
		// ------------------------The object of ExcelSheetUtils is used to
				// create a new workbook & sheet.
			ExcelSheetUtils sheetType= new ExcelSheetUtils();
						 XSSFWorkbook workbook = sheetType.excelXSSFSheet(Variables.qaExcelSheetFilePath);
					//creating new sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		// List of type QATeamMemberDetailsVO
		List<QATeamMemberDetailsVO> membersList = new ArrayList<QATeamMemberDetailsVO>();
		for (int i = sheet.getFirstRowNum() + 2; i <= sheet.getLastRowNum(); i++) {

			QATeamMemberDetailsVO qATeamMemberDetailsVO = new QATeamMemberDetailsVO();
			//creating row
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}

			// System.out.println("--- [" + i + "]" + ro);

			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				//creating cell
				Cell cell = row.getCell(j);

				switch (j) {
				case ApplicationConstants.CELL_ZERO://name
					qATeamMemberDetailsVO.setName(cell.getStringCellValue());

					break;
				case ApplicationConstants.CELL_FOUR://NumOfTestCaseDeveloped
					qATeamMemberDetailsVO.setNumOfTestCaseDeveloped((int) cell.getNumericCellValue());

					break;
				case ApplicationConstants.CELL_FIVE://TestCaseCreationEfforts
					qATeamMemberDetailsVO.setTestCaseCreationEfforts((int) cell.getNumericCellValue());

				case ApplicationConstants.CELL_SIX://NumOfTestCaseReviewed
					qATeamMemberDetailsVO.setNumOfTestCaseReviewed((int) cell.getNumericCellValue());

					break;

				case ApplicationConstants.CELL_SEVEN://TestCaseReviewEfforts
					qATeamMemberDetailsVO.setTestCaseReviewEfforts((int) cell.getNumericCellValue());
					break;

				case ApplicationConstants.CELL_EIGHT://NumOfTestCaseExecutedManually
					qATeamMemberDetailsVO.setNumOfTestCaseExecutedManually((int) cell.getNumericCellValue());
					break;

				case ApplicationConstants.CELL_NINE://ManualTestingEfforts
					qATeamMemberDetailsVO.setManualTestingEfforts((int) cell.getNumericCellValue());
					break;

				case ApplicationConstants.CELL_TEN://NumOfTestCaseExecutedThroughAutomation
					qATeamMemberDetailsVO.setNumOfTestCaseExecutedThroughAutomation((int) cell.getNumericCellValue());
					break;

				case ApplicationConstants.CELL_ELEVEN://AutomationTestingEfforts
					qATeamMemberDetailsVO.setAutomationTestingEfforts((int) cell.getNumericCellValue());
					break;

				default:
					break;
				}

			}
		
				membersList.add(qATeamMemberDetailsVO);

				/*for (QATeamMemberDetailsVO members : membersList) {

					System.out.println(members);

				}*/
			
		}
		return membersList;

	}
/*
	public static void main(String[] args) throws IOException {
		QATeamDataReader qATeamDataReader = new QATeamDataReader();
		qATeamDataReader.readQaTeamData();

	}*/
}