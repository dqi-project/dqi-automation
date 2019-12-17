package com.burn.down.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.apache.poi.ss.usermodel.IndexedColors;

import com.burn.down.ui.errordialog.EmptyFieldsErrorDialog;
import com.burn.down.ui.errordialog.DQIRadioButtonErrorDialog;
import com.burn.down.ui.errordialog.BurnDownSprintNumberAndPlannedHoursErrorDialog;
import com.burn.down.ui.errordialog.BurnDownExcelSheetErrorDialog;
import com.burn.down.ui.errordialog.DQIMonthAndYearErrorDialog;
import com.burn.down.util.Constant;
import com.burn.down.util.Variables;

/**
 * 
 * This class shows frame to the user. Frame displays DQI Parameters section and Burn Down Chart section.
 * @author priyanka_gupta
 * 
 */
public class MainFrame extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	static String month = null;//To store month from dropDownMonth.
	static String year = null;//To store year from dropDownYear.
	
	// Declaration of reference variables.
	JButton dQIbrowsebutton1, dQIbrowsebutton2, dQIsubmitButton1, burnDownBrowseButton, burnDownSubmitButton;
	JTextField dQITextField1, dQITextField2, burnDownChartTextField1;
	JTextField dQITextFieldSprintNumber, dQITextFieldStoryPoints,
	           burnDownTextFieldSprintNumber, burnDownTextFieldPlannedEffortsInHours;
	JRadioButton jiraRadioButton;
	JRadioButton mannualRadioButton;
	JComboBox dropDownMonth, dropDownYear;

	
	/**
	 * Initializes all the components of the main frame.
	 */	
	public MainFrame() {
		
		//Sets frame's title.
		super("DQI Automation and Burn Down Chart");

		Font font1 = new Font(Constant.FONT_FAMILY, Font.PLAIN, 12);
		Font font2 = new Font(Constant.FONT_FAMILY, Font.BOLD, 15);
		
		//Initialization of DQI Parameters Section components.
		
		JLabel dQIMainLabel = new JLabel(Constant.DQI_MAIN_LABEL);
		dQIMainLabel.setVisible(true);
		dQIMainLabel.setFont(font1);
		dQIMainLabel.setBounds(5, 9, 250, 15);
		
		JLabel labelDQISprintNumber = new JLabel(Constant.SPRINT_NUMBER);
		labelDQISprintNumber.setVisible(true);
		labelDQISprintNumber.setFont(font1);
		labelDQISprintNumber.setBounds(50, 48, 250, 15);
		
		JLabel labelDQIStoryPoints = new JLabel(Constant.STORY_POINTS);
		labelDQIStoryPoints.setVisible(true);
		labelDQIStoryPoints.setFont(font1);
		labelDQIStoryPoints.setBounds(65, 78, 250, 15);
		
		dQITextFieldSprintNumber = new JTextField();
		dQITextFieldSprintNumber.setBounds(170, 46, 60, 20);
		
		dQITextFieldStoryPoints = new JTextField();
		dQITextFieldStoryPoints.setBounds(170, 78, 60, 20);
		
		JLabel labelDQIMonthYear = new JLabel(Constant.DATE);
		labelDQIMonthYear.setVisible(true);
		labelDQIMonthYear.setFont(font1);
		labelDQIMonthYear.setBounds(45, 110, 250, 15);
		
		dropDownMonth = new JComboBox(Constant.MONTHS);
		dropDownMonth.setSelectedIndex(0);
		
		dropDownYear = new JComboBox(Constant.YEAR);
		dropDownYear.setSelectedIndex(0);
		
		dropDownMonth.setBounds(170, 110, 60, 20);
		dropDownYear.setBounds(250, 110, 60, 20);

		dropDownMonth.addItemListener(this);
		dropDownYear.addItemListener(this);

		jiraRadioButton = new JRadioButton();
		mannualRadioButton = new JRadioButton();
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(jiraRadioButton);
		buttonGroup.add(mannualRadioButton);

		jiraRadioButton.setFont(font1);
		mannualRadioButton.setFont(font1);
		jiraRadioButton.setText(Constant.JIRA_RADIO_BUTTON_TEXT);
		mannualRadioButton.setText(Constant.MANNUAL_RADIO_BUTTON_TEXT);

		jiraRadioButton.setBounds(50, 160, 300, 20);
		mannualRadioButton.setBounds(50, 178, 300, 40);
		
		dQITextField1 = new JTextField();//For storing Jira or Mannually generated excel sheet file path.
		dQITextField1.setBounds(77, 220, 250, 20);

		dQITextField2 = new JTextField();//For storing QA excel sheet file path.
		dQITextField2.setBounds(77, 292, 250, 20);

		JLabel labelDQI_QA = new JLabel(Constant.DQI_LABEL_1);
		labelDQI_QA.setVisible(true);
		labelDQI_QA.setFont(font1);
		labelDQI_QA.setBounds(77, 268, 250, 15);

		dQIbrowsebutton1 = new JButton(Constant.BROWSE);
		dQIbrowsebutton2 = new JButton(Constant.BROWSE);
		dQIsubmitButton1 = new JButton(Constant.SUBMIT);


		dQIbrowsebutton1.setToolTipText(Constant.BROWSE);
		dQIbrowsebutton2.setToolTipText(Constant.BROWSE);		
		dQIsubmitButton1.setToolTipText(Constant.SUBMIT);
		dQIsubmitButton1.setBackground(Color.LIGHT_GRAY);
		
		dQIbrowsebutton1.setBounds(330, 219, 100, 25);
		dQIbrowsebutton2.setBounds(330, 291, 100, 25);
		dQIsubmitButton1.setBounds(330, 329, 100, 25);
		
		dQIbrowsebutton1.setFont(font1);
		dQIbrowsebutton2.setFont(font1);
		dQIsubmitButton1.setFont(font1);
		
		dQIbrowsebutton1.addActionListener(this);
		dQIbrowsebutton2.addActionListener(this);
		dQIsubmitButton1.addActionListener(this);

		
		//Initialization of Burn Down Chart Section components.
		
		JLabel burnDownChartMainLabel = new JLabel(Constant.BURN_DOWN_CHART_MAIN_LABEL);
		burnDownChartMainLabel.setVisible(true);
		burnDownChartMainLabel.setFont(font1);
		burnDownChartMainLabel.setBounds(5, 380, 250, 15);
		
		JLabel labelBurnDownChart1 = new JLabel(Constant.SPRINT_NUMBER);
		labelBurnDownChart1.setVisible(true);
		labelBurnDownChart1.setFont(font1);
		labelBurnDownChart1.setBounds(40, 420, 250, 15);
		
		JLabel labelBurnDownChart2 = new JLabel(Constant.PLANNED_EFFORTS_IN_HOURS);
		labelBurnDownChart2.setVisible(true);
		labelBurnDownChart2.setFont(font1);
		labelBurnDownChart2.setBounds(275, 422, 250, 15);
		
		JLabel labelBurnDownChart3 = new JLabel(Constant.BURN_DOWN_CHART_LABEL_1);
		labelBurnDownChart3.setVisible(true);
		labelBurnDownChart3.setFont(font1);
		labelBurnDownChart3.setBounds(50, 460, 250, 15);
		
		burnDownBrowseButton = new JButton(Constant.BROWSE);
		burnDownSubmitButton = new JButton(Constant.SUBMIT);
		
		burnDownBrowseButton.setToolTipText(Constant.BROWSE);
		burnDownSubmitButton.setToolTipText(Constant.SUBMIT);
		
		burnDownBrowseButton.setBounds(303, 489, 100, 25);
		burnDownSubmitButton.setBounds(303, 524, 100, 25);
		
		burnDownBrowseButton.setFont(font1);
		burnDownSubmitButton.setFont(font1);
		
		burnDownSubmitButton.setBackground(Color.LIGHT_GRAY);
		
		burnDownBrowseButton.addActionListener(this);
		burnDownSubmitButton.addActionListener(this);
		
		JLabel jlabelLine1 = new JLabel(Constant.LINE_LABEL, SwingConstants.LEFT);
		jlabelLine1.setVisible(true);
		jlabelLine1.setFont(font1);
		jlabelLine1.setBounds(0, 15, 4000, 20);

		JLabel jlabelLine2 = new JLabel(Constant.LINE_LABEL);
		jlabelLine2.setVisible(true);
		jlabelLine2.setFont(font2);
		jlabelLine2.setBounds(0, 355, 4000, 20);

		JLabel jlabelLine3 = new JLabel(Constant.LINE_LABEL);
		jlabelLine3.setVisible(true);
		jlabelLine3.setFont(font2);
		jlabelLine3.setBounds(0, 357, 4000, 20);

		JLabel jlabelLine4 = new JLabel(Constant.LINE_LABEL);
		jlabelLine4.setVisible(true);
		jlabelLine4.setFont(font1);
		jlabelLine4.setBounds(0, 385, 4000, 20);

		burnDownChartTextField1 = new JTextField();
		burnDownChartTextField1.setBounds(50, 490, 250, 20);		

		burnDownTextFieldSprintNumber = new JTextField();
		burnDownTextFieldSprintNumber.setBounds(165, 420, 60, 20);

		burnDownTextFieldPlannedEffortsInHours = new JTextField();
		burnDownTextFieldPlannedEffortsInHours.setBounds(405, 420, 60, 20);
		
		JPanel jPanel = new JPanel();

		add(dQIMainLabel);
		add(jlabelLine1);
		add(labelDQISprintNumber);
		add(labelDQIStoryPoints);
		add(dQITextFieldSprintNumber);
		add(dQITextFieldStoryPoints);
		add(labelDQIMonthYear);
		add(dropDownMonth);
		add(dropDownYear);
		add(jiraRadioButton);
		add(mannualRadioButton);
		add(dQIbrowsebutton1);
		add(dQIbrowsebutton2);
		add(dQIsubmitButton1);
		add(dQITextField1);
		add(labelDQI_QA);
		add(dQITextField2);
		dQITextField1.setVisible(true);
		add(jlabelLine2);
		add(burnDownChartMainLabel);
		add(jlabelLine4);
		add(labelBurnDownChart1);
		add(burnDownTextFieldSprintNumber);
		add(labelBurnDownChart2);
		add(burnDownTextFieldPlannedEffortsInHours);
		add(labelBurnDownChart3);
		add(burnDownChartTextField1);
		add(burnDownBrowseButton);
		add(burnDownSubmitButton);
		add(jPanel);

		setLocation(32, 32);
		setSize(520, 590);
		setResizable(false);
		setVisible(true);

	} // end of BurnDownChartMainFrame()

	/**
	 * Handles all action events when the user clicks on drop down.	
	 */
