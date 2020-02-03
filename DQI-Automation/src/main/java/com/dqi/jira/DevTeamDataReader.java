package com.dqi.jira;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


import com.dqi.vo.DevTeamMemberDetailsVO;
import com.dqiAutomation.exception.DQIInvalidExcelSheetException;

/**
 * 
 * this interface has readDevTeamData which is implemented by classes
 * ManualDevTeamDataReader & JiraDevTeamDataReader to read the excel data.
 * 
 * @author akansha.chaudhary
 *
 */
public interface DevTeamDataReader {
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws DQIInvalidExcelSheetException 
	 */
	
	
	List<DevTeamMemberDetailsVO> readDevTeamData() throws FileNotFoundException, IOException, DQIInvalidExcelSheetException;
}
