package com.burn.down.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 * 
 * @author priyanka_gupta
 * 
 */
public class ExcelFileReader 
{
/**
 * This function returns HSSFWorkbook object.
 * @param excelFilePath
 * @return getHSSFWorkBook
 */
	public ExcelFileReader() {}
 public HSSFWorkbook get_HSSFWorkbook(String excelFilePath)
 {
	 HSSFWorkbook getHSSFWorkBook=null;
	
	 try(InputStream fis=new FileInputStream(new File(excelFilePath)) )
	 {				
		//Creation of HSSFWorkbook instance that refers to .xls file.
		 getHSSFWorkBook = new HSSFWorkbook(fis);
		  
		
	 }
	 catch(IOException ioe)
	 {
		 System.out.println("Error ouccurred: "+ioe);
	 }
	 catch(Exception e)
	 {
		 System.out.println("Error ouccurred: "+e);
	 }
	 return getHSSFWorkBook;
 }
 
 /**
  * This function returns HSSFSheet object.
  * @param excelFilePath
  * @return getHSSFSheet
  */
 public HSSFSheet get_HSSFSheet(String excelFilePath)
 {
	 HSSFSheet getHSSFSheet=null; 
	 
	//Creation of HSSFSheet instance to retrieve the sheet. 
	 getHSSFSheet = get_HSSFWorkbook(excelFilePath).getSheetAt(0);	
	 return getHSSFSheet;
 }
}

