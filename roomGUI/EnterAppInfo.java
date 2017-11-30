package roomGUI;

import java.awt.GridBagLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.io.*;

public class EnterAppInfo extends JPanel {
	private final MainFrame2 frame;
	private JPanel mainPanel;
	private JTextField nameField;
	private JTextField groupField;
	private JTextField txtWhyDoesYour;
	private JTextField txtName;
	private JTextField txtGroup;
	private String appName;
	private String groupName;
	private String message;
	
	/**
	 * Create the panel.
	 */
	public EnterAppInfo(MainFrame2 f) {
		frame=f;
		mainPanel = new JPanel();
		add(mainPanel);			
	
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_mainPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_mainPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0};
		mainPanel.setLayout(gbl_mainPanel);
		
		JLabel lblRoomBookingApplication = new JLabel("Room Booking Application");
		GridBagConstraints gbc_lblRoomBookingApplication = new GridBagConstraints();
		gbc_lblRoomBookingApplication.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomBookingApplication.gridx = 3;
		gbc_lblRoomBookingApplication.gridy = 0;
		mainPanel.add(lblRoomBookingApplication, gbc_lblRoomBookingApplication);
		
		JLabel txtName = new JLabel("Name");
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.anchor = GridBagConstraints.WEST;
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.gridx = 3;
		gbc_txtName.gridy = 2;
		mainPanel.add(txtName, gbc_txtName);
		
		nameField = new JTextField();

		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 3;
		gbc_nameField.gridy = 3;
		mainPanel.add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		JLabel txtGroup = new JLabel("Group");
		GridBagConstraints gbc_txtGroup = new GridBagConstraints();
		gbc_txtGroup.anchor = GridBagConstraints.WEST;
		gbc_txtGroup.insets = new Insets(0, 0, 5, 5);
		gbc_txtGroup.gridx = 3;
		gbc_txtGroup.gridy = 4;
		mainPanel.add(txtGroup, gbc_txtGroup);
		
		groupField = new JTextField();

		GridBagConstraints gbc_groupField = new GridBagConstraints();
		gbc_groupField.insets = new Insets(0, 0, 5, 5);
		gbc_groupField.fill = GridBagConstraints.HORIZONTAL;
		gbc_groupField.gridx = 3;
		gbc_groupField.gridy = 5;
		mainPanel.add(groupField, gbc_groupField);
		groupField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.displayHome();
				frame.hideApp();
			}
		});
		
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 9;
		mainPanel.add(btnBack, gbc_btnBack);
		
		
		JLabel txtWhyDoesYour = new JLabel("Why does your group require the room?");
		GridBagConstraints gbc_txtWhyDoesYour = new GridBagConstraints();
		gbc_txtWhyDoesYour.anchor = GridBagConstraints.WEST;
		gbc_txtWhyDoesYour.insets = new Insets(0, 0, 5, 5);
		gbc_txtWhyDoesYour.gridx = 3;
		gbc_txtWhyDoesYour.gridy = 6;
		mainPanel.add(txtWhyDoesYour, gbc_txtWhyDoesYour);
		
		JTextArea textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(150,150));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 7;
		mainPanel.add(textArea, gbc_textArea);
		
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Writes text area to text file.
				appName=nameField.getText();
				groupName=groupField.getText();
				message=textArea.getText();
				frame.appSelectRoom(appName,groupName,message);
				frame.reqShow(groupName);
			}
		});
		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.anchor = GridBagConstraints.EAST;
		gbc_btnConfirm.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirm.gridx = 3;
		gbc_btnConfirm.gridy = 9;
		mainPanel.add(btnConfirm, gbc_btnConfirm);
		
		
	}
}
