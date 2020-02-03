package com.burndown.service.impl;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import com.burndown.service.PlotBurnDownChart;
import com.burndown.util.BurnDownVariables;

/**
 * This class plots Burn Down Chart.
 * 
 * @author priyanka_gupta
 * 
 */

public class GetBurnDownChart extends JFrame implements PlotBurnDownChart {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(GetBurnDownChart.class);

	public static Map<Double, Double> daysAndHoursMap;
	int countNoOfDays = 0;
	static JFreeChart jFreeChart;

	/**
	 * Default constructor
	 */
	public GetBurnDownChart() {
	}


	/**
	 * @param imageSavingLocation
	 *            Parameterized constructor. Initializes DefaultCategoryDataset,
	 *            JFreeChart and ChartPanel reference variables.
	 * @throws Exception 
	 * 
	 */
	public GetBurnDownChart(String imageSavingLocation) throws Exception {
		super("Burn Down Chart");

		// Creates dataset
		DefaultCategoryDataset dataset = createDataset();

		// Creates chart
		jFreeChart = ChartFactory.createLineChart(BurnDownVariables.getInstance().getBurnDownChartTitle(), // Chart
																											// title
				"Days", // X-Axis Label
				"Remaining Hours", // Y-Axis Label
				dataset);

		ChartPanel panel = new ChartPanel(jFreeChart);
		setContentPane(panel);
		try {
			File file = new File(imageSavingLocation);
			
				ChartUtilities.saveChartAsJPEG(file, jFreeChart, 1000, 500);
				daysAndHoursMap=null;
				BurnDownVariables.getInstance().resetData();
		}
			catch (Exception message) {	
			logger.error("Exception in GetBurnDownChart class ", message);
			throw new Exception();
		}
	}

	/**
	 * 
	 * @return dataset
	 */
	private DefaultCategoryDataset createDataset() {
		String series1 = "Actual Graph";
		int dayNumber = 0;

		double ActualRemainingHours = 0.0;
		double EstimatedRemainingHours = 0.0;

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// Plotting Actual Graph

			dataset.addValue(BurnDownVariables.getInstance().getPlannedEffortsInHours(), series1, "Day 0"); // Setting
																											// XY
																											// Cordinates.
			dayNumber++;

			Set<Entry<Double, Double>> set = daysAndHoursMap.entrySet();
			Iterator<Entry<Double, Double>> itr = set.iterator();

			while (itr.hasNext()) {
				String str = "Day " + dayNumber;

				Map.Entry<Double, Double> e = (Entry<Double, Double>) itr.next();
				ActualRemainingHours = e.getValue();

				dataset.addValue(ActualRemainingHours, series1, str); // Setting
																		// XY
																		// Cordinates.

				dayNumber++;
				countNoOfDays++;
			}

			// Plotting Estimated Graph
			double NumberOfDays = countNoOfDays;
			double HoursperDay = (double) BurnDownVariables.getInstance().getPlannedEffortsInHours() / NumberOfDays;
			dayNumber = 0;
			String series2 = "Estimated Graph";
			EstimatedRemainingHours = BurnDownVariables.getInstance().getPlannedEffortsInHours() - HoursperDay;

			dataset.addValue(BurnDownVariables.getInstance().getPlannedEffortsInHours(), series2, "Day 0"); // Setting
																											// XY
																											// Cordinates.
			dayNumber++;

			while (dayNumber <= countNoOfDays) {
				String str = "Day " + dayNumber;

				dataset.addValue(EstimatedRemainingHours, series2, str); // Setting
																			// XY
																			// Cordinates.

				EstimatedRemainingHours = EstimatedRemainingHours - HoursperDay;
				dayNumber++;
			}
		

		return dataset;

	}



	/**
	 * Creates and saves Line Chart.
	 * 
	 * @param imageSavingLocation
	 * @throws Exception 
	 */
	public void saveBurnDownChartImage(String imageSavingLocation) throws Exception {
		GetBurnDownChart getBurnDownChart = new GetBurnDownChart(imageSavingLocation);
		getBurnDownChart.setAlwaysOnTop(true);
		getBurnDownChart.pack();
		getBurnDownChart.setSize(700, 400);
		getBurnDownChart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getBurnDownChart.setVisible(false);
		getBurnDownChart.setLocationRelativeTo(null);
	}

}
