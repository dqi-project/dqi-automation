package com.burn.down.ui.errordialog;

/**
 * 
 * This class shows error message to the user, 
 * if user fails to fill one or more fields either in DQI Parameters section or in Burn Down Chart section.
 * @author priyanka_gupta
 * 
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EmptyFieldsErrorDialog extends JFrame {
	private static JDialog jDialog;  
	/**
	 * Initializes frame components.
	 */
	public EmptyFieldsErrorDialog()
		{
		jDialog = new JDialog(this , "Error", true);  
		jDialog.setLayout( new FlowLayout() );  
	     JButton jButton = new JButton ("OK");  
	     jButton.addActionListener ( new ActionListener()  
	     {  
	         public void actionPerformed( ActionEvent e )  
	         {  
	        	 EmptyFieldsErrorDialog.jDialog.setVisible(false);  
	         }  
	     });  
	     jDialog.add( new JLabel ("Fields cannot be empty."));  
	     jDialog.add(jButton);   
	     
	     jDialog.setSize(300,100);    	    
	     jDialog.setLocationRelativeTo(null);
	     jDialog.setVisible(true); 
	 }  
}
