package com.jarvis.mongodb;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mongodb.ConnectionString;

public class ConnectionDialog {
	
	static JTextField hostnameField;
	static JTextField databaseField;
	static JTextField collectionField;
	static JDialog dialog;
	
	public static void showDialog() {
		hostnameField = new JTextField(15);
		databaseField = new JTextField(15);
		collectionField = new JTextField(15);
		JButton connectButton = new JButton("Connect!");
		
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				packStuffAsObject();
				dialog.setVisible(false);
				dialog.dispose();
				
			}
		});
		
		dialog = new JDialog();
		JPanel panel = new JPanel();
		panel.add(new JLabel("Hostname"));
		panel.add(hostnameField);
		panel.add(new JLabel("Database"));
		panel.add(databaseField);
		panel.add(new JLabel("Collection"));
		panel.add(collectionField);
		panel.add(connectButton);
		
		dialog.add(panel);
		dialog.setTitle("Connecting...");
		//dialog.setSize(200, 400);
		dialog.pack();
		dialog.setVisible(true);
	}
	
	public static void packStuffAsObject() {
		SimpleSettings n = new SimpleSettings(hostnameField.getText(), databaseField.getText(), collectionField.getText());
		ConnectionString c = new ConnectionString("mongodb://" + hostnameField.getText() + "/" + databaseField.getText());
		MongoUtils connection = new MongoUtils();
		connection.establishConnection(c, n);
	}
}
