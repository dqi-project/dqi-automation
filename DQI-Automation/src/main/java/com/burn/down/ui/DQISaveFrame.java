package com.burn.down.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

import com.burn.down.util.Variables;
import com.dqi.process.DQIDataProcessor;

/**
 * This class shows save dialog to the user to save generated excel sheet in DQI Parameters section.
 * @author priyanka_gupta
 * 
 */
public class DQISaveFrame extends JFrame implements ActionListener {

	JButton saveButton;
	/**
	 * Initializes frame components.
	 */
	public DQISaveFrame()
	{
		super("Save");
		
    	 Font myFont = new Font("Arial", Font.PLAIN,15);
    	 saveButton = new JButton("Save");
    	 saveButton.setFont(myFont);
    	 saveButton.setPreferredSize(new Dimension(200,30));
    	 saveButton.setBounds(100, 200, 10, 10);
    	 saveButton.addActionListener(this);
    	 add(saveButton);
    	 
    	 setLocation(50, 100);
         setSize(500, 200);
         setResizable(false);
         setLayout(new FlowLayout());
         setVisible(true);
    	 setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    	 setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
		 if (ae.getSource() == saveButton) 
	        { 
	            // create an object of JFileChooser class 
	            JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
	  
	            // restrict the user to select files of all types 
	            jfileChooser.setAcceptAllFileFilterUsed(true); 
	  
	            // set a title for the dialog 
	            jfileChooser.setDialogTitle("Select a file"); 	            
	  
	            
	            
	            /**
	             *  invokes the showsSaveDialog function to show the save dialog allowing user to save 
	             *  generated excel sheet.
	             */
	            if (jfileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
	  
	            { 
	            	Variables.finalSheetPath=jfileChooser.getSelectedFile().getAbsolutePath().toString();
	            	try 
	            	{
	    				new DQIDataProcessor().process();
	    			} 
	            	catch (IOException e) 
	            	{
	    				e.printStackTrace();
	    			}

                } 
	        }
		 
			setVisible(false);
	}

}
