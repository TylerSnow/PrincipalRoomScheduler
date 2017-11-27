package school;
import java.util.List;

public class School {
	private List<Room> roomList;
	private String id;
	private List<Request> pendingRequests;
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
	
	public List<Request> getPendingRequests(){
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
}
