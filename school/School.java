package school;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class School {
	private List<Room> roomList;
	private String id;
	private static List<Request> pendingRequests;
	private static List<Account> authorizedAccounts;
	private List<Group> groupList;
	
	public School(List<Room> nRoomList, String nId, List<Request> nPendingRequests, List<Account> nAuthorizedAccounts, List<Group> nGroupList) {
		roomList = nRoomList;
		id = nId;
		pendingRequests = nPendingRequests;
		authorizedAccounts = nAuthorizedAccounts;
		groupList = nGroupList;
		authorizedAccounts.add(makeAdmin());
		createSampleRequests();
	}
	
	public String getId() {
		return id;
	}
	
	public List<Room> getRoomList(){
		return roomList;
	}
	
	public static List<Request> getPendingRequests(){
		return pendingRequests;
	}
	
	public static List<Account> getAuthorizedAccounts(){
		return authorizedAccounts;
	}
	
	public List<Group> getGroupList(){
		return groupList;
	}
	
	public void addRoom(Room newRoom) {
		roomList.add(newRoom);
	}
	
	public Account makeAdmin() {
		Account admin = new Account("admin", "admin");
		return admin;
	}
	
	public static void createSampleRequests() {
		Group MathClub = new Group("Math Club");
		pendingRequests.add(new Request(new Applicant("Steve", MathClub), new Room("Gymnasium", 2),
				new Booking(LocalTime.parse("02:00"), LocalTime.parse("02:00"), Semester.FALL, DayOfWeek.MONDAY, MathClub), 
				1, "Math Competition", LocalDate.now()));
		Group HockeyTeam = new Group("Hockey Team");
		pendingRequests.add(new Request(new Applicant("Bob", HockeyTeam), new Room("ChemLab", 1),
				new Booking(LocalTime.parse("03:00"), LocalTime.parse("03:00"), Semester.FALL, DayOfWeek.TUESDAY, HockeyTeam),
				2, "Practice", LocalDate.now()));
		Group ChessClub = new Group("Chess Club");
		pendingRequests.add(new Request(new Applicant("Jim", ChessClub), new Room("Library", 3),
				new Booking(LocalTime.parse("04:00"), LocalTime.parse("04:00"), Semester.FALL, DayOfWeek.THURSDAY, ChessClub),
				3, "Tournament", LocalDate.now()));
	}
}
