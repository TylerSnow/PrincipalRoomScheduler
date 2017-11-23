import java.awt.EventQueue;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;

public class TimeRoomGridPanel extends JPanel{
	private JScrollPane pane;
	private String[] rooms = {"101", "102", "103", "104", "105", "106"};
	private final MainFrame2 frame;
	
	/**
	 * Create the application.
	 */
	public TimeRoomGridPanel(MainFrame2 f) {
		frame = f;
		setLayout(new GridLayout(rooms.length+1, 25));
		pane = new JScrollPane(this);
		Dimension preferredSize = new Dimension(600,600);
		pane.setPreferredSize(preferredSize);
		JButton[][] grid = createGrid(rooms);
		for (int b = 0 ; b < rooms.length + 1 ; b++) {
			for (int a = 0 ; a < 17 ; a++) {
				add(grid[b][a]);
			}
		}
	}
	
	public JButton[][] createGrid(String[] rooms) {
		Font f = new Font("serif", Font.PLAIN, 18);
		JButton[][] grid = new JButton[rooms.length+1][17];
		grid[0][0] = new JButton("Back");
		grid[0][0].setBackground(Color.WHITE);
		grid[0][0].addActionListener(new BackButtonListener());
		
		//This loop creates the column of Rooms
		for (int k = 1 ; k <= rooms.length ; k++) {
			grid[k][0] = new JButton(rooms[k-1]);
			grid[k][0].setBackground(Color.LIGHT_GRAY);
			grid[k][0].setFont(f);
		}
		//This one is the row of times
		for (int y = 1 ; y < 17 ; y++) {
			String timeSlot = y+7 + ":00";
			grid[0][y] = new JButton(timeSlot);
			grid[0][y].setBackground(Color.LIGHT_GRAY);
			grid[0][y].setFont(f);
		}
		
		for (int j = 1 ; j <= rooms.length ; j++) {
			for (int i = 1 ; i < 17 ; i++) {
				grid[j][i] = new JButton(/*rooms[j-1]+" "+ (i+7)+":00"*/);
				grid[j][i].addActionListener(new MyActionListener());
				grid[j][i].setBackground(Color.GREEN);
			}
				/*if (rooms[j-1].isBooked() == false) {
					grid[i][j].setBackground(Color.GREEN);
				} else if (rooms[j-1].isBooked() == true) {
					grid[i][j].setBackground(Color.RED);
					grid[i][j].setEnabled(false)
				}*/	
		}
		
		//Border highlight = new LineBorder(Color.YELLOW, 2);
		grid[4][6].setBackground(Color.RED);
		grid[4][6].setEnabled(false);
		//grid[4][6].setBorder(thickBorder);
		grid[4][7].setBackground(Color.RED);
		grid[4][7].setEnabled(false);
		grid[4][8].setBackground(Color.RED);
		grid[4][8].setEnabled(false);
		grid[6][6].setBackground(Color.RED);
		grid[6][6].setEnabled(false);
		grid[1][1].setBackground(Color.RED);
		grid[1][1].setEnabled(false);
		grid[1][2].setBackground(Color.RED);
		grid[1][2].setEnabled(false);
		grid[1][3].setBackground(Color.RED);
		grid[1][3].setEnabled(false);
		grid[5][14].setBackground(Color.RED);
		grid[5][14].setEnabled(false);
		return grid;
	}
	
	private class MyActionListener implements ActionListener{
		@Override
        public void actionPerformed(ActionEvent e) {
            /*for (int r = 0 ; r < rooms.length ; r++) {
            	if (e.paramString().contains(rooms[r])) {
            		System.out.print(rooms[r]);
            	}
            }*/
        }
    }
	
	private class BackButtonListener implements ActionListener{
		@Override
        public void actionPerformed(ActionEvent e) {
            frame.back();
        }
    }
}
