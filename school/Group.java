package school;

import java.io.Serializable;

public class Group implements Serializable {
	private String name;
	private int preferredLevel;
	
	public Group(String nName) {
		name = nName;
		School.AddGroup(this);
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setPreferredLevel(int newLevel) {
		preferredLevel = newLevel;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPreferredLevel() {
		return preferredLevel;
	}
}
