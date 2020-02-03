package com.burndown.ui.errordialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * This class shows error message to the user,
 * if user fails to upload excel sheet in Burn Down Chart Section.
 * @author priyanka_gupta
 * 
 */
public class BurnDownExcelSheetErrorDialog extends JFrame {
	private static JDialog jDialog;  
	/**
	 * Initializes frame components.
	 */
	public BurnDownExcelSheetErrorDialog()
		{

	     JOptionPane.showMessageDialog(null,
				    "Please enter an Excel Sheet to continue.","Error",  JOptionPane.ERROR_MESSAGE);	
	 }  
	public static void main(String[] args) {
		new BurnDownExcelSheetErrorDialog();
	}
}
