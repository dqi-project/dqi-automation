package com.dqi.vo;
/**
 * 
 * @author akansha.chaudhary
 *
 */
public class QATeamDataAggregatorVO {
	private int totalTestCaseCreationEfforts;
	private int totalTestCaseReviewEfforts;
	private int totalManualTestingEfforts;
	private int totalAutomationTestingEfforts;
	
	private int totalnumOfTestCaseDeveloped;
	private int totalnumOfTestCaseReviewed;
	private int totalnumOfTestCaseExecutedManually;
	private int totalnumOfTestCaseExecutedThroughAutomation;

	public int getTotalTestCaseCreationEfforts() {
		return totalTestCaseCreationEfforts;
	}

	public void setTotalTestCaseCreationEfforts(int totalTestCaseCreationEfforts) {
		this.totalTestCaseCreationEfforts = totalTestCaseCreationEfforts;
	}

	public int getTotalTestCaseReviewEfforts() {
		return totalTestCaseReviewEfforts;
	}

	public void setTotalTestCaseReviewEfforts(int totalTestCaseReviewEfforts) {
		this.totalTestCaseReviewEfforts = totalTestCaseReviewEfforts;
	}

	public int getTotalManualTestingEfforts() {
		return totalManualTestingEfforts;
	}

	public void setTotalManualTestingEfforts(int totalManualTestingEfforts) {
		this.totalManualTestingEfforts = totalManualTestingEfforts;
	}

	public int getTotalAutomationTestingEfforts() {
		return totalAutomationTestingEfforts;
	}

	public void setTotalAutomationTestingEfforts(int totalAutomationTestingEfforts) {
		this.totalAutomationTestingEfforts = totalAutomationTestingEfforts;
	}

	public int getTotalnumOfTestCaseDeveloped() {
		return totalnumOfTestCaseDeveloped;
	}

	public void setTotalnumOfTestCaseDeveloped(int totalnumOfTestCaseDeveloped) {
		this.totalnumOfTestCaseDeveloped = totalnumOfTestCaseDeveloped;
	}

	public int getTotalnumOfTestCaseReviewed() {
		return totalnumOfTestCaseReviewed;
	}

	public void setTotalnumOfTestCaseReviewed(int totalnumOfTestCaseReviewed) {
		this.totalnumOfTestCaseReviewed = totalnumOfTestCaseReviewed;
	}

	public int getTotalnumOfTestCaseExecutedManually() {
		return totalnumOfTestCaseExecutedManually;
	}

	public void setTotalnumOfTestCaseExecutedManually(int totalnumOfTestCaseExecutedManually) {
		this.totalnumOfTestCaseExecutedManually = totalnumOfTestCaseExecutedManually;
	}

	public int getTotalnumOfTestCaseExecutedThroughAutomation() {
		return totalnumOfTestCaseExecutedThroughAutomation;
	}

	public void setTotalnumOfTestCaseExecutedThroughAutomation(int totalnumOfTestCaseExecutedThroughAutomation) {
		this.totalnumOfTestCaseExecutedThroughAutomation = totalnumOfTestCaseExecutedThroughAutomation;
	}

	@Override
	public String toString() {
		return "QATeamDataAggregatorVO [totalTestCaseCreationEfforts=" + totalTestCaseCreationEfforts
				+ ", totalTestCaseReviewEfforts=" + totalTestCaseReviewEfforts + ", totalManualTestingEfforts="
				+ totalManualTestingEfforts + ", totalAutomationTestingEfforts=" + totalAutomationTestingEfforts
				+ ", totalnumOfTestCaseDeveloped=" + totalnumOfTestCaseDeveloped + ", totalnumOfTestCaseReviewed="
				+ totalnumOfTestCaseReviewed + ", totalnumOfTestCaseExecutedManually="
				+ totalnumOfTestCaseExecutedManually + ", totalnumOfTestCaseExecutedThroughAutomation="
				+ totalnumOfTestCaseExecutedThroughAutomation + "]";
	}

}