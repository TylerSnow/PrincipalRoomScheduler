import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class MainFrame2 extends JFrame {
	
	private JPanel mainPanel;
	private HomePanel homePanel;
	private Calender calPanel;
	private TimeRoomGridPanel gridPanel;
	private CardLayout cards = new CardLayout();
	
	public static String HOME_PANEL = "Home Panel";
	public static String CALENDER_PANEL = "Calender Panel";
	public static String GRID_PANEL = "Grid Panel";
	
	/**
	 * Create the frame.
	 */
	public MainFrame2() {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainPanel = new JPanel(cards);
		
		homePanel = new HomePanel(this);
		mainPanel.add(homePanel, HOME_PANEL);
		
		calPanel = new Calender(this);
		mainPanel.add(calPanel, CALENDER_PANEL);
		
		gridPanel = new TimeRoomGridPanel();
		mainPanel.add(gridPanel, GRID_PANEL);

		cards.show(mainPanel, "Home Page");
		add(mainPanel);
		
	}
	
	public void showPanel(String panel) {
		cards.show(mainPanel, panel);
	}
	
	public static void main(String[] args) {
		MainFrame2 frame = new MainFrame2();
	}

}
