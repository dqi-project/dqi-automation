package com.burndown.ui.errordialog;


import java.awt.HeadlessException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * In Burn Down Chart section,
 * BurnDownChartInvalidExcelSheetErrorDialog is shown
 * when user uploads invalid excel sheet.
 * @author priyanka_gupta
 *
 */
public class BurnDownChartInvalidExcelSheetErrorDialog extends JFrame 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1597155618986541269L;
	private static JDialog jDialog;  
	
	/*
	 * Initializes all frame components.
	 */
	public BurnDownChartInvalidExcelSheetErrorDialog() throws HeadlessException 
	{
	     JOptionPane.showMessageDialog(null,
				    "Enter valid excel sheet to continue.","Invalid Values",  JOptionPane.ERROR_MESSAGE);
	}

}
