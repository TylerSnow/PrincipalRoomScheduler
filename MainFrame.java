import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel mainPanel;
	private HomePanel home;
	private TimeRoomGridPane applicant;
	private Calender calender;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		mainPanel = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		home = new HomePanel();
		mainPanel.add(home);
		home.applicantButton.addActionListener(new ApplicantListener());
		add(mainPanel);
	}
	
	private class ApplicantListener extends AbstractAction {
		public ApplicantListener() {
			
		}
		public void actionPerformed(ActionEvent e) {
			home.setVisible(false);
			mainPanel.add(home);
			System.out.println("Doing it");
			calender = new Calender();
			mainPanel.add(calender);
			add(mainPanel);
		}
	}
	
	private class GridListener extends AbstractAction {
		public GridListener() {
			
		}
		public void actionPerformed(ActionEvent e) {
			home.setVisible(false);
			applicant = new TimeRoomGridPane(mainPanel);
			System.out.println("Doing it");
			add(mainPanel);
		}
	}
}
