import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HomePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePanel() {
		setLayout(new BorderLayout(0, 0));
		
		//Welcome
		JPanel welcomePanel = new JPanel();
		welcomePanel.setPreferredSize(new Dimension(20, 50));
		JLabel welcomeLabel = new JLabel("Scheduletron 3000");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		welcomePanel.add(welcomeLabel);
		add(welcomePanel, BorderLayout.NORTH);
		
		//Description
		JPanel descriptionPanel = new JPanel();
		JTextArea description = new JTextArea();
		description.setText("Welcome to the school scheduling program.\n" +
				"To proceed, press one of the buttons below.");
		descriptionPanel.add(description);
		add(descriptionPanel, BorderLayout.CENTER);
		
		//Buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(20, 50));
		add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new GridLayout(0, 2));
		buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JButton principalButton = new JButton("Enter as Principal");
		int margin = 10;
		principalButton.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));
		JButton applicantButton = new JButton("Enter as Applicant");
		applicantButton.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));
		
		buttonPanel.add(principalButton);
		buttonPanel.add(applicantButton);
		

	}

}
