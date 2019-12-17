package com.dqi.compute;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dqi.reader.ManualDevTeamDataReader;
import com.dqi.reader.JiraDevTeamDataReader;
import com.dqi.vo.DevTeamDataAggregatorVO;
import com.dqi.vo.DevTeamMemberDetailsVO;

/**
 * 
 * This class is used to aggregate the data of development team. List Returned
 * from DEvTeamMemberDetailsVO in aggregateDevTeamData method.
 * 
 * 
 * @author akansha.chaudhary
 *
 */
public class DevTeamDataAggregator {
	double totalAnalysis;
	double totalDev;
	double totalUT;
	double agrregateDev;
	double totalCodeReview;
	double totalInternalReviewDefects;
	double totalExternalReviewDefects;
	double totalQADefects;
	double totalStoryPoints;

	/**
	 * 
	 * @param devTeamList
	 * @return
	 */
	public DevTeamDataAggregatorVO aggregateDevTeamData(List<DevTeamMemberDetailsVO> devTeamList) {

		DevTeamDataAggregatorVO devTeamDataAggregatorVO = new DevTeamDataAggregatorVO();

		for (DevTeamMemberDetailsVO devTeamMemberDetailsVO : devTeamList) {

			totalAnalysis = totalAnalysis + devTeamMemberDetailsVO.getAnalysis();

			agrregateDev = devTeamMemberDetailsVO.getDev() + devTeamMemberDetailsVO.getUt()
					+ devTeamMemberDetailsVO.getCodeReview();

			totalDev = totalDev + agrregateDev;

			totalUT = totalUT + devTeamMemberDetailsVO.getUt();

			totalCodeReview = totalCodeReview + devTeamMemberDetailsVO.getCodeReview();

			totalInternalReviewDefects = totalInternalReviewDefects + devTeamMemberDetailsVO.getInternalReviewDefects();
			totalExternalReviewDefects = totalExternalReviewDefects + devTeamMemberDetailsVO.getExternalReviewDefects();
			totalQADefects = totalQADefects + devTeamMemberDetailsVO.getqADefects();

		}

		devTeamDataAggregatorVO.setTotalAnalysis(totalAnalysis);
		devTeamDataAggregatorVO.setTotalDevEfforts(totalDev);
		devTeamDataAggregatorVO.setTotalCodeReview(totalCodeReview);
		devTeamDataAggregatorVO.setTotalUT(totalUT);
		devTeamDataAggregatorVO.setTotalInternalReviewDefects(totalInternalReviewDefects);
		devTeamDataAggregatorVO.setTotalExternalReviewDefects(totalExternalReviewDefects);
		devTeamDataAggregatorVO.setTotalQADefects(totalQADefects);
		devTeamDataAggregatorVO.setTotalStoryPoints(totalStoryPoints);
/*
		System.out.println("\nTotalDev=" + totalDev + "\nTotalAnalysis=" + totalAnalysis + " \nTotalCodeReview="
				+ totalCodeReview + "\nTotal Ut=" + totalUT + "\nTotalInternalReviewDefects="
				+ totalInternalReviewDefects + "\nTotalExternalReviewDefects= " + totalExternalReviewDefects
				+ "\nTotalQADefects=" + totalQADefects + "\nTotalStoryPoints=" + totalStoryPoints);
		System.out.println();
*/
		return devTeamDataAggregatorVO;

	}

}
