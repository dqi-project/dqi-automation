package com.dqi.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.burn.down.util.Variables;
import com.dqi.common.ApplicationConstants;
import com.dqi.common.ExcelSheetUtils;
import com.dqi.jira.DevTeamDataReader;
import com.dqi.vo.DevTeamMemberDetailsVO;

/**
 * This class is reading the data of the Development team from the jira excel
 * sheet.
 * 
 * @author akansha.chaudhary
 *
 */
public class JiraDevTeamDataReader implements DevTeamDataReader {

	public List<DevTeamMemberDetailsVO> readDevTeamData() throws IOException {
		// ------------------------The object of ExcelSheetUtils is used to
				// create a new workbook & sheet.
		ExcelSheetUtils sheetType = new ExcelSheetUtils();
		
		

		HSSFWorkbook workbook = sheetType.excelHSSFSheet(Variables.jiraExcelSheetFilePath);
		//creating sheet
		HSSFSheet sheet = workbook.getSheetAt(0);
		// List of type DevTeamMemberDetailsVO
		List<DevTeamMemberDetailsVO> membersList = new ArrayList<DevTeamMemberDetailsVO>();

		for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {

			DevTeamMemberDetailsVO devTeamMemberDetailsVO = new DevTeamMemberDetailsVO();
			//creating row
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}

			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				//creating cell
				Cell cell = row.getCell(j);

				if (cell == null) {
					continue;
				}
				switch (j) {
				case ApplicationConstants.CELL_FIVE://summary
					devTeamMemberDetailsVO.setSummary(cell.getStringCellValue());

					break;
				case ApplicationConstants.CELL_SIX://name
					devTeamMemberDetailsVO.setName(cell.getStringCellValue());
					break;
				case ApplicationConstants.CELL_SEVEN://hours
					devTeamMemberDetailsVO.setHours((int) cell.getNumericCellValue());
					break;

				default:
					break;
				}

			}

			membersList.add(devTeamMemberDetailsVO);

			for (i = 0; i < membersList.size(); i++) {

				if (membersList.get(i).getSummary().startsWith(ApplicationConstants.DEVELOPMENT)|| membersList.get(i).getSummary().startsWith(ApplicationConstants.DEV)) {
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
				} else if (membersList.get(i).getSummary().startsWith(ApplicationConstants.UNITTESTING) ||membersList.get(i).getSummary().startsWith(ApplicationConstants.UT) ) {
					devTeamMemberDetailsVO.setUt(membersList.get(i).getHours());
					devTeamMemberDetailsVO.setDev(0);
					devTeamMemberDetailsVO.setAnalysis(0);
					devTeamMemberDetailsVO.setCodeReview(0);
					
				}else if (membersList.get(i).getSummary().startsWith(ApplicationConstants.CODEREVIEW)) {
					devTeamMemberDetailsVO.setCodeReview(membersList.get(i).getHours());
					devTeamMemberDetailsVO.setDev(0);
					devTeamMemberDetailsVO.setAnalysis(0);
					devTeamMemberDetailsVO.setUt(0);
				
				}
				
			}

		}

		
		 for (DevTeamMemberDetailsVO members : membersList) {
		 
		/* System.out.println("Name1  " + members.getName() + "\t" + "Analysis["
		  + members.getAnalysis() + "]\tDev[" + members.getDev() + "]"+"]\tUt[" + members.getUt() + "]"+"]\tCode Review[" + members.getCodeReview() + "]");
		 System.out.println("\n");*/
		 
		  }
		 

		Map<String, DevTeamMemberDetailsVO> totalByEmployee1 = new HashMap<>();

		for (DevTeamMemberDetailsVO devTeamMemberDetailsVO : membersList) {

			String name = devTeamMemberDetailsVO.getName();
			{

				if (totalByEmployee1.containsKey(name)) {
					DevTeamMemberDetailsVO devTeamMemberDetailsVO1 = totalByEmployee1.get(name);
					devTeamMemberDetailsVO1.setName(name);
					devTeamMemberDetailsVO1
							.setAnalysis(devTeamMemberDetailsVO1.getAnalysis() + devTeamMemberDetailsVO.getAnalysis());
					devTeamMemberDetailsVO1
							.setDev((devTeamMemberDetailsVO1.getDev() + devTeamMemberDetailsVO.getDev()));
					devTeamMemberDetailsVO1.setUt(devTeamMemberDetailsVO1.getUt()+devTeamMemberDetailsVO.getUt());
					devTeamMemberDetailsVO1.setCodeReview(devTeamMemberDetailsVO1.getCodeReview()+devTeamMemberDetailsVO.getCodeReview());
					
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
		
		

		for (String name : totalByEmployee1.keySet()) {
			/*System.out.println("Name2 : [" + name + "] Analysis [" + totalByEmployee1.get(name).getAnalysis()
					+ "] total dev [" + totalByEmployee1.get(name).getDev() + "]  Ut  ["+totalByEmployee1.get(name).getUt()+"]  Code Review ["+totalByEmployee1.get(name).getCodeReview()+"]");
		*/}

		List<DevTeamMemberDetailsVO> jiraDevMemberList = new ArrayList<>(totalByEmployee1.values());
		for (DevTeamMemberDetailsVO data : jiraDevMemberList) {
			/*System.out.println("Name-->" + data.getName() + "  Analysis  [" + data.getAnalysis() + "]" + "   Dev[ "
					+ data.getDev() + "] Ut [ "+data.getUt()+"]  Code Review  ["+data.getCodeReview()+"]\n");
		*/}
	
		System.out.println("\n");
		return jiraDevMemberList;

	}

	/*public static void main(String[] args) throws IOException {

		JiraDevTeamDataReader jiraDevTeamDataReader = new JiraDevTeamDataReader();
		jiraDevTeamDataReader.readDevTeamData();

	}*/

}
