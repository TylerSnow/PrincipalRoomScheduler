package roomGUI;
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
import javax.swing.JTabbedPane;

public class MakeRequestPanel extends JPanel {
	private MainFrame2 frame;
	private JPanel mainPanel;
	private JTextField roomField;
	private JTextField semesterField;
	private JComboBox[] combos = new JComboBox[5];
	
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
	public MakeRequestPanel(MainFrame2 f, String semester, String room, String day) {
		frame = f;
		mainPanel = new JPanel();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Reservation For");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		mainPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblRoom = new JLabel("Room:");
		GridBagConstraints gbc_lblRoom = new GridBagConstraints();
		gbc_lblRoom.anchor = GridBagConstraints.EAST;
		gbc_lblRoom.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoom.gridx = 1;
		gbc_lblRoom.gridy = 1;
		mainPanel.add(lblRoom, gbc_lblRoom);
		
		roomField = new JTextField();
		roomField.setText(room);
		roomField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		mainPanel.add(roomField, gbc_textField);
		roomField.setColumns(10);
		
		JLabel lblSemester = new JLabel("Semester:");
		GridBagConstraints gbc_lblSemester = new GridBagConstraints();
		gbc_lblSemester.anchor = GridBagConstraints.EAST;
		gbc_lblSemester.insets = new Insets(0, 0, 5, 5);
		gbc_lblSemester.gridx = 1;
		gbc_lblSemester.gridy = 2;
		mainPanel.add(lblSemester, gbc_lblSemester);
		
		semesterField = new JTextField();
		semesterField.setText(semester);
		semesterField.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		mainPanel.add(semesterField, gbc_textField_1);
		semesterField.setColumns(10);
				
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.availBack();
			}
		});
		
		//Tabbed Pane ###########################################################
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridwidth = 5;
		gbc_tabbedPane.gridheight = 5;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 1;
		gbc_tabbedPane.gridy = 4;
		mainPanel.add(tabbedPane, gbc_tabbedPane);
		
		//#########################################################################
		
		//Booking panel 1 ###########################################################
		
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("Booking #1", null, panel1, null);
		
		JComboBox toCombo1 = new JComboBox(toTimes);
		toCombo1.setSelectedItem("01:00");
		panel1.add(toCombo1);
		
		JComboBox fromCombo1 = new JComboBox(fromTimes);
		fromCombo1.setSelectedItem("00:00");
		panel1.add(fromCombo1);

		toCombo1.addActionListener (new FromComboListener(fromCombo1, toCombo1));
		fromCombo1.addActionListener (new FromComboListener(fromCombo1, toCombo1));
		
		
		//##############################################################################
		
		//Booking panel 2 ###########################################################
		
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("Booking #2", null, panel2, null);
		
		JComboBox toCombo2 = new JComboBox(toTimes);
		toCombo2.setSelectedItem("01:00");
		panel2.add(toCombo2);
		
		JComboBox fromCombo2 = new JComboBox(fromTimes);
		fromCombo2.setSelectedItem("00:00");
		panel2.add(fromCombo2);

		toCombo2.addActionListener (new FromComboListener(fromCombo2, toCombo2));
		fromCombo2.addActionListener (new FromComboListener(fromCombo2, toCombo2));
		
		//#########################################################################
		
		//Booking panel 3 ###########################################################
		
		JPanel panel3 = new JPanel();
		tabbedPane.addTab("Booking #3", null, panel3, null);
		
		JComboBox toCombo3 = new JComboBox(toTimes);
		toCombo3.setSelectedItem("01:00");
		panel3.add(toCombo3);
		
		JComboBox fromCombo3 = new JComboBox(fromTimes);
		fromCombo3.setSelectedItem("00:00");
		panel3.add(fromCombo3);

		toCombo3.addActionListener (new FromComboListener(fromCombo3, toCombo3));
		fromCombo3.addActionListener (new FromComboListener(fromCombo3, toCombo3));
		
		//#########################################################################
		
		//Booking panel 4 ###########################################################
		
		JPanel panel4 = new JPanel();
		tabbedPane.addTab("Booking #4", null, panel4, null);
		
		JComboBox toCombo4 = new JComboBox(toTimes);
		toCombo4.setSelectedItem("01:00");
		panel4.add(toCombo4);
		
		JComboBox fromCombo4 = new JComboBox(fromTimes);
		fromCombo4.setSelectedItem("00:00");
		panel4.add(fromCombo4);

		toCombo4.addActionListener (new FromComboListener(fromCombo4, toCombo4));
		fromCombo4.addActionListener (new FromComboListener(fromCombo4, toCombo4));
		
		//#########################################################################
		
		//Booking panel 5 ###########################################################
		
		JPanel panel5 = new JPanel();
		tabbedPane.addTab("Booking #5", null, panel5, null);
		
		JComboBox toCombo5 = new JComboBox(toTimes);
		toCombo5.setSelectedItem("01:00");
		panel5.add(toCombo5);
		
		JComboBox fromCombo5 = new JComboBox(fromTimes);
		fromCombo5.setSelectedItem("00:00");
		panel5.add(fromCombo5);

		toCombo5.addActionListener (new FromComboListener(fromCombo5, toCombo5));
		fromCombo5.addActionListener (new FromComboListener(fromCombo5, toCombo5));
		
		//#########################################################################
				
		
		
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.WEST;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 10;
		mainPanel.add(btnBack, gbc_btnBack);
		
		JButton btnConfirm = new JButton("Confirm");
		
		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.anchor = GridBagConstraints.EAST;
		gbc_btnConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirm.gridx = 4;
		gbc_btnConfirm.gridy = 10;
		mainPanel.add(btnConfirm, gbc_btnConfirm);
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> selectedRooms = new ArrayList<>();
				if (fromCombo.getSelectedItem() != null && toCombo.getSelectedItem() != null) {					
					if (selectedRooms.size() > 0) {
						frame.enterAvailability(semesterField.getText(), roomField.getText(),
								fromCombo.getSelectedItem().toString(), toCombo.getSelectedItem().toString(),
								selectedRooms);
					}
				}
			}
		});
		add(mainPanel);
	}
	
	class FromComboListener implements ActionListener{
		private JComboBox fromCombo;
		private JComboBox toCombo;
		
		public FromComboListener(JComboBox from, JComboBox to) {
			
		}
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
	}
	class ToComboListener implements ActionListener{
		private JComboBox fromCombo;
		private JComboBox toCombo;
		
		public ToComboListener(JComboBox from, JComboBox to) {
			
		}
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
	}

}
