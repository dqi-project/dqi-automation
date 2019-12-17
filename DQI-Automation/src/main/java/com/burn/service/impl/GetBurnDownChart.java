//package com.burn.service.impl;
//
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//
//import javax.swing.JFrame;
//import javax.swing.SwingUtilities;
//import javax.swing.WindowConstants;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartFrame;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.category.DefaultCategoryDataset;
//
//
//import com.burn.service.PlotBurnDownChart;
///**
// * 
// * @author priyanka_gupta
// * This class creates Burn Down Chart.
// */
//
//public class GetBurnDownChart extends JFrame implements PlotBurnDownChart
//{
//	Map<Double,Double> map;
//	static JFreeChart jFreeChart;
//	public static String burnDownChartTitle;
//	public static String excelFilePath;
//	
//	/*
//	 * Non-parameterized constructor
//	 */
//	 public GetBurnDownChart()
//	 {
//		 super("Burn Down Chart");   
//		    
//		    // Creates dataset  
//		    DefaultCategoryDataset dataset = createDataset() ;  
//		    
//		    // Creates chart  
//		    jFreeChart = ChartFactory.createLineChart(  
//		        "Burn Down Chart", // Chart title  
//		        "Days", // X-Axis Label  
//		        "Remaining Hours", // Y-Axis Label   
//		        dataset  
//		        );  
//		   
//		    ChartPanel panel = new ChartPanel(jFreeChart);  
//		    setContentPane(panel);
//		    ChartFrame chartFrame = new ChartFrame( "", jFreeChart );
//		    chartFrame.setSize( 1000, 400 );
//	        chartFrame.setVisible( false );
//	       
//	 }
//	 
//	 /*
//	  * Parameterized constructor
//	  */
//	 public GetBurnDownChart(String excelFilePath)
//	 {  
//		    super("Burn Down Chart");   
//		    
//		    // Creates dataset  
//		    DefaultCategoryDataset dataset = createDataset() ;  
//		    
//		    // Creates chart  
//		    jFreeChart = ChartFactory.createLineChart(  
//				   GetBurnDownChart.burnDownChartTitle, // Chart title  
//		        "Days", // X-Axis Label  
//		        "Remaining Hours", // Y-Axis Label   
//		        dataset  
//		        );  
//		   
//		    ChartPanel panel = new ChartPanel(jFreeChart);  
//		    setContentPane(panel);
//		    try
//			 {
//		    	File file=new File(excelFilePath);
//		    	if(false == file.exists())
//			 ChartUtilities.saveChartAsJPEG(file, jFreeChart, 1000, 500);
//		    	
//			
//			 }
//			 catch (IOException e)
//			 {
//				 System.err.println("Error while saving graph image"+e);
//			 }
//		 
//     }
//	 
//	
//	 private DefaultCategoryDataset createDataset() 
//	 { 
//		    String series1 = "Actual Graph";  		     
//		    int dayNumber=0;
//		    
//			
//			double ActualRemainingHours=0.0;
//			double EstimatedRemainingHours=0.0;
//			int countNoOfDays=0;
//		    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		
//		    //Ploting Actual Graph
//		   
//		    map= new GetHoursAndDays().excelReadDaysAndHours(GetBurnDownChart.excelFilePath);		    
//			System.out.println(" |GetBurnDown GetBurnDownChart.excelFilePath= "+GetBurnDownChart.excelFilePath);
//			System.out.println("GetBurnDownChart.burnDownChartTitle = "+GetBurnDownChart.burnDownChartTitle);
//		    dataset.addValue(GetHoursAndDays.plannedEffortsInHours, series1, "Day 0"); //Setting XY Cordinates.
//		    dayNumber++;
//			   
//		    Set set=map.entrySet();
//		    Iterator itr=set.iterator();
//		
//		
//		    while(itr.hasNext())
//		    {		
//		       String str="Day "+dayNumber;	 
//		    
//			   Map.Entry<Double, Double> e = (Map.Entry)itr.next();
//			   ActualRemainingHours=e.getValue();		   
//				   
//			       dataset.addValue(ActualRemainingHours, series1, str); //Setting XY Cordinates.
//			   
//			       dayNumber++;
//			  countNoOfDays++;
//			 }
//		   
//		 
//		    System.out.println("Count= "+countNoOfDays);
//		    
//		    
//		  //Ploting Estimated Graph
//		    double NumberOfDays=countNoOfDays;
//			double HoursperDay =(double)GetHoursAndDays.plannedEffortsInHours/NumberOfDays;
//			dayNumber=0;
//		  String series2 = "Estimated Graph";
//		  EstimatedRemainingHours=GetHoursAndDays.plannedEffortsInHours-HoursperDay;
//		  
//				 
//				dataset.addValue(GetHoursAndDays.plannedEffortsInHours, series2, "Day 0");  //Setting XY Cordinates.
//				dayNumber++;
//			
//		  while(dayNumber<=countNoOfDays)
//		 {
//			 String str="Day "+dayNumber;			
//				
//			 dataset.addValue(EstimatedRemainingHours, series2, str);  //Setting XY Cordinates.
//			
//			 EstimatedRemainingHours = EstimatedRemainingHours - HoursperDay;
//			 dayNumber++;
//		 }
//		 
//		   
//		    return dataset;  
//		 
//		  }  
//	 /*
//	  * Creates Chart.
//	  */
//	 public void createBurnDownChart(String excelFilePath1) 
//	 {
//		 System.out.println(excelFilePath1);
//		 GetBurnDownChart.excelFilePath = excelFilePath1;
//		 SwingUtilities.invokeLater(() -> {  
//	    	 	
//             GetBurnDownChart getBurnDownChart = new GetBurnDownChart(); 
//             getBurnDownChart.setAlwaysOnTop(true);  
//             getBurnDownChart.pack();  
//             getBurnDownChart.setSize(700, 400);  
//             getBurnDownChart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
//             getBurnDownChart.setVisible(false);
//             getBurnDownChart.setLocationRelativeTo(null);
//           }
//    );  
//		 
//		 
//	 }
//
//	 /*
//	  * Creates and saves Chart.
//	  */
//	 public void saveBurnDownChartImage(String fileLocation)
//	 {
//		 SwingUtilities.invokeLater(() -> {  
//	    	 	
//             GetBurnDownChart getBurnDownChart = new GetBurnDownChart(fileLocation); 
//             getBurnDownChart.setAlwaysOnTop(true);  
//             getBurnDownChart.pack();  
//             getBurnDownChart.setSize(700, 400);  
//             getBurnDownChart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
//             getBurnDownChart.setVisible(false);
//             getBurnDownChart.setLocationRelativeTo(null);
//           }
//    );  
//		
//         System.out.println("Images were written succesfully.");
//	 }
//	
//}	 
package com.burn.service.impl;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import com.burn.down.util.Variables;
import com.burn.service.PlotBurnDownChart;
/**
 * This class plots Burn Down Chart.
 * @author priyanka_gupta
 * 
 */

