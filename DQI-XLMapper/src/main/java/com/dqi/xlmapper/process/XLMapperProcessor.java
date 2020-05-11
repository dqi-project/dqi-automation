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

import com.dqi.xlmapper.config.model.SourDestSheet;
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
	
	List<XLMappingCellDefinition> rowCells[] = new ArrayList[2];
	rowCells[0]=new ArrayList<XLMappingCellDefinition>();
	rowCells[1]=new ArrayList<XLMappingCellDefinition>();
	
	int i=0;
	
	if(xlmappingConfigs.getTabWiseMappingDetails()!=null) {
		for(SourDestSheet sds : xlmappingConfigs.getTabWiseMappingDetails()) {			
			if(sds.getSrcCellTargetCellTypeMappings()!=null) {
				for(String loc : sds.getSrcCellTargetCellTypeMappings()) {
					rowCells[i].add(XLCoordinatesResolver.resolve(loc));					
				}
				i++;
			}
		}
		}
		
	//Writing to the target excel sheet.
		SourceToTargetCellWriter.write(xlmappingConfigs, rowCells);	
	}
	catch (Throwable e) {
		
		e.printStackTrace();
	}
	}
}
