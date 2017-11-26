package roomGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonListener implements ActionListener{
	private MainFrame2 frame;
	
	public BackButtonListener(MainFrame2 f) {
		frame = f;
	}
    public void actionPerformed(ActionEvent e) {
        frame.back();
    }
}
