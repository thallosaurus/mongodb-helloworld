package com.jarvis.mongodb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.jarvis.mongodb.MongoUtils;

/* Old Imports:

import com.mongodb.Block;
import com.mongodb.ServerAddress;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.ConnectionString;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.inc;
import static com.mongodb.client.model.Updates.set;
import static java.util.Arrays.asList;

*/

public class Main implements ActionListener {
	
	//Labels
	JButton connectLabel;
	JButton insertContent;
	JButton deleteContent;
	JFrame frame;
	MongoUtils u = new MongoUtils();
	static SimpleSettings connectionSettings;
	
	public static void main(String[] args) {
		Main obj = new Main();
		obj.run();
	}
	
	public void run() {
		//Define Objects
		frame = new JFrame("MongoDB Test");
		connectLabel = new JButton();
		insertContent = new JButton();
		deleteContent = new JButton();
		JPanel panel = new JPanel();
		connectLabel.addActionListener(this);
		insertContent.addActionListener(this);
		deleteContent.addActionListener(this);
		
		//Pre run stuff:
		connectLabel.setText("Connect");
		insertContent.setText("Insert Data");
		deleteContent.setText("Delete Data");
		panel.add(connectLabel);
		panel.add(insertContent);
		panel.add(deleteContent);
		
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if (obj == connectLabel) {
			//Connection here
			System.out.println("Pressed Connect");
			ConnectionDialog.showDialog();
		} else if (obj == insertContent) {
			//Insertion here
			MongoUtils.insertElement();
		} else if (obj == deleteContent) {
			//Deletion here
		}
	}
}
