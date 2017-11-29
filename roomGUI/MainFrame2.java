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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MainFrame2 extends JFrame {
	
	private JPanel princCardPanel;
	private JPanel homePanel;
	private JPanel mainCardPanel;
	//private JPanel princAvailCardPanel;
	//private JPanel princRequestCardPanel;
	private PrincipalLogin loginPanel;
	private PrincipalMenu principalMenu;
	private RoomAndSemester princRoomPanel;
	private EnterAvailability princAvailPanel;
	private PrincipalRequests princReqPanel;
	private ViewRequest princViewReqPanel;
	private ConfirmEnterAvail princConfirmPanel;
	private CardLayout princCards = new CardLayout();
	private CardLayout princAvailCards = new CardLayout();
	private CardLayout princRequestCards = new CardLayout();
	private CardLayout mainCards= new CardLayout();
	
	private JPanel appCardPanel;
	private CardLayout appCards = new CardLayout();
	private ApplicantInfo appPanel;	
	private RequestPanel reqPanel;
	private RequestPanelTSP reqPanelTSP;
	private RequestStored reqStored;
	
	/**
	 * Create the frame.
	 */
	public MainFrame2() {
		School school = new School("bish");
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		princCardPanel = new JPanel(princCards);
		//princAvailCardPanel = new JPanel(princAvailCards);
		//princRequestCardPanel = new JPanel(princRequestCards);
		
		reqStored= new RequestStored();
		
		homePanel = new HomePanel(this);
		
		loginPanel = new PrincipalLogin(this);
		princCardPanel.add(loginPanel, "Login Panel");
		
		principalMenu = new PrincipalMenu(this);
		princCardPanel.add(principalMenu, "Principal Menu");

		appCardPanel= new JPanel(appCards);
		appPanel = new ApplicantInfo(this);
		reqPanel=new RequestPanel(this);
		reqPanelTSP=new RequestPanelTSP(this);
		appCardPanel.add(appPanel,"Applicant Panel");
		appCardPanel.add(reqPanel,"Request Panel Name");
		appCardPanel.add(reqPanelTSP,"Request Panel Timeslot");
		
		//Main Card layout that contains homepanel,appcardpanel,princcardpanel
		mainCardPanel=new JPanel(mainCards);
		mainCardPanel.add(homePanel,"HomePanel");
		mainCardPanel.add(princCardPanel,"Principal Card");
		mainCardPanel.add(appCardPanel,"Applicant Card");
		princCards.show(princCardPanel, "Login Panel");
		//princCardPanel.add(new RequestPanel(this), "Test page");
		//princCards.show(princCardPanel, "Test page");
		//add(appCardPanel);
		//add(princCardPanel);
		//add(homePanel);
		add(mainCardPanel);
		repaint();
		revalidate();
	}
	

	//Displays Card Panels
	public void displayPrinc(){
		princCardPanel.setVisible(true);
	}
	public void displayApp(){
		appCardPanel.setVisible(true);
	}
	public void displayHome(){
		homePanel.setVisible(false);
	}

	public void hidePrinc(){
		princCardPanel.setVisible(false);
	}
	public void hideApp(){
		appCardPanel.setVisible(false);
	}
	public void hideHome(){
		homePanel.setVisible(false);
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
	public void appShow(){
		appCards.show(appCardPanel,"Applicant Panel");
	}
	public void reqShow(){
		appCards.show(appCardPanel,"Request Panel Name");
	}
	public void reqTSPShow(){
		appCards.show(appCardPanel,"Request Panel Timeslot");
	}
	public void setAppInfoStored(String n, String g, String m){
		reqStored.setAppName(n);
		reqStored.setAppGroup(g);
		reqStored.setMessage(m);
	}
	public void setReqPanelStored(String r, String s){
		reqStored.setRoom(r);
		reqStored.setSem(s);
	}
	public void setReqPanelTSPStored(String st, String et, String d, String p){	
		reqStored.setStartTime(st);
		reqStored.setEndTime(et);
		reqStored.setDay(d);
		reqStored.setPriority(p);
	}
	public String[] getStoredInfo(){
		String[] arr= { reqStored.getAppName(),reqStored.getAppGroup(),reqStored.getMessage(),reqStored.getRoom(),reqStored.getSem(),reqStored.getStartTime(),reqStored.getEndTime(),reqStored.getDay(),reqStored.getPriority() };
		return arr;
	}
	public void generateRequest(String [] n) {
		String appName=n[0];
		String appGroup=n[1];
		String room=n[3];
		String sem=n[4];
		String startTime=n[5];
		String endTime =n[6];
		String day= n[7];
		String priority= n[8];
		String message=n[2];
		String numSlots="1";
		
		school.Request.generateRequest(appName, appGroup, room, sem, numSlots, startTime, endTime, day, priority, message);
		System.out.println(school.School.getPendingRequests());
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
		
		School.addRoomAvailability(room, LocalTime.parse(start), LocalTime.parse(end), days, semester);
		
		princConfirmPanel = new ConfirmEnterAvail(this);
		princCardPanel.add(princConfirmPanel, "Principal Confirm Panel");
		princCards.show(princCardPanel, "Principal Confirm Panel");
	}
	
	public void viewRequest(Request r) {
		princViewReqPanel = new ViewRequest(this, r);
		princCardPanel.add(princViewReqPanel, "Principal View Request Panel");
		princCards.show(princCardPanel, "Principal View Request Panel");
	}
	
	public static void main(String[] args) {
		MainFrame2 frame = new MainFrame2();
	}

}
