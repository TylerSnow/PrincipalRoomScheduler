package roomGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButtonListener implements ActionListener{
	private MainFrame2 frame;
	
	public NextButtonListener(MainFrame2 f) {
		frame = f;
	}
    public void actionPerformed(ActionEvent e) {
        frame.next();
    }
}
