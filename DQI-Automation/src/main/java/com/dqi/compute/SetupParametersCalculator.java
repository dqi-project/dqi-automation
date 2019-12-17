package com.dqi.compute;

import com.burn.down.util.Variables;
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
	public SetupParametersVO calculateSetupParameters(DevTeamDataAggregatorVO devTeamDataAggregatorVO,
			QATeamDataAggregatorVO qATeamDataAggregatorVO,BaseMeasuresVO baseMeasuresVO) {

		SetupParametersVO setupParametersVO = new SetupParametersVO();
		
		// --------------------------Aggregate dev and QA parameters
		double totalAnalysis = devTeamDataAggregatorVO.getTotalAnalysis();
		double totalDevEfforts = devTeamDataAggregatorVO.getTotalDevEfforts();
		double totalCodeRefactoringEfforts = devTeamDataAggregatorVO.getTotalCodeReview();
		
		double totalTestCaseCreationEfforts = qATeamDataAggregatorVO.getTotalTestCaseCreationEfforts();
		double totalTestCaseReviewEfforts = qATeamDataAggregatorVO.getTotalTestCaseReviewEfforts();
		double totalManualTestingEfforts = qATeamDataAggregatorVO.getTotalManualTestingEfforts();
		double totalAutomationTestingEfforts = qATeamDataAggregatorVO.getTotalAutomationTestingEfforts();
		/*
		System.out.println("analysis="+totalAnalysis+" totalDevEfforts="+totalDevEfforts+"tc="
		+totalTestCaseCreationEfforts+"  tcr="+totalTestCaseReviewEfforts+" tme"+totalManualTestingEfforts
				+" auto"+ totalAutomationTestingEfforts);
		
		*/
		// ------------------------------Total actual efforts -----------------
		
		double totalActualEfforts=totalAnalysis+totalDevEfforts+totalTestCaseCreationEfforts+
				totalTestCaseReviewEfforts+totalManualTestingEfforts+totalAutomationTestingEfforts;
		//System.out.println("TOTAL eFFORTS"+totalActualEfforts);

		// --------------------------------Base
		// measures---------------------------
		double totalTestCaseDeveloped = qATeamDataAggregatorVO.getTotalnumOfTestCaseDeveloped();
		double totalTestCaseReview = qATeamDataAggregatorVO.getTotalnumOfTestCaseReviewed();
		double totalTestCaseExecutedManually = qATeamDataAggregatorVO.getTotalnumOfTestCaseExecutedManually();
		double totalTestCaseExecutedAutomation = qATeamDataAggregatorVO.getTotalnumOfTestCaseExecutedThroughAutomation();
		
		/*double totalActualEfforts = devTeamDataAggregatorVO.getTotalAnalysis()
				+ devTeamDataAggregatorVO.getTotalDevEfforts()
				+ qATeamDataAggregatorVO.getTotalTestCaseCreationEfforts()
				+ qATeamDataAggregatorVO.getTotalTestCaseReviewEfforts()
				+ qATeamDataAggregatorVO.getTotalManualTestingEfforts()
				+ qATeamDataAggregatorVO.getTotalAutomationTestingEfforts();
*/
		

		// ---------------------------Setup parameters
		// %--------------------------------
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
			double productivity =Variables.dQIStoryPoints / totalActualEfforts;
				
			/*System.out.println("story Points "+Variables.dQIStoryPoints);*/
		setupParametersVO.setStoryPoints(Variables.dQIStoryPoints );
		setupParametersVO.setTotalactualEfforts(totalActualEfforts);
		setupParametersVO.setProductivity(productivity);

		/*System.out.printf("User Story Analysis and Design=" + userStoryAnalysisAndDesign + "\n");
		System.out.printf("Code Development=" + setupParametersVO.getCodeDevelopment() + "\n");
		System.out.printf("Code refactoring=" + setupParametersVO.getCodeRefactoring() + "\n");
		System.out.printf("Test case creation=" + setupParametersVO.getTestCaseCreation() + "\n");
		System.out.printf("Test case review=" + setupParametersVO.getTestCaseReview() + "\n");
		System.out.printf("Manual testing=" + setupParametersVO.getManualTesting() + "\n");
		System.out.printf("Automation Testing =" + setupParametersVO.getAutomationTesting() + "\n");

		System.out.println("Total num of test case developed=" + baseMeasuresVO.getTestCasesdeveloped() + "\n Total"
				+ " num of test case Reviewed=" + baseMeasuresVO.getTestCasesReviewed() + "\n"
				+ " Total numOf Test Case Executed Manually=" + baseMeasuresVO.getTestCasesexecutedmanually() + "\n"
				+ " Total num Of Test Case ExecutedT hrough Automation="
				+ baseMeasuresVO.getTestCasesexecutedAutomation() +
				 "\nTotal Actual Efforts="
				+ setupParametersVO.getTotalactualEfforts());
	*/
		return setupParametersVO;
	}
}
