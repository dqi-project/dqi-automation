package com.dqi.vo;
/**
 * 
 * 
 * @author akansha.chaudhary
 *
 */
public class BaseMeasuresVO {
	private int testCasesdeveloped;
	private int testCasesReviewed;
	private int testCasesexecutedmanually;
	private int testCasesexecutedAutomation;

	public int getTestCasesdeveloped() {
		return testCasesdeveloped;
	}

	public void setTestCasesdeveloped(double d) {
		this.testCasesdeveloped = (int) d;
	}

	public int getTestCasesReviewed() {
		return testCasesReviewed;
	}

	public void setTestCasesReviewed(int testCasesReviewed) {
		this.testCasesReviewed = testCasesReviewed;
	}

	public int getTestCasesexecutedmanually() {
		return testCasesexecutedmanually;
	}

	public void setTestCasesexecutedmanually(int testCasesexecutedmanually) {
		this.testCasesexecutedmanually = testCasesexecutedmanually;
	}

	public int getTestCasesexecutedAutomation() {
		return testCasesexecutedAutomation;
	}

	public void setTestCasesexecutedAutomation(int testCasesexecutedAutomation) {
		this.testCasesexecutedAutomation = testCasesexecutedAutomation;
	}

}
