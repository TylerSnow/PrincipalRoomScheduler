import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;

public class RoomAndSemester extends JPanel {

	/**
	 * Create the panel.
	 */
	public RoomAndSemester() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		add(btnBack, gbc_btnBack);
		
		String[] semesters = {"Fall", "Winter", "Spring"};
		
		String[] rooms = {"Gymnasium", "Chemistry Lab", "Physics Lab", "Auditorium", "Cafeteria"};
		
		JButton forFormatting = new JButton("Back");
		forFormatting.setVisible(false);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 0;
		add(forFormatting, gbc_btnNewButton_1);
		
		JLabel lblRoomAvailabilityInformation = new JLabel("Room Availability Information");
		lblRoomAvailabilityInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblRoomAvailabilityInformation = new GridBagConstraints();
		gbc_lblRoomAvailabilityInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomAvailabilityInformation.gridx = 3;
		gbc_lblRoomAvailabilityInformation.gridy = 1;
		add(lblRoomAvailabilityInformation, gbc_lblRoomAvailabilityInformation);
		
		JLabel lblSelectARoom = new JLabel("Select a Room and Semester");
		GridBagConstraints gbc_lblSelectARoom = new GridBagConstraints();
		gbc_lblSelectARoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectARoom.gridx = 3;
		gbc_lblSelectARoom.gridy = 2;
		add(lblSelectARoom, gbc_lblSelectARoom);
		
		JLabel lblSemester = new JLabel("Semester:");
		GridBagConstraints gbc_lblSemester = new GridBagConstraints();
		gbc_lblSemester.insets = new Insets(0, 0, 5, 5);
		gbc_lblSemester.anchor = GridBagConstraints.EAST;
		gbc_lblSemester.gridx = 2;
		gbc_lblSemester.gridy = 4;
		add(lblSemester, gbc_lblSemester);
		JComboBox comboBox = new JComboBox(semesters);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);
		
		JLabel lblRoom = new JLabel("Room:");
		GridBagConstraints gbc_lblRoom = new GridBagConstraints();
		gbc_lblRoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoom.anchor = GridBagConstraints.EAST;
		gbc_lblRoom.gridx = 2;
		gbc_lblRoom.gridy = 5;
		add(lblRoom, gbc_lblRoom);
		JComboBox comboBox_1 = new JComboBox(rooms);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 5;
		add(comboBox_1, gbc_comboBox_1);
		
		JButton btnNewButton = new JButton("Confirm");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 6;
		add(btnNewButton, gbc_btnNewButton);

	}
	
	public static void main(String [] args) {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RoomAndSemester r = new RoomAndSemester();
		frame.getContentPane().add(r);
		frame.repaint();
		frame.revalidate();
	}

}
