package school;
import java.time.LocalDate;

public class Request {
	private Applicant applicant;
	private Room room;
	private Booking booking;
	private int priority;
	private String message;
	private LocalDate dateRequested;
	
	public Request(Applicant nApplicant, Room r, Booking b, int nPriority, String nMessage, LocalDate nDateRequested) {
		applicant = nApplicant;
		room = r;
		booking = b;
		priority = nPriority;
		message = nMessage;
		dateRequested = nDateRequested;
	}
	
	public Applicant getApplicant() {
		return applicant;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public Booking getBooking() {
		return booking;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public String getMessage() {
		return message;
	}
	
	public LocalDate getDateRequested() {
		return dateRequested;
	}
	
	/*public void approveRequest(int approvedRoomIndex) {
		Booking approvedBooking = requestedRooms[approvedRoomIndex].getRoom();
		approvedBooking.getRoom().
	}*/
}
