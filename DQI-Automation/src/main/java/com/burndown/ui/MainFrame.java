package com.burndown.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

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
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.apache.log4j.Logger;

import com.burndown.service.impl.GetBurnDownChart;
import com.burndown.service.impl.GetDaysAndHours;
import com.burndown.ui.errordialog.BurnDownChartFileNotFoundErrorDialog;
import com.burndown.ui.errordialog.BurnDownChartGeneralErrorDialog;
import com.burndown.ui.errordialog.BurnDownChartInvalidExcelSheetErrorDialog;
import com.burndown.ui.errordialog.BurnDownChartInvalidValuesErrorDialog;
import com.burndown.ui.errordialog.BurnDownExcelSheetErrorDialog;
import com.burndown.ui.errordialog.BurnDownSprintNumberAndPlannedHoursErrorDialog;
import com.burndown.ui.errordialog.DQIMonthAndYearErrorDialog;
import com.burndown.ui.errordialog.DQIRadioButtonErrorDialog;
import com.burndown.ui.errordialog.EmptyFieldsErrorDialog;
import com.burndown.util.BurnDownVariables;
import com.burndown.util.Constant;
import com.burndown.util.DQIVariables;
import com.dqi.process.DQIDataProcessor;
import com.dqiAutomation.exception.BurnDownInvalidExcelSheetException;
import com.dqiAutomation.exception.DQIInvalidExcelSheetException;

/**
 * 
 * This class shows frame to the user. Frame displays DQI Parameters section and
 * Burn Down Chart section.
 * 
 * @author priyanka_gupta
 * 
 */
public class MainFrame extends JFrame implements ActionListener, ItemListener {
	private static final Logger logger = Logger.getLogger(MainFrame.class);

	private static final long serialVersionUID = 1L;
	static String month;// To store month from dropDownMonth.
	static String year;// To store year from dropDownYear.
	ButtonGroup buttonGroup = new ButtonGroup();
	// Declaration of reference variables.
	JButton dQIbrowsebutton1, dQIbrowsebutton2, dQIsubmitButton1, burnDownBrowseButton, burnDownSubmitButton;
	JTextField dQITextField1, dQITextField2, burnDownChartTextField1;
	JTextField dQITextFieldSprintNumber, dQITextFieldStoryPoints, burnDownTextFieldSprintNumber,
			burnDownTextFieldPlannedEffortsInHours;
	JRadioButton jiraRadioButton;
	JRadioButton manualRadioButton;
	JComboBox<String> dropDownMonth, dropDownYear;

	/**
	 * Non-parameterized constructor.
	 */
	public MainFrame() {

	}

