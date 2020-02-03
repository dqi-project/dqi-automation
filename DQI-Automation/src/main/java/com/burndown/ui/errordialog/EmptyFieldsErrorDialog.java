package com.burndown.ui.errordialog;

/**
 * 
 * This class shows error message to the user, 
 * if user fails to fill one or more fields either in DQI Parameters section or in Burn Down Chart section.
 * @author priyanka_gupta
 * 
 */

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EmptyFieldsErrorDialog extends JFrame {
	private static JDialog jDialog;

	/**
	 * Initializes frame components.
	 */
	public EmptyFieldsErrorDialog() {

		JOptionPane.showMessageDialog(null, " Fields cannot be empty.", "Empty Fields Error!",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		new EmptyFieldsErrorDialog();
	}
}
