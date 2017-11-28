package school;
import java.time.LocalTime;
import java.time.DayOfWeek;

public class Booking {
	private LocalTime startTime;
	private LocalTime endTime;
	private DayOfWeek day;
	private Semester semester;
	private Group group;
	
	public Booking(LocalTime nStartTime, LocalTime nEndTime, Semester s, DayOfWeek d, Group nGroup) {
		startTime = nStartTime;
		endTime = nEndTime;
		semester = s;
		day = d;
		group = nGroup;
	}
	
	public DayOfWeek getWeekday() {
		return day;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	
	public LocalTime getEndTime() {
		return endTime;
	}
	
	public Semester getSemester() {
		return semester;
	}
	
	public DayOfWeek getDay() {
		return day;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public int[] generateIntArray() {
		int[] timeArray = new int[this.getEndTime().getHour()-this.getStartTime().getHour()];
		for (int s = 0 ; s < timeArray.length ; s++) {
			timeArray[s] = s + this.getStartTime().getHour();
		}
		return timeArray;
	}
}
