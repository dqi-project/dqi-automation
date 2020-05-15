package com.dqi.xlmapper.config.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class XLMappingConfigs {
	
	String sourceXL;
	String targetXL;
	List<TabWiseMappingDetails> tabWiseMappingDetails = new ArrayList<>();
	
	public String getSourceXL() {
		return sourceXL;
	}
	public void setSourceXL(String sourceXL) {
		this.sourceXL = sourceXL;
	}
	public String getTargetXL() {
		return targetXL;
	}
	public void setTargetXL(String targetXL) {
		this.targetXL = targetXL;
	}
	
	public List<TabWiseMappingDetails> getTabWiseMappingDetails() {
		return tabWiseMappingDetails;
	}
	public void setTabWiseMappingDetails(List<TabWiseMappingDetails> tabWiseMappingDetails) {
		this.tabWiseMappingDetails = tabWiseMappingDetails;
	}
	@Override
	public String toString() {
		return "XLMappingConfigs [sourceXL=" + sourceXL + ", targetXL=" + targetXL + ", tabWiseMappingDetails="
				+ tabWiseMappingDetails + "]";
	}	
}

