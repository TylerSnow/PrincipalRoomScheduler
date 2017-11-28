package school;

public class Request {
	private Applicant applicant;
	private int numSlots;
	private Room room;
	private Booking[] bookings;
	private String message;
	
	public Request(Applicant nApplicant, int nNumSlots, Room r, Booking[] b, String nMessage) {
		applicant = nApplicant;
		numSlots = nNumSlots;
		room = r;
		bookings = b;
		message = nMessage;
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
	
	public String toString() {
		return ("Group: " + applicant.getGroup().getName() + ", Slots: " + numSlots);
				
	}
	
	public void approveRequest(int approvedIndex) {
		this.getRoom().addBooking(this.getBookings()[approvedIndex], this.getBookings()[approvedIndex].getSemester());
	}
}

