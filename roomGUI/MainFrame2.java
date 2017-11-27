package roomGUI;
import javax.swing.JFrame;
import javax.swing.JPanel;

import school.Room;
import school.School;
import school.Request;
import school.Account;
import school.Group;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

public class MainFrame2 extends JFrame {
	
	private JPanel princCardPanel;
	//private JPanel princAvailCardPanel;
	//private JPanel princRequestCardPanel;
	private HomePanel homePanel;
	private PrincipalLogin loginPanel;
	private PrincipalMenu principalMenu;
	private RoomAndSemester princRoomPanel;
	private EnterAvailability princAvailPanel;
	private PrincipalRequests princReqPanel;
	private ConfirmEnterAvail princConfirmPanel;
	private CardLayout princCards = new CardLayout();
	private CardLayout princAvailCards = new CardLayout();
	private CardLayout princRequestCards = new CardLayout();
	
	/**
	 * Create the frame.
	 */
	public MainFrame2() {
		School school = new School(new ArrayList<Room>(), "bish", new ArrayList<Request>(),
				new ArrayList<Account>(), new ArrayList<Group>());
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		princCardPanel = new JPanel(princCards);
		//princAvailCardPanel = new JPanel(princAvailCards);
		//princRequestCardPanel = new JPanel(princRequestCards);
		
		homePanel = new HomePanel(this);
		princCardPanel.add(homePanel, "Home Panel");
		
		loginPanel = new PrincipalLogin(this);
		princCardPanel.add(loginPanel, "Login Panel");
		
		principalMenu = new PrincipalMenu(this);
		princCardPanel.add(principalMenu, "Principal Menu");

		princCards.show(princCardPanel, "Home Page");
		//princCardPanel.add(new RequestPanel(this), "Test page");
		//princCards.show(princCardPanel, "Test page");
		add(princCardPanel);
		repaint();
		revalidate();
	}
	
	public void next() {
		princCards.next(princCardPanel);
	}
	
	//just use cards.previous()
	public void back() {
		princCards.previous(princCardPanel);
	}
	
	public void goPrincAvail() {
		princRoomPanel = new RoomAndSemester(this, true);
		princCardPanel.add(princRoomPanel, "Principal Room Panel");
		princCards.show(princCardPanel, "Principal Room Panel");
	}
	
	public void goPrincRequests() {
		princRoomPanel = new RoomAndSemester(this, false);
		princCardPanel.add(princRoomPanel, "Principal Room Panel");
		princCards.show(princCardPanel, "Principal Room Panel");
	}
	
	public void availBack() {
		princCards.show(princCardPanel, "Principal Room Panel");
	}
	
	public void home() {
		princCards.show(princCardPanel, "Home Panel");
		loginPanel.reset();
	}
	
	public void princAgain() {
		princCards.show(princCardPanel, "Principal Room Panel");
	}
	
	public void princMenu() {
		princCards.show(princCardPanel, "Principal Menu");
	}
	
	public void showAvailabilityPanel(String semester, String room) {
		princAvailPanel = new EnterAvailability(this, semester, room);
		princCardPanel.add(princAvailPanel, "Principal Availability Panel");
		princCards.show(princCardPanel, "Principal Availability Panel");
	}
	
	public void showRequestPanel(String semester, String room) {
		princReqPanel = new PrincipalRequests(this, semester, room);
		princCardPanel.add(princReqPanel, "Principal Request Panel");
		princCards.show(princCardPanel, "Principal Request Panel");
	}
	
	public void enterAvailability(String semester, String room, String start, String end, ArrayList<String> days) {
		System.out.print("Reservation made for:\n"
				+ "Room: " + room + "\n"
				+ "Semester: " + semester + "\n"
				+ "From: " + start + "\n"
				+ "To: " + end + "\n"
				+ "On days: ");
		for (String day : days) {
			System.out.print(day + ", ");
		}
		System.out.println("");
		
		princConfirmPanel = new ConfirmEnterAvail(this);
		princCardPanel.add(princConfirmPanel, "Principal Confirm Panel");
		princCards.show(princCardPanel, "Principal Confirm Panel");
	}
	
	public static void main(String[] args) {
		MainFrame2 frame = new MainFrame2();
	}

}
