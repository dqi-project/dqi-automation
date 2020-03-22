package com.mock;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author priyanka_gupta
 *
 */
@SpringBootApplication
public class MockApplication {
	
	public static void main(String[] args) throws Throwable{
		SpringApplication.run(MockApplication.class, args);
	
		String url="http://localhost:8091/rest/api/2/search";
		
		StringBuilder jsonInput = new StringBuilder();
	    jsonInput.append("{\"jql\": \"worklogAuthor in (name1, name2) AND"
		 		+ " Worklogoate>e 2019/12/26 AND wOrklogDate >= '2019/01/25\", "
		 		+ "\"fields\": [\"key\", \"summary\", \"assignee\",timespent\",\"timeoriginalestimate\"] }");
		 
		 try {
	            String result = new RequestClass().sendPOST(url,jsonInput);
	            System.out.println(result);
	            new ResponseClass().getData();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	     }
		   
}
