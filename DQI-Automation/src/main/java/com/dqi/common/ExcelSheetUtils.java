package com.dqi.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.burndown.util.DQIVariables;

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

	private static final Logger logger = Logger.getLogger(ExcelSheetUtils.class);

	public XSSFWorkbook excelXSSFSheet(String file) {
		XSSFWorkbook workbook1 = null;

		// creating file
		File fileName1 = new File(file);

		try (FileInputStream file1 = new FileInputStream(fileName1)) {
			// XSSFWorkbook for .xlsx format
			workbook1 = new XSSFWorkbook(file1);

		} catch (FileNotFoundException e) {
	//		DQIVariables.getInstance().setFileNotFound(true);
			DQIVariables.getInstance().setFileName(fileName1.getName());
			logger.error("file not found", e);
		} catch (Exception e) {
	//		DQIVariables.getInstance().setExceptionOccurred(true);
			DQIVariables.getInstance().setFileName(fileName1.getName());
			logger.error("file not found", e);
		}
		return workbook1;

	}

	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public HSSFWorkbook excelHSSFSheet(String file) {
		// creating file
		File fileName2 = new File(file);
		HSSFWorkbook workbook2 = null;
		try (FileInputStream file2 = new FileInputStream(fileName2)) {
			// HSSFWorkbook for .xls format
			workbook2 = new HSSFWorkbook(file2);

		} catch (FileNotFoundException e) {
		//	DQIVariables.getInstance().setFileNotFound(true);
			DQIVariables.getInstance().setFileName(fileName2.getName());
			logger.error("file not found", e);
		} catch (Exception e) {
		//	DQIVariables.getInstance().setExceptionOccurred(true);
			DQIVariables.getInstance().setFileName(fileName2.getName());
			logger.error("file not found", e);
		}
		return workbook2;

	}

}