	/**
	 * Parameterized constructor. Initializes all the components of the main frame.
	 * 
	 * @param value
	 */
	public MainFrame(boolean value) {

		
		// Sets frame's title.
		super("DQI Automation and Burn Down Chart");
		Font fontSmall = new Font(Font.SANS_SERIF, Font.BOLD, 12);
		Font fontLarge = new Font(Font.SANS_SERIF, Font.BOLD, 15);

		// Initialization of DQI Parameters Section components.

		JLabel dQIMainLabel = new JLabel(Constant.DQI_MAIN_LABEL);
		dQIMainLabel.setForeground(Color.white);
		dQIMainLabel.setBackground(new Color(51, 60, 84));
		dQIMainLabel.setVisible(true);
		dQIMainLabel.setFont(fontLarge);
		dQIMainLabel.setOpaque(true);
		dQIMainLabel.setBounds(0, 0, 550, 32);

		JLabel labelDQISprintNumber = new JLabel(Constant.SPRINT_NUMBER);
	//	labelDQISprintNumber.setForeground(Color.white);
		labelDQISprintNumber.setVisible(true);
		labelDQISprintNumber.setFont(fontSmall);
		labelDQISprintNumber.setBounds(50, 48, 250, 15);

		JLabel labelDQIStoryPoints = new JLabel(Constant.STORY_POINTS);
	//	labelDQIStoryPoints.setForeground(Color.white);
		labelDQIStoryPoints.setVisible(true);
		labelDQIStoryPoints.setFont(fontSmall);
		labelDQIStoryPoints.setBounds(64, 80, 250, 15);

		dQITextFieldSprintNumber = new JTextField();
		dQITextFieldSprintNumber.setBounds(170, 46, 60, 20);

		dQITextFieldStoryPoints = new JTextField();
		dQITextFieldStoryPoints.setBounds(170, 78, 60, 20);

		JLabel labelDQIMonthYear = new JLabel(Constant.DATE);
	//	labelDQIMonthYear.setForeground(Color.white);
		labelDQIMonthYear.setVisible(true);
		labelDQIMonthYear.setFont(fontSmall);
		labelDQIMonthYear.setBounds(45, 113, 250, 15);

		dropDownMonth = new JComboBox<String>(Constant.MONTHS);
		dropDownMonth.setSelectedIndex(0);

		dropDownYear = new JComboBox<String>(Constant.YEAR);
		dropDownYear.setSelectedIndex(0);

		dropDownMonth.setBounds(170, 110, 65, 20);
		dropDownYear.setBounds(250, 110, 60, 20);

		dropDownMonth.addItemListener(this);
		dropDownYear.addItemListener(this);

		jiraRadioButton = new JRadioButton();
		manualRadioButton = new JRadioButton();

		buttonGroup.add(jiraRadioButton);
		buttonGroup.add(manualRadioButton);

		jiraRadioButton.setFont(fontSmall);
		manualRadioButton.setFont(fontSmall);
		
		/*
		 * jiraRadioButton.setForeground(Color.white);
		 * manualRadioButton.setForeground(Color.white);
		 */
		
		jiraRadioButton.setBackground(new Color(212, 228, 228));
		manualRadioButton.setBackground(new Color(212, 228, 228));
		
		jiraRadioButton.setText(Constant.JIRA_RADIO_BUTTON_TEXT);
		manualRadioButton.setText(Constant.MANNUAL_RADIO_BUTTON_TEXT);

		jiraRadioButton.setBounds(50, 160, 470, 20);
		manualRadioButton.setBounds(50, 178, 470, 40);

		dQITextField1 = new JTextField();// For storing Jira or Manually
											// generated excel sheet file path.
		dQITextField1.setBounds(77, 220, 250, 20);

		dQITextField2 = new JTextField();// For storing QA excel sheet file
											// path.
		dQITextField2.setBounds(77, 292, 250, 20);

		JLabel labelDQI_QA = new JLabel(Constant.DQI_LABEL_1);
	//	labelDQI_QA.setForeground(Color.white);
		labelDQI_QA.setVisible(true);
		labelDQI_QA.setFont(fontSmall);
		labelDQI_QA.setBounds(77, 268, 470, 15);

		dQIbrowsebutton1 = new JButton(Constant.BROWSE);
		dQIbrowsebutton2 = new JButton(Constant.BROWSE);
		dQIsubmitButton1 = new JButton(Constant.SUBMIT);
		
		dQIbrowsebutton1.setBackground(Color.LIGHT_GRAY);
		dQIbrowsebutton2.setBackground(Color.LIGHT_GRAY);
		dQIsubmitButton1.setBackground(Color.LIGHT_GRAY);
		
		dQIbrowsebutton1.setBorder(new LineBorder(Color.DARK_GRAY,1));
		dQIbrowsebutton2.setBorder(new LineBorder(Color.DARK_GRAY,1));
		dQIsubmitButton1.setBorder(new LineBorder(Color.DARK_GRAY,1));

		dQIbrowsebutton1.setToolTipText(Constant.BROWSE);
		dQIbrowsebutton2.setToolTipText(Constant.BROWSE);
		dQIsubmitButton1.setToolTipText(Constant.SUBMIT);	

		dQIbrowsebutton1.setBounds(330, 219, 100, 25);
		dQIbrowsebutton2.setBounds(330, 291, 100, 25);
		dQIsubmitButton1.setBounds(330, 329, 100, 25);

		dQIbrowsebutton1.setFont(fontLarge);
		dQIbrowsebutton2.setFont(fontLarge);
		dQIsubmitButton1.setFont(fontLarge);

		dQIbrowsebutton1.addActionListener(this);
		dQIbrowsebutton2.addActionListener(this);
		dQIsubmitButton1.addActionListener(this);

		// Initialization of Burn Down Chart Section components.
		
		JLabel burnDownChartMainLabel = new JLabel(Constant.BURN_DOWN_CHART_MAIN_LABEL);
		burnDownChartMainLabel.setForeground(Color.white);
		burnDownChartMainLabel.setBackground(new Color(51, 60, 84));
		burnDownChartMainLabel.setOpaque(true);
		burnDownChartMainLabel.setVisible(true);
		burnDownChartMainLabel.setFont(fontLarge);
		burnDownChartMainLabel.setBounds(0, 373, 600, 28);

		JLabel labelBurnDownChart1 = new JLabel(Constant.SPRINT_NUMBER);
	//	labelBurnDownChart1.setForeground(Color.black);
		labelBurnDownChart1.setVisible(true);
		labelBurnDownChart1.setFont(fontSmall);
		labelBurnDownChart1.setBounds(40, 420, 250, 15);

		JLabel labelBurnDownChart2 = new JLabel(Constant.PLANNED_EFFORTS_IN_HOURS);
	//	labelBurnDownChart2.setForeground(Color.white);
		labelBurnDownChart2.setVisible(true);
		labelBurnDownChart2.setFont(fontSmall);
		labelBurnDownChart2.setBounds(275, 422, 250, 15);

		JLabel labelBurnDownChart3 = new JLabel(Constant.BURN_DOWN_CHART_LABEL_1);
	//	labelBurnDownChart3.setForeground(Color.white);
		labelBurnDownChart3.setVisible(true);
		labelBurnDownChart3.setFont(fontSmall);
		labelBurnDownChart3.setBounds(50, 460, 455, 15);

		burnDownBrowseButton = new JButton(Constant.BROWSE);
		burnDownSubmitButton = new JButton(Constant.SUBMIT);
		/*
		 * URL yellow = new
		 * URL("http://www.wpclipart.com/small_icons/buttons/.cache/button_yellow.png");
		 * burnDownSubmitButton.setIcon(new ImageIcon(yellow));
		 */

		burnDownBrowseButton.setToolTipText(Constant.BROWSE);
		burnDownSubmitButton.setToolTipText(Constant.SUBMIT);
		
		burnDownBrowseButton.setBorder(new LineBorder(Color.DARK_GRAY,1));
		burnDownSubmitButton.setBorder(new LineBorder(Color.DARK_GRAY,1));

		burnDownBrowseButton.setBounds(303, 489, 100, 25);
		burnDownSubmitButton.setBounds(303, 524, 100, 25);

		burnDownBrowseButton.setFont(fontLarge);
		burnDownSubmitButton.setFont(fontLarge);

		burnDownBrowseButton.setBackground(Color.LIGHT_GRAY);
		burnDownSubmitButton.setBackground(Color.LIGHT_GRAY);

		burnDownBrowseButton.addActionListener(this);
		burnDownSubmitButton.addActionListener(this);

		JLabel jlabelLine1 = new JLabel(Constant.LINE_LABEL, SwingConstants.LEFT);
		jlabelLine1.setBackground(new Color(212, 228, 228))	;
		jlabelLine1.setVisible(true);
		jlabelLine1.setFont(fontSmall);
		jlabelLine1.setBounds(0, 15, 4000, 20);

		JLabel jlabelLine2 = new JLabel(Constant.LINE_LABEL);
		jlabelLine2.setBackground(new Color(212, 228, 228));
		jlabelLine2.setVisible(true);
		jlabelLine2.setFont(fontLarge);
		jlabelLine2.setBounds(0, 355, 4000, 20);

		JLabel jlabelLine3 = new JLabel(Constant.LINE_LABEL);	
		jlabelLine3.setBackground(new Color(212, 228, 228));
		jlabelLine3.setVisible(true);
		jlabelLine3.setFont(fontLarge);
		jlabelLine3.setBounds(0, 357, 4000, 20);

		JLabel jlabelLine4 = new JLabel(Constant.LINE_LABEL);	
		jlabelLine4.setBackground(new Color(212, 228, 228));
		jlabelLine4.setVisible(true);
		jlabelLine4.setFont(fontSmall);
		jlabelLine4.setBounds(0, 385, 4000, 20);

		burnDownChartTextField1 = new JTextField();
		burnDownChartTextField1.setBounds(50, 490, 250, 20);

		burnDownTextFieldSprintNumber = new JTextField();
		burnDownTextFieldSprintNumber.setBounds(165, 420, 60, 20);

		burnDownTextFieldPlannedEffortsInHours = new JTextField();
		burnDownTextFieldPlannedEffortsInHours.setBounds(405, 420, 60, 20);

		JPanel jPanel = new JPanel();
		
		JLabel colorLabel=new JLabel();		
		
		// Adding all the components to the frame.		
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
		add(manualRadioButton);
		add(dQIbrowsebutton1);
		add(dQIbrowsebutton2);
		add(dQIsubmitButton1);
		add(dQITextField1);
		add(labelDQI_QA);
		add(dQITextField2);
		dQITextField1.setVisible(true);
		//add(jlabelLine2);
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
		add(colorLabel);

		getContentPane().setBackground(new Color(212, 228, 228));
	    pack();
	    setVisible(true);
		setLocation(32, 32);
		setSize(520, 590);
		setResizable(false);
		setVisible(true);

	} // end of MainFrame()

