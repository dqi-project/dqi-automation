package com.dqi.vo;
/**
 * 
 * 
 * @author akansha.chaudhary
 *
 */
public class DevTeamDataAggregatorVO {
	private double totalDevEfforts;
	private double totalAnalysis;
	private double totalUT;
	private double totalCodeReview;
	private double totalInternalReviewDefects;
	private double totalExternalReviewDefects;
	private double totalQADefects;
	private double totalStoryPoints;

	public double getTotalDevEfforts() {
		return totalDevEfforts;
	}

	public void setTotalDevEfforts(double totalDevEfforts) {
		this.totalDevEfforts = totalDevEfforts;
	}

	public double getTotalAnalysis() {
		return totalAnalysis;
	}

	public void setTotalAnalysis(double totalAnalysis) {
		this.totalAnalysis = totalAnalysis;
	}

	public double getTotalUT() {
		return totalUT;
	}

	public void setTotalUT(double totalUT) {
		this.totalUT = totalUT;
	}

	public double getTotalCodeReview() {
		return totalCodeReview;
	}

	public void setTotalCodeReview(double totalCodeReview) {
		this.totalCodeReview = totalCodeReview;
	}

	public double getTotalInternalReviewDefects() {
		return totalInternalReviewDefects;
	}

	public void setTotalInternalReviewDefects(double totalInternalReviewDefects) {
		this.totalInternalReviewDefects = totalInternalReviewDefects;
	}

	public double getTotalExternalReviewDefects() {
		return totalExternalReviewDefects;
	}

	public void setTotalExternalReviewDefects(double totalExternalReviewDefects) {
		this.totalExternalReviewDefects = totalExternalReviewDefects;
	}

	public double getTotalQADefects() {
		return totalQADefects;
	}

	public void setTotalQADefects(double totalQADefects) {
		this.totalQADefects = totalQADefects;
	}

	public double getTotalStoryPoints() {
		return totalStoryPoints;
	}

	public void setTotalStoryPoints(double totalStoryPoints) {
		this.totalStoryPoints = totalStoryPoints;
	}

	@Override
	public String toString() {
		return "DevTeamDataAggregatorVO [totalDevEfforts=" + totalDevEfforts + ", totalAnalysis=" + totalAnalysis
				+ ", totalUT=" + totalUT + ", totalCodeReview=" + totalCodeReview + ", totalInternalReviewDefects="
				+ totalInternalReviewDefects + ", totalExternalReviewDefects=" + totalExternalReviewDefects
				+ ", totalQADefects=" + totalQADefects + ", totalStoryPoints=" + totalStoryPoints + "]";
	}

}