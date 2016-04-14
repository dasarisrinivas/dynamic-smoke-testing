package com.tcs.bits.dynamicautomation.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class Test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		JPanel p = new JPanel();
	    final String strURL = "http://www.yahoo.com";
	    final JLabel label = new JLabel("<html><a href=\" " + strURL + "\"> click </a></html>");
	  
	    final JEditorPane htmlPane = new JEditorPane();
	  
	 
	    p.add(label);
	  
	    getContentPane().add(BorderLayout.NORTH, p);
	    getContentPane().add(BorderLayout.CENTER, new JScrollPane(htmlPane));
	    setBounds(20,200, 500,500);
	}

}
