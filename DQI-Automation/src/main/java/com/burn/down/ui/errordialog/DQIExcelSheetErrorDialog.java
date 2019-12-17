package com.burn.down.ui.errordialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * This class shows error message to user if user fails to upload excel sheets
 * in DQI Parameters section.
 * @author priyanka_gupta
 * 
 */
public class DQIExcelSheetErrorDialog extends JFrame {
	private static JDialog jDialog;  
	/**
	 * Initializes frame components.
	 */
	public DQIExcelSheetErrorDialog()
		{
		jDialog = new JDialog(this , "Error", true);  
		jDialog.setLayout( new FlowLayout() );  
	     JButton jButton = new JButton ("OK");  
	     jButton.addActionListener ( new ActionListener()  
	     {  
	         public void actionPerformed( ActionEvent e )  
	         {  
	        	 DQIExcelSheetErrorDialog.jDialog.setVisible(false);  
	         }  
	     });  
	     jDialog.add( new JLabel ("Please enter Excel Sheets to continue."));  
	     jDialog.add(jButton);   
	     
	     jDialog.setSize(300,100);    
	     jDialog.setVisible(true);  
	     jDialog.setLocationRelativeTo(null);
	 }  
}
