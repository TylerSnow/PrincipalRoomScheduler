import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;

public class MainFrame2 extends JFrame {
	
	private JPanel princCardPanel;
	private HomePanel homePanel;
	private PrincipalLogin loginPanel;
	private RoomAndSemester princRoomPanel;
	private EnterAvailability princAvailPanel;
	private ConfirmEnterAvail princConfirmPanel;
	private CardLayout cards = new CardLayout();
	
	public static String HOME_PANEL = "Home Panel";
	public static String LOGIN_PANEL = "Login Panel";
	public static String PRINCIPAL_ROOM_PANEL = "Principal Room Panel";
	public static String PRINCIPAL_AVAIL_PANEL = "Principal Avail Panel";
	public static String PRINCIPAL_CONFIRM_PANEL = "Principal Confirm Panel";


	private String prevPanel;
	
	/**
	 * Create the frame.
	 */
	public MainFrame2() {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		princCardPanel = new JPanel(cards);
		
		homePanel = new HomePanel(this);
		princCardPanel.add(homePanel, HOME_PANEL);
		
		loginPanel = new PrincipalLogin(this);
		princCardPanel.add(loginPanel, LOGIN_PANEL);
		
		princRoomPanel = new RoomAndSemester(this);
		princCardPanel.add(princRoomPanel, PRINCIPAL_ROOM_PANEL);

		cards.show(princCardPanel, "Home Page");
		add(princCardPanel);
		repaint();
		revalidate();
	}
	
	public void next() {
		cards.next(princCardPanel);
	}
	
	//just use cards.previous()
	public void back() {
		cards.previous(princCardPanel);
	}
	
	public void showAvailabilityPanel(String semester, String room) {
		princAvailPanel = new EnterAvailability(this, semester, room);
		princCardPanel.add(princAvailPanel, PRINCIPAL_AVAIL_PANEL);
		cards.show(princCardPanel, PRINCIPAL_AVAIL_PANEL);
	}
	
	public void enterAvailability(String semester, String room, String start, String end, ArrayList<String> days) {
		princConfirmPanel = new ConfirmEnterAvail();
		princCardPanel.add(princConfirmPanel, PRINCIPAL_CONFIRM_PANEL);
		cards.show(princCardPanel, PRINCIPAL_CONFIRM_PANEL);
	}
	
	public void availBack() {
		cards.show(princCardPanel, PRINCIPAL_ROOM_PANEL);
	}
	
	public static void main(String[] args) {
		MainFrame2 frame = new MainFrame2();
	}

}
