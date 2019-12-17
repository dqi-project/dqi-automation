package com.dqi.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * This class has methods for creating HSSF and XSSF workbook sheets. Which are
 * used in reader classes contained in com.dqi reader package.
 * 
 * 
 * @author akansha.chaudhary
 * 
 * 
 */
public class ExcelSheetUtils {
/**
 * 
 * @param file
 * @return
 * @throws IOException
 */
	public XSSFWorkbook excelXSSFSheet(String file) throws IOException {
// creating file
		File fileName1 = new File(file);

		try (FileInputStream file1 = new FileInputStream(fileName1)) {
			//XSSFWorkbook for .xlsx format
			XSSFWorkbook workbook1 = new XSSFWorkbook(file1);

			return workbook1;

		}

	}
/**
 * 
 * @param file
 * @return
 * @throws IOException
 */
	public HSSFWorkbook excelHSSFSheet(String file) throws IOException {
		// creating file
		File fileName2 = new File(file);

		try (FileInputStream file2 = new FileInputStream(fileName2)) {
			//HSSFWorkbook for .xls format
			HSSFWorkbook workbook2 = new HSSFWorkbook(file2);
			return workbook2;
		}

	}

}
