package com.dqi.initializer;

import org.springframework.stereotype.Service;

import com.github.tomakehurst.wiremock.WireMockServer;

@Service("mockService")
public class MockServiceInitializer {
	
	public void start() {
		
		WireMockServer wireMockServer = new WireMockServer(8091);
		System.out.println("Wiremock server starting in progress");
		wireMockServer.start();
        System.out.println("Wiremock server started. Listening on localhost:" + wireMockServer.port());
        
        MockServiceClientRequestHandler.handleRequest(8091);
		
	}

}
