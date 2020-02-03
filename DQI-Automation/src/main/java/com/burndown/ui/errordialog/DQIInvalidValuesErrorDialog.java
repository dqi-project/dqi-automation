/**
 * 
 */
package com.burndown.ui.errordialog;

import java.awt.HeadlessException;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JOptionPane;

/**
 * * This class shows error message to the user. If user enters invalid values
 * in the fields then this error dialog is shown.
 * 
 * @author priyanka_gupta
 *
 */
public class DQIInvalidValuesErrorDialog extends JFrame {

	private static JDialog jDialog;

	/**
	 * Initializes frame components.
	 * 
	 * @throws HeadlessException
	 */
	public DQIInvalidValuesErrorDialog() throws HeadlessException {

		JOptionPane.showMessageDialog(null, " Please enter valid Sprint No. and Story Points to continue.",
				"Invalid Values", JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		new DQIInvalidValuesErrorDialog();
	}
}
