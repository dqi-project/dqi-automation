/**
 * 
 */
package com.mock;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 * @author priyanka_gupta
 *
 */
public class ResponseClass {
	public void getData() throws IOException
	{ 
		 
		 HttpGet request = new HttpGet("http://localhost:8091/rest/api/2/search");

	     // add request headers
		/*
		 * request.addHeader("custom-key", "abc");
		 * request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
		 */

	     try (CloseableHttpClient httpClient = HttpClients.createDefault();
	          CloseableHttpResponse response = httpClient.execute(request)) {

	         // Get HttpResponse Status
	         System.out.println(response.getProtocolVersion());              // HTTP/1.1
	         System.out.println(response.getStatusLine().getStatusCode());   // 200
	         System.out.println(response.getStatusLine().getReasonPhrase()); // OK
	         System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

	         HttpEntity entity = response.getEntity();
	         
	         if (entity != null) {
	             // return it as a String
	             String result = EntityUtils.toString(entity);
	             System.out.println(result);
	}
}
	}
}
