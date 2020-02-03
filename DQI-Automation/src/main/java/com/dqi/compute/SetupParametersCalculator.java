package com.dqi.compute;

import org.apache.log4j.Logger;

import com.burndown.util.DQIVariables;
import com.dqi.vo.BaseMeasuresVO;
import com.dqi.vo.DevTeamDataAggregatorVO;
import com.dqi.vo.QATeamDataAggregatorVO;
import com.dqi.vo.SetupParametersVO;

/**
 * This class is used to compute setup parameters by passing
 * devTeamDataAggregatorVO,qATeamDataAggregatorVO in calculateSetupParameters
 * method which returns setupParametersVO .
 * 
 * @author akansha.chaudhary
 *
 */
public class SetupParametersCalculator {
	/**
	 * 
	 * @param devTeamDataAggregatorVO
	 * @param qATeamDataAggregatorVO
	 * @param baseMeasuresVO
	 * @return
	 */
	private static final Logger logger = Logger.getLogger(SetupParametersCalculator.class);

	public SetupParametersVO calculateSetupParameters(DevTeamDataAggregatorVO devTeamDataAggregatorVO,
			QATeamDataAggregatorVO qATeamDataAggregatorVO, BaseMeasuresVO baseMeasuresVO) {

		DQIVariables dQIVariables = DQIVariables.getInstance();
		SetupParametersVO setupParametersVO = new SetupParametersVO();

		// --------------------------Aggregate dev and QA parameters
		double totalAnalysis = devTeamDataAggregatorVO.getTotalAnalysis();
		double totalDevEfforts = devTeamDataAggregatorVO.getTotalDevEfforts();
		double totalCodeRefactoringEfforts = devTeamDataAggregatorVO.getTotalCodeReview();

		double totalTestCaseCreationEfforts = qATeamDataAggregatorVO.getTotalTestCaseCreationEfforts();
		double totalTestCaseReviewEfforts = qATeamDataAggregatorVO.getTotalTestCaseReviewEfforts();
		double totalManualTestingEfforts = qATeamDataAggregatorVO.getTotalManualTestingEfforts();
		double totalAutomationTestingEfforts = qATeamDataAggregatorVO.getTotalAutomationTestingEfforts();

		// ------------------------------Total actual efforts -----------------

		double totalActualEfforts = totalAnalysis + totalDevEfforts + totalTestCaseCreationEfforts
				+ totalTestCaseReviewEfforts + totalManualTestingEfforts + totalAutomationTestingEfforts;

		// --------------------------------Base
		// measures---------------------------
		double totalTestCaseDeveloped = qATeamDataAggregatorVO.getTotalnumOfTestCaseDeveloped();
		double totalTestCaseReview = qATeamDataAggregatorVO.getTotalnumOfTestCaseReviewed();
		double totalTestCaseExecutedManually = qATeamDataAggregatorVO.getTotalnumOfTestCaseExecutedManually();
		double totalTestCaseExecutedAutomation = qATeamDataAggregatorVO
				.getTotalnumOfTestCaseExecutedThroughAutomation();

		// ---------------------------Setup
		// parameters--------------------------------

		double userStoryAnalysisAndDesign = ((totalAnalysis) / (totalActualEfforts)) * 100;
		double codeDevelopment = ((totalDevEfforts) / (totalActualEfforts)) * 100;
		double codeRefactoring = ((totalCodeRefactoringEfforts) / (totalActualEfforts)) * 100;
		double testCaseCreation = ((totalTestCaseCreationEfforts) / (totalActualEfforts)) * 100;
		double testCaseReview = ((totalTestCaseReviewEfforts) / (totalActualEfforts)) * 100;
		double manualTesting = ((totalManualTestingEfforts) / (totalActualEfforts)) * 100;
		double automationTesting = ((totalAutomationTestingEfforts) / (totalActualEfforts)) * 100;

		setupParametersVO.setUserStoryAnalysisAndDesign(userStoryAnalysisAndDesign);
		setupParametersVO.setCodeDevelopment(codeDevelopment);
		setupParametersVO.setCodeRefactoring(codeRefactoring);
		setupParametersVO.setTestCaseCreation(testCaseCreation);
		setupParametersVO.setTestCaseReview(testCaseReview);
		setupParametersVO.setManualTesting(manualTesting);
		setupParametersVO.setAutomationTesting(automationTesting);

		baseMeasuresVO.setTestCasesdeveloped(totalTestCaseDeveloped);
		baseMeasuresVO.setTestCasesReviewed((int) totalTestCaseReview);
		baseMeasuresVO.setTestCasesexecutedmanually((int) totalTestCaseExecutedManually);
		baseMeasuresVO.setTestCasesexecutedAutomation((int) totalTestCaseExecutedAutomation);

		// --------------------------------Productivity-------------------------
		double productivity = dQIVariables.getdQIStoryPoints() / totalActualEfforts;

		setupParametersVO.setStoryPoints(dQIVariables.getdQIStoryPoints());
		setupParametersVO.setTotalactualEfforts(totalActualEfforts);
		setupParametersVO.setProductivity(productivity);

		logger.info("Setup parameters calculated successfully");
		return setupParametersVO;
	}
}
