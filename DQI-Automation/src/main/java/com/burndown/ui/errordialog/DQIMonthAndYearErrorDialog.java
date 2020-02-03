package com.burndown.ui.errordialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class shows error to the user if user fails to enter valid Month and
 * Year in DQI Parameters section.
 * 
 * @author priyanka_gupta
 * 
 */
public class DQIMonthAndYearErrorDialog extends JFrame {
	private static JDialog jDialog;

	public DQIMonthAndYearErrorDialog() {

		JOptionPane.showMessageDialog(null, " Please enter Month and Year.", "Empty Month - Year!",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		new DQIMonthAndYearErrorDialog();
	}
}
