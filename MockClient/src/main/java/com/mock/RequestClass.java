/**
 * 
 */
package com.mock;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author priyanka_gupta
 *
 */
public class RequestClass {
	
String jql;
String fields[];
	
public String getJql() {
		return jql;
	}
	public void setJql(String jql) {
		this.jql = jql;
	}

	public String[] getFields() {
		return fields;
	}
	public void setFields(String[] fields) {
		this.fields = fields;
	}
}
