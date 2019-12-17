package com.dqi.vo;

/**
 * 
 * @author akansha.chaudhary
 *
 */
public class SetupParametersVO {
	private double totalactualEfforts;
	private double userStoryAnalysisAndDesign;
	private double codeDevelopment;
	private double codeRefactoring;
	private double testCaseCreation;
	private double testCaseReview;
	private double manualTesting;
	private double automationTesting;
	private double productivity;

	public double getProductivity() {
		return productivity;
	}

	public void setProductivity(double productivity) {
		this.productivity = productivity;
	}

	private double storyPoints;

	public double getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(double storyPoints) {
		this.storyPoints = storyPoints;
	}

	public double getUserStoryAnalysisAndDesign() {
		return userStoryAnalysisAndDesign;
	}

	public void setUserStoryAnalysisAndDesign(double userStoryAnalysisAndDesign) {
		this.userStoryAnalysisAndDesign = userStoryAnalysisAndDesign;
	}

	public double getCodeDevelopment() {
		return codeDevelopment;
	}

	public void setCodeDevelopment(double codeDevelopment) {
		this.codeDevelopment = codeDevelopment;
	}

	public double getCodeRefactoring() {
		return codeRefactoring;
	}

	public void setCodeRefactoring(double codeRefactoring) {
		this.codeRefactoring = codeRefactoring;
	}

	public double getTestCaseCreation() {
		return testCaseCreation;
	}

	public void setTestCaseCreation(double testCaseCreation) {
		this.testCaseCreation = testCaseCreation;
	}

	public double getTestCaseReview() {
		return testCaseReview;
	}

	public void setTestCaseReview(double testCaseReview) {
		this.testCaseReview = testCaseReview;
	}

	public double getManualTesting() {
		return manualTesting;
	}

	public void setManualTesting(double manualTesting) {
		this.manualTesting = manualTesting;
	}

	public double getAutomationTesting() {
		return automationTesting;
	}

	public void setAutomationTesting(double automationTesting) {
		this.automationTesting = automationTesting;
	}

	public double getTotalactualEfforts() {
		return totalactualEfforts;
	}

	public void setTotalactualEfforts(double totalactualEfforts) {
		this.totalactualEfforts = totalactualEfforts;
	}

	@Override
	public String toString() {
		return "SetupParametersVO [totalactualEfforts=" + totalactualEfforts + ", userStoryAnalysisAndDesign="
				+ userStoryAnalysisAndDesign + ", codeDevelopment=" + codeDevelopment + ", codeRefactoring="
				+ codeRefactoring + ", testCaseCreation=" + testCaseCreation + ", testCaseReview=" + testCaseReview
				+ ", manualTesting=" + manualTesting + ", automationTesting=" + automationTesting + ", productivity="
				+ productivity + ", storyPoints=" + storyPoints + "]";
	}

}
