package com.burndown.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;

/**
 * 
 * @author priyanka_gupta
 * 
 */
public class ExcelFileReader {
	private static final Logger logger = Logger.getLogger(ExcelFileReader.class);

	/**
	 * Non-parameterized constructor.
	 */
	public ExcelFileReader() {
	}

	/**
	 * This function returns HSSFWorkbook object.
	 * 
	 * @param excelFilePath
	 * @return getHSSFWorkBook
	 * @throws Exception 
	 */
	public HSSFWorkbook get_HSSFWorkbook(String excelFilePath) throws Exception

	{

		HSSFWorkbook getHSSFWorkBook = null;

		try (InputStream fis = new FileInputStream(new File(excelFilePath))) {
			// Creation of HSSFWorkbook instance that refers to .xls file.
			getHSSFWorkBook = new HSSFWorkbook(fis);

		}catch (OfficeXmlFileException e) {		
			
			logger.error("Excel sheet is not valid", e);
			throw new OfficeXmlFileException(Constant.BURN_DOWN_CHART_EXCEPTION_MESSAGE);
		} 
		catch (IOException e) {		
			logger.error("File not found", e);
			throw new IOException();
		} catch (Exception e) {
			
			logger.error("Error Occured", e);
			throw new Exception();
		}
		return getHSSFWorkBook;
	}

	/**
	 * This function returns HSSFSheet object.
	 * 
	 * @param excelFilePath
	 * @return getHSSFSheet
	 * @throws Exception 
	 */
	public HSSFSheet get_HSSFSheet(String excelFilePath) throws Exception {
		HSSFSheet getHSSFSheet = null;
		try {
			// Creation of HSSFSheet instance to retrieve the sheet.
			getHSSFSheet = get_HSSFWorkbook(excelFilePath).getSheetAt(0);
		} catch (Exception e) {
			logger.error("Error Occured", e);
			throw new Exception();
		}
		return getHSSFSheet;
	}
}
