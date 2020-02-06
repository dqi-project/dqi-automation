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

import com.burndown.service.impl.GetBurnDownChart;
import com.burndown.ui.errordialog.BurnDownChartGeneralErrorDialog;
import com.burndown.util.Constant;

/**
 * This class shows save dialog to the user to save Burn Down Chart Image.
 * 
 * @author priyanka_gupta
 * 
 */
public class BurnDownChartSaveFrame extends JFrame implements ActionListener {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6959835157006922536L;
	private static final Logger logger = Logger.getLogger(BurnDownChartSaveFrame.class);

	JButton saveButton, saveButton1;

	/**
	 * Initializes frame components.
	 */
	public BurnDownChartSaveFrame() {
		super("Save");

		Font myFont = new Font(Constant.FONT_FAMILY, Font.PLAIN, 15);

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

			FileNameExtensionFilter restrict = new FileNameExtensionFilter(".jpeg file", "jpeg");
			jfileChooser.addChoosableFileFilter(restrict);

			/**
			 * invokes the showsSaveDialog function to show the save dialog
			 * allowing user to save Burn Down Chart image.
			 */
			if (jfileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)

			{
				try
				{
				logger.info("Save frame working.");

				new GetBurnDownChart()
						.saveBurnDownChartImage(jfileChooser.getSelectedFile().getAbsolutePath().toString() + ".jpeg");
				new BurnDownChartImageSavedDialog().setLocationRelativeTo(null);	
				}catch(Throwable e)
				{
					new BurnDownChartGeneralErrorDialog();
				}
			}
		}


		

	}

}
