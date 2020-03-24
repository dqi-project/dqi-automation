package com.dqi.jira.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class SearchRequest {

	String jql;
	List<String> fields;
}
