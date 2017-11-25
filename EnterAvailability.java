import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Font;

public class EnterAvailability extends JPanel {
	private MainFrame2 frame;
	private JPanel mainPanel;
	private JTextField roomField;
	private JTextField semesterField;
	
	//3 arrays is temporary fix... I hope
	private static String[] times = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00",
			"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00",
			"20:00", "21:00", "22:00", "23:00"};
	private static String[] fromTimes = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00",
			"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00",
			"20:00", "21:00", "22:00"};
	private static String[] toTimes = {"01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00",
			"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00",
			"20:00", "21:00", "22:00", "23:00"};
	
	private static String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

	/**
	 * Create the panel.
	 */
	public EnterAvailability(MainFrame2 f, String semester, String room) {
		frame = f;
		mainPanel = new JPanel();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Availability Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		mainPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblRoom = new JLabel("Room:");
		GridBagConstraints gbc_lblRoom = new GridBagConstraints();
		gbc_lblRoom.anchor = GridBagConstraints.EAST;
		gbc_lblRoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoom.gridx = 1;
		gbc_lblRoom.gridy = 2;
		mainPanel.add(lblRoom, gbc_lblRoom);
		
		roomField = new JTextField();
		roomField.setText(room);
		roomField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		mainPanel.add(roomField, gbc_textField);
		roomField.setColumns(10);
		
		JLabel lblSemester = new JLabel("Semester:");
		GridBagConstraints gbc_lblSemester = new GridBagConstraints();
		gbc_lblSemester.anchor = GridBagConstraints.EAST;
		gbc_lblSemester.insets = new Insets(0, 0, 5, 5);
		gbc_lblSemester.gridx = 1;
		gbc_lblSemester.gridy = 3;
		mainPanel.add(lblSemester, gbc_lblSemester);
		
		semesterField = new JTextField();
		semesterField.setText(semester);
		semesterField.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		mainPanel.add(semesterField, gbc_textField_1);
		semesterField.setColumns(10);
		
		JLabel lblIsAvailable = new JLabel("Is Available...");
		GridBagConstraints gbc_lblIsAvailable = new GridBagConstraints();
		gbc_lblIsAvailable.anchor = GridBagConstraints.EAST;
		gbc_lblIsAvailable.insets = new Insets(0, 0, 5, 5);
		gbc_lblIsAvailable.gridx = 1;
		gbc_lblIsAvailable.gridy = 4;
		mainPanel.add(lblIsAvailable, gbc_lblIsAvailable);
		
		JLabel lblFrom = new JLabel("From:");
		GridBagConstraints gbc_lblFrom = new GridBagConstraints();
		gbc_lblFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrom.anchor = GridBagConstraints.EAST;
		gbc_lblFrom.gridx = 1;
		gbc_lblFrom.gridy = 5;
		mainPanel.add(lblFrom, gbc_lblFrom);
		
		//ButtonGroup checkboxGroup = new ButtonGroup();
				
		JComboBox fromCombo = new JComboBox(fromTimes);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 5;
		mainPanel.add(fromCombo, gbc_comboBox);
		
		JLabel lblTo = new JLabel("To:");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.anchor = GridBagConstraints.EAST;
		gbc_lblTo.gridx = 1;
		gbc_lblTo.gridy = 6;
		mainPanel.add(lblTo, gbc_lblTo);
		
		JComboBox toCombo = new JComboBox(toTimes);
		toCombo.setSelectedItem("01:00");
		fromCombo.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        updateFromCombo(toCombo.getSelectedItem().toString());
		    }
		});
		
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 6;
		mainPanel.add(toCombo, gbc_comboBox_1);
		
		fromCombo.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if (toCombo.getSelectedItem() != null) {
		    		String fromChoice = fromCombo.getSelectedItem().toString();
		    		String toChoice = toCombo.getSelectedItem().toString();
		    		int newFrom = (Arrays.asList(fromTimes).indexOf(fromChoice));
		    		int currTo = (Arrays.asList(toTimes).indexOf(toChoice));
		    		if (newFrom >= currTo) {
		    			System.out.println("Caught1");
		    			String newTo = times[newFrom + 1];
		    			toCombo.setSelectedItem(newTo);
		    		}
		    	}
		    }
		});
		
		toCombo.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if (fromCombo.getSelectedItem() != null) {
		    		String fromChoice = fromCombo.getSelectedItem().toString();
		    		String toChoice = toCombo.getSelectedItem().toString();
		    		int newTo = (Arrays.asList(toTimes).indexOf(toChoice));
		    		int currFrom = (Arrays.asList(fromTimes).indexOf(fromChoice));
		    		if (newTo <= currFrom) {
		    			System.out.println("Caught2");
		    			String newFrom = times[newTo];
		    			fromCombo.setSelectedItem(newFrom);
		    		}
		    	}
		    }
		});
		
		JLabel lblOnDays = new JLabel("On Days:");
		GridBagConstraints gbc_lblOnDays = new GridBagConstraints();
		gbc_lblOnDays.anchor = GridBagConstraints.EAST;
		gbc_lblOnDays.insets = new Insets(0, 0, 5, 5);
		gbc_lblOnDays.gridx = 1;
		gbc_lblOnDays.gridy = 7;
		mainPanel.add(lblOnDays, gbc_lblOnDays);
		
		JCheckBox[] checkBoxes = new JCheckBox[7];
		
		JCheckBox chckbxSunday = new JCheckBox(days[0]);
		checkBoxes[0] = chckbxSunday;
		GridBagConstraints gbc_chckbxSunday = new GridBagConstraints();
		gbc_chckbxSunday.anchor = GridBagConstraints.WEST;
		gbc_chckbxSunday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSunday.gridx = 1;
		gbc_chckbxSunday.gridy = 8;
		//checkboxGroup.add(chckbxSunday);
		mainPanel.add(chckbxSunday, gbc_chckbxSunday);
		
		JCheckBox chckbxMonday = new JCheckBox(days[1]);
		checkBoxes[1] = chckbxMonday;
		GridBagConstraints gbc_chckbxMonday = new GridBagConstraints();
		gbc_chckbxMonday.anchor = GridBagConstraints.WEST;
		gbc_chckbxMonday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMonday.gridx = 2;
		gbc_chckbxMonday.gridy = 8;
		//checkboxGroup.add(chckbxMonday);
		mainPanel.add(chckbxMonday, gbc_chckbxMonday);
		
		JCheckBox chckbxTuesday = new JCheckBox(days[2]);
		checkBoxes[2] = chckbxTuesday;
		GridBagConstraints gbc_chckbxTuesday = new GridBagConstraints();
		gbc_chckbxTuesday.anchor = GridBagConstraints.WEST;
		gbc_chckbxTuesday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTuesday.gridx = 3;
		gbc_chckbxTuesday.gridy = 8;
		//checkboxGroup.add(chckbxTuesday);
		mainPanel.add(chckbxTuesday, gbc_chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox(days[3]);
		checkBoxes[3] = chckbxWednesday;
		GridBagConstraints gbc_chckbxWednesday = new GridBagConstraints();
		gbc_chckbxWednesday.anchor = GridBagConstraints.WEST;
		gbc_chckbxWednesday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxWednesday.gridx = 4;
		gbc_chckbxWednesday.gridy = 8;
		//checkboxGroup.add(chckbxWednesday);
		mainPanel.add(chckbxWednesday, gbc_chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox(days[4]);
		checkBoxes[4] = chckbxThursday;
		GridBagConstraints gbc_chckbxThursday = new GridBagConstraints();
		gbc_chckbxThursday.anchor = GridBagConstraints.WEST;
		gbc_chckbxThursday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxThursday.gridx = 1;
		gbc_chckbxThursday.gridy = 9;
		//checkboxGroup.add(chckbxThursday);
		mainPanel.add(chckbxThursday, gbc_chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox(days[5]);
		checkBoxes[5] = chckbxFriday;
		GridBagConstraints gbc_chckbxFriday = new GridBagConstraints();
		gbc_chckbxFriday.anchor = GridBagConstraints.WEST;
		gbc_chckbxFriday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxFriday.gridx = 2;
		gbc_chckbxFriday.gridy = 9;
		//checkboxGroup.add(chckbxFriday);
		mainPanel.add(chckbxFriday, gbc_chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox(days[6]);
		checkBoxes[6] = chckbxSaturday;
		GridBagConstraints gbc_chckbxSaturday = new GridBagConstraints();
		gbc_chckbxSaturday.anchor = GridBagConstraints.WEST;
		gbc_chckbxSaturday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSaturday.gridx = 3;
		gbc_chckbxSaturday.gridy = 9;
		//checkboxGroup.add(chckbxSaturday);
		mainPanel.add(chckbxSaturday, gbc_chckbxSaturday);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new BackButtonListener(frame));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.WEST;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 10;
		mainPanel.add(btnBack, gbc_btnBack);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> selectedRooms = new ArrayList<>();
				if (fromCombo.getSelectedItem() != null && toCombo.getSelectedItem() != null) {
					for (int i = 0; i < 7; i++) {
						if (checkBoxes[i].isSelected()) {
							selectedRooms.add(checkBoxes[i].getText());
						}
					}
					if (selectedRooms.size() > 0) {
						frame.enterAvailability(semesterField.getText(), roomField.getText(),
								fromCombo.getSelectedItem().toString(), toCombo.getSelectedItem().toString(),
								selectedRooms);
					}
				}
			}
		});
		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.anchor = GridBagConstraints.EAST;
		gbc_btnConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirm.gridx = 4;
		gbc_btnConfirm.gridy = 10;
		mainPanel.add(btnConfirm, gbc_btnConfirm);

		setLayout(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);
	}
	
	public static void updateToCombo() {
		
	}
	
	public static void updateFromCombo(String toChoice) {
		
	}
	
	/*
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel mainPanel = new JPanel();
		frame.setBounds(100, 100, 600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EnterAvailability r = new EnterAvailability();
		mainPanel.add(r);
		frame.getContentPane().add(mainPanel);
		frame.repaint();
		frame.revalidate();
	}*/

}
