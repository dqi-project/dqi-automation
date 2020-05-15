package com.dqi.xlmapper.core;

import com.dqi.xlmapper.config.model.XLMappingCellDefinition;

public class XLCoordinatesResolver {
public static XLMappingCellDefinition resolve(String srcCellTargetCellTypeMappings)
{
	XLMappingCellDefinition xlmappingCellDefinition = new XLMappingCellDefinition();
	srcCellTargetCellTypeMappings = srcCellTargetCellTypeMappings.toUpperCase();
	System.out.println(srcCellTargetCellTypeMappings);
	String srcCellTargetCellTypeMappingsArray[] = srcCellTargetCellTypeMappings.split("~");
	char srcSheetCellMappingArray[] = srcCellTargetCellTypeMappingsArray[0].toCharArray();
	
	int rowNum = 0;
	int columnNum = 0;
	for (char arrayValue : srcSheetCellMappingArray) {

		if (Character.isLetter(arrayValue)) {		
			columnNum = (columnNum * 26) + (arrayValue - 64);
			
		} else if (Character.isDigit(arrayValue)) {
			rowNum = (rowNum * 10) + (arrayValue - 48);
		}

	}
	xlmappingCellDefinition.setSourceColumn(columnNum - 1);
	xlmappingCellDefinition.setSourceRow(rowNum - 1);


	////////////////////
	char targetSheetCellMappingArray[] = srcCellTargetCellTypeMappingsArray[1].toCharArray();

	columnNum = 0;
	rowNum = 0;
	for (char arrayValue : targetSheetCellMappingArray) {

		if (Character.isLetter(arrayValue)) {
			columnNum = (columnNum * 26) + (arrayValue - 64);
		} else if (Character.isDigit(arrayValue)) {
			rowNum = (rowNum * 10) + (arrayValue - 48);
		}

	}
	
	xlmappingCellDefinition.setTargetColumn(columnNum - 1);
	xlmappingCellDefinition.setTargetRow(rowNum - 1);
	
	xlmappingCellDefinition.setValueType(srcCellTargetCellTypeMappingsArray[2]);
	return xlmappingCellDefinition;
}
}
