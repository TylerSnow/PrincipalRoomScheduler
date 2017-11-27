package school;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class RoomTester {
	public static void main(String[]args) {
		//Room Gym = new Room("Gym", 1);
		//Room Cafe = new Room("Cafe", 2);
		Room Library = new Room("Library", 3);
		//LocalTime[] time1 = {LocalTime.of(1, 00),LocalTime.of(2, 00),LocalTime.of(3, 00),LocalTime.of(4, 00),LocalTime.of(5, 00)};
		//int[] time1 = {0,1,2,3,4,5,6,7,8};
		int[] time2 = {3,4,5,6,7,8,9,};
		//int[] time3 = {1,2,3,4,5,6,7,8};
		//Gym.addAvailability(DayOfWeek.MONDAY,time1);
		//Cafe.addAvailability(DayOfWeek.THURSDAY, time3);
		Library.addAvailability(DayOfWeek.TUESDAY, time2);
		//Group MathClub = new Group("MathClub");
		//Group HockeyTeam = new Group("HockeyTeam");
		Group ChessClub = new Group("ChessClub");
		Applicant Steve = new Applicant("Steve", ChessClub);
		//Applicant Jen = new Applicant("Jen", HockeyTeam);
		//Applicant Bob = new Applicant("Bob", MathClub);
		Booking b0 = new Booking(LocalTime.of(04, 00), LocalTime.of(05, 00), Semester.FALL, DayOfWeek.TUESDAY, ChessClub);
		Booking b1 = new Booking(LocalTime.of(05, 00), LocalTime.of(06, 00), Semester.FALL, DayOfWeek.TUESDAY, ChessClub);
		/*Booking b2 = new Booking(Cafe, 4, 10, 11, ChessClub);
		Booking b3 = new Booking(Cafe, 4, 8, 9, ChessClub);
		Booking b4 = new Booking(Library, 5, 3, 4, ChessClub);
		Booking b5 = new Booking(Gym, 1, 1, 5, HockeyTeam);
		Booking b6 = new Booking(Gym, 1, 2, 4, HockeyTeam);
		Booking b7 = new Booking(Gym, 1, 3, 5, HockeyTeam);
		Booking b8 = new Booking(Gym, 1, 1, 3, HockeyTeam);
		Booking b9 = new Booking(Cafe, 4, 1, 8, HockeyTeam);		
		Booking b10 = new Booking(Library, 5, 3, 5, MathClub);
		Booking b11 = new Booking(Library, 5, 3, 4, MathClub);
		Booking b12 = new Booking(Library, 5, 4, 5, MathClub);
		Booking b13 = new Booking(Library, 5, 8, 9, MathClub);
		Booking b14 = new Booking(Cafe, 4, 1, 4, MathClub);*/
		Booking[] chessBooking = {b0,b1};
		//Booking[] hockeyBooking = {b5,b6,b7,b8,b9};
		//Booking[] mathBooking = {b10,b11,b12,b13,b14};
		//Request mathRequest = new Request(Bob, 1, Library, mathBooking, "Math Club Request");
		//Request hockeyRequest = new Request(Jen, 1, Library, hockeyBooking, "Hockey Team Request");
		Request chessRequest = new Request(Steve, 1, Library, chessBooking, "Chess Club Request");
		//mathRequest.approveRequest(1);
		//hockeyRequest.approveRequest(4);
		chessRequest.approveRequest(0);
		//Gym.printBookings();
		//Cafe.printBookings();
		Library.printAvailability();
	}
}
