package school;
import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class School {
	private static List<Room> roomList = new ArrayList<Room>();
	private static String id;
	private static List<Request> pendingRequests = new ArrayList<Request>();
	private static List<Account> authorizedAccounts = new ArrayList<Account>();
	private static List<Group> groupList = new ArrayList<Group>();
	
	public School(String nId) {
		id = nId;
		authorizedAccounts.add(makeAdmin());
		createSampleRequests();
	}
	
	public static String getId() {
		return id;
	}
	
	public static List<Room> getRoomList(){
		return roomList;
	}
	
	public static List<Request> getPendingRequests(){
		return pendingRequests;
	}
	
	public static List<Account> getAuthorizedAccounts(){
		return authorizedAccounts;
	}
	
	public static List<Group> getGroupList(){
		return groupList;
	}
	
	public static void addRoom(Room newRoom) {
		roomList.add(newRoom);
	}
	
	public static Account makeAdmin() {
		Account admin = new Account("admin", "admin");
		return admin;
	}
	
	public static void AddPendingRequest(Request r) {
		School.pendingRequests.add(r);
	}
	
	public static void AddAuthorizedUser(Account a) {
		School.authorizedAccounts.add(a);
	}
	
	public static void AddGroup(Group g) {
		School.groupList.add(g);
	}
	
	public static void addRoomAvailability(String roomName, LocalTime startTime, LocalTime endTime, List<String> dayOfWeek, String s) {
		Semester sem = Semester.toSem(s);
		int[] timeArray = new int[endTime.getHour()-startTime.getHour()];
		for (int a = 0 ; a < timeArray.length ; a++) {
			timeArray[a] = a + startTime.getHour();
		}
		for (String day : dayOfWeek) {
			DayOfWeek d = null;
			switch (day) {
				case "Monday" : d = DayOfWeek.MONDAY;
				case "Tuesday" : d = DayOfWeek.TUESDAY;
				case "Wednesday" : d = DayOfWeek.WEDNESDAY;
				case "Thursday" : d = DayOfWeek.THURSDAY;
				case "Friday" : d = DayOfWeek.FRIDAY;
				case "Saturday" : d = DayOfWeek.SATURDAY;
				case "Sunday" : d = DayOfWeek.SUNDAY;
			}
			for (Room r : School.getRoomList()) {
				if (r.getName() == roomName) {
					r.addAvailability(d, timeArray, sem);
				}
			}
		}
	}
	
	@SuppressWarnings("unused")
	public static void createSampleRequests() {
		Group MathClub = new Group("Math Club");
		Group ChessClub = new Group("Chess Club");
		Group HockeyTeam = new Group("Hockey Team");
		Group SkatingTeam = new Group("Skating Team");
		Booking[] mb1 = {
				new Booking(LocalTime.parse("01:00"),LocalTime.parse("02:00"),Semester.FALL, DayOfWeek.MONDAY, MathClub),
				new Booking(LocalTime.parse("02:00"),LocalTime.parse("03:00"),Semester.FALL, DayOfWeek.MONDAY, MathClub),
				new Booking(LocalTime.parse("03:00"),LocalTime.parse("04:00"),Semester.FALL, DayOfWeek.MONDAY, MathClub),
				new Booking(LocalTime.parse("04:00"),LocalTime.parse("05:00"),Semester.FALL, DayOfWeek.MONDAY, MathClub),
				new Booking(LocalTime.parse("05:00"),LocalTime.parse("06:00"),Semester.FALL, DayOfWeek.MONDAY, MathClub),
				};
		Booking[] cb1 = {
				new Booking(LocalTime.parse("01:00"),LocalTime.parse("02:00"),Semester.FALL, DayOfWeek.FRIDAY, ChessClub),
				new Booking(LocalTime.parse("02:00"),LocalTime.parse("03:00"),Semester.FALL, DayOfWeek.FRIDAY, ChessClub),
				new Booking(LocalTime.parse("03:00"),LocalTime.parse("04:00"),Semester.FALL, DayOfWeek.FRIDAY, ChessClub),
				new Booking(LocalTime.parse("04:00"),LocalTime.parse("05:00"),Semester.FALL, DayOfWeek.FRIDAY, ChessClub),
				new Booking(LocalTime.parse("05:00"),LocalTime.parse("06:00"),Semester.FALL, DayOfWeek.FRIDAY, ChessClub),
				};
		Booking[] hb1 = {
				new Booking(LocalTime.parse("01:00"),LocalTime.parse("02:00"),Semester.FALL, DayOfWeek.TUESDAY, HockeyTeam),
				new Booking(LocalTime.parse("02:00"),LocalTime.parse("03:00"),Semester.FALL, DayOfWeek.TUESDAY, HockeyTeam),
				new Booking(LocalTime.parse("03:00"),LocalTime.parse("04:00"),Semester.FALL, DayOfWeek.TUESDAY, HockeyTeam),
				new Booking(LocalTime.parse("04:00"),LocalTime.parse("05:00"),Semester.FALL, DayOfWeek.TUESDAY, HockeyTeam),
				new Booking(LocalTime.parse("05:00"),LocalTime.parse("06:00"),Semester.FALL, DayOfWeek.TUESDAY, HockeyTeam),
				};
		Booking[] sb1 = {
				new Booking(LocalTime.parse("01:00"),LocalTime.parse("02:00"),Semester.WINTER, DayOfWeek.TUESDAY, SkatingTeam),
				new Booking(LocalTime.parse("04:00"),LocalTime.parse("05:00"),Semester.WINTER, DayOfWeek.THURSDAY, SkatingTeam),
				new Booking(LocalTime.parse("12:00"),LocalTime.parse("13:00"),Semester.WINTER, DayOfWeek.SUNDAY, SkatingTeam),
				new Booking(LocalTime.parse("08:00"),LocalTime.parse("09:00"),Semester.WINTER, DayOfWeek.SATURDAY, SkatingTeam),
				new Booking(LocalTime.parse("05:00"),LocalTime.parse("09:00"),Semester.WINTER, DayOfWeek.MONDAY, SkatingTeam),
				};
		Request samReq1 = new Request(new Applicant("Joe", SkatingTeam), 3, Semester.WINTER, new Room("Auditorium", 4), sb1, "Skating Praccy");
		Request samReq2 = new Request(new Applicant("Jen", MathClub), 1, Semester.FALL, new Room("Chemistry Lab", 1), mb1, "Math Club Tournament");
		Request samReq3 = new Request(new Applicant("Bob", ChessClub), 2, Semester.FALL, new Room("Physics Lab", 2), cb1, "Chess Meeting");
		Request samReq4 = new Request(new Applicant("Steve", HockeyTeam), 1, Semester.FALL, new Room("Gymnasium", 3), hb1, "Hockey Practice");
	}
}
