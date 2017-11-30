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
import java.util.Arrays;

import javax.swing.JScrollPane;

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
	private PriorityIncrementer priInc;
	private JButton btnSubmit;
	private static String[] fromTimes = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00",
			"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00",
			"20:00", "21:00", "22:00"};
	private static String[] toTimes = {"01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00",
			"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00",
			"20:00", "21:00", "22:00", "23:00"};
	
	/**
	 * Create the panel.
	 */
	public RequestPanelTSP(MainFrame2 f) {
		frame=f;
		mainPanel = new JPanel();
		add(mainPanel);	

		priInc= new PriorityIncrementer();
		
		String[] timeSlots = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00",
				"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00",
				"20:00", "21:00", "22:00", "23:00"};
		
		
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		String[] priorities= {"1","2","3","4","5"};
		
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{0, 0, 0};
		gbl_mainPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_mainPanel.columnWeights = new double[]{1.0, 1.0, 0.0};
		gbl_mainPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0};
		mainPanel.setLayout(gbl_mainPanel);
		
		JLabel txtChooseATimeslot = new JLabel("Choose a start time.");
		GridBagConstraints gbc_txtChooseATimeslot = new GridBagConstraints();
		gbc_txtChooseATimeslot.insets = new Insets(0, 0, 5, 5);
		gbc_txtChooseATimeslot.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChooseATimeslot.gridx = 1;
		gbc_txtChooseATimeslot.gridy = 0;
		mainPanel.add(txtChooseATimeslot, gbc_txtChooseATimeslot);
		
		JScrollPane sTimePane = new JScrollPane();
		GridBagConstraints gbc_sTimePane = new GridBagConstraints();
		gbc_sTimePane.fill = GridBagConstraints.BOTH;
		gbc_sTimePane.insets = new Insets(0, 0, 5, 5);
		gbc_sTimePane.gridx = 1;
		gbc_sTimePane.gridy = 1;
		mainPanel.add(sTimePane, gbc_sTimePane);
		
		JList timeList = new JList(fromTimes);
		sTimePane.setViewportView(timeList);
		
	
		timeList.setVisibleRowCount(5);
		//Can possibly be modified to have multiple selections at once.
		timeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel txtChooseEndTimeslot = new JLabel("Choose an end time.");
		GridBagConstraints gbc_txtChooseEndTimeslot = new GridBagConstraints();
		gbc_txtChooseEndTimeslot.insets = new Insets(0, 0, 5, 0);
		gbc_txtChooseEndTimeslot.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChooseEndTimeslot.gridx = 2;
		gbc_txtChooseEndTimeslot.gridy = 0;
		mainPanel.add(txtChooseEndTimeslot, gbc_txtChooseEndTimeslot);
		
		JScrollPane sEndTimePane = new JScrollPane();
		GridBagConstraints gbc_sEndTimePane = new GridBagConstraints();
		gbc_sEndTimePane.fill = GridBagConstraints.BOTH;
		gbc_sEndTimePane.insets = new Insets(0, 0, 5, 0);
		gbc_sEndTimePane.gridx = 2;
		gbc_sEndTimePane.gridy = 1;
		mainPanel.add(sEndTimePane, gbc_sEndTimePane);
		
				
				JList timeEndList = new JList(toTimes);
				sEndTimePane.setViewportView(timeEndList);
				timeEndList.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						timeSlotEnd=timeSlots[timeEndList.getSelectedIndex()];
						if (timeList.getSelectedValue() != null) {
				    		String fromChoice = timeList.getSelectedValue().toString();
				    		String toChoice = timeEndList.getSelectedValue().toString();
				    		int currFrom = (Arrays.asList(timeSlots).indexOf(fromChoice));
				    		int newTo = (Arrays.asList(timeSlots).indexOf(toChoice));
				    		if (newTo <= currFrom) {
				    			System.out.println("Caught2");
				    			timeList.setSelectedIndex(newTo-1);
				    		}
				    	}
					}
				});
	
		timeEndList.setVisibleRowCount(5);
		//Can possibly be modified to have multiple selections at once.
		timeEndList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		timeList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				timeSlotStart=timeSlots[timeList.getSelectedIndex()];
				if (timeEndList.getSelectedValue() != null) {
		    		String fromChoice = timeList.getSelectedValue().toString();
		    		String toChoice = timeEndList.getSelectedValue().toString();
		    		int newFrom = (Arrays.asList(timeSlots).indexOf(fromChoice));
		    		int currTo = (Arrays.asList(timeSlots).indexOf(toChoice));
		    		if (newFrom >= currTo) {
		    			System.out.println("Caught1");
		    			timeEndList.setSelectedIndex(newFrom);
		    		}
		    	}
			}
		});
		
		JLabel txtChooseADay = new JLabel("Choose a Day");
		GridBagConstraints gbc_txtChooseADay = new GridBagConstraints();
		gbc_txtChooseADay.insets = new Insets(0, 0, 5, 5);
		gbc_txtChooseADay.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChooseADay.gridx = 1;
		gbc_txtChooseADay.gridy = 2;
		mainPanel.add(txtChooseADay, gbc_txtChooseADay);
		
		JScrollPane sDayPane = new JScrollPane();
		GridBagConstraints gbc_sDayPane = new GridBagConstraints();
		gbc_sDayPane.fill = GridBagConstraints.BOTH;
		gbc_sDayPane.insets = new Insets(0, 0, 5, 5);
		gbc_sDayPane.gridx = 1;
		gbc_sDayPane.gridy = 3;
		mainPanel.add(sDayPane, gbc_sDayPane);
		
				JList dayList = new JList(days);
				sDayPane.setViewportView(dayList);
				dayList.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						day=days[dayList.getSelectedIndex()];
					}
				});
	
		dayList.setVisibleRowCount(3);
		dayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					frame.reqShow();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.EAST;
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 4;
		mainPanel.add(btnBack, gbc_btnBack);
		
		JButton btnNextRequest = new JButton("Add Booking");
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setVisible(false);
		btnNextRequest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (priInc.getInc()>1) {
					frame.setReqPanelTSPStored(fromTimes[timeList.getSelectedIndex()],toTimes[timeEndList.getSelectedIndex()],days[dayList.getSelectedIndex()],Integer.toString(priInc.getInc()));
					priInc.removePri();
					frame.reqTSPShow();
					frame.generateRequest(frame.getStoredInfo());
					System.out.println(priInc.getInc());
				}
				else if(priInc.getInc()==1) {
					frame.setReqPanelTSPStored(fromTimes[timeList.getSelectedIndex()],toTimes[timeEndList.getSelectedIndex()],days[dayList.getSelectedIndex()],Integer.toString(priInc.getInc()));
					priInc.removePri();
					frame.reqTSPShow();
					frame.generateRequest(frame.getStoredInfo());
					btnSubmit.setVisible(true);
					btnNextRequest.setVisible(false);
				}
				else{
					btnSubmit.setVisible(true);
					btnNextRequest.setVisible(false);
				}
			}
		});
		GridBagConstraints gbc_btnNextRequest = new GridBagConstraints();
		gbc_btnNextRequest.anchor = GridBagConstraints.EAST;
		gbc_btnNextRequest.insets = new Insets(0, 0, 0, 5);
		gbc_btnNextRequest.gridx = 2;
		gbc_btnNextRequest.gridy = 4;
		mainPanel.add(btnNextRequest, gbc_btnNextRequest);
		

		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setReqPanelTSPStored(timeSlots[timeList.getSelectedIndex()],timeSlots[timeEndList.getSelectedIndex()],days[dayList.getSelectedIndex()],Integer.toString(priInc.getInc()));
				frame.generateRequest(frame.getStoredInfo());
				school.Request.submitUnfinished();
				//Return to HomePanel
				frame.displayHome();
				frame.hideApp();
				frame.appShow();
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 4;
		mainPanel.add(btnSubmit, gbc_btnSubmit);	
	}

}
