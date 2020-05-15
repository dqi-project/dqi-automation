package com.dqi.xlmapper.process;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

public void process(String filePath) throws Throwable 
{			
	try (final InputStream inputStream = new FileInputStream(new File(filePath)))
	{
		XLMappingConfigs xlmappingConfigs=(XLMappingConfigs) new Yaml(new Constructor(XLMappingConfigs.class)).load(inputStream);
	
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
	catch(FileNotFoundException e)
	{
		throw new FileNotFoundException();
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
		throw new Throwable();
	}
	}
}
