package com.burndown.ui.errordialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class shows error message to the user. If user fails to select a radio
 * button in DQI Parameters section.
 * 
 * @author priyanka_gupta
 * 
 */
public class DQIRadioButtonErrorDialog extends JFrame {
	private static JDialog jDialog;

	/**
	 * Initializes frame components.
	 */
	public DQIRadioButtonErrorDialog() {

		JOptionPane.showMessageDialog(null, " Select an option to continue.", "Error", JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		new DQIRadioButtonErrorDialog();
	}
}
