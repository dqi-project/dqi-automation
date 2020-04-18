package com.dqi.jira.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Assignee {
	String name;
	String emailAddress;
	String displayName;
}
