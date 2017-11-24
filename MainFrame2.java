import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class MainFrame2 extends JFrame {
	
	private JPanel mainPanel;
	private HomePanel homePanel;
	private Calender calPanel;
	private TimeRoomGridPanel gridPanel;
	private CardLayout cards = new CardLayout();
	
	public static String HOME_PANEL = "Home Panel";
	public static String CALENDER_PANEL = "Calender Panel";
	public static String GRID_PANEL = "Grid Panel";
	private String prevPanel;
	
	/**
	 * Create the frame.
	 */
	public MainFrame2() {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		mainPanel = new JPanel(cards);
		
		homePanel = new HomePanel(this);
		mainPanel.add(homePanel, HOME_PANEL);
		
		prevPanel = HOME_PANEL;
		
		calPanel = new Calender(this);
		mainPanel.add(calPanel, CALENDER_PANEL);

		cards.show(mainPanel, "Home Page");
		add(mainPanel);
		repaint();
		revalidate();
	}
	
	public void showPanel(String panel, String prev) {
		if (panel.equals(GRID_PANEL)) {
			//call makeGrid here, pass to trgp constructor?
			gridPanel = new TimeRoomGridPanel(this);
			mainPanel.add(gridPanel, GRID_PANEL);
			prevPanel = prev;
		}
		cards.show(mainPanel, panel);
	}
	
	public void back(String newPrev) {
		cards.show(mainPanel, prevPanel);
		prevPanel = newPrev;
		//System.out.println(prevPanel);
	}
	
	public static void main(String[] args) {
		MainFrame2 frame = new MainFrame2();
	}

}
