package school;
import java.time.LocalDateTime;

public class Booking {
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Group group;
	
	public Booking(LocalDateTime nStartTime, LocalDateTime nEndTime, Group nGroup) {
		startTime = nStartTime;
		endTime = nEndTime;
		group = nGroup;
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
