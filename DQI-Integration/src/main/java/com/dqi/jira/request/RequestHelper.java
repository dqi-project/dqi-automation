package com.dqi.jira.request;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages="com.dqi.jira.request")
@Component
public class RequestHelper {
	
@Autowired
JiraPropertyLoader jiraPropertyLoader;

	public static SearchRequest getSearchRequestDev(RequestHelper requestHelper) {
		SearchRequest req = new SearchRequest();
		req.setJql(MessageFormat.format(requestHelper.jiraPropertyLoader.getJqlDev(), 
				requestHelper.jiraPropertyLoader.getNames(),
				requestHelper.jiraPropertyLoader.getFromDate(),
				requestHelper.jiraPropertyLoader.getToDate())); 
		  List<String> l = Arrays.asList(requestHelper.jiraPropertyLoader.getFieldsDev().toString().split(","));
		  req.setFields(l);
		 		return req;
	}
	
	
	public static SearchRequest getSearchRequestPS(RequestHelper requestHelper) {
		SearchRequest req = new SearchRequest();
					
		req.setJql(requestHelper.jiraPropertyLoader.getJqlPS());	
		
		List<String> l = Arrays.asList(requestHelper.jiraPropertyLoader.getFieldsPS().toString().split(","));		
		req.setFields(l);
		
		
		return req;
	}

}
