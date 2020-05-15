package com.dqi.xlmapper.process;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.dqi.xlmapper.config.model.TabWiseMappingDetails;
import com.dqi.xlmapper.config.model.XLMappingCellDefinition;
import com.dqi.xlmapper.config.model.XLMappingConfigs;
import com.dqi.xlmapper.core.SourceToTargetCellWriter;
import com.dqi.xlmapper.core.XLCoordinatesResolver;


@Component
@Configuration

public class XLMapperProcessor {
@Autowired
XLMappingConfigs xlmappingConfigs;

public void process(String filePath) 
{			
	try (final InputStream in = new FileInputStream(new File(filePath)))
	{
		    final Yaml yaml = new Yaml(new Constructor(XLMappingConfigs.class));
		    xlmappingConfigs=(XLMappingConfigs) yaml.load(in);
	
	List<XLMappingCellDefinition> xlmappingCellDefinitionListArray[] = new ArrayList[2];
	xlmappingCellDefinitionListArray[0]=new ArrayList<XLMappingCellDefinition>();
	xlmappingCellDefinitionListArray[1]=new ArrayList<XLMappingCellDefinition>();
	
	int arrayIndex=0;
	
	if(xlmappingConfigs.getTabWiseMappingDetails()!=null) {
		for(TabWiseMappingDetails tabWiseMappingDetails : xlmappingConfigs.getTabWiseMappingDetails()) {			
			if(tabWiseMappingDetails.getSrcCellTargetCellTypeMappings()!=null) {
				for(String srcCellTargetCellTypeMappings : tabWiseMappingDetails.getSrcCellTargetCellTypeMappings()) {
					xlmappingCellDefinitionListArray[arrayIndex].add(XLCoordinatesResolver.resolve(srcCellTargetCellTypeMappings));					
				}
				arrayIndex++;
			}
		}
		}
		
	//Writing to the target excel sheet.
		SourceToTargetCellWriter.write(xlmappingConfigs, xlmappingCellDefinitionListArray);	
	}
	catch(IllegalStateException e)
	{
		System.out.println("Error occurred. Please check if .yaml file data or excel sheet's data is correct, try again.");
	}
	catch(NullPointerException e)
	{
		System.out.println("Error occurred. Please check if .yaml file data or excel sheet's data is correct, try again.");
		//e.printStackTrace();
	}
	catch(Throwable e)
	{
		System.out.println("An error occurred. Please try again.");
	}
	}
}
