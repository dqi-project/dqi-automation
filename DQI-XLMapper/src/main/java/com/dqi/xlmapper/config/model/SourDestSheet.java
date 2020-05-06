package com.dqi.xlmapper.config.model;

import java.util.ArrayList;
import java.util.List;

public class SourDestSheet {
	String sourceTab ;
	String targetTab;
	List<String> srcCellTargetCellTypeMappings = new ArrayList<>();
	
	public String getSourceTab() {
		return sourceTab;
	}
	public void setSourceTab(String sourceTab) {
		this.sourceTab = sourceTab;
	}
	public String getTargetTab() {
		return targetTab;
	}
	public void setTargetTab(String targetTab) {
		this.targetTab = targetTab;
	}
	
	public List<String> getSrcCellTargetCellTypeMappings() {
		return srcCellTargetCellTypeMappings;
	}
	public void setSrcCellTargetCellTypeMappings(List<String> srcCellTargetCellTypeMappings) {
		this.srcCellTargetCellTypeMappings = srcCellTargetCellTypeMappings;
	}	

	@Override
	public String toString() {
		return "SourDestSheet [sourceTab=" + sourceTab + ", targetTab=" + targetTab + ", srcCellTargetCellTypeMappings="
				+ srcCellTargetCellTypeMappings + "]";
	}
	
	
}
