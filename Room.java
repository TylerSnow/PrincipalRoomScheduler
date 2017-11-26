public class Room {
	//availableTimes[0][0] is Sunday at 8am, availableTimes[0][1] is 9am, etc
	//availableTimes[1][0] is Monday at 8am.
	private timeSlot[][] availableTimes = new timeSlot[7][16];
	private timeSlot[][] bookedSlots = new timeSlot[7][16];
	private String name;
	private int idno;
	
	public Room(String nName, int nIdno) {
		availableTimes = initializeAvail();
		bookedSlots = initializeBookedSlots();
		name = nName;
		idno = nIdno;
	}
	
	public String getName() {
		return name;
	}
	
	public int getIDno() {
		return idno;
	}
	
	public timeSlot[][] initializeAvail() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 16; j++) {
				availableTimes[i][j] = new timeSlot();
			}
		}
		return availableTimes;
	}
	
	public timeSlot[][] initializeBookedSlots() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 16; j++) {
				bookedSlots[i][j] = new timeSlot();
			}
		}
		return bookedSlots;
	}
	
	public void addAvailability(int weekday, int[] time) {
		for(int t:time) {
			availableTimes[weekday][t].makeAvailable();
		}
	}
	
	public timeSlot[][] getAvailableTimes() {
		return availableTimes;
	}
	
	public void bookTimeSlot(int weekday, int[] time, Booking nBooking) {
		for (int t : time) {
			bookedSlots[weekday][t].bookSlot(nBooking);
		}
	}
	
	public timeSlot[][] getBookedSlots(){
		return bookedSlots;
	}
	
	public void printBookedSlots() {
		for (int c = 0 ; c <= 6 ; c++) {
			System.out.println(c);
			for (int u= 0 ; u <= 15 ; u++) {
				if (bookedSlots[c][u].getBooking() != null) {
					System.out.print(bookedSlots[c][u].getBooking().getGroup().getName() + " ");
				} else {
					System.out.print(bookedSlots[c][u].getBooking() + " ");
				}
			}
			System.out.println("");
		}
	}
	
	public void printAvailability() {
		for (int c = 0 ; c <= 6 ; c++) {
			System.out.println(c);
			for (int u= 0 ; u <= 15 ; u++) {
				System.out.print(availableTimes[c][u].isAvailable() + " ");
			}
			System.out.println("");
		}
	}
}