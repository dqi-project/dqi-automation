package com.dqi.jira.consumer;

public class Fields {
	
	String summary;
	String timespent;
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTimespent() {
		return timespent;
	}
	public void setTimespent(String timespent) {
		this.timespent = timespent;
	}
	@Override
	public String toString() {
		return "Fields [summary=" + summary + ", timespent=" + timespent + "]";
	}
	
	


}
