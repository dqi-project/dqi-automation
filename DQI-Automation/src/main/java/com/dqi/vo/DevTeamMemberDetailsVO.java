package com.dqi.vo;
/**
 * 
 * @author akansha.chaudhary
 *
 */
public class DevTeamMemberDetailsVO {
	private String name;
	private String jiraTicketNo;
	private String sprintName;
	private int analysis;
	private int dev;
	private int ut;
	private int codeReview;
	private int internalReviewDefects;
	private int externalReviewDefects;
	private int qADefects;
	private String summary;
	private int hours;

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getJiraTicketNo() {
		return jiraTicketNo;
	}

	public void setJiraTicketNo(String jiraTicketNo) {
		this.jiraTicketNo = jiraTicketNo;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAnalysis() {
		return analysis;
	}

	public void setAnalysis(int analysis) {
		this.analysis = analysis;
	}

	public int getDev() {
		return dev;
	}

	public void setDev(int dev) {
		this.dev = dev;
	}

	public int getUt() {
		return ut;
	}

	public void setUt(int ut) {
		this.ut = ut;
	}

	public int getCodeReview() {
		return codeReview;
	}

	public void setCodeReview(int codeReview) {
		this.codeReview = codeReview;
	}

	public int getInternalReviewDefects() {
		return internalReviewDefects;
	}

	public void setInternalReviewDefects(int internalReviewDefects) {
		this.internalReviewDefects = internalReviewDefects;
	}

	public int getExternalReviewDefects() {
		return externalReviewDefects;
	}

	public void setExternalReviewDefects(int externalReviewDefects) {
		this.externalReviewDefects = externalReviewDefects;
	}


	public int getqADefects() {
		return qADefects;
	}

	public void setqADefects(int qADefects) {
		this.qADefects = qADefects;
	}

	@Override
	public String toString() {
		return "DevTeamMemberDetailsVO [name=" + name + ", jiraTicketNo=" + jiraTicketNo + ", sprintName=" + sprintName
				+ ", analysis=" + analysis + ", dev=" + dev + ", ut=" + ut + ", codeReview=" + codeReview
				+ ", internalReviewDefects=" + internalReviewDefects + ", externalReviewDefects="
				+ externalReviewDefects + ", qADefects=" + qADefects +  ", summary="
				+ summary + ", hours=" + hours + "]";
	}

}
