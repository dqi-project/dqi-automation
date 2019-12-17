package com.dqi.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.burn.down.util.Variables;
import com.dqi.common.ApplicationConstants;
import com.dqi.common.ExcelSheetUtils;
import com.dqi.vo.DevTeamMemberDetailsVO;

/**
 * This class is reading the data of the Development team from the manual excel
 * sheet.
 * 
 * @author akansha.chaudhary
 *
 */
public class DataCollectionReader {

	public List<DevTeamMemberDetailsVO> readDevTeamData() throws IOException {
		// ------------------------The object of ExcelSheetUtils is used to
		// create a new workbook & sheet.
		ExcelSheetUtils sheetType = new ExcelSheetUtils();
		XSSFWorkbook workbook = sheetType.excelXSSFSheet(Variables.mannualExcelSheetFilePath);
		// Creating new sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		// List of type DevTeamMemberDetailsVO
		List<DevTeamMemberDetailsVO> membersList = new ArrayList<DevTeamMemberDetailsVO>();

		String name = "";

		for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {

			DevTeamMemberDetailsVO devTeamMemberDetailsVO = new DevTeamMemberDetailsVO();// object
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
				// Reading cells
				switch (j) {
				case ApplicationConstants.CELL_ZERO://name 

					devTeamMemberDetailsVO.setSprintName(cell.getStringCellValue());

					if (!cell.getStringCellValue().equals("")) {
						name = cell.getStringCellValue();
						devTeamMemberDetailsVO.setName(name);
					} else
						devTeamMemberDetailsVO.setName(name);

					break;

				case ApplicationConstants.CELL_ONE://jira ticket number
					devTeamMemberDetailsVO.setJiraTicketNo(cell.getStringCellValue());
					break;

				case ApplicationConstants.CELL_TWO:// analysis
					devTeamMemberDetailsVO.setAnalysis((int) cell.getNumericCellValue());
					break;
				case ApplicationConstants.CELL_THREE://Development
					devTeamMemberDetailsVO.setDev((int) cell.getNumericCellValue());
					break;
				case ApplicationConstants.CELL_FOUR:// UT
					devTeamMemberDetailsVO.setUt((int) cell.getNumericCellValue());
					break;
				case ApplicationConstants.CELL_FIVE://Code review
					devTeamMemberDetailsVO.setCodeReview((int) cell.getNumericCellValue());
					break;
				case ApplicationConstants.CELL_SIX://InternalReviewDefects
					devTeamMemberDetailsVO.setInternalReviewDefects((int) cell.getNumericCellValue());
					break;
				case ApplicationConstants.CELL_SEVEN://ExternalReviewDefects
					devTeamMemberDetailsVO.setExternalReviewDefects((int) cell.getNumericCellValue());
					break;
			/*	case ApplicationConstants.CELL_TEN://StoryPoint
					devTeamMemberDetailsVO.setStoryPoint((int) cell.getNumericCellValue());
					break;*/

				default:
					break;
				}

			}

			membersList.add(devTeamMemberDetailsVO);

		}
		
		/* for (DevTeamMemberDetailsVO members : membersList) {
		  
		  System.out.println(members + "\n"); System.out.println(
		  "****************************************************************************************"
		  );
		  
		  } System.out.println();
		 */
		return membersList;

	}
	
	 /* public static void main(String[] args) { try {
	  
	  DataCollectionReader dataCollectionReader = new DataCollectionReader();
	  dataCollectionReader.readDevTeamData();
	  
	  } catch (IOException e) {
	  
	  e.printStackTrace(); } }
	*/
}
