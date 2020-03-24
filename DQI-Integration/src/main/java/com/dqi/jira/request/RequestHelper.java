package com.dqi.jira.request;

import java.util.Arrays;
import java.util.List;

public class RequestHelper {

	public static SearchRequest getSearchRequest() {
		SearchRequest req = new SearchRequest();
		
		req.setJql("worklogAuthor in (name1, name2) AND worklogDate >= '2019/12/26' AND worklogDate <= '2020/01/25'");
		
		List<String> l = Arrays.asList("key", "summary", "assignee","timespent","timeoriginalestimate");
		req.setFields(l);
		
		return req;
	}

}
