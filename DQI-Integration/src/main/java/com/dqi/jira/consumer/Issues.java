package com.dqi.jira.consumer;

public class Issues {
	
	String key;
	
	Fields fields;

	public Fields getFields() {
		return fields;
	}

	public void setFields(Fields fields) {
		this.fields = fields;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Issues [key=" + key + ", fields=" + fields + "]";
	}
	
	
	
	

}
