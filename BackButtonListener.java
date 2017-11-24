import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonListener implements ActionListener{
	private MainFrame2 frame;
	private String prev;
	public BackButtonListener(MainFrame2 f, String prev) {
		this.frame = f;
		this.prev = prev;
	}
    public void actionPerformed(ActionEvent e) {
        frame.back(prev);
    }
}
