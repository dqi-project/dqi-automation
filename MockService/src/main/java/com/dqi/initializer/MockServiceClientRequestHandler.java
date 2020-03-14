package com.dqi.initializer;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class MockServiceClientRequestHandler {
	
	public static void handleRequest(int port) {
		configureFor("localhost", port);	
		
		stubFor(post(urlEqualTo("/rest/api/2/search"))
				.willReturn(aResponse().withBody(SearchResponse.SEARCH_RESPONSE)));
	}


}