public void itemStateChanged(ItemEvent e) {
		
		// if the state dropDownMonth is changed
		if (e.getSource() == dropDownMonth && false == dQITextFieldSprintNumber.getText().isEmpty()
				&& false == dQITextFieldStoryPoints.getText().isEmpty())
		{
			month = dropDownMonth.getSelectedItem().toString();
			System.out.println(month + " month selected");
		}

		// if state of dropDownYear is changed
		else if (e.getSource() == dropDownYear && false == dQITextFieldSprintNumber.getText().isEmpty()
				&& false == dQITextFieldStoryPoints.getText().isEmpty())
		{
			year = dropDownYear.getSelectedItem().toString();
			System.out.println(year + " year selected");
		}

		
	}

/**
 *  Handles all action events when the user clicks on any component in the frame.
 */
	public void actionPerformed(ActionEvent ae) 
	{
		
		/**
		 * In DQI Parameters section,
		 * if user presses dQIsubmitButton1 after providing Sprint Number,
		 * Story Points and uploading two excel sheets then following code is executed.
		 */
		if (ae.getSource() == dQIsubmitButton1 
				&& false == dQITextField1.getText().isEmpty()
				&& false == dQITextField2.getText().isEmpty() 
				&& false == dQITextFieldSprintNumber.getText().isEmpty() 
				&& false == dQITextFieldStoryPoints.getText().isEmpty() ) 
		{
			Variables.dQISprintNumber = "Sprint-" + dQITextFieldSprintNumber.getText();
			System.out.println("sprint no"+Variables.dQISprintNumber);
		
			Variables.dQIStoryPoints = Integer.parseInt(dQITextFieldStoryPoints.getText());
			System.out.println("Story Points"+Variables.dQIStoryPoints);
			
			month = dropDownMonth.getSelectedItem().toString();
			year = dropDownYear.getSelectedItem().toString();
			
			Variables.dQIMonthYear=month+"-"+year;
			System.out.println("Variables.dQIMonthYear= "+Variables.dQIMonthYear);
			
			new DQISaveFrame().setLocationRelativeTo(null);
			
			dQITextField1.setText("");
			dQITextField2.setText("");			
		}

		
		/**
		 * In DQI Parameters section,
		 * if user fails to enter Sprint Number and Story Points,
		 * then error message is shown.
		 */		
		else if( ae.getSource() == dQIsubmitButton1 
				 && (true == dQITextFieldSprintNumber.getText().isEmpty() 
				 || true == dQITextFieldStoryPoints.getText().isEmpty()) )
		{
			//error message
			new EmptyFieldsErrorDialog().setLocationRelativeTo(null);
		}
		
		
		/**
		 * In DQI Parameters Section,
		 * if user fails to 
		 * upload excel sheets
		 * error message is shown.
		 */
		else if (ae.getSource() == dQIsubmitButton1
				&& (true == dQITextField1.getText().isEmpty()
				|| true == dQITextField2.getText().isEmpty()) )
           {
			//Error Message
			new EmptyFieldsErrorDialog().setLocationRelativeTo(null);
	       }
		
		
		/**
		 * In Burn Down Chart Section,
		 * when user presses burnDownSubmitButton after uploading excel sheet
		 * then following code is executed.		 
		 */
		else if ( ae.getSource() == burnDownSubmitButton 
				&& Variables.excelFilePath != null )
		{
			// Setting Title of the Burn Down Chart.
			Variables.burnDownChartTitle = Constant.BURN_DOWN_CHART_TITLE + burnDownTextFieldSprintNumber.getText();
			Variables.plannedEffortsInHours = Double.parseDouble(burnDownTextFieldPlannedEffortsInHours.getText());
			
			System.out.println("GetBurnDownChart.burnDownChartTitle= " + Variables.burnDownChartTitle);
			System.out.println("GetHoursAndDays.plannedEffortsInHours= " + Variables.plannedEffortsInHours);
			new BurnDownChartSaveFrame().setLocationRelativeTo(null);
		}

		
		/**
		 * In Burn Down Chart Section,
		 * if user fails to enter Sprint Number and Planned Efforts in Hours and clicks
		 * burnDownBrowseButton then error message is shown.
		 */
		else if ( ae.getSource() == burnDownBrowseButton 
				&& ( true == burnDownTextFieldSprintNumber.getText().isEmpty()
				|| true == burnDownTextFieldPlannedEffortsInHours.getText().isEmpty()) )
		{
			System.out.println("burnDownTextFieldSprintNumber.getText().isEmpty()= "+burnDownTextFieldSprintNumber.getText().isEmpty());
			System.out.println("burnDownTextFieldPlannedEffortsInHours.getText().isEmpty()= "+burnDownTextFieldPlannedEffortsInHours.getText().isEmpty());

			//Error Message
			new BurnDownSprintNumberAndPlannedHoursErrorDialog().setLocationRelativeTo(null);
		}
		
		
		/**
		 * In Burn Down Chart Section,
		 * after writing Sprint Number and Planned Efforts in Hours and directly clicks
		 * submit button before uploading
		 * excel sheet then error message is shown.
		 */
		else if ( ae.getSource() == burnDownSubmitButton 
				&& ( false == burnDownTextFieldSprintNumber.getText().isEmpty()
				&& false == burnDownTextFieldPlannedEffortsInHours.getText().isEmpty() )
				&& true == burnDownChartTextField1.getText().isEmpty() )
		{
			System.out.println("burnDownTextFieldSprintNumber.getText().isEmpty()= "+burnDownTextFieldSprintNumber.getText().isEmpty());
			System.out.println("burnDownTextFieldPlannedEffortsInHours.getText().isEmpty()= "+burnDownTextFieldPlannedEffortsInHours.getText().isEmpty());

			//Error Message
			new BurnDownExcelSheetErrorDialog().setLocationRelativeTo(null);			
		}
		
		
		/**
		 * In Burn Down Chart Section,
		 * if user clicks burnDownSubmitButton without providing all the
		 * mandatory fields then error message is shown.
		 */
		else if ( ae.getSource() == burnDownSubmitButton 
				&&  true == burnDownTextFieldSprintNumber.getText().isEmpty()
				&& true == burnDownTextFieldPlannedEffortsInHours.getText().isEmpty()
				&& true == burnDownChartTextField1.getText().isEmpty() )
		{
			System.out.println("burnDownTextFieldSprintNumber.getText().isEmpty()= "+burnDownTextFieldSprintNumber.getText().isEmpty());
			System.out.println("burnDownTextFieldPlannedEffortsInHours.getText().isEmpty()= "+burnDownTextFieldPlannedEffortsInHours.getText().isEmpty());

			//Error Message
			new EmptyFieldsErrorDialog().setLocationRelativeTo(null);			
		}
		
		/**
		 * In Burn Down Chart Section,
		 * after providing Sprint Number and Planned Efforts in Hours
		 * when user clicks burnDownBrowseButton then following code is executed.
		 */
		else if ( ae.getSource() == burnDownBrowseButton 
				&&( false == burnDownTextFieldSprintNumber.getText().isEmpty()
				&& false == burnDownTextFieldPlannedEffortsInHours.getText().isEmpty()) )
		{
			JFileChooser jfileChooser = new JFileChooser( FileSystemView.getFileSystemView().getHomeDirectory() );

			// restrict the user from selecting files of all types
			jfileChooser.setAcceptAllFileFilterUsed(false);

			// set a title for the dialog
			jfileChooser.setDialogTitle("Select a .xls file");

			// To only allow selection of excel sheet with .xls extension
			FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .xls files", "xls");
			jfileChooser.addChoosableFileFilter(restrict);

			
			/**
			 * invoke the showOpenDialog(null) function to show the open dialog 
		     * allowing user to upload an excel sheet.
			 */			 
			if ( jfileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ) 
			{
				burnDownChartTextField1.setText(jfileChooser.getSelectedFile().getAbsolutePath().toString());
				
				Variables.excelFilePath = jfileChooser.getSelectedFile().getAbsolutePath().toString();
				
				System.out.println("Variables.excelFilePath= " + Variables.excelFilePath);
				System.out.println("burnDownChartTextField1.getText().isEmpty()= "+burnDownChartTextField1.getText().isEmpty());
				
			}
			
		}

		
		/**
		 * In DQI Parameters Section,
		 * if user presses dQIbrowsebutton1 and one of the radio box is selected
		 * then following code is executed.
		 */
		else if( ae.getSource() == dQIbrowsebutton1 
		        && (false == Constant.MONTHS[0].equals(dropDownMonth.getSelectedItem().toString()) 
				&& false == Constant.YEAR[0].equals( dropDownYear.getSelectedItem().toString()) ) )
        { 
        	
           	System.out.println("dQITextField1.getText()= "+dQITextField1.getText().isEmpty());
        	Variables.jiraRadioButtonDQI = jiraRadioButton.isSelected();
        	Variables.mannualRadioButtonDQI = mannualRadioButton.isSelected();

        	//This code will be executed when user selects jiraRadioButton. 
        	if(true == jiraRadioButton.isSelected())
        	{
            // Creating an object of JFileChooser class 
            JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
  
            // restrict the user to select files of all types 
            jfileChooser.setAcceptAllFileFilterUsed(false); 
  
            // set a title for the dialog 
            jfileChooser.setDialogTitle("Select a .xls file"); 
  
           // To only allow selection of excel sheet with .xls extension
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .xls files", "xls"); 
            jfileChooser.addChoosableFileFilter(restrict); 

            /**
             * invoke the showsOpenDialog(null) function to show the open dialog 
             * allowing user to upload an excel sheet.
             */
            if (jfileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
            {
            	dQITextField1.setText(jfileChooser.getSelectedFile().getAbsolutePath().toString());
            	
            	Variables.jiraExcelSheetFilePath = dQITextField1.getText();
            	System.out.println("Jira working");
            	System.out.println("Variables.jiraExcelSheetFilePath= "+Variables.jiraExcelSheetFilePath); 
            } 
        	}
        	
        	//This code will be executed when user selects mannualRadioButton. 
        	else if(true == mannualRadioButton.isSelected())
        	{

        		 // Creating an object of JFileChooser class 
                JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
      
                // restrict the user to select files of all types 
                jfileChooser.setAcceptAllFileFilterUsed(false); 
      
                // set a title for the dialog 
                jfileChooser.setDialogTitle("Select a .xlsx file"); 
      
                // To only allow selection of excel sheet with .xlsx extension 
                FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .xlsx files", "xlsx"); 
                jfileChooser.addChoosableFileFilter(restrict); 

                /**
                 * invoke the showsOpenDialog(null) function to show the open dialog 
                 * allowing user to upload an excel sheet.
                 */
                if (jfileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
                {
                	dQITextField1.setText(jfileChooser.getSelectedFile().getAbsolutePath().toString());
                	
                	Variables.mannualExcelSheetFilePath = dQITextField1.getText();
        	    }
        	}
        	
        	
        	/**
        	 * In DQI Parameters section,
        	 * if user fails to select any of the radio button
        	 * then error message is shown.
        	 */
        	else if(false == mannualRadioButton.isSelected() && false == jiraRadioButton.isSelected())
        	{
        		new DQIRadioButtonErrorDialog().setLocationRelativeTo(null); 
        	}
        	
        	System.out.println("Variables.mannualExcelSheetFilePath= "+Variables.mannualExcelSheetFilePath);
        	System.out.println("jiraRadioButton.isSelected()= "+jiraRadioButton.isSelected());
        	System.out.println("mannualRadioButton.isSelected()= "+mannualRadioButton.isSelected());
        	
        }

		
		/**
		 * In DQI Parameters section,
		 * if user fails to enter Month and Year 
		 * then error message is shown.
		 */
		else if( ae.getSource() == dQIbrowsebutton1 
				&& (Constant.MONTHS[0].equals(dropDownMonth.getSelectedItem().toString())  
				|| Constant.YEAR[0].equals(dropDownYear.getSelectedItem().toString())) )
		{
			System.out.println("Working month and year.");
			//error message
			new DQIMonthAndYearErrorDialog().setLocationRelativeTo(null);
		}

		
		/**
		 * In DQI Parameters section,
		 * if user presses dQIbrowsebutton2 
		 * then following code is executed to
		 * upload QA effort sheet. 
		 */
		else if (ae.getSource() == dQIbrowsebutton2)

		{

			// Creating an object of JFileChooser class
			JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			// restrict the user to select files of all types
			jfileChooser.setAcceptAllFileFilterUsed(false);

			// set a title for the dialog
			jfileChooser.setDialogTitle("Select a .xlsx file");

			// only allow files of .xls extension
			FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .xlsx files", "xlsx");
			jfileChooser.addChoosableFileFilter(restrict);

			// invoke the showsOpenDialog function to show the open dialog
			if (jfileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				// Qa path Text Field
				dQITextField2.setText(jfileChooser.getSelectedFile().getAbsolutePath().toString());
				
				Variables.qaExcelSheetFilePath = dQITextField2.getText();
				
				System.out.println("Variables.qaExcelSheetFilePath= " + Variables.qaExcelSheetFilePath);

				// new
				// GetBurnDownChart().createBurnDownChart(jfileChooser.getSelectedFile().getAbsolutePath().toString());
			}

//			Variables.jiraRadioButtonDQI = false;
//			Variables.mannualRadioButtonDQI = false;
		}

	}// end actionPerformed(ActionEvent ae)


}
