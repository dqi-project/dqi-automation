package com.dqi.xlmapper.config.model;


public class XLMappingCellDefinition{
	int sourceRow;
	int targetRow;
	int sourceColumn;
	int targetColumn;
	String valueType;
	
	
	
	public int getSourceRow() {
		return sourceRow;
	}
	public void setSourceRow(int sourceRow) {
		this.sourceRow = sourceRow;
	}
	public int getTargetRow() {
		return targetRow;
	}
	public void setTargetRow(int targetRow) {
		this.targetRow = targetRow;
	}
	public int getSourceColumn() {
		return sourceColumn;
	}
	public void setSourceColumn(int sourceColumn) {
		this.sourceColumn = sourceColumn;
	}
	public int getTargetColumn() {
		return targetColumn;
	}
	public void setTargetColumn(int targetColumn) {
		this.targetColumn = targetColumn;
	}
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	@Override
	public String toString() {
		return "XLMappingCellDefinition [sourceRow=" + sourceRow + ", targetRow=" + targetRow + ", sourceColumn="
				+ sourceColumn + ", targetColumn=" + targetColumn + ", valueType=" + valueType + "]";
	}
	
	
	
}

