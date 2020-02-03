package com.burndown.ui.errordialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class shows error message to the user, if user fails to write Sprint
 * Number or Planned Efforts or both in Burn Down Chart section.
 * 
 * @author priyanka_gupta
 * 
 */
public class BurnDownSprintNumberAndPlannedHoursErrorDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JDialog jDialog;

	/**
	 * Initializes frame components.
	 */
	public BurnDownSprintNumberAndPlannedHoursErrorDialog() {

		JOptionPane.showMessageDialog(null, "Please enter Sprint Number and Planned Efforts.", "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		new BurnDownSprintNumberAndPlannedHoursErrorDialog();
	}
}
