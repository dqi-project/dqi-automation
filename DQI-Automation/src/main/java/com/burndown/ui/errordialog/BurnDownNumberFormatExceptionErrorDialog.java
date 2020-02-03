package com.burndown.ui.errordialog;


import java.awt.HeadlessException;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.burndown.util.BurnDownVariables;
/**
 * * This class shows error message to the user.
 * If string values are found in uploaded excel sheet then this error dialog is shown.
 * @author priyanka_gupta
 *
 */
public class BurnDownNumberFormatExceptionErrorDialog extends JFrame {

	private static JDialog jDialog;  
	

	/*
	 * Initializes all frame components.
	 */
	public BurnDownNumberFormatExceptionErrorDialog() throws HeadlessException 
	{

	     JOptionPane.showMessageDialog(null,
	    		 "String found at row no. - "+BurnDownVariables.getInstance().getExceptionAtRowNumber()
                 +" ,column no. - "+BurnDownVariables.getInstance().getExceptionAtColumnNumber()
                 +".\n Please enter numeric value.","String Found",  JOptionPane.ERROR_MESSAGE);	
	}
public static void main(String[] args) {
	new BurnDownNumberFormatExceptionErrorDialog();
}
}
