package com.burndown.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.apache.log4j.Logger;

import com.burndown.ui.errordialog.DQIFileNotFoundErrorDialog;
import com.burndown.ui.errordialog.DQIInvalidExcelSheetErrorDialog;
import com.burndown.ui.errordialog.DQIStringFoundErrorDialog;
import com.burndown.util.Constant;
import com.burndown.util.DQIVariables;
import com.dqi.process.DQIDataProcessor;
import com.dqi.writer.DQIDataWriter;
import com.dqiAutomation.exception.DQIInvalidExcelSheetException;

/**
 * This class shows save dialog to the user to save generated excel sheet in DQI
 * Parameters section.
 * 
 * @author priyanka_gupta
 * 
 */
public class DQISaveFrame extends JFrame implements ActionListener {
	private static final Logger logger = Logger.getLogger(DQISaveFrame.class);

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6685473521623174628L;
	JButton saveButton;

	/**
	 * Initializes frame components.
	 */
	public DQISaveFrame() {
		super("Save");

		Font myFont = new Font("Arial", Font.PLAIN, 15);
		saveButton = new JButton("Save");
		saveButton.setFont(myFont);
		saveButton.setLayout(new FlowLayout());
		saveButton.setLocation(58, 500);
		saveButton.setBounds(58, 40, 80, 40);
		saveButton.addActionListener(this);
		saveButton.setVisible(true);

		add(saveButton);
		add(new JPanel());
		setLocation(32, 32);
		setSize(200, 150);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == saveButton) {
			this.setVisible(false);
			// create an object of JFileChooser class
			JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			// restrict the user to select files of all types
			jfileChooser.setAcceptAllFileFilterUsed(false);

			// set a title for the dialog
			jfileChooser.setDialogTitle("Save");

			jfileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".xlsx file", "xlsx"));

			/**
			 * invokes the showsSaveDialog function to show the save dialog allowing user to
			 * save generated excel sheet.
			 */
			if (jfileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)

			{
				System.err.println("DQIVariables.getInstance().isWriteExcel()= "+DQIVariables.getInstance().isWriteExcel());
				DQIVariables.getInstance().setWriteExcel(true);
				DQIVariables.getInstance()
						.setdQIfinalSheetPath(jfileChooser.getSelectedFile().getAbsolutePath().toString());
				 new DQIDataProcessor().process();
			
				new DQIExcelCreatedDialog();	
				DQIVariables.getInstance().setOpenSaveFrame(false);

			}
		}

		
	}

}
