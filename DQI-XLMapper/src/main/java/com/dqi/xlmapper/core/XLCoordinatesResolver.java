package com.dqi.xlmapper.core;

import com.dqi.xlmapper.config.model.XLMappingCellDefinition;



public class XLCoordinatesResolver {
public static XLMappingCellDefinition resolve(String rowColType)
{
	XLMappingCellDefinition xlmappingCellDefinition = new XLMappingCellDefinition();
	String s = rowColType;
	s = s.toUpperCase();
	System.out.println(s);
	String ars[] = s.split("~");
	char soucArr[] = ars[0].toCharArray();
	int col = 0;
	int tCol = 0;
	int row = 0;
	int tRow = 0;
	for (char ch : soucArr) {

		if (Character.isLetter(ch)) {
			tCol = tCol * 26;
			int chr = ch - 64;
			tCol = tCol + chr;
		} else if (Character.isDigit(ch)) {
			tRow = tRow * 10;
			int dig = ch - 48;
			tRow = tRow + dig;
			// System.out.println(dig);
		}

	}
	col = tCol - 1;
	row = tRow - 1;
	xlmappingCellDefinition.setSourceColumn(col);
	xlmappingCellDefinition.setSourRow(row);
	// System.out.println("col : "+col );
	// System.out.println("row : "+row );

	////////////////////
	char destArr[] = ars[1].toCharArray();
	col = 0;
	tCol = 0;
	row = 0;
	tRow = 0;
	for (char ch : destArr) {

		if (Character.isLetter(ch)) {
			tCol = tCol * 26;
			int chr = ch - 64;
			tCol = tCol + chr;
		} else if (Character.isDigit(ch)) {
			tRow = tRow * 10;
			int dig = ch - 48;
			tRow = tRow + dig;
			// System.out.println(dig);
		}

	}
	col = tCol - 1;
	row = tRow - 1;
	xlmappingCellDefinition.setTargetColumn(col);
	xlmappingCellDefinition.setDestRow(row);
	// System.out.println("col : "+col );
	// System.out.println("row : "+row );
	xlmappingCellDefinition.setValueType(ars[2]);
	return xlmappingCellDefinition;
}
}
