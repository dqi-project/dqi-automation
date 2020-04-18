package com.dqi.jira.response;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class SearchResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2949959476452511354L;
	String expand;
	List<Issues> issues;
}
