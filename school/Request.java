package school;
//import java.time.LocalDate;

public class Request {
	private Applicant applicant;
	private int numSlots;
	private Room room;
	private Booking[] bookings;
	//private int priority;
	private String message;
	//private LocalDate dateRequested;
	
	public Request(Applicant nApplicant, int nNumSlots, Room r, Booking[] b, /*int nPriority,*/ String nMessage /*,LocalDate nDateRequested*/) {
		applicant = nApplicant;
		numSlots = nNumSlots;
		room = r;
		bookings = b;
		//priority = nPriority;
		message = nMessage;
		//dateRequested = nDateRequested;
		School.AddPendingRequest(this);
	}
	
	public Applicant getApplicant() {
		return applicant;
	}
	
	public int getNumSlots() {
		return numSlots;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public Booking[] getBookings() {
		return bookings;
	}
	
	/*public int getPriority() {
		return priority;
	}*/
	
	/*public LocalDate getDateRequested() {
		return dateRequested;
	}*/
	
	public void approveRequest(int approvedIndex) {
		this.getRoom().addBooking(this.getBookings()[approvedIndex]);
	}
}

