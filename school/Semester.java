package school;

public enum Semester {
	FALL, WINTER, SPRING;
	
	public Semester toSem(String s) {
		switch(s) {
			case "Fall" : return FALL;
			case "Winter" : return WINTER;
			case "Spring" : return SPRING;
			default: return FALL;
		}
	}
}
