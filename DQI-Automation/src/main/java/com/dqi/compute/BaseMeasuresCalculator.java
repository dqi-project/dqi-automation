package com.dqi.compute;

import org.apache.log4j.Logger;

import com.dqi.reader.JiraDevTeamDataReader;
import com.dqi.vo.BaseMeasuresVO;
import com.dqi.vo.QATeamDataAggregatorVO;

/**
 * This class is used to calculate the base measures. QATeamAggregatorVO
 * returned in calculate base measure method.
 * 
 * @author akansha.chaudhary
 *
 */

public class BaseMeasuresCalculator {
	/**
	 * 
	 * @param qATeamDataAggregatorVO
	 * @return
	 */

	private static final Logger logger = Logger.getLogger(BaseMeasuresCalculator.class);

	public BaseMeasuresVO calculateBaseMeasures(QATeamDataAggregatorVO qATeamDataAggregatorVO) {

		BaseMeasuresVO baseMeasuresVO = new BaseMeasuresVO();

		// TotalnumOfTestCaseDeveloped
		baseMeasuresVO.setTestCasesdeveloped(qATeamDataAggregatorVO.getTotalnumOfTestCaseDeveloped());

		// TotalnumOfTestCaseReviewed
		baseMeasuresVO.setTestCasesReviewed((int) qATeamDataAggregatorVO.getTotalnumOfTestCaseReviewed());

		// TotalnumOfTestCaseExecutedManually
		baseMeasuresVO
				.setTestCasesexecutedmanually((int) qATeamDataAggregatorVO.getTotalnumOfTestCaseExecutedManually());

		// TotalnumOfTestCaseExecutedThroughAutomation
		baseMeasuresVO.setTestCasesexecutedAutomation(
				(int) qATeamDataAggregatorVO.getTotalnumOfTestCaseExecutedThroughAutomation());

		logger.info("basemeasures calculated");
		return baseMeasuresVO;
	}

}