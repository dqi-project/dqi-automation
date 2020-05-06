package com.dqi.xlmapper.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.dqi.xlmapper.config.model.XLMappingCellDefinition;

@Component
public class CopyExcelToExcel {
	/*
	 * public static void main(String[] args) throws IOException { new
	 * CopyExcelToExcel().CopyExcel(); }
	 */
	
//	public static void main(String[] args) {
//		CopyExcelToExcel obj = new CopyExcelToExcel();
//		String s= "bb49~S11~String";
//		RowCell rc= Utility.getRowCol(s);
//		System.out.println(rc);
//	}
	
	
	/*
	 * public void CopyExcel() throws IOException {
	 * 
	 * File inputFile=new
	 * File("C:\\Users\\abhisheksinghk\\Desktop\\Hcldoc\\S2Result.xlsx");
	 * FileInputStream fis=new FileInputStream(inputFile); XSSFWorkbook
	 * inputWorkbook=new XSSFWorkbook(fis); XSSFSheet setUpXSSFSheet =
	 * inputWorkbook.getSheet("SetUp Parameters"); XSSFRow row5 =
	 * setUpXSSFSheet.getRow(4); String str = row5.getCell(2).getStringCellValue();
	 * XSSFRow row7 = setUpXSSFSheet.getRow(6); String str2 =
	 * row7.getCell(2).getStringCellValue(); File outputFile=new File(
	 * "C:\\Users\\abhisheksinghk\\Desktop\\Hcldoc\\IDM_Data_Collection_Symantec_Dev_Capacity.xlsm"
	 * ); // FileOutputStream fos=new FileOutputStream(outputFile); FileInputStream
	 * fos=new FileInputStream(outputFile); XSSFWorkbook outputWorkbook=new
	 * XSSFWorkbook(fos); fos.close(); fis.close(); XSSFSheet setUpXSSFSheet1 =
	 * outputWorkbook.getSheet("Setup Parameters"); XSSFRow row17 =
	 * setUpXSSFSheet1.getRow(16); row17.getCell(2).setCellValue(str);
	 * row17.getCell(2).getStringCellValue();
	 * 
	 * XSSFRow row19 = setUpXSSFSheet1.getRow(18);
	 * row19.getCell(2).setCellValue(str2); row19.getCell(2).getStringCellValue();
	 * //File outputFile1=new File(
	 * "C:\\Users\\abhisheksinghk\\Desktop\\Hcldoc\\IDM_Data_Collection_Symantec_Dev_Capacity1.xlsm"
	 * ); FileOutputStream fos1=new FileOutputStream(outputFile);
	 * outputWorkbook.write(fos1);
	 * 
	 * fos1.close();
	 * 
	 * }
	 */
}
