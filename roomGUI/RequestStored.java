package roomGUI;

public class RequestStored{
	private String appName;
	private String appGroup;
	private String message;
	private String room;
	private String sem;
	private String startTime;
	private String endTime;
	private String day;
	private String priority;

	public void setAppName(String n){
		appName=n;
	}
	public void setAppGroup(String g){
		appGroup=g;
	}
	public void setMessage(String m){
		message=m;
	}
	public void setRoom(String r){
		room=r;
	}
	public void setSem(String s){
		sem=s;
	}
	public void setStartTime(String st){
		startTime=st;
	}
	public void setEndTime(String et){
		endTime=et;
	}
	public void setPriority(String p){
		priority=p;	
	}
	public void setDay(String d){
		day=d;
	}
	public String getAppName(){
		return appName;
	}
	public String getAppGroup(){
		return appGroup;
	}
	public String getMessage(){
		return message;
	}
	public String getRoom(){
		return room;
	}
	public String getSem(){
		return sem;
	}
	public String getStartTime(){
		return startTime;
	}
	public String getEndTime(){
		return endTime;
	}
	public String getDay(){
		return day;
	}
	public String getPriority(){
		return priority;
	}

}
