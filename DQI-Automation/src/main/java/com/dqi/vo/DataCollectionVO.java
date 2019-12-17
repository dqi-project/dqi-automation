package com.dqi.vo;
/**
 * 
 * @author akansha.chaudhary
 *
 */
public class DataCollectionVO {
	private String name;
	private double totalAnalysis;
	private double totalDev;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalAnalysis() {
		return totalAnalysis;
	}

	public void setTotalAnalysis(double totalAnalysis) {
		this.totalAnalysis = totalAnalysis;
	}

	public double getTotalDev() {
		return totalDev;
	}

	public void setTotalDev(double totalDev) {
		this.totalDev = totalDev;
	}

	@Override
	public String toString() {
		return "DataCollectionVO [name=" + name + ", totalAnalysis=" + totalAnalysis + ", totalDev=" + totalDev + "]";
	}

}
