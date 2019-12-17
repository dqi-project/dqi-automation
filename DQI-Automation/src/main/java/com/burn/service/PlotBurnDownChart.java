package com.burn.service;
/**
 * This interface contains abstract methods to create and save Burn Down Chart.
 * @author priyanka_gupta
 * 
 */
public interface PlotBurnDownChart 
{
	public void createBurnDownChart(String excelFilePath);//creates line chart
	 public void saveBurnDownChartImage(String fileLocation);//creates line chart and saves it.
}
