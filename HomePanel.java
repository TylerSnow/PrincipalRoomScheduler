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

public class HomePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel welcomeLabel = new JLabel("Scheduletron 3000");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(welcomeLabel, BorderLayout.NORTH);
		welcomeLabel.setPreferredSize(new Dimension(20, 50));
		
		JTextArea description = new JTextArea();
		description.setText("Welcome to the school scheduling program.\nTo proceed, press one of the buttons below.");
		add(description, BorderLayout.CENTER);
		
		//#######################################################################################################
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(20, 50));
        buttonPanel.setMaximumSize(new Dimension(100, 600));
		add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new GridLayout(0, 2));
		buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JButton principalButton = new JButton("Enter as Principal");
		//principalButton.setPreferredSize(new Dimension(10, 30));
		int margin = 10;
		principalButton.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));
		JButton applicantButton = new JButton("Enter as Applicant");
		//applicantButton.setPreferredSize(new Dimension(10, 30));
		applicantButton.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));

		
		buttonPanel.add(principalButton);
		buttonPanel.add(applicantButton);
		//#######################################################################################################

	}

}
