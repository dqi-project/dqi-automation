package com.dqi.jira.consumer;		
import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dqi.jira.request.JiraPropertyLoader;
import com.dqi.jira.request.RequestHelper;
import com.dqi.jira.request.SearchRequest;
import com.dqi.jira.response.SearchResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@ComponentScan(basePackages="com.dqi.jira.request")
		@Service("consumer")
		public class JIRAServiceConsumer {
			@Autowired
			RequestHelper requestHelper;	
			@Autowired
			JiraPropertyLoader jiraPropertyLoader;
			
			public void search() {
				RestTemplate restTemplate = new RestTemplate();
				 
				SearchRequest requestVO = RequestHelper.getSearchRequestDev(requestHelper);
				SearchRequest requestVOPS = RequestHelper.getSearchRequestPS(requestHelper);
				
				//The below is only to check request json
				ObjectMapper mapper = new ObjectMapper();
				String jsonStr;
				try {
					jsonStr = mapper.writeValueAsString(requestVO);
					System.out.println(jsonStr);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//////////////////////////////////////////
				
				MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
				mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
				restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		

		

				HttpEntity<SearchRequest> request = new HttpEntity<>(requestVO);
				String username = "test";
				String password = "test";
		

		        String authorizationHeader = "Basic " + DatatypeConverter.printBase64Binary((username + ":" + password).getBytes());
		

		        HttpHeaders requestHeaders = new HttpHeaders();
		        //set up HTTP Basic Authentication Header
		        requestHeaders.add("Authorization", authorizationHeader);
		        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		        requestHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		

		        //request entity is created with request headers
		        HttpEntity<SearchRequest> requestEntity = new HttpEntity<>(requestVO, requestHeaders);
		

		        //String url = "http://"+ApplicationConstants.HOST+":"+ApplicationConstants.PORT+ApplicationConstants.API_URL;
		        //String url = "";
		

				//String response = restTemplate.postForObject("http://localhost:8091/rest/api/2/search", request, String.class);
				SearchResponse response = restTemplate.postForObject("http://"+jiraPropertyLoader.getHost()+":"+jiraPropertyLoader.getPort()+jiraPropertyLoader.getApi_url(), request, SearchResponse.class);
				System.out.println(response);
				SearchResponse response = restTemplate.postForObject("http://"+jiraPropertyLoader.getHost()+":"+jiraPropertyLoader.getPort()+jiraPropertyLoader.getApi_url(), requestVO, SearchResponse.class);
		        //ResponseEntity<SearchResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, SearchResponse.class);
				//System.out.println(responseEntity.getBody().toString());
				
				HttpEntity<SearchRequest> requestPS = new HttpEntity<>(requestVOPS);
				//String response = restTemplate.postForObject("http://localhost:8091/rest/api/2/search", request, String.class);
				response = restTemplate.postForObject("http://"+jiraPropertyLoader.getHost()+":"+jiraPropertyLoader.getPort()+jiraPropertyLoader.getApi_url_ps(), requestPS, SearchResponse.class);
				System.out.println(response);
				System.out.println(response.toString());
			}
		}

