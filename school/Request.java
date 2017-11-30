package school;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Request {
	private Applicant applicant;
	private int numSlots;
	private Room room;
	private Booking[] bookings;
	private String message;
	private Semester semester;
	private static Request unfinishedRequest;
	
	public Request(Applicant nApplicant, int nNumSlots, Semester sem, Room r, Booking[] b, String nMessage) {
		applicant = nApplicant;
		numSlots = nNumSlots;
		semester = sem;
		room = r;
		bookings = b;
		message = nMessage;
		School.AddPendingRequest(this);
	}
	
	//DONT use this. It is only for being called from the generateRequest method//
	public Request(boolean DONTUSETHISMETHOD, Applicant nApplicant, Semester sem, int nNumSlots, Room r, Booking[] b, String nMessage) {
		applicant = nApplicant;
		numSlots = nNumSlots;
		semester = sem;
		room = r;
		bookings = b;
		message = nMessage;
	}
	
	public static void generateRequest(String appName, String appGroup, String room, String sem, String numSlots, String startTime, String endTime, String day, String priority, String message) {
		Booking[] tempBooking = null;
		int slots  = Integer.parseInt(numSlots);
		Room rRoom = null;
		Applicant app = new Applicant(appName, new Group(appGroup));
		if (unfinishedRequest == null) {
			System.out.println("DOING 1");
			tempBooking = new Booking[5];
			for(int i = 0; i < 5; i++) {
				Booking b = new Booking(LocalTime.parse("00:00"), LocalTime.parse("00:00"), Semester.FALL, DayOfWeek.MONDAY, new Group(appGroup));
				tempBooking[i] = b;
			}
			app = new Applicant(appName, new Group(appGroup));
			slots = Integer.parseInt(numSlots);
		} else {
			System.out.println("DOING 2");
			tempBooking = unfinishedRequest.getBookings();
			app = unfinishedRequest.getApplicant();
		}
		for (Room r : School.getRoomList()) {
			if (r.getName() == room) {
				System.out.println(r.getName());
				rRoom = r;
			}
		}
		Semester semester = Semester.toSem(sem);
		LocalTime strt = LocalTime.parse(startTime);
		LocalTime end = LocalTime.parse(endTime);
		DayOfWeek d = null;
		switch (day) {
			case "Monday" : d = DayOfWeek.MONDAY; {
				d = DayOfWeek.MONDAY;
				break;
			}
			case "Tuesday" : d = DayOfWeek.TUESDAY; {
				d = DayOfWeek.TUESDAY;
				break;
			}
			case "Wednesday" : d = DayOfWeek.WEDNESDAY;{
				d = DayOfWeek.WEDNESDAY;
				break;
			}
			case "Thursday" : d = DayOfWeek.THURSDAY;{
				d = DayOfWeek.THURSDAY;
				break;
			}
			case "Friday" : d = DayOfWeek.FRIDAY;{
				d = DayOfWeek.FRIDAY;
				break;
			}
			case "Saturday" : d = DayOfWeek.SATURDAY;{
				d = DayOfWeek.SATURDAY;
				break;
			}
			case "Sunday" : d = DayOfWeek.SUNDAY;{
				d = DayOfWeek.SUNDAY;
				break;
			}
			default : d = DayOfWeek.MONDAY;
		}
		int pri = Integer.parseInt(priority);
		for (int i = 0; i < 5; i++) {
			if (tempBooking[i].getStartTime() == tempBooking[i].getEndTime()) {
				Booking b = new Booking(strt, end, semester, d, new Group(appGroup));
				tempBooking[i] = b;
			}
		}
		//Booking b = new Booking(strt, end, semester, d, new Group(appGroup));
		/*
		tempBooking[pri-1] = b;
		System.out.println("STARTING");
		System.out.println(app);
		System.out.println(semester);
		System.out.println(slots);
		System.out.println(rRoom.getName());
		for (int i = 0; i < tempBooking.length; i++) {
			System.out.println(tempBooking[i].getGroup());
		}
		System.out.println(message);
		System.out.println("ENDING");
		*/

		unfinishedRequest = new Request(false, app, semester, slots, rRoom, tempBooking, message);
		submitUnfinished();
	}
	
	public static Request getUnfinished() {
		return unfinishedRequest;
	}
	
	public static void submitUnfinished() {
		School.AddPendingRequest(unfinishedRequest);
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
	
	public Semester getSemester() {
		return semester;
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

