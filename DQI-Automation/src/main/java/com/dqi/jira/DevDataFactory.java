package com.dqi.jira;

import com.dqi.reader.ManualDevTeamDataReader;
import com.burn.down.util.Variables;
import com.dqi.reader.JiraDevTeamDataReader;

/**
 * This factory class is used to get the instance of the file type by method getInstance.
 * 
 * 
 * @author akansha.chaudhary
 *
 */
public class DevDataFactory {

	public DevTeamDataReader getInstance() {
		
		// if instance of manual button is true then reading logic method of manual dev effort sheet will be called.
		if (true == Variables.mannualRadioButtonDQI) {
			System.out.println("in manual"+Variables.mannualRadioButtonDQI);
			return new ManualDevTeamDataReader();
		}		
		
		// if instance of jira radio button is true then reading logic method of jira sheet will be called.

		else if (true == Variables.jiraRadioButtonDQI) {
			System.out.println("in jira"+Variables.jiraRadioButtonDQI);
			return new JiraDevTeamDataReader();
		}
		return  null;
		

	}
}
