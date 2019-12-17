package com.dqi.jira;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.dqi.vo.DevTeamMemberDetailsVO;

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
	 */
	
	
	List<DevTeamMemberDetailsVO> readDevTeamData() throws FileNotFoundException, IOException;
}
