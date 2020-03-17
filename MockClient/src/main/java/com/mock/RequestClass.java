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
	
public String sendPOST(String url,StringBuilder json) throws Exception
	{
		
	
	String result = "";
    HttpPost post = new HttpPost(url);

    

    // send a JSON data
    post.setEntity(new StringEntity(json.toString()));

    try (CloseableHttpClient httpClient = HttpClients.createDefault();
         CloseableHttpResponse response = httpClient.execute(post)) {

        result = EntityUtils.toString(response.getEntity());
    }

    return result;
	}
}
