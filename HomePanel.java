import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HomePanel extends JPanel {

	private JButton applicantButton;
	private JButton principalButton;
	private MainFrame2 frame;
	
	/**
	 * Create the panel.
	 */
	public HomePanel(MainFrame2 frame) {
		
		this.frame = frame;
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
		description.setEditable(false);
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
		
		int margin = 10;
		principalButton = new JButton("Enter as Principal");
		principalButton.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));
		
		applicantButton = new JButton("Enter as Applicant");
		applicantButton.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));
		applicantButton.addActionListener(new ApplicantListener());
		
		buttonPanel.add(principalButton);
		buttonPanel.add(applicantButton);
		
		

	}
	
	private class ApplicantListener extends AbstractAction {
		public ApplicantListener() {
			
		}
		public void actionPerformed(ActionEvent e) {
			frame.showPanel(MainFrame2.CALENDER_PANEL, MainFrame2.HOME_PANEL);
		}
	}
}
