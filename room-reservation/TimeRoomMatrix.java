import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;

public class TimeRoomMatrix {

	//testing push
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeRoomMatrix window = new TimeRoomMatrix();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TimeRoomMatrix() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Time and Room Chart");
		frame.setBounds(0, 0, 800, 800);
		String[] rooms = {"101", "102", "103", "104", "105", "106"};
		
		JPanel panel_1 = new JPanel();
		panel_1.add(new JTextField("This is my attempt at making a Room x Time grid \n it needs work "));
		
		//####################################################################################################
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(rooms.length+1, 25));
		Font f = new Font("serif", Font.PLAIN, 18);
		
		JButton[][] grid = new JButton[rooms.length+1][25];
		grid[0][0] = new JButton("Times");
		grid[0][0].setBackground(Color.WHITE);
		for (int k = 1 ; k <= rooms.length ; k++) {
			grid[k][0] = new JButton(rooms[k-1]);
			grid[k][0].setBackground(Color.LIGHT_GRAY);
			grid[k][0].setFont(f);
		}
		for (int y = 1 ; y < 25 ; y++) {
			String timeSlot = y-1 + ":00";
			grid[0][y] = new JButton(timeSlot);
			grid[0][y].setBackground(Color.LIGHT_GRAY);
			grid[0][y].setFont(f);
		}
		
		for (int j = 1 ; j <= rooms.length ; j++) {
			for (int i = 1 ; i < 25 ; i++) {
				grid[j][i] = new JButton();
				/*if (rooms[j-1].isBooked() == false) {
					grid[i][j].setBackground(Color.GREEN);
				} else if (rooms[j-1].isBooked() == true) {
					grid[i][j].setBackground(Color.RED);
				}*/	
			}
		}
		
		for (int b = 0 ; b < rooms.length + 1 ; b++) {
			for (int a = 0 ; a < 25 ; a++) {
				panel.add(grid[b][a]);
			}
		}
		
		//###########################################################################################
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}
}
