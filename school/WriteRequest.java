package school;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class WriteRequest {
	
	public static void removeRequest(int n) {
		String filePath = new File("").getAbsolutePath();
		filePath += "\\src\\objects\\requests";
		System.out.println("Trying to delete" + filePath + "\\request" + n);
		try
        {
            Files.deleteIfExists(Paths.get(filePath + "\\request" + n));
        }
        catch(NoSuchFileException e)
        {
            System.out.println("No such file/directory exists");
        }
        catch(DirectoryNotEmptyException e)
        {
            System.out.println("Directory is not empty.");
        }
        catch(IOException e)
        {
            System.out.println("Invalid permissions.");
        }
	}

	public void serializeAddress(Request r) {

		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {

			//fout = new FileOutputStream("C:\\Users\\John.DESKTOP-DT12DV9\\Documents\\address.ser");
			String filePath = new File("").getAbsolutePath();
			filePath += "\\src\\objects\\requests";
			if (new File(filePath).list() != null) {
				int numRequests = new File(filePath).list().length;
				String fileName = "\\request" + numRequests;
				fout = new FileOutputStream(filePath + fileName);
			}
			else {
				String fileName = "\\request0";
				fout = new FileOutputStream(filePath + fileName);
			}
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