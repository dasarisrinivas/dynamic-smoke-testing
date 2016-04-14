package com.tcs.bits.dynamicautomation.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.tcs.bits.dynamicautomation.action.InputReader;

/**
 * A Swing application that uploads files to a FTP server.
 * @author www.codejava.net
 *
 */
public class Dashboard extends JFrame implements
		PropertyChangeListener {

	private JLabel labelURL = new JLabel("URL:");
	private JCheckBox chckbxChrome = new JCheckBox("Chrome");
	private JCheckBox chckbxIe = new JCheckBox("IE");
	private JTextField fieldURL = new JTextField(40);

	private JFilePicker dataXML = new JFilePicker("Data XML: ",
			"Browse");
	
	private JFilePicker configXML = new JFilePicker("Config XML: ",
			"Browse");

	private JButton buttonSubmit = new JButton("Submit");

	private JLabel labelProgress = new JLabel("Progress:");
	private JProgressBar progressBar = new JProgressBar(0, 100);

	public Dashboard() {
		super("Dynamic Automation");

		// set up layout
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);

		// set up components
		dataXML.setMode(JFilePicker.MODE_OPEN);
		configXML.setMode(JFilePicker.MODE_OPEN);

		buttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				buttonUploadActionPerformed(event);
			}
		});

		progressBar.setPreferredSize(new Dimension(200, 30));
		progressBar.setStringPainted(true);

		// add components to the frame
		constraints.gridx = 0;
		constraints.gridy = 1;
		add(labelURL, constraints);

		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1.0;
		add(fieldURL, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		add(chckbxChrome, constraints);

		constraints.gridx = 1;
		add(chckbxIe, constraints);
		
		constraints.gridx = 0;
		constraints.gridwidth = 3;
		constraints.gridy = 4;
		add(configXML, constraints);

		constraints.gridx = 0;
		constraints.gridwidth = 2;
		constraints.gridy = 5;
		constraints.anchor = GridBagConstraints.WEST;

		add(dataXML, constraints);

		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.NONE;
		add(buttonSubmit, constraints);

		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.WEST;
		add(labelProgress, constraints);

		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		add(progressBar, constraints);

		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * handle click event of the Upload button
	 */
	private void buttonUploadActionPerformed(ActionEvent event) {
		String testingURL = fieldURL.getText();
		String dataPath = dataXML.getSelectedFilePath();
		String configPath = configXML.getSelectedFilePath();
		
		boolean isChrome = chckbxChrome.isSelected();
		boolean isIE = chckbxIe.isSelected();

		progressBar.setValue(0);
		
		InputReader inputReader = new InputReader();
		inputReader.StartProcessing(testingURL, dataPath, configPath, isChrome);
		progressBar.setValue(100);
		
		
	}

	/**
	 * Update the progress bar's state whenever the progress of upload changes.
	 */	
	public void propertyChange(PropertyChangeEvent evt) {
		if ("progress" == evt.getPropertyName()) {
			int progress = (Integer) evt.getNewValue();
			progressBar.setValue(progress);
		}
	}

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		try {
			// set look and feel to system dependent
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Dashboard().setVisible(true);
			}
		});
	}
	
	private void showNewFrame() {
	    JFrame frame = new JFrame("Search Window" );
	    frame.setSize( 500,120 );
	    frame.setLocationRelativeTo( null );
	    frame.setVisible( true );   

	}
}