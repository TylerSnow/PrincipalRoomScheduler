package roomGUI;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RequestPanelTSP extends JPanel {
	private final MainFrame2 frame;
	private JPanel mainPanel;
	private String timeSlotStart;
	private String timeSlotEnd;
	private String day;
	private String priority;
	private JTextField txtChooseATimeslot;
	private JTextField txtChooseEndTimeslot;
	private JTextField txtChooseADay;
	private JTextField txtPriority;
	/**
	 * Create the panel.
	 */
	public RequestPanelTSP(MainFrame2 f) {
		frame=f;
		mainPanel = new JPanel();
		add(mainPanel);
		
		String[] timeSlots = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00",
				"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00",
				"20:00", "21:00", "22:00", "23:00"};
		
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		String[] priorities= {"1","2","3","4","5"};
		
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_mainPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_mainPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0};
		mainPanel.setLayout(gbl_mainPanel);
		
		txtChooseATimeslot = new JTextField();
		txtChooseATimeslot.setEditable(false);
		txtChooseATimeslot.setText("Choose a timeslot.");
		GridBagConstraints gbc_txtChooseATimeslot = new GridBagConstraints();
		gbc_txtChooseATimeslot.insets = new Insets(0, 0, 5, 5);
		gbc_txtChooseATimeslot.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChooseATimeslot.gridx = 3;
		gbc_txtChooseATimeslot.gridy = 0;
		mainPanel.add(txtChooseATimeslot, gbc_txtChooseATimeslot);
		txtChooseATimeslot.setColumns(10);
		
		JList timeList = new JList(timeSlots);
		timeList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				timeSlotStart=timeSlots[timeList.getSelectedIndex()];
			}
		});
	
		timeList.setVisibleRowCount(5);
		//Can possibly be modified to have multiple selections at once.
		timeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		GridBagConstraints gbc_timeList = new GridBagConstraints();
		gbc_timeList.insets = new Insets(0, 0, 5, 5);
		gbc_timeList.fill = GridBagConstraints.BOTH;
		gbc_timeList.gridx = 3;
		gbc_timeList.gridy = 1;
		mainPanel.add(timeList, gbc_timeList);
		
		txtChooseEndTimeslot = new JTextField();
		txtChooseEndTimeslot.setEditable(false);
		txtChooseEndTimeslot.setText("Choose a timeslot.");
		GridBagConstraints gbc_txtChooseEndTimeslot = new GridBagConstraints();
		gbc_txtChooseEndTimeslot.insets = new Insets(0, 0, 5, 5);
		gbc_txtChooseEndTimeslot.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChooseEndTimeslot.gridx = 3;
		gbc_txtChooseEndTimeslot.gridy = 2;
		mainPanel.add(txtChooseEndTimeslot, gbc_txtChooseATimeslot);
		txtChooseEndTimeslot.setColumns(10);
		
		JList timeEndList = new JList(timeSlots);
		timeEndList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				timeSlotEnd=timeSlots[timeEndList.getSelectedIndex()];
			}
		});
	
		timeEndList.setVisibleRowCount(5);
		//Can possibly be modified to have multiple selections at once.
		timeEndList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		GridBagConstraints gbc_timeEndList = new GridBagConstraints();
		gbc_timeEndList.insets = new Insets(0, 0, 5, 5);
		gbc_timeEndList.fill = GridBagConstraints.BOTH;
		gbc_timeEndList.gridx = 3;
		gbc_timeEndList.gridy = 3;
		mainPanel.add(timeEndList, gbc_timeEndList);
		
		txtChooseADay = new JTextField();
		txtChooseADay.setEditable(false);
		txtChooseADay.setText("Choose a Day.");
		GridBagConstraints gbc_txtChooseADay = new GridBagConstraints();
		gbc_txtChooseADay.insets = new Insets(0, 0, 5, 5);
		gbc_txtChooseADay.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChooseADay.gridx = 3;
		gbc_txtChooseADay.gridy = 4;
		mainPanel.add(txtChooseADay, gbc_txtChooseADay);
		txtChooseADay.setColumns(10);
		
		JList dayList = new JList(days);
		dayList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				day=days[dayList.getSelectedIndex()];
			}
		});
	
		dayList.setVisibleRowCount(5);
		dayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_dayList = new GridBagConstraints();
		gbc_dayList.insets = new Insets(0, 0, 5, 5);
		gbc_dayList.fill = GridBagConstraints.BOTH;
		gbc_dayList.gridx = 3;
		gbc_dayList.gridy = 5;
		mainPanel.add(dayList, gbc_dayList);
		
		txtPriority = new JTextField();
		txtPriority.setEditable(false);
		txtPriority.setText("Select Priority.");
		GridBagConstraints gbc_txtPriority = new GridBagConstraints();
		gbc_txtPriority.insets = new Insets(0, 0, 5, 5);
		gbc_txtPriority.gridx = 3;
		gbc_txtPriority.gridy = 6;
		mainPanel.add(txtPriority, gbc_txtPriority);
		
		JList priorityList = new JList(priorities);
		priorityList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				priority=priorities[priorityList.getSelectedIndex()];
			}
		});
		priorityList.setVisibleRowCount(5);
		priorityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_priorityList = new GridBagConstraints();
		gbc_priorityList.insets = new Insets(0, 0, 5, 5);
		gbc_priorityList.fill = GridBagConstraints.BOTH;
		gbc_priorityList.gridx = 3;
		gbc_priorityList.gridy = 7;
		mainPanel.add(priorityList, gbc_priorityList);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Go to HomePanel.java
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.EAST;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 8;
		mainPanel.add(btnBack, gbc_btnBack);
		
		JButton btnNextRequest = new JButton("Next Request");
		btnNextRequest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Go to RequestPanel.java to make another request
			}
		});
		GridBagConstraints gbc_btnNextRequest = new GridBagConstraints();
		gbc_btnNextRequest.anchor = GridBagConstraints.EAST;
		gbc_btnNextRequest.insets = new Insets(0, 0, 5, 5);
		gbc_btnNextRequest.gridx = 3;
		gbc_btnNextRequest.gridy = 8;
		mainPanel.add(btnNextRequest, gbc_btnNextRequest);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Request req=new Request(new Applicant(test.school.Applicant.getID(),test.school.Applicant.getID()),
				//		newBooking(timeSlotStart,timeSlotEnd,test.school.Group.getName()),Integer.parseInt(priority),
				//		readInFile,day);
				//Return to HomePanel
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.gridx = 4;
		gbc_btnSubmit.gridy = 8;
		mainPanel.add(btnSubmit, gbc_btnSubmit);
		
	}

}
