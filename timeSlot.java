public class timeSlot {
	private boolean isAvailable = false;
	
	public timeSlot() {
		
	}
	
	public void makeAvailable() {
		isAvailable = true;
	}
	
	public void makeUnavailable() {
		isAvailable = false;
	}
	
	public boolean getAvailability() {
		return isAvailable;
	}
}
