package com.dqi.jira.request;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.dqi.common.ApplicationPropertiesLoader;

@Configuration
@Component
public class RequestHelper {
	
@Autowired
ApplicationPropertiesLoader propertiesLoader;

	public static SearchRequest getSearchRequestDev(RequestHelper requestHelper) {
		SearchRequest req = new SearchRequest();
		req.setJql(MessageFormat.format(requestHelper.propertiesLoader.getJqlDev(), 
				requestHelper.propertiesLoader.getNames(),
				requestHelper.propertiesLoader.getFromDate(),
				requestHelper.propertiesLoader.getToDate())); 
		  List<String> l = Arrays.asList(requestHelper.propertiesLoader.getFieldsDev().toString().split(","));
		  req.setFields(l);
		 		return req;
	}
	
	
	public static SearchRequest getSearchRequestPS(RequestHelper requestHelper) {
		SearchRequest req = new SearchRequest();
					
		req.setJql(requestHelper.propertiesLoader.getJqlPS());	
		
		List<String> l = Arrays.asList(requestHelper.propertiesLoader.getFieldsPS().toString().split(","));		
		req.setFields(l);
		
		
		return req;
	}

}
