package com.burndown.ui.errordialog;

import java.awt.HeadlessException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.burndown.util.DQIVariables;

/**
 * * This class shows error message to the user. If uploaded file is not found
 * then this error dialog is shown.
 * 
 * @author priyanka_gupta
 *
 */
public class DQIFileNotFoundErrorDialog extends JFrame {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1480189261670132747L;
	private static JDialog jDialog;

	/**
	 * Initializes frame components.
	 * 
	 * @throws HeadlessException
	 */
	public DQIFileNotFoundErrorDialog() throws HeadlessException {
		JOptionPane.showMessageDialog(null,
				"The system cannot find the file: " + DQIVariables.getInstance().getFileName(), "File Not Found",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		new DQIFileNotFoundErrorDialog();
	}
}
