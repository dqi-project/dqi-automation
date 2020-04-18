package com.dqi.jira.consumer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dqi.dto.PSTeamMemberDetails;
import com.dqi.jira.response.ResponseHelper;
import com.dqi.jira.response.SearchResponse;

@SpringBootApplication
public class DqiIntegrationApplication implements CommandLineRunner{
	
	@Autowired
	private JIRAServiceConsumer JIRAServiceConsumer;

	public static void main(String[] args) {
		SpringApplication.run(DqiIntegrationApplication.class, args);
	}
	
	@Override
	public void run(final String... args) {
		SearchResponse responsePS = this.JIRAServiceConsumer.search();
		Map<String, PSTeamMemberDetails> outputPSTeamMap = ResponseHelper.populatePSTeamMemberDetails(responsePS);
		System.out.println("PS Team Output Data:" + outputPSTeamMap);
	}

}
