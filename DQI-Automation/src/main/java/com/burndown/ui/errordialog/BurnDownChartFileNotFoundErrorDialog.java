/**
 * 
 */
package com.burndown.ui.errordialog;

import java.awt.HeadlessException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *  If uploaded file is not found then this error dialog is shown.
 * @author priyanka_gupta
 *
 */
public class BurnDownChartFileNotFoundErrorDialog extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7475119978745814061L;
	private static JDialog jDialog;  
	
	/**
	 * Initializes frame components.
	 * @throws HeadlessException
	 */
	public BurnDownChartFileNotFoundErrorDialog() throws HeadlessException 
	{
     
		JOptionPane.showMessageDialog(null,
			    "The system cannot find the file specified.","File Not Found", JOptionPane.ERROR_MESSAGE);
	}
public static void main(String[] args) {
	new BurnDownChartFileNotFoundErrorDialog() ;
}

}
