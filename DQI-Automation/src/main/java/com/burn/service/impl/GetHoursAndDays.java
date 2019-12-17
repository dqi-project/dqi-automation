package com.burn.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import com.burn.down.util.Constant;
import com.burn.down.util.ExcelFileReader;
import com.burn.down.util.Variables;
import com.burn.service.ExcelSheetHoursAndDaysReader;

/**
 * This class reads Days and Hours from Excel Sheet.
 * @author priyanka_gupta
 * 
 */
public class GetHoursAndDays implements ExcelSheetHoursAndDaysReader
{
	/*
	 * Non-parameterized constructor. 
	 */
	public GetHoursAndDays() {}
	
/**
 * 
 * @param excelFilePath
 * @return hoursAndDaysMap
 */
public Map excelReadDaysAndHours(String excelFilePath)
	{
	
	Map<Double, Double> map = new HashMap();
	 
	 double cellValue=0.0;
	 double remainingHours=Variables.plannedEffortsInHours;
	try
	{
		 
	//FormulaEvaluator to evaluate cell type.
      FormulaEvaluator formulaEvaluator = new ExcelFileReader().get_HSSFWorkbook(excelFilePath).
    		                                  getCreationHelper().createFormulaEvaluator(); 
   
      //for-each loop to iterate over the rows and columns.
	 for(Row row: new ExcelFileReader().get_HSSFSheet(excelFilePath) )
	 {
		
	 for(Cell cell:row)
	 {
		
		
		 switch(formulaEvaluator.evaluateInCell(cell).getCellType())
		 {
		 //If cell is a Numeric Format
		 case NUMERIC:
		 { 
			//Inserting Days to Map
			 if(Variables.DayColumnIndexNumber ==cell.getColumnIndex() && row.getCell(cell.getColumnIndex())!=null) 
			 {
				 cellValue=cell.getNumericCellValue();//Get the value of the cell containing Day in Excel sheet as a number.
				 
				 //If there is no key == cell.getNumericCellValue() present in Map 
				 //then create a key-value pair in Map with value=remainingHours.
				  if(map.containsKey(cell.getNumericCellValue())!=true)
				 {
				 map.put(cell.getNumericCellValue(), remainingHours); 
				 }
				
				 System.out.print(cell.getNumericCellValue()+"\t\t ");
			 }
			 
			//Inserting Hours to Map	
		if(Variables.HoursColumnIndexNumber==cell.getColumnIndex() 
				&& null!=row.getCell(Variables.DayColumnIndexNumber) 
				&& null != row.getCell(Variables.HoursColumnIndexNumber)) 
			 {	
				
				 //Iterating Map.
				 Set s=map.entrySet();
				 Iterator itr=s.iterator();
				 while(itr.hasNext())
				 {
					 Map.Entry<Double, Double> m1 = (Map.Entry)itr.next();
					
					  String stringKeyValue = m1.getKey().toString(); 
					  double doubleKeyValue = Double.valueOf(stringKeyValue).doubleValue();
				
						if(doubleKeyValue == cellValue)
					 {	
							remainingHours=remainingHours-cell.getNumericCellValue();	
						    m1.setValue(remainingHours);						  
					 }
				 }
				 
				 System.out.print(cell.getNumericCellValue()+"\t\t\t");
				
			 } 
			 
				 
			 }

		break;
		//If cell is a String Format. 
		 case STRING:
		 {			
			 if(Constant.COLUMN_VALUE_1.equalsIgnoreCase(cell.getStringCellValue()))
			 {
				 Variables.DayColumnIndexNumber=cell.getColumnIndex();//Storing index number of Column conatining Day in Excel Sheet.
			    System.out.print(cell.getStringCellValue()+"\t\t"); 
			 }
			 
			 if(Constant.COLUMN_VALUE_2.equalsIgnoreCase(cell.getStringCellValue()))
			 {
				 Variables.HoursColumnIndexNumber=cell.getColumnIndex();//Storing index number of Column conatining Hours in Excel Sheet.
				System.out.print(cell.getStringCellValue()+"\t\t");				 
			 }
		 }
	     break;
	 } 
		 }
	 System.out.println();
	 }
	  
    }
	
	catch(Exception e)
	{
		System.err.println("Error: "+e);
	}
	
	
	TreeMap hoursAndDaysMap=new TreeMap(map);
	 System.out.println(hoursAndDaysMap);
	 
	 return hoursAndDaysMap;
	}

}

