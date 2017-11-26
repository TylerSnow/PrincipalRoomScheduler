package school;
import java.util.List;

public class Room {
	//availableTimes[0][0] is Sunday at 8am, availableTimes[0][1] is 9am, etc
	//availableTimes[1][0] is Monday at 8am.
	private timeSlot[][] availableTimes = new timeSlot[7][16];
	private List<Booking> reservations;
	private List<Booking> approvedRequests;
	private String name;
	private int idno;
	
	public Room(String nName, int nIdno) {
		availableTimes = initializeAvail();
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
	
	public void addAvailability(int weekday, int[] time) {
		for(int t:time) {
			availableTimes[weekday][t].makeAvailable();
		}
	}
	
	public timeSlot[][] getAvailableTimes() {
		return availableTimes;
	}
	
	public List<Booking> getReservations(){
		return reservations;
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
	
	public void addBooking(Booking bookingByAGroup) {
		approvedRequests.add(bookingByAGroup);
	}
	
	public void reserveRoom(Booking reservation) {
		if (reservation.getGroup().getName() == "Principle") {
			reservations.add(reservation);
		}
	}
}