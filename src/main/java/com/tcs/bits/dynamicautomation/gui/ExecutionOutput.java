package com.tcs.bits.dynamicautomation.gui;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URI;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.tcs.bits.dynamicautomation.to.Output;

public class ExecutionOutput extends JFrame  {
	

	private JLabel labelTTC = new JLabel("Total Test Cases:");
	private JLabel labelTTP = new JLabel("Test Cases Passed:");
	private JLabel labelTTF = new JLabel("Test Cases Failed:");



	public ExecutionOutput(final Output outputTO) {
		super("Execution Output");

		
		final JLabel labelLogs = new JLabel("<html><a href=\" " + outputTO.getLogsPath() + "\"> Logs </a></html>");
		final JLabel labelScreenShots = new JLabel("<html><a href=\" " + outputTO.getScreenshotsPath() + "\"> ScreenShots </a></html>");
		

		JLabel labelTTCCount = new JLabel(outputTO.getTotalTestCases());
		JLabel labelTTPCount = new JLabel(outputTO.getPassCount());
		JLabel labelTTFCount = new JLabel(outputTO.getFailCount());
		
		// set up layout
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);


		// add components to the frame
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(labelTTC, constraints);

		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1.0;
		add(labelTTCCount, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		add(labelTTP, constraints);

		constraints.gridx = 1;
		add(labelTTPCount, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		add(labelTTF, constraints);

		constraints.gridx = 1;
		add(labelTTFCount, constraints);

		constraints.gridx = 1;
		constraints.gridy = 3;
		add(labelLogs, constraints);

		constraints.gridx = 2;
		add(labelScreenShots, constraints);
		
		labelLogs.addMouseListener(new MouseAdapter() {
		       public void mouseEntered(MouseEvent me) {
		    	   labelLogs.setCursor(new Cursor(Cursor.HAND_CURSOR));
		       }
		       public void mouseExited(MouseEvent me) {
		    	   labelLogs.setCursor(Cursor.getDefaultCursor());
		       }
		       public void mouseClicked(MouseEvent me)
		       {
		          System.out.println("Clicked on Logs File..."+outputTO.getLogsPath());
		          try {
		        	  URI uri = new java.net.URI(outputTO.getLogsPath());
		        	  Desktop desktop = java.awt.Desktop.getDesktop();
		              desktop.browse(uri);
		            }
		            catch(Exception e) {
		               System.out.println(e);
		            }
		       }
		      });

		labelScreenShots.addMouseListener(new MouseAdapter() {
		       public void mouseEntered(MouseEvent me) {
		    	   labelScreenShots.setCursor(new Cursor(Cursor.HAND_CURSOR));
		       }
		       public void mouseExited(MouseEvent me) {
		    	   labelScreenShots.setCursor(Cursor.getDefaultCursor());
		       }
		       public void mouseClicked(MouseEvent me)
		       {
		          System.out.println("Clicked on Screen shots File..."+outputTO.getScreenshotsPath());
		          try {
		        	  URI uri = new java.net.URI(outputTO.getScreenshotsPath());
		        	  Desktop desktop = java.awt.Desktop.getDesktop();
		              desktop.browse(uri);
		            }
		            catch(Exception e) {
		               System.out.println(e);
		            }
		       }
		      });
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	/**
	 * Launch the application
	 */
	public static void runOutputPanel(final Output outputTO) {
		try {
			// set look and feel to system dependent
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ExecutionOutput(outputTO).setVisible(true);
			}
		});
	}
	
	
	
	
}