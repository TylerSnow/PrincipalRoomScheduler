package school;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Room {
	//availableTimes[0][0] is Sunday at 8am, availableTimes[0][1] is 9am, etc
	//availableTimes[1][0] is Monday at 8am.
	private timeSlot[][] availableTimes = new timeSlot[7][24];
	private List<Booking> reservations;
	private List<Booking> approvedRequests;
	private String name;
	private int idno;
	
	public Room(String nName, int nIdno) {
		availableTimes = initializeAvail();
		approvedRequests = new ArrayList<Booking>();
		reservations = new ArrayList<Booking>();
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
			for (int j = 0; j < 24; j++) {
				availableTimes[i][j] = new timeSlot();
			}
		}
		return availableTimes;
	}
	
	public void addAvailability(DayOfWeek day, int[] time) {
		int weekday = day.getValue();
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
		for (int c = 0 ; c < 7 ; c++) {
			System.out.println(c);
			for (int u= 0 ; u < 24 ; u++) {
				System.out.print(availableTimes[c][u].isAvailable() + " ");
			}
			System.out.println("");
		}
	}
	
	public void addBooking(Booking bookingByAGroup) {
		approvedRequests.add(bookingByAGroup);
		for(int t:bookingByAGroup.generateIntArray()) {
			availableTimes[bookingByAGroup.getDay().getValue()-1][t].isBooked()/*.bookSlot(bookingByAGroup)*/;
		}
	}
	
	public void reserveRoom(Booking reservation) {
		if (reservation.getGroup().getName() == "Principle") {
			reservations.add(reservation);
		}
	}
}