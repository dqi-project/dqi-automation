package com.burn.down.ui.errordialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * This class shows error message to the user.
 * If user fails to select a radio button in DQI Parameters section.
 * @author priyanka_gupta
 * 
 */
public class DQIRadioButtonErrorDialog extends JFrame
{
	private static JDialog jDialog;  
	/**
	 * Initializes frame components.
	 */
public DQIRadioButtonErrorDialog()
	{
	jDialog = new JDialog(this , "Error", true);  
	jDialog.setLayout( new FlowLayout() );  
     JButton b = new JButton ("OK");  
     b.addActionListener ( new ActionListener()  
     {  
         public void actionPerformed( ActionEvent e )  
         {  
        	 DQIRadioButtonErrorDialog.jDialog.setVisible(false);  
         }  
     });  
     jDialog.add( new JLabel ("Select an option to continue."));  
     jDialog.add(b);   
     jDialog.setSize(300,100);       
     jDialog.setLocationRelativeTo(null);
     jDialog.setVisible(true);
 }   
}
