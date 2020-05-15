package com.dqi.xlmapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dqi.xlmapper.process.XLMapperProcessor;

@SpringBootApplication
public class XLMapperApplication implements CommandLineRunner{

	 @Autowired
	 XLMapperProcessor xlmapperProcessor;
	  
	   
	public static void main(String[] args) {
		SpringApplication.run(XLMapperApplication.class, args);
	} 
	
	@Override
	public void run(String... args) {
		try
		{
			if(args.length!=0)
			xlmapperProcessor.process(args[0]);
			System.out.println("Mapping done successfully.");
		}
		catch(Throwable e)
		{
			System.out.println("An error occurred. Please try again.");
			//e.printStackTrace();
		}
		
	}
}
