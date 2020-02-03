package com.burndown.service;
/**
 * This interface contains abstract method to create and save Burn Down Chart.
 * @author priyanka_gupta
 * 
 */
public interface PlotBurnDownChart 
{
	 public void saveBurnDownChartImage(String fileLocation) throws Exception;//creates line chart and saves it.
}

