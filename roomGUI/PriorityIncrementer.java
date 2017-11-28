package roomGUI;

public class PriorityIncrementer {
	int i;
	public PriorityIncrementer(){
		i=5;
	}
	
	public int getInc(){
		return i;
	}
	public void setInc(int n) {
		i=i+n;
	}
	public void incPri() {
		i++;
	}
	public void removePri() {
		if(i>0) {
			i--;
		}
		else {
			i=0;
		}
	}
}
