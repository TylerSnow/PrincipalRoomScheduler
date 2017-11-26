package school;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class School {
	private List<Room> roomList;
	private String id;
	private static List<Request> pendingRequests;
	private List<Account> authorizedAccounts;
	private List<Group> groupList;
	
	public School(List<Room> nRoomList, String nId, List<Request> nPendingRequests, List<Account> nAuthorizedAccounts, List<Group> nGroupList) {
		roomList = nRoomList;
		id = nId;
		pendingRequests = nPendingRequests;
		authorizedAccounts = nAuthorizedAccounts;
		groupList = nGroupList;
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
	
	public List<Account> getAuthorizedAccounts(){
		return authorizedAccounts;
	}
	
	public List<Group> getGroupList(){
		return groupList;
	}
	
	public void addRoom(Room newRoom) {
		roomList.add(newRoom);
	}
	
	/*
	public static void createSampleRequests() {
		Group g = new Group("bys");
		pendingRequests.add(new Request(new Applicant("hey", g), new Room("Gymnasium", 2),
				new Booking(LocalTime.parse("02:00"), LocalTime.parse("02:00"), Semester.FALL, DayOfWeek.MONDAY, g), 
				1, "balls", LocalDate.now()));
	}
	*/
}
