package com.dqi.vo;

/**
 * 
 * @author akansha.chaudhary
 *
 */
public class QATeamMemberDetailsVO {

	private String name;
	private double testCaseCreationEfforts;
	private double testCaseReviewEfforts;
	private double manualTestingEfforts;
	private double automationTestingEfforts;

	private double numOfTestCaseDeveloped;
	private double numOfTestCaseReviewed;
	private double numOfTestCaseExecutedManually;
	private double numOfTestCaseExecutedThroughAutomation;

	public double getNumOfTestCaseDeveloped() {
		return numOfTestCaseDeveloped;
	}

	public void setNumOfTestCaseDeveloped(double numOfTestCaseDeveloped) {
		this.numOfTestCaseDeveloped = numOfTestCaseDeveloped;
	}

	public double getNumOfTestCaseReviewed() {
		return numOfTestCaseReviewed;
	}

	public void setNumOfTestCaseReviewed(double numOfTestCaseReviewed) {
		this.numOfTestCaseReviewed = numOfTestCaseReviewed;
	}

	public double getNumOfTestCaseExecutedManually() {
		return numOfTestCaseExecutedManually;
	}

	public void setNumOfTestCaseExecutedManually(double numOfTestCaseExecutedManually) {
		this.numOfTestCaseExecutedManually = numOfTestCaseExecutedManually;
	}

	public double getNumOfTestCaseExecutedThroughAutomation() {
		return numOfTestCaseExecutedThroughAutomation;
	}

	public void setNumOfTestCaseExecutedThroughAutomation(double numOfTestCaseExecutedThroughAutomation) {
		this.numOfTestCaseExecutedThroughAutomation = numOfTestCaseExecutedThroughAutomation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTestCaseCreationEfforts() {
		return testCaseCreationEfforts;
	}

	public void setTestCaseCreationEfforts(double testCaseCreationEfforts) {
		this.testCaseCreationEfforts = testCaseCreationEfforts;
	}

	public double getTestCaseReviewEfforts() {
		return testCaseReviewEfforts;
	}

	public void setTestCaseReviewEfforts(double testCaseReviewEfforts) {
		this.testCaseReviewEfforts = testCaseReviewEfforts;
	}

	public double getManualTestingEfforts() {
		return manualTestingEfforts;
	}

	public void setManualTestingEfforts(double manualTestingEfforts) {
		this.manualTestingEfforts = manualTestingEfforts;
	}

	public double getAutomationTestingEfforts() {
		return automationTestingEfforts;
	}

	public void setAutomationTestingEfforts(double automationTestingEfforts) {
		this.automationTestingEfforts = automationTestingEfforts;
	}

	@Override
	public String toString() {
		return "QATeamMemberDetailsVO [name=" + name + ", testCaseCreationEfforts=" + testCaseCreationEfforts
				+ ", testCaseReviewEfforts=" + testCaseReviewEfforts + ", manualTestingEfforts=" + manualTestingEfforts
				+ ", automationTestingEfforts=" + automationTestingEfforts + ", numOfTestCaseDeveloped="
				+ numOfTestCaseDeveloped + ", numOfTestCaseReviewed=" + numOfTestCaseReviewed
				+ ", numOfTestCaseExecutedManually=" + numOfTestCaseExecutedManually
				+ ", numOfTestCaseExecutedThroughAutomation=" + numOfTestCaseExecutedThroughAutomation + "]";
	}

}
