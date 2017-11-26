package roomGUI;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

class EnterListener implements KeyListener{
	
	private JButton btn;
	
	public EnterListener(JButton b) {
		btn = b;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER){
			System.out.println("Enter");
			btn.doClick();
		}
	}
			
	@Override
	public void keyReleased(KeyEvent e) {
				
	}
			
	public void keyTyped(KeyEvent e) {
			
	}
}