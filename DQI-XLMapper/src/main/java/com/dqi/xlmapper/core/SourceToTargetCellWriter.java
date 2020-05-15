package com.dqi.xlmapper.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dqi.xlmapper.config.model.TabWiseMappingDetails;
import com.dqi.xlmapper.config.model.XLMappingCellDefinition;
import com.dqi.xlmapper.config.model.XLMappingConfigs;

public class SourceToTargetCellWriter {
public static void write(XLMappingConfigs xlmappingConfigs,List<XLMappingCellDefinition> xlmappingCellDefinitionList[]) throws Throwable 
{	

	try(XSSFWorkbook sourceWorkbook = new XSSFWorkbook(new FileInputStream(new File(xlmappingConfigs.getSourceXL()))))
	{	
	
	try(XSSFWorkbook targetWorkbook = new XSSFWorkbook(new FileInputStream(new File(xlmappingConfigs.getTargetXL()))))
	{
	
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

	try(FileOutputStream fileOutputStream = new FileOutputStream(new File(xlmappingConfigs.getTargetXL())))
	{
	targetWorkbook.write(fileOutputStream);
	}catch(FileNotFoundException e)
	{
		System.out.println(xlmappingConfigs.getTargetXL() + " file not found.");
		throw new Throwable();
	}
	
	}
	}catch(FileNotFoundException e)
	{
		System.out.println(xlmappingConfigs.getSourceXL() + " file not found");
		throw new FileNotFoundException();
	}
	catch(Throwable e)
	{
		throw new Throwable();
	}
}
}
