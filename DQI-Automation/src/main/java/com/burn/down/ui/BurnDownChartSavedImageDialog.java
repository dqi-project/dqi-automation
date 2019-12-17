package com.burn.down.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class shows message to the user that the Burn Down Chart Image was saved successfully.
 * @author priyanka_gupta
 * 
 */
public class BurnDownChartSavedImageDialog extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	private static JDialog jDialog;  
	/**
	 * Initializes frame components.
	 */
	public BurnDownChartSavedImageDialog()
		{
		jDialog = new JDialog(this , "Saved!", true); 
		jDialog.setLayout( new FlowLayout() );  
	     JButton button = new JButton ("OK"); 

	     button.addActionListener ( new ActionListener()  
	     {  
	         public void actionPerformed( ActionEvent e )  
	         {  
	        	 BurnDownChartSavedImageDialog.jDialog.setVisible(false);  
	         }  
	     });  
	     jDialog.add( new JLabel ("Image was successfully saved."));  
	     jDialog.add(button);   
	     jDialog.setSize(300,100);   
	     setLocation(32, 32);
	     jDialog.setLocationRelativeTo(null);
	     jDialog.setVisible(true);  
	     
	 }  

}
