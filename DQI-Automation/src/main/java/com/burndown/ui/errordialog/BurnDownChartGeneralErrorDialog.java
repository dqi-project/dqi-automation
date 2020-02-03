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
 * @author priyanka_gupta
 *
 */
public class BurnDownChartGeneralErrorDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7998203856862159904L;
	private JDialog jDialog;  
	/**
	 * Initializes frame components.
	 * @throws HeadlessException
	 */
	public BurnDownChartGeneralErrorDialog() throws HeadlessException {

		     JOptionPane.showMessageDialog(null,
					    "Error occurred while saving image. Please try again.");
		
	}
public static void main(String[] args) {
	new BurnDownChartGeneralErrorDialog();
}
}
