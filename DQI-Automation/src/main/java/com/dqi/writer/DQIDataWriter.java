package com.dqi.writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.burn.down.util.Variables;

import com.dqi.vo.BaseMeasuresVO;
import com.dqi.vo.DataCollectionVO;
import com.dqi.vo.QATeamMemberDetailsVO;
import com.dqi.vo.SetupParametersVO;

/**
 * 
 * @author udit.naagar
 *
 */
public class DQIDataWriter {

public static XSSFWorkbook finalworkbook;
/**
 * 
 * @param setupParametersVO
 * @param map
 * @param qAlist
 * @param baseMeasuresVO
 * @throws FileNotFoundException
 */
	public void write( SetupParametersVO setupParametersVO, Map<String, DataCollectionVO> map,List<QATeamMemberDetailsVO> qAlist,BaseMeasuresVO baseMeasuresVO )
			throws FileNotFoundException {

		try {

			XSSFWorkbook workbook = new XSSFWorkbook();

			XSSFSheet sheet = workbook.createSheet("SetUp Parameters");

			XSSFSheet sheet1 = workbook.createSheet("Base Measures");

			XSSFSheet sheet2 = workbook.createSheet("Productivity,TAE,StoryPoints");

			XSSFSheet sheet3 = workbook.createSheet("DataCollection");
			
			XSSFSheet sheet4 = workbook.createSheet("QA Details");	

			// -------------Setup parameters------------------
			
			CellStyle style = workbook.createCellStyle();
			CellStyle style1 = workbook.createCellStyle();
			
			Row datarow = sheet.createRow(0);
			
			datarow.createCell(1).setCellValue("SetUp Parameters");
			Cell cell = datarow.getCell(1);
			cell.setCellValue("SetUp Parameters");
			
			//style 
			style.setFillBackgroundColor(IndexedColors.SKY_BLUE.getIndex());
			style.setFillPattern(FillPatternType.LEAST_DOTS);
		    style.setBorderBottom(BorderStyle.THICK);  
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
            style.setBorderRight(BorderStyle.THICK);  
            style.setRightBorderColor(IndexedColors.BLACK.getIndex());  
            style.setBorderTop(BorderStyle.THICK);  
            style.setTopBorderColor(IndexedColors.BLACK.getIndex());  
		    style.setBorderLeft(BorderStyle.THICK);  
            style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			cell.setCellStyle(style);

			
			//style border
		    style1.setBorderBottom(BorderStyle.THICK);  
            style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());  
            style1.setBorderRight(BorderStyle.THICK);  
            style1.setRightBorderColor(IndexedColors.BLACK.getIndex());  
            style1.setBorderTop(BorderStyle.THICK);  
            style1.setTopBorderColor(IndexedColors.BLACK.getIndex());  
		    style1.setBorderLeft(BorderStyle.THICK);  
            style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			
			
			// setting UserStoryAnalysisAndDesign name
			Row datarow1 = sheet.createRow(3);
			datarow1.createCell(1).setCellValue("UserStoryAnalysisAndDesign");
			Cell cell1 = datarow1.getCell(1);
			cell1.setCellValue("UserStoryAnalysisAndDesign");
		
        	cell1.setCellStyle(style);
        	Cell cella = datarow1.createCell(2);
        	// setting UserStoryAnalysisAndDesign value
			cella.setCellValue(setupParametersVO.getUserStoryAnalysisAndDesign()+"%");
			cella.setCellStyle(style1);
        	
        	// setting Code development name
			Row datarow2 = sheet.createRow(4);
			datarow2.createCell(1).setCellValue("Code development");
			Cell cell2= datarow2.getCell(1);
			cell2.setCellStyle(style);
			
			Cell cell2a = datarow2.createCell(2);
        	// setting Code development value
			cell2a.setCellValue(setupParametersVO.getCodeDevelopment()+"%");
			cell2a.setCellStyle(style1);
        	
        	
        	
			// setting Code Refactoring name
			Row datarow3 = sheet.createRow(5);
			datarow3.createCell(1).setCellValue("Code Refactoring");
			Cell cell3 = datarow3.getCell(1);
			cell3.setCellValue("Code Refactoring");
        	cell3.setCellStyle(style);
        	
        	Cell cell3a = datarow3.createCell(2);
			// setting Code Refactoring value
			cell3a.setCellValue(setupParametersVO.getCodeRefactoring()+"%");
			cell3a.setCellStyle(style1);
        	
			// setting Test case creation name

			Row datarow4 = sheet.createRow(6);
			datarow4.createCell(1).setCellValue("Test case creation");
			Cell cell4 = datarow4.getCell(1);
			
			// setting Test case creation value

			cell4.setCellValue("Test case creation");
        	cell4.setCellStyle(style);
        	
        	

        	Cell cell4a = datarow4.createCell(2);
			cell4a.setCellValue(setupParametersVO.getTestCaseCreation()+"%");
			cell4a.setCellStyle(style1);
			//datarow4.createCell(2).setCellValue(setupParametersVO.getTestCaseCreation());

			//setting Test case review name
			Row datarow5 = sheet.createRow(7);
			datarow5.createCell(1).setCellValue("Test case review");
			Cell cell5 = datarow5.getCell(1);
			cell5.setCellValue("Test case review");
        	cell5.setCellStyle(style);
			

        	Cell cell5a = datarow5.createCell(2);
        	//setting Test case review value
			cell5a.setCellValue(setupParametersVO.getTestCaseReview()+"%");
			cell5a.setCellStyle(style1);
			//datarow5.createCell(2).setCellValue(setupParametersVO.getTestCaseReview());

			Row datarow6 = sheet.createRow(8);
			//setting Manual Testing name
			datarow6.createCell(1).setCellValue("Manual Testing");
			Cell cell6 = datarow6.getCell(1);
			cell6.setCellValue("Manual Testing");
        	cell6.setCellStyle(style);
        	
        	Cell cell6a = datarow6.createCell(2);
        	//setting Manual Testing value
			cell6a.setCellValue(setupParametersVO.getManualTesting()+"%");
			cell6a.setCellStyle(style1);
			//datarow6.createCell(2).setCellValue(setupParametersVO.getManualTesting());

			Row datarow7 = sheet.createRow(9);
			//setting Automation Testing name
			datarow7.createCell(1).setCellValue("Automation Testing");
			Cell cell7 = datarow7.getCell(1);
			cell7.setCellValue("Automation Testing");
        	cell7.setCellStyle(style);
        	
        	Cell cell7a = datarow7.createCell(2);
			//setting Automation Testing value

			cell7a.setCellValue(setupParametersVO.getAutomationTesting()+"%");
			cell7a.setCellStyle(style1);
			//datarow7.createCell(2).setCellValue(setupParametersVO.getAutomationTesting());

			// -------------------Base measures-------------------
			Row datarow9 = sheet1.createRow(0);
			datarow9.createCell(1).setCellValue("Base measures");
			Cell cell9 = datarow9.getCell(1);
			cell9.setCellValue("Base measures");
        	cell9.setCellStyle(style);
			
		
			Row datarow10 = sheet1.createRow(3);
			datarow10.createCell(1).setCellValue("Total no of test case developed");
			Cell cell10 = datarow10.getCell(1);
			cell10.setCellValue("Total no of test case developed");
        	cell10.setCellStyle(style);

        	Cell cell10a = datarow10.createCell(2);
			cell10a.setCellValue(baseMeasuresVO.getTestCasesdeveloped());
			cell10a.setCellStyle(style1);
			
			//datarow10.createCell(2).setCellValue(baseMeasuresVO.getTestCasesdeveloped());

			Row datarow11 = sheet1.createRow(4);

			datarow11.createCell(1).setCellValue("Total no of test Cases reviewed");
			Cell cell11 = datarow11.getCell(1);
			cell11.setCellValue("Total no of test Cases reviewed");
        	cell11.setCellStyle(style);
        	
        	Cell cell11a = datarow11.createCell(2);
			cell11a.setCellValue(baseMeasuresVO.getTestCasesReviewed());
			cell11a.setCellStyle(style1);
			

			Row datarow12 = sheet1.createRow(5);
			datarow12.createCell(1).setCellValue("Total no of Test Cases executed manually");
			
			Cell cell12 = datarow12.getCell(1);
			cell12.setCellValue("Total no of Test Cases executed manually");
        	cell12.setCellStyle(style);
        	

        	Cell cell12a = datarow12.createCell(2);
			cell12a.setCellValue(baseMeasuresVO.getTestCasesexecutedmanually());
			cell12a.setCellStyle(style1);
			
			

			Row datarow13 = sheet1.createRow(6);
			datarow13.createCell(1).setCellValue("Total no of Test Cases executed thru Automation");
			Cell cell13 = datarow13.getCell(1);
			cell13.setCellValue("Total no of Test Cases executed thru Automation");
        	cell13.setCellStyle(style);
			
			

        	Cell cell13a = datarow13.createCell(2);
			cell13a.setCellValue(baseMeasuresVO.getTestCasesexecutedAutomation());
			cell13a.setCellStyle(style1);
			
			
			
			// Tab 3 misc data productivity,TAE, story points

			//setting Total Story Points
			Row datarow14 = sheet2.createRow(0);
			datarow14.createCell(1).setCellValue("Total Story Points");
			Cell cell14 = datarow14.getCell(1);
			cell14.setCellValue("Total Story Points");
        	cell14.setCellStyle(style);
        	

        	Cell cell14a = datarow14.createCell(2);
			cell14a.setCellValue(Variables.dQIStoryPoints);
			cell14a.setCellStyle(style1);
			
			// setting Total Actual Efforts
			Row datarow15 = sheet2.createRow(1);
			datarow15.createCell(1).setCellValue("Total Actual Efforts");
			
			Cell cell15 = datarow15.getCell(1);
			cell15.setCellValue("Total Actual Efforts");
        	cell15.setCellStyle(style);
        	

        	Cell cell15a = datarow15.createCell(2);
			cell15a.setCellValue(setupParametersVO.getTotalactualEfforts());
			cell15a.setCellStyle(style1);
			
			// setting productivity
			Row datarow16 = sheet2.createRow(2);
			datarow16.createCell(1).setCellValue("Productivity");
			
			Cell cell16 = datarow16.getCell(1);
			cell16.setCellValue("Productivity");
        	cell16.setCellStyle(style);
			

        	Cell cell16a = datarow16.createCell(2);
			cell16a.setCellValue(setupParametersVO.getProductivity());
			cell16a.setCellStyle(style1);
			
			// DATA COLLECTION

			Row datarow17 = sheet3.createRow(0);
			
			datarow17.createCell(1).setCellValue("Data Collection");

			Cell cell17 = datarow17.getCell(1);
			cell17.setCellValue("Data Collection");
        	cell17.setCellStyle(style);
			
			datarow17.createCell(4).setCellValue("Names");

			Cell cell18 = datarow17.getCell(4);
			cell18.setCellValue("Names");
        	cell18.setCellStyle(style);
			
			
			//datarow18.createCell(3).setCellValue("User Story & Analysis");
			//datarow18.createCell(4).setCellValue("Code Development");

			int i = 5;
			for (String name : map.keySet()) {
				datarow17 = sheet3.createRow(i++);
				if(name!=null){

				
				 
				 datarow17.createCell(0).setCellValue(Variables.dQISprintNumber);
				 datarow17.getCell(0).setCellStyle(style1);
				 datarow17.createCell(1).setCellValue(Variables.dQIMonthYear);
				 datarow17.getCell(1).setCellStyle(style1);
				 datarow17.createCell(2).setCellValue("Analysis");
				 datarow17.getCell(2).setCellStyle(style1);
				 datarow17.createCell(3).setCellValue("User Story & Analysis");
				 datarow17.getCell(3).setCellStyle(style1);
				 datarow17.createCell(4).setCellValue(name);
				 datarow17.getCell(4).setCellStyle(style1);
				datarow17.createCell(5).setCellValue(map.get(name).getTotalAnalysis());
				 datarow17.getCell(5).setCellStyle(style1);

			}
			}
			

			Row datarowx = sheet3.createRow(15);

			int j = 25;
			for (String name : map.keySet()) {
				datarowx = sheet3.createRow(j++);
				if(name!=null){
				
				
				 
				datarowx.createCell(0).setCellValue(Variables.dQISprintNumber);
				datarowx.getCell(0).setCellStyle(style1);
				 datarowx.createCell(1).setCellValue(Variables.dQIMonthYear);
				 datarowx.getCell(1).setCellStyle(style1);
				 datarowx.createCell(2).setCellValue("Development");
				 datarowx.getCell(2).setCellStyle(style1);
				 datarowx.createCell(3).setCellValue("Code Development");
				 datarowx.getCell(3).setCellStyle(style1);
				 datarowx.createCell(4).setCellValue(name);
				 datarowx.getCell(4).setCellStyle(style1);
				datarowx.createCell(5).setCellValue(map.get(name).getTotalDev());
				datarowx.getCell(5).setCellStyle(style1);

				}
			}
			
			
			// Tab 5 QA Team data for data collection
			
			Row datarow19 = sheet4.createRow(5);
			Row datarow20 = sheet4.createRow(0);
			datarow20.createCell(3).setCellValue("Test Case Creation");
			datarow20.getCell(3).setCellStyle(style);
			int k=6;
			for(QATeamMemberDetailsVO name1:qAlist){
				if(name1.getName()=="")
					
				datarow19=sheet4.createRow(k++);
				 datarow19.createCell(0).setCellValue(Variables.dQISprintNumber);
				 datarow19.getCell(0).setCellStyle(style1);
				 datarow19.createCell(1).setCellValue(Variables.dQIMonthYear);
				 datarow19.getCell(1).setCellStyle(style1);
				datarow19.createCell(2).setCellValue("Test Case Creation");
				 datarow19.getCell(2).setCellStyle(style1);
				datarow19.createCell(3).setCellValue("Test Case Creation");
				 datarow19.getCell(3).setCellStyle(style1);
				datarow19.createCell(4).setCellValue(name1.getName());
				 datarow19.getCell(4).setCellStyle(style1);
				datarow19.createCell(5).setCellValue(name1.getTestCaseCreationEfforts());
				 datarow19.getCell(5).setCellStyle(style1);
			
			}
			
				Row datarow21 = sheet4.createRow(20);
				Row datarow21a = sheet4.createRow(18);
				datarow21a.createCell(3).setCellValue("Test Case review");
				datarow21a.getCell(3).setCellStyle(style);
				
				int l=21;
				for(QATeamMemberDetailsVO name2:qAlist){
					if(name2.getName()=="" )
					datarow21=sheet4.createRow(l++);
					datarow21.createCell(0).setCellValue(Variables.dQISprintNumber);
					 datarow21.getCell(0).setCellStyle(style1);
					datarow21.createCell(1).setCellValue(Variables.dQIMonthYear);
					 datarow21.getCell(1).setCellStyle(style1);
					datarow21.createCell(2).setCellValue("Test Case review");
					 datarow21.getCell(2).setCellStyle(style1);
					datarow21.createCell(3).setCellValue("Test Case review");
					 datarow21.getCell(3).setCellStyle(style1);
					datarow21.createCell(4).setCellValue(name2.getName());
					 datarow21.getCell(4).setCellStyle(style1);
					datarow21.createCell(5).setCellValue(name2.getTestCaseReviewEfforts());
					 datarow21.getCell(5).setCellStyle(style1);
					
			}
			
			
				Row datarow23 = sheet4.createRow(35);
				Row datarow23a = sheet4.createRow(33);
				datarow23a.createCell(3).setCellValue("Manual Testing");

				datarow23a.getCell(3).setCellStyle(style);
				int m=36;
				for(QATeamMemberDetailsVO name3:qAlist){
					if(name3.getName()=="")
						
						datarow23=sheet4.createRow(m++);
					
					datarow23.createCell(0).setCellValue(Variables.dQISprintNumber);
					datarow23.getCell(0).setCellStyle(style1);
					datarow23.createCell(1).setCellValue(Variables.dQIMonthYear);
					datarow23.getCell(1).setCellStyle(style1);
					datarow23.createCell(2).setCellValue("Manual Testing");
					datarow23.getCell(2).setCellStyle(style1);
					datarow23.createCell(3).setCellValue("Manual Testing");
					datarow23.getCell(3).setCellStyle(style1);
					datarow23.createCell(4).setCellValue(name3.getName());
					datarow23.getCell(4).setCellStyle(style1);
					datarow23.createCell(5).setCellValue(name3.getManualTestingEfforts());
					datarow23.getCell(5).setCellStyle(style1);
			}
				
				Row datarow25 = sheet4.createRow(50);
				Row datarow25a = sheet4.createRow(48);
				datarow25a.createCell(3).setCellValue("Automation Testing");

				datarow25a.getCell(3).setCellStyle(style);

				int n=51;
				
				for(QATeamMemberDetailsVO name4:qAlist){
					if(name4.getName()=="")
						
						datarow25=sheet4.createRow(n++);
					datarow25.createCell(0).setCellValue(Variables.dQISprintNumber);
					datarow25.getCell(0).setCellStyle(style1);
					datarow25.createCell(1).setCellValue(Variables.dQIMonthYear);
					datarow25.getCell(1).setCellStyle(style1);
					datarow25.createCell(2).setCellValue("Automation Testing");
					datarow25.getCell(2).setCellStyle(style1);
					datarow25.createCell(3).setCellValue("Automation Testing");
					datarow25.getCell(3).setCellStyle(style1);
					datarow25.createCell(4).setCellValue(name4.getName());
					datarow25.getCell(4).setCellStyle(style1);
					datarow25.createCell(5).setCellValue(name4.getAutomationTestingEfforts());
					datarow25.getCell(5).setCellStyle(style1);
			}
			
		// file write
			FileOutputStream outputStream = new FileOutputStream(Variables.finalSheetPath+".xlsx");
			workbook.write(outputStream);

			finalworkbook = workbook;
			System.out.println();
			workbook.close();
			outputStream.close();

			System.out.println("**************DATA WRITTEN Successfully****************");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
/*
	public static void main(String[] args) throws FileNotFoundException, IOException {
		DQIDataWriter dQIDataWriter = new DQIDataWriter();

		SetupParametersCalculator setupParametersCalculator = new SetupParametersCalculator();

		DevTeamDataAggregator devTeamDataAggregator = new DevTeamDataAggregator();
		ManualDevTeamDataReader devTeamDataReader = new ManualDevTeamDataReader();
		BaseMeasuresCalculator baseMeasuresCalculator = new 		BaseMeasuresCalculator();
		QATeamDataAggregator qATeamDataAggregator = new QATeamDataAggregator();
		QATeamDataReader qATeamDataReader = new QATeamDataReader();

		DataCollectionCompute dataCollection = new DataCollectionCompute();

		dQIDataWriter.write(
				setupParametersCalculator.calculateSetupParameters(
						devTeamDataAggregator.aggregateDevTeamData(devTeamDataReader.readDevTeamData()),
						qATeamDataAggregator.aggregateQATeamData(qATeamDataReader.readQaTeamData())),
				dataCollection.aggregateDevTeam(devTeamDataReader.readDevTeamData()),qATeamDataReader.readQaTeamData(),
				baseMeasuresCalculator.calculateBaseMeasures(qATeamDataAggregator.aggregateQATeamData
						(qATeamDataReader.readQaTeamData())));
	}*/

}
