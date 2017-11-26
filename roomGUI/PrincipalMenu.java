package roomGUI;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class PrincipalMenu extends JPanel {
	
	private final MainFrame2 frame;
	private JPanel mainPanel;
	
	/**
	 * Create the panel.
	 */
	public PrincipalMenu(MainFrame2 f) {
		frame = f;
		mainPanel = new JPanel();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 3;
		gbc_lblWelcome.gridy = 2;
		mainPanel.add(lblWelcome, gbc_lblWelcome);
		
		JButton btnViewRequests = new JButton("View Requests");
		btnViewRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.goPrincRequests();
			}
		});
		GridBagConstraints gbc_btnViewRequests = new GridBagConstraints();
		gbc_btnViewRequests.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewRequests.gridx = 3;
		gbc_btnViewRequests.gridy = 4;
		mainPanel.add(btnViewRequests, gbc_btnViewRequests);

		add(mainPanel);
		
		JButton btnEnterAvailability = new JButton("Enter Availability");
		btnEnterAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.goPrincAvail();
			}
		});
		GridBagConstraints gbc_btnEnterAvailability = new GridBagConstraints();
		gbc_btnEnterAvailability.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnterAvailability.gridx = 3;
		gbc_btnEnterAvailability.gridy = 5;
		mainPanel.add(btnEnterAvailability, gbc_btnEnterAvailability);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new BackButtonListener(frame));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 3;
		gbc_btnBack.gridy = 6;
		mainPanel.add(btnBack, gbc_btnBack);
	}

}
