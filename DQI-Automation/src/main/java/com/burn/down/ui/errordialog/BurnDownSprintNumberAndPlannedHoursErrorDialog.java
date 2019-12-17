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
 * if user fails to write Sprint Number or Planned Efforts or both 
 * in Burn Down Chart section.
 * @author priyanka_gupta
 * 
 */
public class BurnDownSprintNumberAndPlannedHoursErrorDialog extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static JDialog jDialog; 
	
	/**
	 * Initializes frame components.
	 */
	public BurnDownSprintNumberAndPlannedHoursErrorDialog()
		{
		jDialog = new JDialog(this , "Error", true);  
		jDialog.setLayout( new FlowLayout() );  
	     JButton jButton = new JButton ("OK");  
	     jButton.addActionListener ( new ActionListener()  
	     {  
	         public void actionPerformed( ActionEvent e )  
	         {  
	        	 BurnDownSprintNumberAndPlannedHoursErrorDialog.jDialog.setVisible(false);  
	         }  
	     });  
	     jDialog.add( new JLabel ("Please enter Sprint Number and Planned Efforts."));  
	     jDialog.add(jButton);   
	     
	     jDialog.setSize(400,100);    	    
	     jDialog.setLocationRelativeTo(null);
	     jDialog.setVisible(true); 
	 }  
}
