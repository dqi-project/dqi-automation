package com.dqi.jira.request;

import java.text.MessageFormat;
import java.util.ArrayList;
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
				requestHelper.propertiesLoader.getNames(), requestHelper.propertiesLoader.getFromDate(),
				requestHelper.propertiesLoader.getToDate()));

		String[] fieldsArray = requestHelper.propertiesLoader.getFieldsDev().toString().split(",");
		List<String> fieldsList = new ArrayList<>(fieldsArray.length);
		for (String field : fieldsArray) {
			fieldsList.add(field.trim());
		}
		req.setFields(fieldsList);

		return req;
	}

	public static SearchRequest getSearchRequestPS(RequestHelper requestHelper) {
		SearchRequest req = new SearchRequest();

		req.setJql(requestHelper.propertiesLoader.getJqlPS());

		String[] fieldsArray = requestHelper.propertiesLoader.getFieldsPS().toString().split(",");
		List<String> fieldsList = new ArrayList<>(fieldsArray.length);
		for (String field : fieldsArray) {
			fieldsList.add(field.trim());
		}
		req.setFields(fieldsList);

		return req;
	}
	
	public static SearchRequest getSearchRequestOnsite(RequestHelper requestHelper) {
		SearchRequest req = new SearchRequest();

		req.setJql(requestHelper.propertiesLoader.getJqlOnsite());

		String[] fieldsArray = requestHelper.propertiesLoader.getFieldsOnsite().toString().split(",");
		List<String> fieldsList = new ArrayList<>(fieldsArray.length);
		for (String field : fieldsArray) {
			fieldsList.add(field.trim());
		}
		req.setFields(fieldsList);

		return req;
	}

}
