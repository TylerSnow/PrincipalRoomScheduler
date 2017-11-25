public class Room {
	//availableTimes[0][0] is sunday at 8am, availableTimes[0][1] is 9am, etc
	//availableTimes[1][0] is monday at 8am.
	private timeSlot[][] availableTimes = new timeSlot[7][16];
	private String name;
	private int idno;
	
	public Room(String name, int idno) {
		this.initialize();
		this.name = name;
		this.idno = idno;
	}
	
	public void initialize() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 16; j++) {
				availableTimes[i][j] = new timeSlot();
			}
		}
	}
	
	public void addAvailability(int weekday, int[] time) {
		for(int t:time) {
			availableTimes[weekday][t].makeAvailable();
		}
	}
}