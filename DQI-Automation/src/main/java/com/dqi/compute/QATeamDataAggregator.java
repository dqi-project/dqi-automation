package com.dqi.compute;

import java.util.List;

import org.apache.log4j.Logger;

import com.dqi.vo.QATeamDataAggregatorVO;
import com.dqi.vo.QATeamMemberDetailsVO;

/**
 * 
 * This class is used to aggregate the data of QA team. List Returned from
 * QATeamDataAggregatorVO in aggregateQATeamData method.
 * 
 * @author akansha.chaudhary
 *
 */
public class QATeamDataAggregator {
	double totalTestCaseCreationEfforts;
	double totalTestCaseReviewEfforts;
	double totalManualTestingEfforts;
	double totalAutomationTestingEfforts;

	double totalnumOfTestCaseDeveloped;
	double totalnumOfTestCaseReviewed;
	double totalnumOfTestCaseExecutedManually;
	double totalnumOfTestCaseExecutedThroughAutomation;
	/**
	 * 
	 * @param membersList
	 * @return
	 */
	private static final Logger logger = Logger.getLogger(QATeamDataAggregator.class);

	public QATeamDataAggregatorVO aggregateQATeamData(List<QATeamMemberDetailsVO> membersList) {

		QATeamDataAggregatorVO qaTeamDataAggregatorVO = new QATeamDataAggregatorVO();

		for (QATeamMemberDetailsVO QaTeamMemberDetailsVO : membersList) {
			totalTestCaseCreationEfforts = totalTestCaseCreationEfforts
					+ QaTeamMemberDetailsVO.getTestCaseCreationEfforts();
			totalTestCaseReviewEfforts = totalTestCaseReviewEfforts + QaTeamMemberDetailsVO.getTestCaseReviewEfforts();
			totalManualTestingEfforts = totalManualTestingEfforts + QaTeamMemberDetailsVO.getManualTestingEfforts();
			totalAutomationTestingEfforts = totalAutomationTestingEfforts
					+ QaTeamMemberDetailsVO.getAutomationTestingEfforts();

			totalnumOfTestCaseDeveloped = totalnumOfTestCaseDeveloped
					+ QaTeamMemberDetailsVO.getNumOfTestCaseDeveloped();
			totalnumOfTestCaseReviewed = totalnumOfTestCaseReviewed + QaTeamMemberDetailsVO.getNumOfTestCaseReviewed();

			totalnumOfTestCaseExecutedManually = totalnumOfTestCaseExecutedManually
					+ QaTeamMemberDetailsVO.getNumOfTestCaseExecutedManually();

			totalnumOfTestCaseExecutedThroughAutomation = totalnumOfTestCaseExecutedThroughAutomation
					+ QaTeamMemberDetailsVO.getNumOfTestCaseExecutedThroughAutomation();

		}

		qaTeamDataAggregatorVO.setTotalAutomationTestingEfforts((int) totalAutomationTestingEfforts);
		qaTeamDataAggregatorVO.setTotalManualTestingEfforts((int) totalManualTestingEfforts);
		qaTeamDataAggregatorVO.setTotalTestCaseCreationEfforts((int) totalTestCaseCreationEfforts);
		qaTeamDataAggregatorVO.setTotalTestCaseReviewEfforts((int) totalTestCaseReviewEfforts);

		qaTeamDataAggregatorVO.setTotalnumOfTestCaseDeveloped((int) totalnumOfTestCaseDeveloped);
		qaTeamDataAggregatorVO.setTotalnumOfTestCaseReviewed((int) totalnumOfTestCaseReviewed);
		qaTeamDataAggregatorVO.setTotalnumOfTestCaseExecutedManually((int) totalnumOfTestCaseExecutedManually);

		qaTeamDataAggregatorVO
				.setTotalnumOfTestCaseExecutedThroughAutomation((int) totalnumOfTestCaseExecutedThroughAutomation);

		logger.info("QA team data aggregated successfully");
		
		
		return qaTeamDataAggregatorVO;

	}

}
