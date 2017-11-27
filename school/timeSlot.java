package school;
public class timeSlot {
	private boolean isAvailable = false;
	private boolean isBooked = false;
	private Booking booked;
	
	public timeSlot() {
		
	}
	
	public void bookSlot(Booking nBooking) {
		this.booked = nBooking;
		this.isBooked = true;
	}
	
	public Booking getBooking() {
		return booked;
	}
	
	public boolean isBooked() {
		return isBooked;
	}
	
	public void makeAvailable() {
		isAvailable = true;
	}
	
	public void makeUnavailable() {
		isAvailable = false;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
}