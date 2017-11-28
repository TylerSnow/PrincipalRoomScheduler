package school;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Request {
	private Applicant applicant;
	private int numSlots;
	private Room room;
	private Booking[] bookings;
	private String message;
	private static Request unfinishedRequest;
	
	public Request(Applicant nApplicant, int nNumSlots, Room r, Booking[] b, String nMessage) {
		applicant = nApplicant;
		numSlots = nNumSlots;
		room = r;
		bookings = b;
		message = nMessage;
		School.AddPendingRequest(this);
	}
	
	//DONT use this. It is only for being called from the generateRequest method//
	public Request(boolean DONTUSETHISMETHOD, Applicant nApplicant, int nNumSlots, Room r, Booking[] b, String nMessage) {
		applicant = nApplicant;
		numSlots = nNumSlots;
		room = r;
		bookings = b;
		message = nMessage;
	}
	
	public void generateRequest(String appName, String appGroup, String sem, String numSlots, String startTime, String endTime, String day, String priority, String message) {
		Booking[] tempBooking = null;
		int slots = 0;
		Applicant app = null;
		if (unfinishedRequest == null) {
			tempBooking = new Booking[5];
			app = new Applicant(appName, new Group(appGroup));
			slots = Integer.parseInt(numSlots);
		} else {
			tempBooking = unfinishedRequest.getBookings();
			app = unfinishedRequest.getApplicant();
		}
		Semester semester = Semester.toSem(sem);
		LocalTime strt = LocalTime.parse(startTime);
		LocalTime end = LocalTime.parse(endTime);
		DayOfWeek d = null;
		switch (day) {
			case "Monday" : d = DayOfWeek.MONDAY;
			case "Tuesday" : d = DayOfWeek.TUESDAY;
			case "Wednesday" : d = DayOfWeek.WEDNESDAY;
			case "Thursday" : d = DayOfWeek.THURSDAY;
			case "Friday" : d = DayOfWeek.FRIDAY;
			case "Saturday" : d = DayOfWeek.SATURDAY;
			case "Sunday" : d = DayOfWeek.SUNDAY;
		}
		int pri = Integer.parseInt(priority);
		Booking b = new Booking(strt, end, semester, d, new Group(appGroup));
		tempBooking[pri-1] = b;
		unfinishedRequest = new Request(false, app, slots, room, tempBooking, message);
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

