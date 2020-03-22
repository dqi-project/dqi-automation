package com.dqi.jira.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DqiIntegrationApplication implements CommandLineRunner{
	
	@Autowired
	private JIRAServiceConsumer JIRAServiceConsumer;

	public static void main(String[] args) {
		SpringApplication.run(DqiIntegrationApplication.class, args);
	}
	
	@Override
	public void run(final String... args) {
		this.JIRAServiceConsumer.search();
	}

}
