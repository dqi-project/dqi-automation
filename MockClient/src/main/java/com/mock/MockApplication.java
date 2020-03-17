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
	    jsonInput.append("{\"jql\": \"worklogAuthor in ('Mohit_Srivastava@symantec.com\", priyadarsini, Virender_Bartwal,"
		 		+ " Akash_Bajpai, Sneha_Verma, vrinda_singh, Vinay_Panwar, "
		 		+ "Abhisheksingh_kushwa, Maneesh_Chowdarygunt, Dev Singh) AND"
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
