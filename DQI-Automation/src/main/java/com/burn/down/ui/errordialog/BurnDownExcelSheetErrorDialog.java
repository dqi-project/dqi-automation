package com.burn.down.ui.errordialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		jDialog = new JDialog(this , "Error", true);  
		jDialog.setLayout( new FlowLayout() );  
	     JButton jButton = new JButton ("OK");  
	     jButton.addActionListener ( new ActionListener()  
	     {  
	         public void actionPerformed( ActionEvent e )  
	         {  
	        	 BurnDownExcelSheetErrorDialog.jDialog.setVisible(false);  
	         }  
	     });  
	     jDialog.add( new JLabel ("Please enter Excel Sheet to continue."));  
	     jDialog.add(jButton);   
	    
	     jDialog.setSize(300,100); 	     
	     jDialog.setLocationRelativeTo(null);
	     jDialog.setVisible(true);
	 }  
}
