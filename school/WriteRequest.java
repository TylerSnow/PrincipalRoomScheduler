package school;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class WriteRequest {

	public static void main(String args[]) {

		WriteRequest obj = new WriteRequest();
		Group skatingTeam = new Group("Tastes bad");

		Booking[] sb1 = {
				new Booking(LocalTime.parse("01:00"),LocalTime.parse("02:00"),Semester.WINTER, DayOfWeek.TUESDAY, skatingTeam),
				new Booking(LocalTime.parse("04:00"),LocalTime.parse("05:00"),Semester.WINTER, DayOfWeek.THURSDAY, skatingTeam),
				new Booking(LocalTime.parse("12:00"),LocalTime.parse("13:00"),Semester.WINTER, DayOfWeek.SUNDAY, skatingTeam),
				new Booking(LocalTime.parse("08:00"),LocalTime.parse("09:00"),Semester.WINTER, DayOfWeek.SATURDAY, skatingTeam),
				new Booking(LocalTime.parse("05:00"),LocalTime.parse("09:00"),Semester.WINTER, DayOfWeek.MONDAY, skatingTeam),
				};
		Request req = new Request(new Applicant("Joe", skatingTeam), 3, Semester.WINTER, new Room("Auditorium", 4), sb1, "Skating Praccy");


		obj.serializeAddress(req);

	}

	public void serializeAddress(Request r) {

		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			//fout = new FileOutputStream("C:\\Users\\John.DESKTOP-DT12DV9\\Documents\\address.ser");
			String filePath = new File("").getAbsolutePath();
			filePath += "\\src\\objects\\requests";
			int numRequests = new File(filePath).list().length;
			String fileName = "\\request" + numRequests;
			fout = new FileOutputStream(filePath + fileName);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(r);

			System.out.println("Done1");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public void serializeAddressJDK7(Request r) {

		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream("address2.ser"))) {

			oos.writeObject(r);
			System.out.println("Done2");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}