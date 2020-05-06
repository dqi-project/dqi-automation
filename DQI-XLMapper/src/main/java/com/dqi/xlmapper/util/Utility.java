//package com.dqi.xlmapper.util;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.dqi.xlmapper.config.model.SourDestSheet;
//import com.dqi.xlmapper.config.model.XLMappingCellDefinition;
//import com.dqi.xlmapper.config.model.XLMappingConfigs;
//
//
//
//public class Utility {
//	public static XLMappingCellDefinition getRowCol(String rowColType) {
//		XLMappingCellDefinition rc = new XLMappingCellDefinition();
//		String s = rowColType;
//		s = s.toUpperCase();
//		System.out.println(s);
//		String ars[] = s.split("~");
//		char soucArr[] = ars[0].toCharArray();
//		int col = 0;
//		int tCol = 0;
//		int row = 0;
//		int tRow = 0;
//		for (char ch : soucArr) {
//
//			if (Character.isLetter(ch)) {
//				tCol = tCol * 26;
//				int chr = ch - 64;
//				tCol = tCol + chr;
//			} else if (Character.isDigit(ch)) {
//				tRow = tRow * 10;
//				int dig = ch - 48;
//				tRow = tRow + dig;
//				// System.out.println(dig);
//			}
//
//		}
//		col = tCol - 1;
//		row = tRow - 1;
//		rc.setSourceColumn(col);
//		rc.setSourRow(row);
//		// System.out.println("col : "+col );
//		// System.out.println("row : "+row );
//
//		////////////////////
//		char destArr[] = ars[1].toCharArray();
//		col = 0;
//		tCol = 0;
//		row = 0;
//		tRow = 0;
//		for (char ch : destArr) {
//
//			if (Character.isLetter(ch)) {
//				tCol = tCol * 26;
//				int chr = ch - 64;
//				tCol = tCol + chr;
//			} else if (Character.isDigit(ch)) {
//				tRow = tRow * 10;
//				int dig = ch - 48;
//				tRow = tRow + dig;
//				// System.out.println(dig);
//			}
//
//		}
//		col = tCol - 1;
//		row = tRow - 1;
//		rc.setTargetColumn(col);
//		rc.setDestRow(row);
//		// System.out.println("col : "+col );
//		// System.out.println("row : "+row );
//		rc.setValueType(ars[2]);
//		return rc;
//	}
//
//	public static boolean CopyExcel(XLMappingConfigs xlmappingConfigs,List<XLMappingCellDefinition> xlmappingcelldefinitionList) throws IOException {
//		String destFile = xlmappingConfigs.getTargetXL();
//		String sourFile = xlmappingConfigs.getSourceXL();
//		
//		//File inputFile = new File("C:\\Users\\abhisheksinghk\\Desktop\\Hcldoc\\S2Result.xlsx");
//		File sourInputFile = new File(sourFile);
//		FileInputStream sourfis = new FileInputStream(sourInputFile);
//		XSSFWorkbook sourWorkbook = new XSSFWorkbook(sourfis);
//		
//		//File outputFile = new File(
////				"C:\\Users\\abhisheksinghk\\Desktop\\Hcldoc\\IDM_Data_Collection_Symantec_Dev_Capacity.xlsm");
//		File destOutputFile = new File(destFile);
//		FileInputStream destfis = new FileInputStream(destOutputFile);
//		XSSFWorkbook destWorkbook = new XSSFWorkbook(destfis);
//		
//		//logic
//		String destSheet =null;
//		String sourSheet =null;
//		XSSFSheet sourXSSFSheet =null;
//		XSSFSheet destXSSFSheet = null;
//		XSSFRow sourRow = null ;
//		String sourStrCell = null ;
//		double sourIntCell = 0;
//		XSSFRow destRow = null ;
//		String destCell = null ;
//		for(SourDestSheet sds : xlmappingConfigs.getTabWiseMappingDetails()) {
//			 destSheet = sds.getTargetTab();
//			 sourSheet = sds.getSourceTab();
//			// List<XLMappingCellDefinition> rowCells =sds.getRowCells();
//		
//			 List<XLMappingCellDefinition> rowCells = xlmappingcelldefinitionList;
//			 sourXSSFSheet = sourWorkbook.getSheet(sourSheet);
//			 destXSSFSheet = destWorkbook.getSheet(destSheet);
//			 sourRow = null ;
//			 sourStrCell = null ;
//			 destRow = null ;
//			 destCell = null ;
//			 if(rowCells!=null) {
//				 for(XLMappingCellDefinition rowCell : rowCells) {
//					 
//					  sourRow = sourXSSFSheet.getRow(rowCell.getSourRow());
//					  if(destXSSFSheet.getRow(rowCell.getDestRow())==null)
//						  destXSSFSheet.createRow(rowCell.getDestRow());
//					 destRow = destXSSFSheet.getRow(rowCell.getDestRow());
//					 System.out.println("Row : "+rowCell.getSourRow()+", cell : "+rowCell.getSourceColumn()+", type : "+rowCell.getValueType()+", sourSheet : "+sourSheet);
//					  if("String".equalsIgnoreCase(rowCell.getValueType())) {
//						  try {
//								sourStrCell = sourRow.getCell(rowCell.getSourceColumn()).getStringCellValue();
//								if(destRow.getCell(rowCell.getTargetColumn())==null)
//								{
//									destRow.createCell(rowCell.getTargetColumn());
//								}
//							  destRow.getCell(rowCell.getTargetColumn()).setCellValue(sourStrCell);
//						} catch (Exception e) {
//							System.out.println("Error : "+e );
//							e.printStackTrace();
//						}
//					  }
//					  if("NUMERIC".equalsIgnoreCase(rowCell.getValueType())) {
//					  try {
//						  System.err.println("rowCell.getSourceColumn()= "+rowCell.getSourceColumn());
//						  System.err.println("sourRow.getCell(rowCell.getSourceColumn()).getStringCellValue()= "+sourRow.getCell(rowCell.getSourceColumn()).getNumericCellValue());
//						  sourIntCell = sourRow.getCell(rowCell.getSourceColumn()).getNumericCellValue();
//							if(destRow.getCell(rowCell.getTargetColumn())==null)
//							{
//								destRow.createCell(rowCell.getTargetColumn());
//							}
//						  destRow.getCell(rowCell.getTargetColumn()).setCellValue(sourIntCell);
//					} catch (Exception e) {
//						System.out.println("Error : "+e );
//						e.printStackTrace();
//					}
//				  }
//				 }
//			 }
//			
//		}
//		destfis.close();
//		sourfis.close();
//		FileOutputStream destfos = new FileOutputStream(destOutputFile);
//		destWorkbook.write(destfos);
//
//		destfos.close();
////		XSSFSheet setUpXSSFSheet = sourWorkbook.getSheet("SetUp Parameters");
////		XSSFRow row5 = sourXSSFSheet.getRow(4);
////		String str = row5.getCell(2).getStringCellValue();
////		
////		
////		XSSFSheet setUpXSSFSheet1 = destWorkbook.getSheet("Setup Parameters");
////		XSSFRow row17 = destXSSFSheet.getRow(16);
////		row17.getCell(2).setCellValue(str);
////		 File outputFile1=new
////		 File("C:\\Users\\abhisheksinghk\\Desktop\\Hcldoc\\IDM_Data_Collection_Symantec_Dev_Capacity1.xlsm");
//
//		return true;
//	}
//}
