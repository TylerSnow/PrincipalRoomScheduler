package school;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadRequest {
	
	private static String filePath;

	public static void main(String args[]) {

		ReadRequest obj = new ReadRequest();

		String filePath = new File("").getAbsolutePath();
		filePath += "\\src\\objects\\requests";
		Request r = obj.deserialzeAddress(filePath);

		System.out.println(r.getApplicant().getGroup().getName());

	}
	
	public static ArrayList<Request> readRequests() {
		ArrayList<Request> stored = new ArrayList<>();
		ReadRequest obj = new ReadRequest();
		filePath = new File("").getAbsolutePath();
		filePath += "\\src\\objects\\requests";
		if (new File(filePath).list() != null) {
			int numRequests = new File(filePath).list().length;
			for (int i = 0; i < numRequests; i++) {
				Request r = obj.deserialzeAddress(filePath + "\\request" + i);
				stored.add(r);
			}
		}
		return stored;
	}

	public Request deserialzeAddress(String filename) {

		Request r = null;

		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			r = (Request) ois.readObject();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return r;

	}

	public Request deserialzeAddressJDK7(String filename) {

		Request r = null;

		try (ObjectInputStream ois
			= new ObjectInputStream(new FileInputStream(filename))) {

			r = (Request) ois.readObject();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return r;

	}

}