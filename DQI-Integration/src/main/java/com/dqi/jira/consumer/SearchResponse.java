package com.dqi.jira.consumer;

import java.io.Serializable;
import java.util.List;

public class SearchResponse implements Serializable {
	
	String expand;
	List<Issues> issues;

	public String getExpand() {
		return expand;
	}
	public void setExpand(String expand) {
		this.expand = expand;
	}
	public List<Issues> getIssues() {
		return issues;
	}
	public void setIssues(List<Issues> issues) {
		this.issues = issues;
	}
	@Override
	public String toString() {
		return "SearchResponse [expand=" + expand + ", issues=" + issues + "]";
	}
	
	

	
}
