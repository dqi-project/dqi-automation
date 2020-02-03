/**
 * 
 */
package com.burndown.ui;


import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.dqi.initializer.DQIAutomationApplication;

/**
 * This class shows message to the user that the Excel sheet was created successfully .
 * @author priyanka_gupta
 *
 */
public class DQIExcelCreatedDialog extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Initializes frame components.
	 */
	public DQIExcelCreatedDialog() throws HeadlessException
		{

	     JOptionPane.showMessageDialog(null,
				    "Excel Sheet created!");
	     DQIAutomationApplication.mainFrameInstance.resetDQIData();
	 }  
	public static void main(String[] args) {
	new DQIExcelCreatedDialog();	
	}
}
