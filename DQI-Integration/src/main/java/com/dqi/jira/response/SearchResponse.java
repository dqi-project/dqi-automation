package com.dqi.jira.response;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class SearchResponse implements Serializable {
	String expand;
	List<Issues> issues;
}
