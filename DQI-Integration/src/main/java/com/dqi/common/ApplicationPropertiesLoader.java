package com.dqi.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@PropertySource("file:/C:/WS/dqi-integration.properties")
@Component
public class ApplicationPropertiesLoader
{
	@Value( "${baseURL}" )
	String baseURL;
	
	@Value( "${apiUrl}" )
	String apiUrl;
	
	@Value( "${apiUrlPS}" )
	String apiUrlPS;
	
	@Value( "${jqlDev}" )
    String jqlDev;
	
	@Value("${names}")
	String names;
	
	@Value("${fromDate}")
	String fromDate;
	
	@Value("${toDate}")
	String toDate;
	
	@Value( "${fieldsDev}" )
    String fieldsDev;
	
	@Value( "${jqlPS}" )
	String jqlPS;
	
	@Value( "${fieldsPs}" )
	String fieldsPS;
	
	@Value( "${jqlOnsite}" )
	String jqlOnsite;
	
	@Value( "${fieldsOnsite}" )
	String fieldsOnsite;
}
