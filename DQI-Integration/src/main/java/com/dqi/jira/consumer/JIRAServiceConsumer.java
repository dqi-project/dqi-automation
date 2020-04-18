package com.dqi.jira.consumer;		
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dqi.common.ApplicationPropertiesLoader;
import com.dqi.jira.request.RequestHelper;
import com.dqi.jira.request.SearchRequest;
import com.dqi.jira.response.SearchResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("consumer")
public class JIRAServiceConsumer {
	
@Autowired
RequestHelper requestHelper;

@Autowired
ApplicationPropertiesLoader propertiesLoader;

//@Autowired
//RestTemplate restTemplate;
	
	public SearchResponse searchPSTeamData() {

		SearchRequest requestVO = RequestHelper.getSearchRequestPS(requestHelper);
		
		//The below is only to check request json
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapper.writeValueAsString(requestVO);
			System.out.println("REQUEST:" + jsonStr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//////////////////////////////////////////
		
		SearchResponse response = search(requestVO, propertiesLoader.getApiUrlPS());		
		return response;
		
	}
	
	public SearchResponse searchDevTeamData() {

		SearchRequest requestVO = RequestHelper.getSearchRequestDev(requestHelper);
		
		//The below is only to check request json
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapper.writeValueAsString(requestVO);
			System.out.println("REQUEST:" + jsonStr);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//////////////////////////////////////////
		
		SearchResponse response = search(requestVO, propertiesLoader.getApiUrl());		
		return response;
		
	}
	
	private SearchResponse search(SearchRequest requestVO, String apiUrl) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

		/****************WITH AUTH*******************
		String username = "test";
		String password = "test";
        String authorizationHeader = "Basic " + DatatypeConverter.printBase64Binary((username + ":" + password).getBytes());
        HttpHeaders requestHeaders = new HttpHeaders();
        
        requestHeaders.add("Authorization", authorizationHeader);
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        requestHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<SearchRequest> requestEntity = new HttpEntity<>(requestVO, requestHeaders);
        SearchResponse response = restTemplate.postForObject("http://"+jiraPropertyLoader.getHost()+":"+jiraPropertyLoader.getPort()+jiraPropertyLoader.getApi_url(), requestVO, SearchResponse.class);
        ResponseEntity<SearchResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, SearchResponse.class);
		System.out.println("RESPONSE:" + responseEntity.getBody().toString());
        **********************************/
        
        String url = String.join("", "http://", propertiesLoader.getHost(),":", propertiesLoader.getPort(), apiUrl);
        System.out.println("URL:" + url);
        
		HttpEntity<SearchRequest> request = new HttpEntity<>(requestVO);
		SearchResponse response = restTemplate.postForObject(url, request, SearchResponse.class);
		System.out.println("RESPONSE:" + response);

		return response;
	}
}

