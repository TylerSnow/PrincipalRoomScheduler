package roomGUI;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class RequestPanel extends JPanel {
	private final MainFrame2 frame;
	private JPanel mainPanel;
	private JTextField txtSelectARoom;
	private JTextField txtSelectASemester;
	private String room;
	private String semester;
	private String numReq;

	/**
	 * Create the panel.
	 */
	public RequestPanel(MainFrame2 f) {
		frame=f;
		mainPanel = new JPanel();
		add(mainPanel);
		
		//Room[] rooms={101,102,103,104,105};
		//Semester[] semesters={fall,winter,spring};
		String[] rooms = {"Gymnasium", "Chemistry Lab", "Physics Lab", "Auditorium", "Cafeteria"};
		String[] semesters = {"Fall", "Winter", "Spring"};
		String[] numReqs={"5","4","3","2","1"};
		
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_mainPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_mainPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		mainPanel.setLayout(gbl_mainPanel);
		
		JLabel lblRoomBookingApplication = new JLabel("Room Booking Application");
		GridBagConstraints gbc_lblRoomBookingApplication = new GridBagConstraints();
		gbc_lblRoomBookingApplication.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomBookingApplication.gridx = 3;
		gbc_lblRoomBookingApplication.gridy = 0;
		mainPanel.add(lblRoomBookingApplication, gbc_lblRoomBookingApplication);
		
		JLabel txtSelectARoom = new JLabel("Select a room.");
		GridBagConstraints gbc_txtSelectARoom = new GridBagConstraints();
		gbc_txtSelectARoom.insets = new Insets(0, 0, 5, 5);
		gbc_txtSelectARoom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSelectARoom.gridx = 3;
		gbc_txtSelectARoom.gridy = 2;
		mainPanel.add(txtSelectARoom, gbc_txtSelectARoom);
		
		JList roomList = new JList(rooms);
		roomList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				room=rooms[roomList.getSelectedIndex()];
			}
		});
		roomList.setVisibleRowCount(5);
		roomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		GridBagConstraints gbc_roomList = new GridBagConstraints();
		gbc_roomList.insets = new Insets(0, 0, 5, 5);
		gbc_roomList.fill = GridBagConstraints.BOTH;
		gbc_roomList.gridx = 3;
		gbc_roomList.gridy = 3;
		mainPanel.add(roomList, gbc_roomList);
		
		JLabel txtSelectASemester = new JLabel("Select a semester.");
		GridBagConstraints gbc_txtSelectASemester = new GridBagConstraints();
		gbc_txtSelectASemester.insets = new Insets(0, 0, 5, 5);
		gbc_txtSelectASemester.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSelectASemester.gridx = 3;
		gbc_txtSelectASemester.gridy = 4;
		mainPanel.add(txtSelectASemester, gbc_txtSelectASemester);
		
		JList semesterList = new JList(semesters);
		semesterList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				semester=semesters[semesterList.getSelectedIndex()];
			}
		});
		semesterList.setVisibleRowCount(5);
		semesterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		JLabel txtnumReq = new JLabel("How many requests?");
		GridBagConstraints gbc_txtnumReq = new GridBagConstraints();
		gbc_txtnumReq.insets = new Insets(0, 0, 5, 5);
		gbc_txtnumReq.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnumReq.gridx = 2;
		gbc_txtnumReq.gridy = 4;
		mainPanel.add(txtnumReq, gbc_txtnumReq);
		
		JScrollPane numReqPane = new JScrollPane();
		GridBagConstraints gbc_numReqPane = new GridBagConstraints();
		gbc_numReqPane.fill = GridBagConstraints.BOTH;
		gbc_numReqPane.insets = new Insets(0, 0, 5, 5);
		gbc_numReqPane.gridx = 2;
		gbc_numReqPane.gridy = 5;
		mainPanel.add(numReqPane, gbc_numReqPane);
		
				JList numReqList = new JList(numReqs);
				numReqPane.setViewportView(numReqList);
				numReqList.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						numReq=numReqs[numReqList.getSelectedIndex()];
					}
				});
	
		numReqList.setVisibleRowCount(1);
		numReqList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		GridBagConstraints gbc_semesterList = new GridBagConstraints();
		gbc_semesterList.insets = new Insets(0, 0, 5, 5);
		gbc_semesterList.fill = GridBagConstraints.BOTH;
		gbc_semesterList.gridx = 3;
		gbc_semesterList.gridy = 5;
		mainPanel.add(semesterList, gbc_semesterList);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Go back to ApplicantInfo.java
				frame.appShow();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 6;
		mainPanel.add(btnBack, gbc_btnBack);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Go to RequestPageTSP.java
				frame.setReqPanelStored(room,semester,numReq);
				frame.reqTSPShow();
				frame.updatePriInc();
				System.out.println(numReq);
			}
		});
		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.anchor = GridBagConstraints.EAST;
		gbc_btnConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirm.gridx = 3;
		gbc_btnConfirm.gridy = 6;
		mainPanel.add(btnConfirm, gbc_btnConfirm);		
	}


}
