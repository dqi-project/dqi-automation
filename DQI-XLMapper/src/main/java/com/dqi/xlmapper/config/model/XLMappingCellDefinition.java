package com.dqi.xlmapper.config.model;


public class XLMappingCellDefinition{
	int sourRow;
	int destRow;
	int sourceColumn;
	int targetColumn;
	String valueType;
	
	public int getSourRow() {
		return sourRow;
	}
	public void setSourRow(int sourRow) {
		this.sourRow = sourRow;
	}
	public int getDestRow() {
		return destRow;
	}
	public void setDestRow(int destRow) {
		this.destRow = destRow;
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
		return "XLMappingCellDefinition [sourRow=" + sourRow + ", destRow=" + destRow + ", sourceColumn=" + sourceColumn
				+ ", targetColumn=" + targetColumn + ", valueType=" + valueType + "]";
	}
	
	
}

