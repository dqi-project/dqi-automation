package com.dqi.xlmapper.process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

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


public void process()
{
	System.out.println(xlmappingConfigs);
	List<XLMappingCellDefinition> rowCells[] = new ArrayList[2];
	rowCells[0]=new ArrayList<XLMappingCellDefinition>();
	rowCells[1]=new ArrayList<XLMappingCellDefinition>();
	
	int i=0;
	
	if(xlmappingConfigs.getTabWiseMappingDetails()!=null) {
		System.out.println("xlmappingConfigs.getTabWiseMappingDetails()= "+xlmappingConfigs.getTabWiseMappingDetails());
		for(SourDestSheet sds : xlmappingConfigs.getTabWiseMappingDetails()) {			
			if(sds.getSrcCellTargetCellTypeMappings()!=null) {
				for(String loc : sds.getSrcCellTargetCellTypeMappings()) {
					rowCells[i].add(XLCoordinatesResolver.resolve(loc));					
				}
				i++;
			}
		}
		}
		
	try {
		SourceToTargetCellWriter.write(xlmappingConfigs, rowCells);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 
	}
}
