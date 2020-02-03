/**
 * 
 */
package com.burndown.ui.errordialog;

import java.awt.HeadlessException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.burndown.util.DQIVariables;

/**
 * * This class shows error message to the user. If invalid excel sheet is
 * uploaded then this error dialog is shown.
 * 
 * @author priyanka_gupta
 *
 */
public class DQIInvalidExcelSheetErrorDialog extends JFrame {
	/**
		 * 
		 */
	private static final long serialVersionUID = 4119198840388395051L;

	private static JDialog jDialog;

	/**
	 * 
	 * Initializes all frame components.
	 * 
	 * @throws HeadlessException
	 */
	public DQIInvalidExcelSheetErrorDialog() throws HeadlessException {

		JOptionPane.showMessageDialog(null, DQIVariables.getInstance().getFileName() + " is not a valid file.", "Error",
				JOptionPane.ERROR_MESSAGE);
		DQIVariables.getInstance().setFileName(null);
	}

	public static void main(String[] args) {
		new DQIInvalidExcelSheetErrorDialog();
	}
}
