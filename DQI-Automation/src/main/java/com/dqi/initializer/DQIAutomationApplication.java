package com.dqi.initializer;

import javax.swing.UIManager;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.burndown.ui.MainFrame;

/*
 * This is the main class being used to run the application. the
 * dQIDataProcessor object made here is used to call the process method of the
 * processor class.
 * 
 * @author akansha.chaudhary
 *
 */
@SpringBootApplication
public class DQIAutomationApplication {

	private static final Logger logger = Logger.getLogger(DQIAutomationApplication.class);
	public static MainFrame mainFrameInstance;

	public static void main(String[] args) throws Exception {
		try {

			BasicConfigurator.configure();

			logger.info("main class running successfully");
 		
			// To set the Look and Feel
			mainFrameInstance = new MainFrame(true);
			mainFrameInstance.setLocationRelativeTo(null);
			SpringApplication.run(DQIAutomationApplication.class, args);

       		} catch (Exception e) {
			logger.error("Exception in main class ", e);

		}

	}
}
