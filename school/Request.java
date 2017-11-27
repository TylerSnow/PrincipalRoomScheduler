package school;
import java.time.LocalDate;

public class Request {
	private Applicant applicant;
	private int numSlots;
	private Room room;
	private Booking booking;
	private int priority;
	private String message;
	private LocalDate dateRequested;
	
	public Request(Applicant nApplicant, int nNumSlots, Room r, Booking b, int nPriority, String nMessage, LocalDate nDateRequested) {
		applicant = nApplicant;
		numSlots = nNumSlots;
		room = r;
		booking = b;
		priority = nPriority;
		message = nMessage;
		dateRequested = nDateRequested;
	}
	
	public Applicant getApplicant() {
		return applicant;
	}
	
	public int getNumSlots() {
		return numSlots;
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
