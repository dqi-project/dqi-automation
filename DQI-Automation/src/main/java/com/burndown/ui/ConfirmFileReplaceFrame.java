/**
 * 
 *//*
package com.burndown.ui;

import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.burndown.util.DQIVariables;

*//**
 * @author priyanka_gupta
 *
 *//*
public class ConfirmFileReplaceFrame extends JFrame {

	*//**
	 * serialVersionUID
	 *//*
	private static final long serialVersionUID = 8832448215211537200L;
	public static int input;

	*//**
	 * @throws HeadlessException
	 *//*
	public ConfirmFileReplaceFrame() throws HeadlessException {

		JFrame frame = new JFrame();
		String fileName = new File(DQIVariables.getInstance().getdQIfinalSheetPath() + ".xlsx").getName();
		input = JOptionPane.showConfirmDialog(frame, "Would you like green eggs and ham?", "An Inane Question",
				JOptionPane.YES_NO_OPTION);

		if (input == 0)
			new DQISaveFrame();

		setLocationRelativeTo(null);
		setLocation(32, 32);
		setSize(100, 100);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ConfirmFileReplaceFrame();
	}
}
*/