package roomGUI;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

public class RoomAndSemester extends JPanel {

	private final MainFrame2 frame;
	private JPanel mainPanel;
	
	/**
	 * Create the panel.
	 */
	public RoomAndSemester(MainFrame2 f, boolean availPath) {
		frame = f;
		mainPanel = new JPanel();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gridBagLayout);
		
		String[] semesters = {"Fall", "Winter", "Spring"};
		
		String[] rooms = {"Gymnasium", "Chemistry Lab", "Physics Lab", "Auditorium", "Cafeteria"};
		
		JLabel lblRoomAvailabilityInformation = new JLabel("Room Availability Information");
		lblRoomAvailabilityInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblRoomAvailabilityInformation = new GridBagConstraints();
		gbc_lblRoomAvailabilityInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomAvailabilityInformation.gridx = 3;
		gbc_lblRoomAvailabilityInformation.gridy = 1;
		mainPanel.add(lblRoomAvailabilityInformation, gbc_lblRoomAvailabilityInformation);
		
		JLabel lblSelectARoom = new JLabel("Select a Room and Semester");
		GridBagConstraints gbc_lblSelectARoom = new GridBagConstraints();
		gbc_lblSelectARoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectARoom.gridx = 3;
		gbc_lblSelectARoom.gridy = 2;
		mainPanel.add(lblSelectARoom, gbc_lblSelectARoom);
		
		JLabel lblSemester = new JLabel("Semester:");
		GridBagConstraints gbc_lblSemester = new GridBagConstraints();
		gbc_lblSemester.insets = new Insets(0, 0, 5, 5);
		gbc_lblSemester.anchor = GridBagConstraints.EAST;
		gbc_lblSemester.gridx = 2;
		gbc_lblSemester.gridy = 4;
		mainPanel.add(lblSemester, gbc_lblSemester);
		
		JComboBox semesterCombo = new JComboBox(semesters);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 4;
		mainPanel.add(semesterCombo, gbc_comboBox);
		
		JLabel lblRoom = new JLabel("Room:");
		GridBagConstraints gbc_lblRoom = new GridBagConstraints();
		gbc_lblRoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoom.anchor = GridBagConstraints.EAST;
		gbc_lblRoom.gridx = 2;
		gbc_lblRoom.gridy = 5;
		mainPanel.add(lblRoom, gbc_lblRoom);
		
		JComboBox roomCombo = new JComboBox(rooms);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 5;
		mainPanel.add(roomCombo, gbc_comboBox_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new BackButtonListener(frame));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.EAST;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 6;
		mainPanel.add(btnBack, gbc_btnBack);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (availPath) {
					if (roomCombo.getSelectedItem() != null && semesterCombo.getSelectedItem() != null) {
						frame.showAvailabilityPanel(semesterCombo.getSelectedItem().toString(),
												roomCombo.getSelectedItem().toString());
					}
				}
				else {
					if (roomCombo.getSelectedItem() != null && semesterCombo.getSelectedItem() != null) {
						frame.showRequestPanel(semesterCombo.getSelectedItem().toString(),
												roomCombo.getSelectedItem().toString());
					}
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 6;
		mainPanel.add(confirmButton, gbc_btnNewButton);
		
		add(mainPanel);

	}

}
