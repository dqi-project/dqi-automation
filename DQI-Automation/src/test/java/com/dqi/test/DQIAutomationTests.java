package com.dqi.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.dqi.vo.BaseMeasuresVO;
import com.dqi.vo.DataCollectionVO;
import com.dqi.vo.DevTeamDataAggregatorVO;
import com.dqi.vo.DevTeamMemberDetailsVO;
import com.dqi.vo.QATeamDataAggregatorVO;
import com.dqi.vo.QATeamMemberDetailsVO;
import com.dqi.vo.SetupParametersVO;
import com.dqi.writer.DQIDataWriter;

import junit.framework.TestCase;

import com.dqi.compute.DataCollectionCompute;
import com.dqi.compute.DevTeamDataAggregator;
import com.dqi.compute.QATeamDataAggregator;
import com.dqi.compute.SetupParametersCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = com.dqi.initializer.DQIAutomationApplication.class)

/**
 * 
 * @author Akansha.Chaudhary
 *
 */
public class DQIAutomationTests extends TestCase {
	DevTeamDataAggregatorVO devTeamDataAggregatorVO = new DevTeamDataAggregatorVO();
	QATeamDataAggregatorVO qATeamDataAggregatorVO = new QATeamDataAggregatorVO();
	SetupParametersCalculator setupParametersCalculator = new SetupParametersCalculator();
	SetupParametersVO setupParametersVO = new SetupParametersVO();
	BaseMeasuresVO baseMeasuresVO = new BaseMeasuresVO();
	DevTeamMemberDetailsVO devTeamMemberDetailsVO = new DevTeamMemberDetailsVO();
	DevTeamDataAggregator devTeamDataAggregator = new DevTeamDataAggregator();
	QATeamDataAggregator qATeamDataAggregator = new QATeamDataAggregator();
	DataCollectionVO dataCollectionVO = new DataCollectionVO();
	DataCollectionCompute dataCollectionCompute = new DataCollectionCompute();
	DQIDataWriter writer = new DQIDataWriter();

	@Test
	public void testcalculateSetupParameters() {

		devTeamDataAggregatorVO.setTotalAnalysis((float) 89.0);

		devTeamDataAggregatorVO.setTotalDevEfforts((float) 299.0);
		devTeamDataAggregatorVO.setTotalCodeReview((float) 23.0);
		qATeamDataAggregatorVO.setTotalTestCaseCreationEfforts(155);

		qATeamDataAggregatorVO.setTotalTestCaseReviewEfforts(25);

		qATeamDataAggregatorVO.setTotalManualTestingEfforts(375);
		qATeamDataAggregatorVO.setTotalAutomationTestingEfforts(128);

		double userStoryAnalysisAndDesign = setupParametersCalculator
				.calculateSetupParameters(devTeamDataAggregatorVO, qATeamDataAggregatorVO, baseMeasuresVO)
				.getUserStoryAnalysisAndDesign();

		double codeDevelopment = setupParametersCalculator
				.calculateSetupParameters(devTeamDataAggregatorVO, qATeamDataAggregatorVO, baseMeasuresVO)
				.getCodeDevelopment();
		double codeRefactoring = setupParametersCalculator
				.calculateSetupParameters(devTeamDataAggregatorVO, qATeamDataAggregatorVO, baseMeasuresVO)
				.getCodeRefactoring();
		double testCaseCreation = setupParametersCalculator
				.calculateSetupParameters(devTeamDataAggregatorVO, qATeamDataAggregatorVO, baseMeasuresVO)
				.getTestCaseCreation();
		double testCaseReview = setupParametersCalculator
				.calculateSetupParameters(devTeamDataAggregatorVO, qATeamDataAggregatorVO, baseMeasuresVO)
				.getTestCaseReview();
		double manualTesting = setupParametersCalculator
				.calculateSetupParameters(devTeamDataAggregatorVO, qATeamDataAggregatorVO, baseMeasuresVO)
				.getManualTesting();
		double automationTesting = setupParametersCalculator
				.calculateSetupParameters(devTeamDataAggregatorVO, qATeamDataAggregatorVO, baseMeasuresVO)
				.getAutomationTesting();

		assertEquals(userStoryAnalysisAndDesign, 8.309990882873535);
		assertEquals(codeDevelopment, 27.91783332824707, 0.00);
		assertEquals(codeRefactoring, 0.00, 0.00);
		assertEquals(testCaseCreation, 14.472455978393555, 0.00);
		assertEquals(testCaseReview, 2.3342671394348145, 0.00);
		assertEquals(manualTesting, 35.01400375366211, 0.00);
		assertEquals(automationTesting, 11.951447486877441, 0.00);
	}

