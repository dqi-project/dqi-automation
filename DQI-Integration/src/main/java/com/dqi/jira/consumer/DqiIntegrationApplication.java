package com.dqi.jira.consumer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.dqi.dto.PSTeamMemberDetails;
import com.dqi.jira.response.ResponseHelper;
import com.dqi.jira.response.SearchResponse;

@SpringBootApplication
@ComponentScan(basePackages="com.dqi.*")
public class DqiIntegrationApplication implements CommandLineRunner{
	
	@Autowired
	private JIRAServiceConsumer JIRAServiceConsumer;

	public static void main(String[] args) {
		SpringApplication.run(DqiIntegrationApplication.class, args);
	}
	
	@Override
	public void run(final String... args) {
		
		System.out.println("PS Team search start");
		SearchResponse responsePS = this.JIRAServiceConsumer.searchPSTeamData();
		Map<String, PSTeamMemberDetails> outputPSTeamMap = ResponseHelper.populatePSTeamMemberDetails(responsePS);
		System.out.println("PS Team Output Data:" + outputPSTeamMap);
		
		System.out.println("\n\nDev Team search start");
		SearchResponse responseDev = this.JIRAServiceConsumer.searchDevTeamData();
		System.out.println("Dev Team Output Data:" + responseDev);
		
		System.out.println("\n\nOnsite Team search start");
		SearchResponse responseOnsite = this.JIRAServiceConsumer.searchOnsiteTeamData();
		//For Onsite only count is required which is covered in PS team data hence using same method
		Map<String, PSTeamMemberDetails> outputOnsiteTeamMap = ResponseHelper.populatePSTeamMemberDetails(responseOnsite);
		System.out.println("Onsite Team Output Data:" + outputOnsiteTeamMap);//For Onsite only count is required which is covered in PS team data
	}

}
