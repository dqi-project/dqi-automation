package com.burndown.ui.errordialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class shows error message to user if user fails to upload excel sheets
 * in DQI Parameters section.
 * 
 * @author priyanka_gupta
 * 
 */
public class DQIExcelSheetErrorDialog extends JFrame {
	private static JDialog jDialog;

	/**
	 * Initializes frame components.
	 */
	public DQIExcelSheetErrorDialog() {

		JOptionPane.showMessageDialog(null, "Please enter Excel Sheets to continue.", "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		new DQIExcelSheetErrorDialog();
	}
}
