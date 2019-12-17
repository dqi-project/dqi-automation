package com.burn.down.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

import com.burn.down.util.Constant;
import com.burn.down.util.Variables;
import com.burn.service.impl.GetBurnDownChart;
import com.dqi.writer.DQIDataWriter;
/**
 * This class shows save dialog to the user to save Burn Down Chart Image.
 * @author priyanka_gupta
 * 
 */
public class BurnDownChartSaveFrame extends JFrame implements ActionListener 
{

	
	JButton saveButton;
	/**
	 * Initializes frame components.
	 */
	public BurnDownChartSaveFrame()
	{
		super("Save");
		
    	 Font myFont = new Font(Constant.FONT_FAMILY, Font.PLAIN,15);
    	 saveButton = new JButton("Save");
    	 saveButton.setFont(myFont);
    	 saveButton.setPreferredSize(new Dimension(200,30));
    	 saveButton.setBounds(100, 200, 10, 10);
    	 saveButton.addActionListener(this);
    	 add(saveButton);
    	 
    	 setLocation(50, 100);
         setSize(400, 200);
         setResizable(false);
         setLayout(new FlowLayout());
         setVisible(true);
    	 setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    	 setLocationRelativeTo(null);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
		 if (ae.getSource() == saveButton && Variables.excelFilePath!=null) 
	        { 
	            // create an object of JFileChooser class 
	            JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
	  
	            // restrict the user to select files of all types 
	            jfileChooser.setAcceptAllFileFilterUsed(true); 
	  
	            // set a title for the dialog 
	            jfileChooser.setDialogTitle("Select a file"); 
	  
	              
	            /**
	             *  invokes the showsSaveDialog function to show the save dialog allowing user to save 
	             *  Burn Down Chart image.
	             */
	            if (jfileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
	  
	            { 
	            	new GetBurnDownChart().saveBurnDownChartImage(jfileChooser.getSelectedFile().getAbsolutePath().toString()+".jpeg");
	                new BurnDownChartSavedImageDialog().setLocationRelativeTo(null); 
	            } 
	        }
		 this.setVisible(false);

	}

}
