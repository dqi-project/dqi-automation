package com.dqi.xlmapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dqi.xlmapper.exception.DQIXLMapperInvalidSheetNameException;
import com.dqi.xlmapper.exception.DQIXLMapperInvalidValueTypeException;
import com.dqi.xlmapper.process.XLMapperProcessor;

@SpringBootApplication
public class XLMapperApplication implements CommandLineRunner{

	@Autowired
	XLMapperProcessor xlmapperProcessor;
	private static final Logger logger = Logger.getLogger(XLMapperApplication.class);  

	public static void main(String[] args) {
		SpringApplication.run(XLMapperApplication.class, args);
	} 

	@Override
	public void run(String... args) {
		String filename=null;
		try
		{
			if(args.length!=0)
			{
				filename=args[0];
				new FileInputStream(args[0]).close();
				filename=null;
				xlmapperProcessor.process(args[0]);					
			}
			else
			{
				System.out.println("Error: Please provide .yaml file path.");
			}
		}
		catch(DQIXLMapperInvalidValueTypeException e)
		{
			System.out.println("Error occurred. Please check if .yaml file data or excel sheet's data is correct, try again.");
			logger.error("Exception in XLMapperApplication class ", e);
		}
		catch(DQIXLMapperInvalidSheetNameException e)
		{
			System.out.println("Error occurred. Please check if .yaml file data or excel sheet's data is correct, try again.");
			logger.error("Exception in XLMapperApplication class ", e);
		}	
		catch(FileNotFoundException e)
		{
			if(null != filename)
				System.out.println("The system cannot find "+ new File(filename)+" file.");
			logger.error("Exception in XLMapperApplication class ", e);
		}
		catch(IllegalStateException e)
		{
			System.out.println("Error occurred. Please check if .yaml file data or excel sheet's data is correct, try again.");
			logger.error("Exception in XLMapperApplication class ", e);
		}
		catch(Throwable message)
		{
			System.out.println("Error occurred. Please check if .yaml file data or excel sheet's data is correct, try again.");
			logger.error("Exception in XLMapperApplication class ", message);
		}
	}
}
