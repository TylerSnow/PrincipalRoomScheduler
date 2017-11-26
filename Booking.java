public class Booking {
	private int weekday;
	private int[] slotsBooked;
	private Group group;
	
	public Booking(int nWeekday, int[] nSlotsBooked, Group nGroup) {
		weekday = nWeekday;
		slotsBooked = nSlotsBooked;
		group = nGroup;
	}
	
	public int getWeekday() {
		return weekday;
	}
	
	public int[] getSlotsBooked() {
		return slotsBooked;
	}
	
	public Group getGroup() {
		return group;
	}
}
