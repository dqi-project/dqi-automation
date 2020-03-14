package com.dqi.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockServiceApplication implements CommandLineRunner {
	
	@Autowired
	private MockServiceInitializer mockServiceInitializer;

	public static void main(String[] args) {
		SpringApplication.run(MockServiceApplication.class, args);
	}
	
	@Override
	public void run(final String... args) {
		this.mockServiceInitializer.start();
	}

}
