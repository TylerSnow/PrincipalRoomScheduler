import javax.swing.JButton;

public class GridButton extends JButton{
	private int xcoord;
	private int ycoord;
	
	public GridButton(int nX, int nY) {
		this.xcoord = nX;
		this.ycoord = nY;
	}
	
	public GridButton(int nX, int nY, String title) {
		super.setText(title);
		this.xcoord = nX;
		this.ycoord = nY;
	}
	
	public int getXcoord() {
		return xcoord;
	}
	
	public int getYcoord() {
		return ycoord;
	}
}
