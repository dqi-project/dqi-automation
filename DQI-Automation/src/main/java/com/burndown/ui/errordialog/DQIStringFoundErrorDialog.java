package com.burndown.ui.errordialog;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JOptionPane;

import com.burndown.util.DQIVariables;

/**
 * * This class shows error message to the user. If string values are found in
 * the uploaded excel sheet.
 * 
 * @author priyanka_gupta
 *
 */
public class DQIStringFoundErrorDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7776739950207168565L;
	private static JDialog jDialog;

	/**
	 * Non-parameterized constructor. Initializes all the frame components.
	 */
	public DQIStringFoundErrorDialog() {

		JOptionPane.showMessageDialog(null,
				"Error in file: " + DQIVariables.getInstance().getFileName() + ". String found at row no. - "
						+ DQIVariables.getInstance().getExceptionAtRowNumber() + " ,column no. - "
						+ DQIVariables.getInstance().getExceptionAtColumnNumber() + ".\n Please enter numeric value.",
				"String Found", JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		new DQIStringFoundErrorDialog();
	}
}
