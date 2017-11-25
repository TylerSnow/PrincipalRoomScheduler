import java.time.LocalDateTime;

public class Booking {
	private Room room;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Group group;
	
	public Booking(Room nRoom, LocalDateTime nStartTime, LocalDateTime nEndTime, Group nGroup) {
		room = nRoom;
		startTime = nStartTime;
		endTime = nEndTime;
		group = nGroup;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	public LocalDateTime getEndTime() {
		return endTime;
	}
	
	public Group getGroup() {
		return group;
	}
}
