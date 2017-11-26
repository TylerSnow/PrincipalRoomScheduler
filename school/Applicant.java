package school;

public class Applicant {
	private String id;
	private Group group;
	
	public Applicant(String nId, Group nGroup) {
		id = nId;
		group = nGroup;
	}
	
	public String getID() {
		return id;
	}
	
	public Group getGroup() {
		return group;
	}
}
