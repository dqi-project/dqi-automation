package com.dqi.initializer;

import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.burn.down.ui.MainFrame;
import com.dqi.process.DQIDataProcessor;
/*
 * This is the main class being used to run the application. the
 * dQIDataProcessor object made here is used to call the process method of the
 * processor class.
 * 
 * @author akansha.chaudhary
 *
 */
@SpringBootApplication
@ComponentScan("com.dqi.initializer")
public class DQIAutomationApplication {
	public static void main(String[] args) {
		try {
			// To set the Look and Feel
						UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
						new MainFrame().setLocationRelativeTo(null);
						SpringApplication.run(DQIAutomationApplication.class, args);


		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
