package com.dqi.jira.consumer;

import java.util.List;

public class SearchRequest {

	String jql;
	List<String> fields;
	
	public String getJql() {
		return jql;
	}
	public void setJql(String jql) {
		this.jql = jql;
	}
	public List<String> getFields() {
		return fields;
	}
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
}
