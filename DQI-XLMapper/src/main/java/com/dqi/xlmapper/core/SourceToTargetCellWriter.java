package com.dqi.xlmapper.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dqi.xlmapper.config.model.TabWiseMappingDetails;
import com.dqi.xlmapper.config.model.XLMappingCellDefinition;
import com.dqi.xlmapper.config.model.XLMappingConfigs;
import com.dqi.xlmapper.exception.DQIXLMapperInvalidSheetNameException;

public class SourceToTargetCellWriter {
	private static final Logger logger = Logger.getLogger(SourceToTargetCellWriter.class);
	public static void write(XLMappingConfigs xlmappingConfigs,List<XLMappingCellDefinition> xlmappingCellDefinitionList[]) throws Throwable 
	{	
		String notFoundFile=xlmappingConfigs.getSourceXL();

		try(XSSFWorkbook sourceWorkbook = new XSSFWorkbook(new FileInputStream(new File(xlmappingConfigs.getSourceXL()))))
		{	
			notFoundFile=xlmappingConfigs.getTargetXL();
			try(XSSFWorkbook targetWorkbook = new XSSFWorkbook(new FileInputStream(new File(xlmappingConfigs.getTargetXL()))))
			{
				notFoundFile=null;
				XSSFSheet sourceXLSheet =null;
				XSSFSheet targetXLSheet = null;
				XSSFRow sourceXLRow = null ;
				String sourceXLStringCellValue = null ;
				double sourceXLNumericCellValue = 0.0;
				XSSFRow targetXLRow = null ;


				int listIndex=0;
				for(TabWiseMappingDetails tabWiseMappingDetails : xlmappingConfigs.getTabWiseMappingDetails()) {


					sourceXLSheet = sourceWorkbook.getSheet(tabWiseMappingDetails.getSourceTab());
					targetXLSheet = targetWorkbook.getSheet(tabWiseMappingDetails.getTargetTab());

					if(null != sourceXLSheet && null != targetXLSheet)
					{
						sourceXLRow = null ;
						sourceXLStringCellValue = null ;
						targetXLRow = null ;
						if(xlmappingCellDefinitionList[listIndex]!=null) {
							for(XLMappingCellDefinition xlmappingCellDefinition : xlmappingCellDefinitionList[listIndex]) {

								sourceXLRow = sourceXLSheet.getRow(xlmappingCellDefinition.getSourceRow());
								if(targetXLSheet.getRow(xlmappingCellDefinition.getTargetRow())==null)
									targetXLSheet.createRow(xlmappingCellDefinition.getTargetRow());
								targetXLRow = targetXLSheet.getRow(xlmappingCellDefinition.getTargetRow());
								if("String".equalsIgnoreCase(xlmappingCellDefinition.getValueType())) {
									try {
										sourceXLStringCellValue = sourceXLRow.getCell(xlmappingCellDefinition.getSourceColumn()).getStringCellValue();
										if(targetXLRow.getCell(xlmappingCellDefinition.getTargetColumn())==null)
										{
											targetXLRow.createCell(xlmappingCellDefinition.getTargetColumn());
										}
										targetXLRow.getCell(xlmappingCellDefinition.getTargetColumn()).setCellValue(sourceXLStringCellValue);
									} catch (IllegalStateException e) {
										System.out.println("Error : "+ "Found Numeric value, required String value." );
										throw new IllegalStateException();
										//e.printStackTrace();
									}
								}
								if("NUMERIC".equalsIgnoreCase(xlmappingCellDefinition.getValueType())) {
									try {
										sourceXLNumericCellValue = sourceXLRow.getCell(xlmappingCellDefinition.getSourceColumn()).getNumericCellValue();
										if(targetXLRow.getCell(xlmappingCellDefinition.getTargetColumn())==null)
										{
											targetXLRow.createCell(xlmappingCellDefinition.getTargetColumn());
										}
										targetXLRow.getCell(xlmappingCellDefinition.getTargetColumn()).setCellValue(sourceXLNumericCellValue);
									} catch (IllegalStateException e) {
										System.out.println("Error : "+ "Found String value, required Numeric value." );
										throw new IllegalStateException();
										//e.printStackTrace();
									}
								}
							}
						}
						listIndex++;		
					}
					else
					{
						throw new DQIXLMapperInvalidSheetNameException();
					}
				}	

				try(FileOutputStream fileOutputStream = new FileOutputStream(new File(xlmappingConfigs.getTargetXL())))
				{
					targetWorkbook.write(fileOutputStream);
					System.out.println("Mapping done successfully.");
				}catch(Throwable e)
				{
					System.out.println("Error occurred while writing to "+ new File(xlmappingConfigs.getTargetXL())+". (Please check that the file is not being used by another process.)");
					logger.error("Exception in SourceToTargetCellWriter class ", e);
					throw new Throwable();
				}

			}
		}
		catch(DQIXLMapperInvalidSheetNameException e)
		{
			logger.error("Exception in SourceToTargetCellWriter class ", e);
			throw new DQIXLMapperInvalidSheetNameException();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("The system cannot find "+new File(notFoundFile)+" file.");
			logger.error("Exception in SourceToTargetCellWriter class ", e);
			throw new FileNotFoundException();
		}
		catch(Throwable e)
		{
			logger.error("Exception in SourceToTargetCellWriter class ", e);
			throw new Throwable();
		}
	}
}
