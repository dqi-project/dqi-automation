package com.dqi.compute;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dqi.reader.ManualDevTeamDataReader;
import com.dqi.vo.DataCollectionVO;
import com.dqi.vo.DevTeamMemberDetailsVO;

/**
 * This class is used to compute the total analysis and total development of the
 * development team members
 * 
 * @author akansha.chaudhary
 *
 */

public class DataCollectionCompute {
/**
 * 
 * @param membersList
 * @return
 */
	public Map<String, DataCollectionVO> aggregateDevTeam(List<DevTeamMemberDetailsVO> membersList) {
		// creating map
		Map<String, DataCollectionVO> jiraReadMap = new HashMap<>();
		// System.out.println("Data Collection \n");

		for (DevTeamMemberDetailsVO devTeamMemberDetailsVO : membersList) {

			String name = devTeamMemberDetailsVO.getName();
			{
				//reading logic for dev effort sheet
				if (jiraReadMap.containsKey(name)) {
					DataCollectionVO dataCollectionVO = jiraReadMap.get(name);

					dataCollectionVO.setTotalAnalysis(
							dataCollectionVO.getTotalAnalysis() + devTeamMemberDetailsVO.getAnalysis());
					dataCollectionVO.setTotalDev((dataCollectionVO.getTotalDev() + devTeamMemberDetailsVO.getDev()
							+ devTeamMemberDetailsVO.getUt() + devTeamMemberDetailsVO.getCodeReview()));
					jiraReadMap.put(name, dataCollectionVO);
				} else {
					DataCollectionVO dataCollectionVO = new DataCollectionVO();
					dataCollectionVO.setTotalAnalysis(devTeamMemberDetailsVO.getAnalysis());
					dataCollectionVO.setTotalDev(devTeamMemberDetailsVO.getDev() + devTeamMemberDetailsVO.getUt()
							+ devTeamMemberDetailsVO.getCodeReview());
					jiraReadMap.put(name, dataCollectionVO);
				}

			}
		}
/*
		for (String name : jiraReadMap.keySet()) {
			System.out.println("name : [" + name + "] analysis [" + jiraReadMap.get(name).getTotalAnalysis()
					+ "] total dev [" + jiraReadMap.get(name).getTotalDev() + "]");
		}*/
		return jiraReadMap;
	}

	
}
