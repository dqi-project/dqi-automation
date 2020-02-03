package com.burndown.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.dqi.initializer.DQIAutomationApplication;

/**
 * This class shows message to the user that the Burn Down Chart Image was saved
 * successfully.
 * 
 * @author priyanka_gupta
 * 
 */
public class BurnDownChartImageSavedDialog extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Initializes frame components.
	 */
	public BurnDownChartImageSavedDialog() {

		JOptionPane.showMessageDialog(null, "Image Saved!");
		DQIAutomationApplication.mainFrameInstance.resetBurnDownData();
	}

	public static void main(String[] args) {
		new BurnDownChartImageSavedDialog();
	}
}
