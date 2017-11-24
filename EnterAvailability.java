import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Font;

public class EnterAvailability extends JPanel {
	private JTextField roomField;
	private JTextField semesterField;

	/**
	 * Create the panel.
	 */
	public EnterAvailability() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Availability Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblRoom = new JLabel("Room:");
		GridBagConstraints gbc_lblRoom = new GridBagConstraints();
		gbc_lblRoom.anchor = GridBagConstraints.EAST;
		gbc_lblRoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoom.gridx = 1;
		gbc_lblRoom.gridy = 2;
		add(lblRoom, gbc_lblRoom);
		
		roomField = new JTextField();
		roomField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(roomField, gbc_textField);
		roomField.setColumns(10);
		
		JLabel lblSemester = new JLabel("Semester:");
		GridBagConstraints gbc_lblSemester = new GridBagConstraints();
		gbc_lblSemester.anchor = GridBagConstraints.EAST;
		gbc_lblSemester.insets = new Insets(0, 0, 5, 5);
		gbc_lblSemester.gridx = 1;
		gbc_lblSemester.gridy = 3;
		add(lblSemester, gbc_lblSemester);
		
		semesterField = new JTextField();
		semesterField.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		add(semesterField, gbc_textField_1);
		semesterField.setColumns(10);
		
		JLabel lblIsAvailable = new JLabel("Is Available...");
		GridBagConstraints gbc_lblIsAvailable = new GridBagConstraints();
		gbc_lblIsAvailable.anchor = GridBagConstraints.EAST;
		gbc_lblIsAvailable.insets = new Insets(0, 0, 5, 5);
		gbc_lblIsAvailable.gridx = 1;
		gbc_lblIsAvailable.gridy = 4;
		add(lblIsAvailable, gbc_lblIsAvailable);
		
		JLabel lblFrom = new JLabel("From:");
		GridBagConstraints gbc_lblFrom = new GridBagConstraints();
		gbc_lblFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrom.anchor = GridBagConstraints.EAST;
		gbc_lblFrom.gridx = 1;
		gbc_lblFrom.gridy = 5;
		add(lblFrom, gbc_lblFrom);
		
		//ButtonGroup checkboxGroup = new ButtonGroup();
		
		String[] times = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00",
				"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00",
				"20:00", "21:00", "22:00", "23:00", };
				
		JComboBox fromCombo = new JComboBox(times);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 5;
		add(fromCombo, gbc_comboBox);
		
		JLabel lblTo = new JLabel("To:");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.anchor = GridBagConstraints.EAST;
		gbc_lblTo.gridx = 1;
		gbc_lblTo.gridy = 6;
		add(lblTo, gbc_lblTo);
		
		JComboBox toCombo = new JComboBox(times);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 6;
		add(toCombo, gbc_comboBox_1);
		
		JLabel lblOnDays = new JLabel("On Days:");
		GridBagConstraints gbc_lblOnDays = new GridBagConstraints();
		gbc_lblOnDays.anchor = GridBagConstraints.EAST;
		gbc_lblOnDays.insets = new Insets(0, 0, 5, 5);
		gbc_lblOnDays.gridx = 1;
		gbc_lblOnDays.gridy = 7;
		add(lblOnDays, gbc_lblOnDays);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		GridBagConstraints gbc_chckbxSunday = new GridBagConstraints();
		gbc_chckbxSunday.anchor = GridBagConstraints.WEST;
		gbc_chckbxSunday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSunday.gridx = 1;
		gbc_chckbxSunday.gridy = 8;
		//checkboxGroup.add(chckbxSunday);
		add(chckbxSunday, gbc_chckbxSunday);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		GridBagConstraints gbc_chckbxMonday = new GridBagConstraints();
		gbc_chckbxMonday.anchor = GridBagConstraints.WEST;
		gbc_chckbxMonday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMonday.gridx = 2;
		gbc_chckbxMonday.gridy = 8;
		//checkboxGroup.add(chckbxMonday);
		add(chckbxMonday, gbc_chckbxMonday);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		GridBagConstraints gbc_chckbxTuesday = new GridBagConstraints();
		gbc_chckbxTuesday.anchor = GridBagConstraints.WEST;
		gbc_chckbxTuesday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTuesday.gridx = 3;
		gbc_chckbxTuesday.gridy = 8;
		//checkboxGroup.add(chckbxTuesday);
		add(chckbxTuesday, gbc_chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		GridBagConstraints gbc_chckbxWednesday = new GridBagConstraints();
		gbc_chckbxWednesday.anchor = GridBagConstraints.WEST;
		gbc_chckbxWednesday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxWednesday.gridx = 4;
		gbc_chckbxWednesday.gridy = 8;
		//checkboxGroup.add(chckbxWednesday);
		add(chckbxWednesday, gbc_chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		GridBagConstraints gbc_chckbxThursday = new GridBagConstraints();
		gbc_chckbxThursday.anchor = GridBagConstraints.WEST;
		gbc_chckbxThursday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxThursday.gridx = 1;
		gbc_chckbxThursday.gridy = 9;
		//checkboxGroup.add(chckbxThursday);
		add(chckbxThursday, gbc_chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		GridBagConstraints gbc_chckbxFriday = new GridBagConstraints();
		gbc_chckbxFriday.anchor = GridBagConstraints.WEST;
		gbc_chckbxFriday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxFriday.gridx = 2;
		gbc_chckbxFriday.gridy = 9;
		//checkboxGroup.add(chckbxFriday);
		add(chckbxFriday, gbc_chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		GridBagConstraints gbc_chckbxSaturday = new GridBagConstraints();
		gbc_chckbxSaturday.anchor = GridBagConstraints.WEST;
		gbc_chckbxSaturday.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSaturday.gridx = 3;
		gbc_chckbxSaturday.gridy = 9;
		//checkboxGroup.add(chckbxSaturday);
		add(chckbxSaturday, gbc_chckbxSaturday);
		
		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.WEST;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 10;
		add(btnBack, gbc_btnBack);
		
		JButton btnConfirm = new JButton("Confirm");
		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.anchor = GridBagConstraints.EAST;
		gbc_btnConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirm.gridx = 4;
		gbc_btnConfirm.gridy = 10;
		add(btnConfirm, gbc_btnConfirm);

	}
	
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
	}

}
