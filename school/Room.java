package school;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Room {
	//availableTimes[0][0] is Monday at 00:00, availableTimes[0][1] is 01:00, etc
	//availableTimes[1][0] is Tuesday at 00:00.
	private timeSlot[][] fallAvailTimes = new timeSlot[7][24];
	private timeSlot[][] winterAvailTimes = new timeSlot[7][24];
	private timeSlot[][] springAvailTimes = new timeSlot[7][24];
	private List<Booking> reservations;
	private List<Booking> approvedRequests;
	private String name;
	private int idno;
	
	public Room(String nName, int nIdno) {
		fallAvailTimes = initializeAvail();
		winterAvailTimes = initializeAvail();
		springAvailTimes = initializeAvail();
		approvedRequests = new ArrayList<Booking>();
		reservations = new ArrayList<Booking>();
		name = nName;
		idno = nIdno;
		School.addRoom(this);
	}
	
	public String getName() {
		return name;
	}
	
	public int getIDno() {
		return idno;
	}
	
	public timeSlot[][] initializeAvail() {
		timeSlot[][] availableTimes = new timeSlot[7][24];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 24; j++) {
				availableTimes[i][j] = new timeSlot();
			}
		}
		return availableTimes;
	}
	
	public timeSlot[][] getSemesterTimeslots(Semester s){
		timeSlot[][] sem = null;
		switch (s) {
			case FALL : sem = fallAvailTimes;
			case WINTER : sem =  winterAvailTimes;
			case SPRING : sem =  springAvailTimes;
		}
		return sem;
	}
	
	public void addAvailability(DayOfWeek day, int[] time, Semester s) {
		int weekday = day.getValue()-1;
		for(int t:time) {
			this.getSemesterTimeslots(s)[weekday][t].makeAvailable();
		}
		this.printAvailability(s);
	}
	
	public timeSlot[][] getAvailableTimes(Semester s) {
		return this.getSemesterTimeslots(s);
	}
	
	public List<Booking> getReservations(){
		return reservations;
	}
	
	public void printAvailability(Semester s) {
		for (int c = 0 ; c < 7 ; c++) {
			switch (c) {
				case 0 : System.out.println("Monday:"); break;
				case 1 : System.out.println("Tuesday:"); break;
				case 2 : System.out.println("Wednesday:"); break;
				case 3 : System.out.println("Thursday:"); break;
				case 4 : System.out.println("Friday:"); break;
				case 5 : System.out.println("Saturday:"); break;
				case 6 : System.out.println("Sunday"); break;
			}
			for (int u= 0 ; u < 24 ; u++) {
				System.out.print("0"+u+":00 ");
				boolean ava = this.getSemesterTimeslots(s)[c][u].isAvailable();
				boolean bvb = this.getSemesterTimeslots(s)[c][u].isBooked();
				if (ava == false) {
					System.out.print( "NotAvailable ");
				} else {
					if (bvb == true) {
						System.out.print(this.getSemesterTimeslots(s)[c][u].getBooking().getGroup().getName() + " ");
					} else {
						System.out.print("NotBooked ");
					}
				}
			}
			System.out.println("");
		}
	}
	
	public void addBooking(Booking bookingByAGroup, Semester s) {
		approvedRequests.add(bookingByAGroup);
		for(int t:bookingByAGroup.generateIntArray()) {
			this.getSemesterTimeslots(s)[bookingByAGroup.getDay().getValue()-1][t].bookSlot(bookingByAGroup);
		}
	}
	
	public void reserveRoom(Booking reservation) {
		if (reservation.getGroup().getName() == "Principle") {
			reservations.add(reservation);
		}
	}
}