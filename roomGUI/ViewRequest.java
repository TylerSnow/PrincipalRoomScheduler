package roomGUI;

import javax.swing.JPanel;

import school.Booking;
import school.Request;
import school.Semester;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import java.awt.Canvas;
import java.awt.List;
import java.awt.Color;

public class ViewRequest extends JPanel {

	private final MainFrame2 frame;
	private Request request;
	private JTextField roomField;
	private JTextField semesterField;
	private JTextField groupField;
	private JTextField desiredField;
	private JTextField messageField;
	private JList list;
	private DefaultListModel model;
	private ArrayList<Integer> toApprove;
	private ArrayList<Integer> toDeny;

	
	/**
	 * Create the panel.
	 */
	public ViewRequest(MainFrame2 f, Request r) {
		frame = f;
		request = r;
		toApprove = new ArrayList<>();
		toDeny = new ArrayList<>();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblRequestInfo = new JLabel("Request Info");
		lblRequestInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblRequestInfo = new GridBagConstraints();
		gbc_lblRequestInfo.gridwidth = 4;
		gbc_lblRequestInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblRequestInfo.gridx = 1;
		gbc_lblRequestInfo.gridy = 0;
		add(lblRequestInfo, gbc_lblRequestInfo);
		
		JLabel lblNewLabel = new JLabel("Room:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		roomField = new JTextField();
		roomField.setEditable(false);
		roomField.setText(r.getRoom().getName());
		GridBagConstraints gbc_roomField = new GridBagConstraints();
		gbc_roomField.insets = new Insets(0, 0, 5, 5);
		gbc_roomField.fill = GridBagConstraints.HORIZONTAL;
		gbc_roomField.gridx = 2;
		gbc_roomField.gridy = 1;
		add(roomField, gbc_roomField);
		roomField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Semester:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		semesterField = new JTextField();
		semesterField.setEditable(false);
		semesterField.setText(r.getSemester().toString());
		GridBagConstraints gbc_semesterField = new GridBagConstraints();
		gbc_semesterField.insets = new Insets(0, 0, 5, 5);
		gbc_semesterField.fill = GridBagConstraints.HORIZONTAL;
		gbc_semesterField.gridx = 4;
		gbc_semesterField.gridy = 1;
		add(semesterField, gbc_semesterField);
		semesterField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Group:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		groupField = new JTextField();
		groupField.setEditable(false);
		groupField.setText(r.getApplicant().getGroup().getName());
		GridBagConstraints gbc_groupField = new GridBagConstraints();
		gbc_groupField.insets = new Insets(0, 0, 5, 5);
		gbc_groupField.fill = GridBagConstraints.HORIZONTAL;
		gbc_groupField.gridx = 2;
		gbc_groupField.gridy = 2;
		add(groupField, gbc_groupField);
		groupField.setColumns(10);
		
		JLabel lblDesired = new JLabel("Desired #:");
		GridBagConstraints gbc_lblDesired = new GridBagConstraints();
		gbc_lblDesired.anchor = GridBagConstraints.EAST;
		gbc_lblDesired.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesired.gridx = 3;
		gbc_lblDesired.gridy = 2;
		add(lblDesired, gbc_lblDesired);
		
		desiredField = new JTextField();
		desiredField.setEditable(false);
		desiredField.setText(r.getNumSlots() + "");
		GridBagConstraints gbc_desiredField = new GridBagConstraints();
		gbc_desiredField.insets = new Insets(0, 0, 5, 5);
		gbc_desiredField.fill = GridBagConstraints.HORIZONTAL;
		gbc_desiredField.gridx = 4;
		gbc_desiredField.gridy = 2;
		add(desiredField, gbc_desiredField);
		desiredField.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message:");
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.anchor = GridBagConstraints.EAST;
		gbc_lblMessage.insets = new Insets(0, 0, 5, 5);
		gbc_lblMessage.gridx = 1;
		gbc_lblMessage.gridy = 3;
		add(lblMessage, gbc_lblMessage);
		
		messageField = new JTextField();
		messageField.setEditable(false);
		messageField.setText(r.getMessage());
		GridBagConstraints gbc_messageField = new GridBagConstraints();
		gbc_messageField.insets = new Insets(0, 0, 5, 5);
		gbc_messageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_messageField.gridx = 2;
		gbc_messageField.gridy = 3;
		add(messageField, gbc_messageField);
		messageField.setColumns(10);
		
		JLabel lblSelectedSlots = new JLabel("Selected Slots:");
		GridBagConstraints gbc_lblSelectedSlots = new GridBagConstraints();
		gbc_lblSelectedSlots.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectedSlots.gridx = 1;
		gbc_lblSelectedSlots.gridy = 4;
		add(lblSelectedSlots, gbc_lblSelectedSlots);
		
		
		Booking[] bookings = r.getBookings();
		model = new DefaultListModel();
		for(int i = 0; i < bookings.length; i++) {
			model.addElement(bookings[i].toString());
		}
		list = new JList(model);
		list.setForeground(Color.BLACK);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 4;
		gbc_list.gridheight = 2;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 5;
		add(list, gbc_list);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new BackButtonListener(frame));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 7;
		add(btnBack, gbc_btnBack);
		
		JButton btnDeny = new JButton("Deny");
		btnDeny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//r.approveRequest(list.getSelectedIndex());
				toDeny.add(list.getSelectedIndex());
				String newElement = bookings[list.getSelectedIndex()] + " (Denied)";
				int pos = list.getSelectedIndex();
				model.remove(list.getSelectedIndex());
				model.insertElementAt(newElement, pos);
			}
		});
		GridBagConstraints gbc_btnDeny = new GridBagConstraints();
		gbc_btnDeny.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeny.gridx = 2;
		gbc_btnDeny.gridy = 7;
		add(btnDeny, gbc_btnDeny);
		
		JButton btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//r.approveRequest(list.getSelectedIndex());
				toApprove.add(list.getSelectedIndex());
				String newElement = bookings[list.getSelectedIndex()] + " (Approved)";
				int pos = list.getSelectedIndex();
				model.remove(list.getSelectedIndex());
				model.insertElementAt(newElement, pos);
			}
		});
		GridBagConstraints gbc_btnApprove = new GridBagConstraints();
		gbc_btnApprove.insets = new Insets(0, 0, 0, 5);
		gbc_btnApprove.gridx = 3;
		gbc_btnApprove.gridy = 7;
		add(btnApprove, gbc_btnApprove);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Requests Approved:");
				for(int i = 0; i < toApprove.size(); i++) {
					r.approveRequest(toApprove.get(i));
					System.out.println(toApprove.get(i).toString());
				}
				frame.home();
				frame.hidePrinc();
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 4;
		gbc_btnSubmit.gridy = 7;
		add(btnSubmit, gbc_btnSubmit);

	}

}
