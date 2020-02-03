/**
 * 
 */
package com.burndown.ui.errordialog;

import java.awt.FlowLayout;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * This error dialog is shown when user 
 * enters characters in Sprint number and Planned Efforts in Hours
 * instead of valid numbers.
 * @author priyanka_gupta
 *
 */
public class BurnDownChartInvalidValuesErrorDialog extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5543513544479265865L;
	private static JDialog jDialog;  

	/**
	 * Initializes frame components.
	 * @throws HeadlessException
	 */
	public BurnDownChartInvalidValuesErrorDialog() throws HeadlessException {
		 
	     JOptionPane.showMessageDialog(null,
				    "Please enter valid Sprint No. and Planned Efforts to continue.","Invalid values",  JOptionPane.ERROR_MESSAGE);	
	}
	public static void main(String[] args) {
		new BurnDownChartInvalidValuesErrorDialog();
	}

}
