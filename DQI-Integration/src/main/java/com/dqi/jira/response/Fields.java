package com.dqi.jira.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Fields {
	
	String summary;
	String timespent;
	String timeoriginalestimate;
	Assignee assignee;
	
}
