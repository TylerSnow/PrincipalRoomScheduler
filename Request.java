import java.time.LocalDate;

public class Request {
	private Applicant applicant;
	private Booking[] requestedRooms;
	private int priority;
	private String message;
	private LocalDate dateRequested;
	
	public Request(Applicant nApplicant, Booking[] nRequestedRooms, int nPriority, String nMessage, LocalDate nDateRequested) {
		applicant = nApplicant;
		requestedRooms = nRequestedRooms;
		priority = nPriority;
		message = nMessage;
		dateRequested = nDateRequested;
	}
	
	public Applicant getApplicant() {
		return applicant;
	}
	
	public Booking[] getRequestedRooms() {
		return requestedRooms;
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
