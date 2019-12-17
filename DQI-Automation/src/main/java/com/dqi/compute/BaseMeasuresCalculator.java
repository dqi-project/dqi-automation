package com.dqi.compute;

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
	public BaseMeasuresVO calculateBaseMeasures(QATeamDataAggregatorVO qATeamDataAggregatorVO) {

		BaseMeasuresVO baseMeasuresVO = new BaseMeasuresVO();
		
		//TotalnumOfTestCaseDeveloped
		baseMeasuresVO.setTestCasesdeveloped(qATeamDataAggregatorVO.getTotalnumOfTestCaseDeveloped());
		
		//TotalnumOfTestCaseReviewed
		baseMeasuresVO.setTestCasesReviewed((int) qATeamDataAggregatorVO.getTotalnumOfTestCaseReviewed());
		
		//TotalnumOfTestCaseExecutedManually
		baseMeasuresVO
				.setTestCasesexecutedmanually((int) qATeamDataAggregatorVO.getTotalnumOfTestCaseExecutedManually());
		
		//TotalnumOfTestCaseExecutedThroughAutomation
		baseMeasuresVO.setTestCasesexecutedAutomation(
				(int) qATeamDataAggregatorVO.getTotalnumOfTestCaseExecutedThroughAutomation());

		
		/*
		System.out.println("TotalnumOfTestCaseDeveloped ="+baseMeasuresVO.getTestCasesdeveloped()+" TotalnumOfTestCaseReviewed="+baseMeasuresVO.getTestCasesReviewed()
		+" TotalnumOfTestCaseExecutedManually="+baseMeasuresVO.getTestCasesexecutedmanually()+" TotalnumOfTestCaseExecutedThroughAutomation="+baseMeasuresVO.getTestCasesexecutedAutomation() );*/
		return baseMeasuresVO;
	}

}