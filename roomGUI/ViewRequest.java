package roomGUI;

import javax.swing.JPanel;

import school.Request;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class ViewRequest extends JPanel {

	private final MainFrame2 frame;
	private Request request;
	private JTextField roomField;
	private JTextField semesterField;
	/**
	 * Create the panel.
	 */
	public ViewRequest(MainFrame2 f, Request r) {
		frame = f;
		request = r;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Room:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		roomField = new JTextField();
		roomField.setEditable(false);
		GridBagConstraints gbc_roomField = new GridBagConstraints();
		gbc_roomField.insets = new Insets(0, 0, 5, 5);
		gbc_roomField.fill = GridBagConstraints.HORIZONTAL;
		gbc_roomField.gridx = 4;
		gbc_roomField.gridy = 2;
		add(roomField, gbc_roomField);
		roomField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Semester:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		semesterField = new JTextField();
		semesterField.setEditable(false);
		GridBagConstraints gbc_semesterField = new GridBagConstraints();
		gbc_semesterField.insets = new Insets(0, 0, 5, 5);
		gbc_semesterField.fill = GridBagConstraints.HORIZONTAL;
		gbc_semesterField.gridx = 4;
		gbc_semesterField.gridy = 3;
		add(semesterField, gbc_semesterField);
		semesterField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Group:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblDesired = new JLabel("Desired #:");
		GridBagConstraints gbc_lblDesired = new GridBagConstraints();
		gbc_lblDesired.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesired.gridx = 3;
		gbc_lblDesired.gridy = 5;
		add(lblDesired, gbc_lblDesired);
		
		JLabel lblMessage = new JLabel("Message:");
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.insets = new Insets(0, 0, 0, 5);
		gbc_lblMessage.gridx = 3;
		gbc_lblMessage.gridy = 6;
		add(lblMessage, gbc_lblMessage);

	}

}
