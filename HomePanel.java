import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HomePanel extends JPanel {
	private final MainFrame2 frame;
	
	/**
	 * Create the panel.
	 */
	public HomePanel(MainFrame2 frame) {
		
		this.frame = frame;
		setLayout(new BorderLayout(0, 0));	
		
		//Welcome
		JPanel welcomePanel = new JPanel();
		//welcomePanel.setPreferredSize(new Dimension(20, 50));
		JLabel welcomeLabel = new JLabel("Scheduletron 3000");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		welcomePanel.add(welcomeLabel);
		add(welcomePanel, BorderLayout.NORTH);
		
		
		//Description
		JPanel descriptionPanel = new JPanel();
		JTextArea description = new JTextArea();
		description.setEditable(false);
		description.setText("Welcome to the school scheduling program.\n" +
				"To proceed, press one of the buttons below.");
		descriptionPanel.add(description);
		add(descriptionPanel, BorderLayout.CENTER);
		
		int margin = 10;
		JPanel holder = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_buttonPanel.rowHeights = new int[]{0};
		gbl_buttonPanel.columnWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_buttonPanel.rowWeights = new double[]{Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JButton princButton = new JButton("Enter As Principal");
		princButton.addActionListener(new NextButtonListener(frame));
		GridBagConstraints gbc_btnEnterAsPrincipal = new GridBagConstraints();
		gbc_btnEnterAsPrincipal.gridheight = 2;
		gbc_btnEnterAsPrincipal.insets = new Insets(0, 0, 0, 5);
		gbc_btnEnterAsPrincipal.gridx = 1;
		gbc_btnEnterAsPrincipal.gridy = 0;
		buttonPanel.add(princButton, gbc_btnEnterAsPrincipal);
		
		JButton btnNewButton = new JButton("Enter as Applicant");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 1;
		buttonPanel.add(btnNewButton, gbc_btnNewButton);
		holder.add(buttonPanel);
		add(holder, BorderLayout.SOUTH);


	}
}
