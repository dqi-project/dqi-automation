package com.burn.down.ui.errordialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.burn.down.util.Constant;
/**
 * This class shows error to the user if user fails to enter valid 	Month and Year 
 * in DQI Parameters section. 
 * @author priyanka_gupta
 * 
 */
public class DQIMonthAndYearErrorDialog extends JFrame {
	private static JDialog jDialog;  
	public DQIMonthAndYearErrorDialog()
		{
		jDialog = new JDialog(this , "Error", true); 
	     JButton jButton = new JButton ("OK");  
	     jButton.setBounds(10, 20, 40, 40);
	     jButton.addActionListener ( new ActionListener()  
	     {  
	         public void actionPerformed( ActionEvent e )  
	         {  
	        	 DQIMonthAndYearErrorDialog.jDialog.setVisible(false);  
	        	 
	         }  
	     });  
	     jDialog.add( new JLabel ("Please enter valid Month and Year."));  
	    
	     jDialog.add(jButton);
	     jDialog.setLayout( new FlowLayout() );
	     jDialog.setSize(300,100);
	     jDialog.setLocationRelativeTo(null);
	     jDialog.setVisible(true);
	 }  
}