	public boolean checkFileExtension(String excelFilePath, String fileExtension) {
		File file = new File(excelFilePath);
		String fileName = file.getName();

		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0
				&& (fileName.substring(fileName.lastIndexOf(".") + 1)).equals(fileExtension))

			return true;

		else
			return false;
	}

	/**
	 * In DQI Section, This method clears all data from the Main Frame's fields
	 * after successful creation of excel sheet.
	 */
	public void resetDQIData() {

		dQITextField1.setText("");
		dQITextField2.setText("");
		dQITextFieldSprintNumber.setText("");
		dQITextFieldStoryPoints.setText("");
		dropDownMonth.setSelectedIndex(0);
		dropDownYear.setSelectedIndex(0);
		jiraRadioButton.setSelected(false);
		manualRadioButton.setSelected(false);
		buttonGroup.clearSelection();

	}

	/**
	 * In Burn Down Chart Section, This method clears all data from the Main Frame's
	 * fields after successful creation of Burn Down Chart image.
	 */
	public void resetBurnDownData() {
		burnDownTextFieldSprintNumber.setText("");
		burnDownTextFieldPlannedEffortsInHours.setText("");
		burnDownChartTextField1.setText("");
	}

	/**
	 * Handles all action events when the user clicks on drop down.
	 */
	public void itemStateChanged(ItemEvent e) {

		// if the state dropDownMonth is changed
		if (e.getSource() == dropDownMonth && false == dQITextFieldSprintNumber.getText().isEmpty()
				&& false == dQITextFieldStoryPoints.getText().isEmpty()) {
			month = dropDownMonth.getSelectedItem().toString();
		}

		// if state of dropDownYear is changed
		else if (e.getSource() == dropDownYear && false == dQITextFieldSprintNumber.getText().isEmpty()
				&& false == dQITextFieldStoryPoints.getText().isEmpty()) {
			year = dropDownYear.getSelectedItem().toString();
		}
	}

	/**
	 * Handles all action events when user clicks on any component in the frame.
	 */
	public void actionPerformed(ActionEvent ae) {
		/**
		 * In DQI Parameters section, if user presses dQIsubmitButton1 after
		 * providing Sprint Number, Story Points and uploading two excel sheets
		 * then following code is executed to create an excel sheet. But if user
		 * enters invalid Sprint Number or Story Points then error dialog is
		 * shown.
		 */
		if (ae.getSource() == dQIsubmitButton1 && false == dQITextField1.getText().isEmpty()
				&& false == dQITextField2.getText().isEmpty() && false == dQITextFieldSprintNumber.getText().isEmpty()
				&& false == dQITextFieldStoryPoints.getText().isEmpty()) {
			try {
				/*
				 * To check that entered Story Points and Sprint Number contains
				 * only numbers.
				 */
				Double.parseDouble(dQITextFieldSprintNumber.getText());
				Double.parseDouble(dQITextFieldStoryPoints.getText());

				DQIVariables.getInstance().setdQISprintNumber("Sprint-" + dQITextFieldSprintNumber.getText());
				

				DQIVariables.getInstance().setdQIStoryPoints(Integer.parseInt(dQITextFieldStoryPoints.getText()));

				
				month = dropDownMonth.getSelectedItem().toString();
				year = dropDownYear.getSelectedItem().toString();

				DQIVariables.getInstance().setdQIMonthYear(month + "-" + year);


				// If Jira Radio Button selected
				if (true == jiraRadioButton.isSelected()) {
					if (checkFileExtension(dQITextField1.getText(), Constant.DQI_JIRA_FILE_EXTENSION)) {

						
						DQIVariables.getInstance().setFileName(dQITextField1.getText());
						// To check existence of uploaded file
						new FileInputStream(dQITextField1.getText()).close();

						DQIVariables.getInstance().setJiraExcelSheetFilePath(dQITextField1.getText());
 
						
						logger.info("JIRA File extension correct");

					} else {
						logger.info("JIRA File extension incorrect");
						DQIVariables.getInstance().setFileName(dQITextField1.getText());
						throw new DQIInvalidExcelSheetException(Constant.DQI_INVALID_SHEET_EXCEPTION_MESSAGE);
					}
				}

				// If Manual Radio Button selected
				else if (true == manualRadioButton.isSelected()) {
					if (checkFileExtension(dQITextField1.getText(), Constant.DQI_MANUAL_FILE_EXTENSION)) {
						
						DQIVariables.getInstance().setFileName(dQITextField1.getText());
						// To check existence of uploaded file
						new FileInputStream(dQITextField1.getText()).close();

						DQIVariables.getInstance().setManualExcelSheetFilePath(dQITextField1.getText());
						
						logger.info("Manual File extension correct");
					} else {
						logger.info("Manual File extension incorrect");
						DQIVariables.getInstance().setFileName(dQITextField1.getText());
						throw new DQIInvalidExcelSheetException(Constant.DQI_INVALID_SHEET_EXCEPTION_MESSAGE);
					}
				}

				// When QA excel sheet is uploaded.
				if (checkFileExtension(dQITextField2.getText(), Constant.DQI_QA_FILE_EXTENSION)) {

					
					DQIVariables.getInstance().setFileName(dQITextField2.getText());
					// To check existence of uploaded file
			 		new FileInputStream(dQITextField2.getText()).close();

					DQIVariables.getInstance().setQaExcelSheetFilePath(dQITextField2.getText());

					logger.info("QA File extension correct");
					
					new DQIDataProcessor().process();
					if(DQIVariables.getInstance().isOpenSaveFrame())
						new DQISaveFrame().setLocationRelativeTo(null);
				} 
			}			
			
			catch (Exception e) {				
				logger.error("Error in Main Frame", e);
			}
		}

		/**
		 * In DQI Parameters section, if user fails to enter Sprint Number and
		 * Story Points, then error message is shown.
		 */
		else if (ae.getSource() == dQIsubmitButton1 && (true == dQITextFieldSprintNumber.getText().isEmpty()
				|| true == dQITextFieldStoryPoints.getText().isEmpty())) {
			// Error Dialog
			new EmptyFieldsErrorDialog().setLocationRelativeTo(null);
		}

		/**
		 * In DQI Parameters Section, if user fails to upload excel sheets error
		 * message is shown.
		 */
		else if (ae.getSource() == dQIsubmitButton1
				&& (true == dQITextField1.getText().isEmpty() || true == dQITextField2.getText().isEmpty())) {
			// Error Dialog
			new EmptyFieldsErrorDialog().setLocationRelativeTo(null);
		}

		/**
		 * In Burn Down Chart Section, when user presses burnDownSubmitButton
		 * after providing Sprint Number, Planned Efforts and uploading excel
		 * sheet then following code is executed to plot and save Burn Down
		 * Chart image. But if user enters invalid Sprint Number or Planned
		 * Efforts then error dialog is shown. `.
		 */
		else if (ae.getSource() == burnDownSubmitButton)
		  {
			try {
				/*
				 * To check that entered Planned Efforts and Sprint Number
				 * contains only numbers.
				 */
				Double.parseDouble(burnDownTextFieldSprintNumber.getText());
				Double.parseDouble(burnDownTextFieldPlannedEffortsInHours.getText());
				

				if (checkFileExtension(burnDownChartTextField1.getText(), Constant.BURN_DOWN_CHART_FILE_EXTENSION))// To
																													// check
																													// file
																													// extension.
				{
					new FileInputStream(burnDownChartTextField1.getText()).close();;
					BurnDownVariables.getInstance().setExcelFilePath(burnDownChartTextField1.getText());
					
					Map<Double, Double> daysAndHoursMap=new GetDaysAndHours().excelReadDaysAndHours(BurnDownVariables.getInstance().getExcelFilePath());				
				
					if(null != daysAndHoursMap)
					{
						GetBurnDownChart.daysAndHoursMap=daysAndHoursMap;
						new BurnDownChartSaveFrame().setLocationRelativeTo(null);					
					}
					
				
				}

				else
					throw new BurnDownInvalidExcelSheetException(
							Constant.BURN_DOWN_INVALID_EXCEL_SHEET_EXCEPTION_MESSAGE);
				
			}

			catch (FileNotFoundException errorMessage) {
				new BurnDownChartFileNotFoundErrorDialog();
				logger.error("Error in Main Frame", errorMessage);

			} catch (NumberFormatException errorMessage) {
				logger.error("Error in Main Frame", errorMessage);
				new BurnDownChartInvalidValuesErrorDialog().setLocationRelativeTo(null);				
			} catch (BurnDownInvalidExcelSheetException errorMessage) {
				logger.error("Error in Main Frame", errorMessage);
				new BurnDownChartInvalidExcelSheetErrorDialog();
			} catch (Throwable errorMessage) {
				
				new BurnDownChartGeneralErrorDialog().setVisible(true);;
				logger.error("Error in Main Frame", errorMessage);
			}
		}

		/**
		 * In Burn Down Chart Section, if user fails to enter Sprint Number and
		 * Planned Efforts in Hours and clicks burnDownBrowseButton then error
		 * message is shown.
		 */
		else if (ae.getSource() == burnDownBrowseButton && (true == burnDownTextFieldSprintNumber.getText().isEmpty()
				|| true == burnDownTextFieldPlannedEffortsInHours.getText().isEmpty())) {
			

			// Error Dialog
			new BurnDownSprintNumberAndPlannedHoursErrorDialog().setLocationRelativeTo(null);
		}

		/**
		 * In Burn Down Chart Section, after writing Sprint Number and Planned
		 * Efforts in Hours and directly clicks submit button before uploading
		 * excel sheet then error message is shown.
		 */
		else if (ae.getSource() == burnDownSubmitButton
				&& (false == burnDownTextFieldSprintNumber.getText().isEmpty()
						&& false == burnDownTextFieldPlannedEffortsInHours.getText().isEmpty())
				&& true == burnDownChartTextField1.getText().isEmpty()) {
			

			// Error Dialog
			new BurnDownExcelSheetErrorDialog().setLocationRelativeTo(null);
		}

		/**
		 * In Burn Down Chart Section, if user clicks
		 * burnDownSubmitButton(Submit) without providing all the mandatory
		 * fields then error message is shown.
		 */
		else if (ae.getSource() == burnDownSubmitButton && true == burnDownTextFieldSprintNumber.getText().isEmpty()
				&& true == burnDownTextFieldPlannedEffortsInHours.getText().isEmpty()
				&& true == burnDownChartTextField1.getText().isEmpty()) {
			

			// Error Dialog
			new EmptyFieldsErrorDialog().setLocationRelativeTo(null);
		}

		/**
		 * In Burn Down Chart Section, after providing Sprint Number and Planned
		 * Efforts in Hours when user clicks burnDownBrowseButton then following
		 * code is executed to upload an excel sheet. But if user enters invalid
		 * Sprint Number or Planned Efforts then error dialog is shown.
		 */

		else if (ae.getSource() == burnDownBrowseButton && (false == burnDownTextFieldSprintNumber.getText().isEmpty()
				&& false == burnDownTextFieldPlannedEffortsInHours.getText().isEmpty())) {
			try {
				/*
				 * To check that entered Planned Efforts and Sprint Number
				 * contains only numbers.
				 */
				Double.parseDouble(burnDownTextFieldSprintNumber.getText());
				Double.parseDouble(burnDownTextFieldPlannedEffortsInHours.getText());
				JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				// restrict the user from selecting files of all types
				jfileChooser.setAcceptAllFileFilterUsed(false);

				// set a title for the dialog
				jfileChooser.setDialogTitle("Select a .xls file");

				// To only allow selection of excel sheet with .xls extension
				jfileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Only .xls files", "xls"));

				/**
				 * invoke the showOpenDialog(null) function to show the open
				 * dialog allowing user to upload an excel sheet.
				 */
				if (jfileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					burnDownChartTextField1.setText(jfileChooser.getSelectedFile().getAbsolutePath().toString());

					BurnDownVariables.getInstance()
							.setExcelFilePath(jfileChooser.getSelectedFile().getAbsolutePath().toString());
					

					BurnDownVariables.getInstance().setBurnDownChartTitle(
							Constant.BURN_DOWN_CHART_TITLE + burnDownTextFieldSprintNumber.getText());
					BurnDownVariables.getInstance().setPlannedEffortsInHours(
							Double.parseDouble(burnDownTextFieldPlannedEffortsInHours.getText()));

				}

			} catch (NumberFormatException errorMessage) {
				new BurnDownChartInvalidValuesErrorDialog().setLocationRelativeTo(null);
				
				
			}
		}

		/**
		 * In DQI Parameters Section, if user presses dQIbrowsebutton1 and one
		 * of the radio box is selected then following code is executed.
		 */
		else if (ae.getSource() == dQIbrowsebutton1
				&& (false == Constant.MONTHS[0].equals(dropDownMonth.getSelectedItem().toString())
						&& false == Constant.YEAR[0].equals(dropDownYear.getSelectedItem().toString()))) {


			DQIVariables.getInstance().setdQImannualRadioButton(manualRadioButton.isSelected());
			DQIVariables.getInstance().setdQIjiraRadioButton(jiraRadioButton.isSelected());

			// This code will be executed when user selects jiraRadioButton.
			if (true == jiraRadioButton.isSelected()) {
				// Creating an object of JFileChooser class
				JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				// restrict the user to select files of all types
				jfileChooser.setAcceptAllFileFilterUsed(false);

				// set a title for the dialog
				jfileChooser.setDialogTitle("Select a .xls file");

				// To only allow selection of excel sheet with .xls extension

				jfileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Only .xls files", "xls"));

				/**
				 * invoke the showsOpenDialog(null) function to show the open
				 * dialog allowing user to upload an excel sheet.
				 */
				if (jfileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					dQITextField1.setText(jfileChooser.getSelectedFile().getAbsolutePath().toString());
					DQIVariables.getInstance().setJiraExcelSheetFilePath(dQITextField1.getText());
					
				}
			}

			// This code will be executed when user selects mannualRadioButton.
			else if (true == manualRadioButton.isSelected()) {

				// Creating an object of JFileChooser class
				JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				// restrict the user to select files of all types
				jfileChooser.setAcceptAllFileFilterUsed(false);

				// set a title for the dialog
				jfileChooser.setDialogTitle("Select a .xls file");

				// To only allow selection of excel sheet with .xlsx extension
				jfileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Only .xls files", "xlsx"));

				/**
				 * invoke the showsOpenDialog(null) function to show the open
				 * dialog allowing user to upload an excel sheet.
				 */
				if (jfileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					dQITextField1.setText(jfileChooser.getSelectedFile().getAbsolutePath().toString());
					DQIVariables.getInstance().setManualExcelSheetFilePath(dQITextField1.getText());
				}
			}

			/**
			 * In DQI Parameters section, if user fails to select any of the
			 * radio button then error message is shown.
			 */
			else if (false == manualRadioButton.isSelected() && false == jiraRadioButton.isSelected()) {
				new DQIRadioButtonErrorDialog().setLocationRelativeTo(null);
			}

		

		}

		/**
		 * In DQI Parameters section, if user fails to enter Month and Year then
		 * error message is shown.
		 */
		else if (ae.getSource() == dQIbrowsebutton1
				&& (Constant.MONTHS[0].equals(dropDownMonth.getSelectedItem().toString())
						|| Constant.YEAR[0].equals(dropDownYear.getSelectedItem().toString()))) {
			// error message
			new DQIMonthAndYearErrorDialog().setLocationRelativeTo(null);
		}

		/**
		 * In DQI Parameters section, if user presses dQIbrowsebutton2 then
		 * following code is executed to upload QA effort sheet.
		 */
		else if (ae.getSource() == dQIbrowsebutton2)

		{
			// Creating an object of JFileChooser class
			JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			// restrict the user to select files of all types
			jfileChooser.setAcceptAllFileFilterUsed(false);

			// set a title for the dialog
			jfileChooser.setDialogTitle("Select a .xls file");

			// only allow files of .xlsx extension
			jfileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Only .xls files", "xlsx"));

			// invoke the showsOpenDialog function to show the open dialog
			if (jfileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				// Text field to store QA excel sheet file path.
				dQITextField2.setText(jfileChooser.getSelectedFile().getAbsolutePath().toString());
				DQIVariables.getInstance().setQaExcelSheetFilePath(dQITextField2.getText());

				

			}

		
		}

	}// end of actionPerformed(ActionEvent ae)

}
