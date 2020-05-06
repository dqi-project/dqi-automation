package com.dqi.xlmapper.config.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "xlmappingconfigs")
public class XLMappingConfigs {
	
	String sourceXL;	
	String targetXL;	
	List<SourDestSheet> tabWiseMappingDetails = new ArrayList<>();
	
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
	
	
	public List<SourDestSheet> getTabWiseMappingDetails() {
		return tabWiseMappingDetails;
	}
	public void setTabWiseMappingDetails(List<SourDestSheet> tabWiseMappingDetails) {
		this.tabWiseMappingDetails = tabWiseMappingDetails;
	}
	@Override
	public String toString() {
		return "XLMappingConfigs [sourceXL=" + sourceXL + ", targetXL=" + targetXL + ", tabWiseMappingDetails="
				+ tabWiseMappingDetails + "]";
	}
	
	
}