public class GetBurnDownChart extends JFrame implements PlotBurnDownChart
{
	Map<Double,Double> map;
	static JFreeChart jFreeChart;
 
	/*
	 * Default constructor
	 */
	 public GetBurnDownChart()
	 {
//		 super("Burn Down Chart");   
//		    
//		    // Creates dataset  
//		    DefaultCategoryDataset dataset = createDataset() ;  
//		    
//		    // Creates chart  
//		    jFreeChart = ChartFactory.createLineChart(  
//		        "Burn Down Chart", // Chart title  
//		        "Days", // X-Axis Label  
//		        "Remaining Hours", // Y-Axis Label   
//		        dataset  
//		        );  
//		   
//		    ChartPanel panel = new ChartPanel(jFreeChart);  
//		    setContentPane(panel);
//		    ChartFrame chartFrame = new ChartFrame( "", jFreeChart );
//		    chartFrame.setSize( 1000, 400 );
//	        chartFrame.setVisible( false );
	       
	 }
	 
	 /*
	  * Parameterized constructor
	  * Initializes DefaultCategoryDataset, JFreeChart and ChartPanel
	  * reference variables. 
	  */
	 public GetBurnDownChart(String excelFilePath)
	 {  
		    super("Burn Down Chart");   
		    
		    // Creates dataset  
		    DefaultCategoryDataset dataset = createDataset() ;  
		    
		    // Creates chart  
		    jFreeChart = ChartFactory.createLineChart(  
				   Variables.burnDownChartTitle, // Chart title  
		        "Days", // X-Axis Label  
		        "Remaining Hours", // Y-Axis Label   
		        dataset  
		        );  
		   
		    ChartPanel panel = new ChartPanel(jFreeChart);  
		    setContentPane(panel);
		    try
			 {
		    	File file=new File(excelFilePath);
		    	if(false == file.exists())
			 ChartUtilities.saveChartAsJPEG(file, jFreeChart, 1000, 500);
		    	
			
			 }
			 catch (IOException e)
			 {
				 System.err.println("Error while saving graph image"+e);
			 }
		 
     }
	 
	
	 private DefaultCategoryDataset createDataset() 
	 { 
		    String series1 = "Actual Graph";  		     
		    int dayNumber=0;
		    
			
			double ActualRemainingHours=0.0;
			double EstimatedRemainingHours=0.0;
			int countNoOfDays=0;
		    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		    //Ploting Actual Graph
		   
		    map= new GetHoursAndDays().excelReadDaysAndHours(Variables.excelFilePath);		    
				   
		    dataset.addValue(Variables.plannedEffortsInHours, series1, "Day 0"); //Setting XY Cordinates.
		    dayNumber++;
			   
		    Set set=map.entrySet();
		    Iterator itr=set.iterator();
		
		
		    while(itr.hasNext())
		    {		
		       String str="Day "+dayNumber;	 
		    
			   Map.Entry<Double, Double> e = (Map.Entry)itr.next();
			   ActualRemainingHours=e.getValue();		   
				   
			       dataset.addValue(ActualRemainingHours, series1, str); //Setting XY Cordinates.
			   
			       dayNumber++;
			  countNoOfDays++;
			 }
		   
		 
		    System.out.println("Count= "+countNoOfDays);
		    
		    
		  //Ploting Estimated Graph
		    double NumberOfDays=countNoOfDays;
			double HoursperDay =(double)Variables.plannedEffortsInHours/NumberOfDays;
			dayNumber=0;
		  String series2 = "Estimated Graph";
		  EstimatedRemainingHours=Variables.plannedEffortsInHours-HoursperDay;
		  
				 
				dataset.addValue(Variables.plannedEffortsInHours, series2, "Day 0");  //Setting XY Cordinates.
				dayNumber++;
			
		  while(dayNumber<=countNoOfDays)
		 {
			 String str="Day "+dayNumber;			
				
			 dataset.addValue(EstimatedRemainingHours, series2, str);  //Setting XY Cordinates.
			
			 EstimatedRemainingHours = EstimatedRemainingHours - HoursperDay;
			 dayNumber++;
		 }
		 
		   
		    return dataset;  
		 
		  }  
	 /*
	  * Creates Line Chart.
	  */
	 public void createBurnDownChart(String excelFilePath1) 
	 {
		 System.out.println(excelFilePath1);
		 Variables.excelFilePath = excelFilePath1;
		 SwingUtilities.invokeLater(() -> {  
	    	 	
             GetBurnDownChart getBurnDownChart = new GetBurnDownChart(); 
             getBurnDownChart.setAlwaysOnTop(true);  
             getBurnDownChart.pack();  
             getBurnDownChart.setSize(700, 400);  
             getBurnDownChart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
             getBurnDownChart.setVisible(false);
             getBurnDownChart.setLocationRelativeTo(null);
           }
    );  
		 
		 
	 }

	 /*
	  * Creates and saves Line Chart.
	  */
	 public void saveBurnDownChartImage(String fileLocation)
	 {
		 SwingUtilities.invokeLater(() -> {  
	    	 	
             GetBurnDownChart getBurnDownChart = new GetBurnDownChart(fileLocation); 
             getBurnDownChart.setAlwaysOnTop(true);  
             getBurnDownChart.pack();  
             getBurnDownChart.setSize(700, 400);  
             getBurnDownChart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
             getBurnDownChart.setVisible(false);
             getBurnDownChart.setLocationRelativeTo(null);
           }
    );  
		
         System.out.println("Images were written succesfully.");
	 }
	
}	 