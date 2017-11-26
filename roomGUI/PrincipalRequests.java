package roomGUI;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import school.School;

import java.awt.Color;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JButton;

public class PrincipalRequests extends JPanel {

	private final MainFrame2 frame;
	private JPanel mainPanel;
	
	/**
	 * Create the panel.
	 */
	public PrincipalRequests(MainFrame2 f, String semester, String room) {
		frame = f;
		mainPanel = new JPanel();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		DefaultListModel listModel = new DefaultListModel();
		
		JLabel lblPendingRequests = new JLabel("Pending Requests");
		lblPendingRequests.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPendingRequests = new GridBagConstraints();
		gbc_lblPendingRequests.gridwidth = 5;
		gbc_lblPendingRequests.insets = new Insets(0, 0, 5, 5);
		gbc_lblPendingRequests.gridx = 4;
		gbc_lblPendingRequests.gridy = 0;
		add(lblPendingRequests, gbc_lblPendingRequests);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 2;
		gbc_list.gridwidth = 6;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 3;
		gbc_list.gridy = 2;
		add(list, gbc_list);
		
		JButton btnNewButton = new JButton("Back");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 4;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Confirm");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 8;
		gbc_btnNewButton_1.gridy = 4;
		add(btnNewButton_1, gbc_btnNewButton_1);

	}

}
