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
	private float analysis;
	private float dev;
	private float ut;
	private float codeReview;
	private float internalReviewDefects;
	private float externalReviewDefects;
	private float qADefects;
	private String summary;
	private float hours;

	

	public float getHours() {
		return hours;
	}

	public void setHours(float hours) {
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

	public float getAnalysis() {
		return analysis;
	}

	public float getDev() {
		return dev;
	}

	public void setDev(float dev) {
		this.dev = dev;
	}

	public float getUt() {
		return ut;
	}

	public void setUt(float ut) {
		this.ut = ut;
	}

	public float getCodeReview() {
		return codeReview;
	}

	public void setCodeReview(float codeReview) {
		this.codeReview = codeReview;
	}

	public float getInternalReviewDefects() {
		return internalReviewDefects;
	}

	public void setInternalReviewDefects(float internalReviewDefects) {
		this.internalReviewDefects = internalReviewDefects;
	}

	public float getExternalReviewDefects() {
		return externalReviewDefects;
	}

	public void setExternalReviewDefects(float externalReviewDefects) {
		this.externalReviewDefects = externalReviewDefects;
	}

	public float getqADefects() {
		return qADefects;
	}

	public void setAnalysis(float analysis) {
		this.analysis = analysis;
	}

	public void setqADefects(float qADefects) {
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
