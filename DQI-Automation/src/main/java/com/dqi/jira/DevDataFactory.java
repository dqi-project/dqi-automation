package com.dqi.jira;

import com.burndown.util.DQIVariables;
import com.dqi.reader.DataCollectionReader;
import com.dqi.reader.JiraDevTeamDataReader;

/**
 * This factory class is used to get the instance of the file type by method
 * getInstance.
 * 
 * 
 * @author akansha.chaudhary
 *
 */
public class DevDataFactory {

	public DevTeamDataReader getInstance() {
		DQIVariables dQIVariables = DQIVariables.getInstance();
		/* if instance of manual button is true then reading logic method of
		 manual dev effort sheet will be called.*/
		if (true == dQIVariables.isdQImannualRadioButton()) {
			return new DataCollectionReader();
		}

		/* if instance of jira radio button is true then reading logic method of
		 jira sheet will be called.*/

		else if (true == dQIVariables.isdQIjiraRadioButton()) {
			return new JiraDevTeamDataReader();
		}
		return null;

	}
}
