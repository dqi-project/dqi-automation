package com.dqi.jira.consumer;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
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

@Service("consumer")
@ComponentScan(basePackages="com.dqi.jira.request")
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
			//System.out.println(mapper.writeValueAsString(requestVOPS));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//////////////////////////////////////////
		
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		
		
		HttpEntity<SearchRequest> request = new HttpEntity<>(requestVO);
		//String response = restTemplate.postForObject("http://localhost:8091/rest/api/2/search", request, String.class);
		
		SearchResponse response = restTemplate.postForObject("http://"+jiraPropertyLoader.getHost()+":"+jiraPropertyLoader.getPort()+jiraPropertyLoader.getApi_url(), request, SearchResponse.class);
		System.out.println(response);
		
		HttpEntity<SearchRequest> requestPS = new HttpEntity<>(requestVOPS);
		//String response = restTemplate.postForObject("http://localhost:8091/rest/api/2/search", request, String.class);
		response = restTemplate.postForObject("http://"+jiraPropertyLoader.getHost()+":"+jiraPropertyLoader.getPort()+jiraPropertyLoader.getApi_url_ps(), requestPS, SearchResponse.class);
		System.out.println(response);
	}


}
