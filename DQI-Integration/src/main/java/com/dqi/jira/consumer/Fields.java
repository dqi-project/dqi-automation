package com.dqi.jira.consumer;

public class Fields {
	String summary;
	String timespent;
	String timeoriginalestimate;
	Assignee assignee;
	
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
	
	public String getTimeoriginalestimate() {
		return timeoriginalestimate;
	}
	public void setTimeoriginalestimate(String timeoriginalestimate) {
		this.timeoriginalestimate = timeoriginalestimate;
	}	
	public Assignee getAssignee() {
		return assignee;
	}
	public void setAssignee(Assignee assignee) {
		this.assignee = assignee;
	}
	@Override
	public String toString() {
		return "Fields [summary=" + summary + ", timespent=" + timespent + ", timeoriginalestimate="
				+ timeoriginalestimate + ", assignee=" + assignee + "]";
	}
}
