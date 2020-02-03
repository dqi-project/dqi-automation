package com.dqi.compute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		for (DevTeamMemberDetailsVO devTeamMemberDetailsVO : membersList) {

			String name = devTeamMemberDetailsVO.getName();
			{
				// reading logic for dev effort sheet
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

		return jiraReadMap;
	}

}
