import java.time.LocalDateTime;

public class Request {
	private Applicant applicant;
	private Booking[] requestedRooms;
	private int priority;
	private String message;
	private LocalDateTime requestedTime;
	
	public Request(Applicant nApplicant, Booking[] nRequestedRooms, int nPriority, String nMessage, LocalDateTime nRequestedTime) {
		applicant = nApplicant;
		requestedRooms = nRequestedRooms;
		priority = nPriority;
		message = nMessage;
		requestedTime = nRequestedTime;
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
	
	public LocalDateTime getRequestedTime() {
		return requestedTime;
	}
}