	@Test
	public void testDevAggregate() {

		List<DevTeamMemberDetailsVO> devTeamList = new ArrayList<>();

		devTeamMemberDetailsVO.setAnalysis(4);
		devTeamMemberDetailsVO.setDev(10);
		devTeamMemberDetailsVO.setUt(6);
		devTeamMemberDetailsVO.setCodeReview(2);

		devTeamMemberDetailsVO.setInternalReviewDefects(1);
		devTeamMemberDetailsVO.setExternalReviewDefects(0);
		devTeamMemberDetailsVO.setqADefects(0);

		devTeamList.add(devTeamMemberDetailsVO);

		System.out.println("list**" + devTeamList);

		double totalAnalysis = devTeamDataAggregator.aggregateDevTeamData((List<DevTeamMemberDetailsVO>) devTeamList)
				.getTotalAnalysis();

		double totalDev = devTeamDataAggregator.aggregateDevTeamData((List<DevTeamMemberDetailsVO>) devTeamList)
				.getTotalDevEfforts();

		double totalUT = devTeamDataAggregator.aggregateDevTeamData((List<DevTeamMemberDetailsVO>) devTeamList)
				.getTotalUT();

		double totalCodeReview = devTeamDataAggregator.aggregateDevTeamData((List<DevTeamMemberDetailsVO>) devTeamList)
				.getTotalCodeReview();

		double totalInternalReviewDefects = devTeamDataAggregator
				.aggregateDevTeamData((List<DevTeamMemberDetailsVO>) devTeamList).getTotalInternalReviewDefects();

		double totalExternalReviewDefects = devTeamDataAggregator
				.aggregateDevTeamData((List<DevTeamMemberDetailsVO>) devTeamList).getTotalExternalReviewDefects();

		double totalQADefects = devTeamDataAggregator.aggregateDevTeamData((List<DevTeamMemberDetailsVO>) devTeamList)
				.getTotalQADefects();

		assertEquals(totalAnalysis, 4, 0);
		assertEquals(totalDev, 36, 0);
		assertEquals(totalUT, 18, 0);
		assertEquals(totalCodeReview, 8, 0);
		assertEquals(totalInternalReviewDefects, 5, 0);
		assertEquals(totalExternalReviewDefects, 0, 0);
		assertEquals(totalQADefects, 0, 0);

	}

	@Test
	public void testQAAggregate() {
		QATeamMemberDetailsVO qATeamMemberDetailsVO = new QATeamMemberDetailsVO();

		List<QATeamMemberDetailsVO> qATeamList = new ArrayList<>();

		qATeamMemberDetailsVO.setTestCaseCreationEfforts((float) 23.0);
		qATeamMemberDetailsVO.setTestCaseReviewEfforts((float) 17.0);
		qATeamMemberDetailsVO.setManualTestingEfforts((float) 34.0);
		qATeamMemberDetailsVO.setAutomationTestingEfforts((float) 2.0);
		qATeamMemberDetailsVO.setNumOfTestCaseDeveloped((float) 22.0);
		qATeamMemberDetailsVO.setNumOfTestCaseReviewed((float) 12.0);
		qATeamMemberDetailsVO.setNumOfTestCaseExecutedManually((float) 15.0);
		qATeamMemberDetailsVO.setNumOfTestCaseExecutedThroughAutomation(12);

		qATeamList.add(qATeamMemberDetailsVO);
		System.out.println("qATeamList" + qATeamList);

		double totalTestCaseCreationEfforts = qATeamDataAggregator.aggregateQATeamData(qATeamList)
				.getTotalTestCaseCreationEfforts();
		double totalTestCaseReviewEfforts = qATeamDataAggregator.aggregateQATeamData(qATeamList)
				.getTotalTestCaseReviewEfforts();
		double totalManualTestingEfforts = qATeamDataAggregator.aggregateQATeamData(qATeamList)
				.getTotalManualTestingEfforts();
		double totalAutomationTestingEfforts = qATeamDataAggregator.aggregateQATeamData(qATeamList)
				.getTotalAutomationTestingEfforts();

		double totalnumOfTestCaseDeveloped = qATeamDataAggregator.aggregateQATeamData(qATeamList)
				.getTotalnumOfTestCaseDeveloped();
		double totalnumOfTestCaseReviewed = qATeamDataAggregator.aggregateQATeamData(qATeamList)
				.getTotalnumOfTestCaseReviewed();

		double totalnumOfTestCaseExecutedManually = qATeamDataAggregator.aggregateQATeamData(qATeamList)
				.getTotalnumOfTestCaseExecutedManually();

		double totalnumOfTestCaseExecutedThroughAutomation = qATeamDataAggregator.aggregateQATeamData(qATeamList)
				.getTotalnumOfTestCaseExecutedThroughAutomation();

		assertEquals(totalTestCaseCreationEfforts, 23.0, 0.00);

		assertEquals(totalTestCaseReviewEfforts, 34.0, 0);

		assertEquals(totalManualTestingEfforts, 102.0, 0);
		assertEquals(totalAutomationTestingEfforts, 8.0, 0);

		assertEquals(totalnumOfTestCaseDeveloped, 110.0, 0);
		assertEquals(totalnumOfTestCaseReviewed, 72.0, 0);
		assertEquals(totalnumOfTestCaseExecutedManually, 105.0, 0);
		assertEquals(totalnumOfTestCaseExecutedThroughAutomation, 96.0, 0);

	}
}
