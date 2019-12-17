package com.dqi.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.burn.down.util.Variables;
import com.dqi.common.ApplicationConstants;
import com.dqi.common.ExcelSheetUtils;
import com.dqi.jira.DevTeamDataReader;
import com.dqi.vo.DevTeamMemberDetailsVO;

/**
 * This class is reading the data of the Development team from the manual excel
 * sheet.
 * 
 * @author akansha.chaudhary
 *
 */
public class ManualDevTeamDataReader implements DevTeamDataReader {

	public List<DevTeamMemberDetailsVO> readDevTeamData() throws IOException, FileNotFoundException {

		// ------------------------The object of ExcelSheetUtils is used to
		// create a new workbook & sheet.

		ExcelSheetUtils sheetType = new ExcelSheetUtils();
		
		XSSFWorkbook workbook = sheetType.excelXSSFSheet(Variables.mannualExcelSheetFilePath);

		// Creating new sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		// List of type DevTeamMemberDetailsVO
		List<DevTeamMemberDetailsVO> membersList = new ArrayList<DevTeamMemberDetailsVO>();

		// System.out.println("---- " + sheet.getFirstRowNum() + " - " +
		// sheet.getLastRowNum());
		String name = "";

		for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {

			DevTeamMemberDetailsVO devTeamMemberDetailsVO = new DevTeamMemberDetailsVO();
			// creating row
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}

			// System.out.println("--- [" + i + "]" + ro);

			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				// creating cell
				Cell cell = row.getCell(j);

				if (cell == null) {
					continue;
				}

				switch (j) {
				case ApplicationConstants.CELL_ZERO:// name

					devTeamMemberDetailsVO.setName(cell.getStringCellValue());
					if (!cell.getStringCellValue().equals("")) {
						name = cell.getStringCellValue();
						devTeamMemberDetailsVO.setName(name);
					} else {
						devTeamMemberDetailsVO.setName(name);
					}

					break;
				case ApplicationConstants.CELL_ONE:
					devTeamMemberDetailsVO.setJiraTicketNo(cell.getStringCellValue());// JiraTicketNo
					break;
				case ApplicationConstants.CELL_TWO:
					devTeamMemberDetailsVO.setAnalysis((int) cell.getNumericCellValue());// Analysis
					break;
				case ApplicationConstants.CELL_THREE:
					devTeamMemberDetailsVO.setDev((int) cell.getNumericCellValue());// Development
					break;
				case ApplicationConstants.CELL_FOUR:
					devTeamMemberDetailsVO.setUt((int) cell.getNumericCellValue());// UT
					break;
				case ApplicationConstants.CELL_FIVE:
					devTeamMemberDetailsVO.setCodeReview((int) cell.getNumericCellValue());// CodeReview
					break;
				case ApplicationConstants.CELL_SIX:
					devTeamMemberDetailsVO.setInternalReviewDefects((int) cell.getNumericCellValue());// InternalReviewDefects
					break;
				case ApplicationConstants.CELL_SEVEN:
					devTeamMemberDetailsVO.setExternalReviewDefects((int) cell.getNumericCellValue());/// ExternalReviewDefects
					break;
				case ApplicationConstants.CELL_EIGHT:
					devTeamMemberDetailsVO.setqADefects((int) cell.getNumericCellValue());// qADefects
					break;
				/*case ApplicationConstants.CELL_TEN:
					devTeamMemberDetailsVO.setStoryPoint((int) cell.getNumericCellValue());// StoryPoint
					break;*/

				default:
					break;
				}

			}

			membersList.add(devTeamMemberDetailsVO);

		}
		/*
		  for (DevTeamMemberDetailsVO members : membersList) {
		  
		  System.out.println(members + "\n"); System.out.println(
		  "****************************************************************************************"
		  );
		  
		  } System.out.println();
		 */
		return membersList;
	}
}
