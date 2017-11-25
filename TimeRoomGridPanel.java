import java.awt.EventQueue;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;

public class TimeRoomGridPanel extends JPanel{
	private JScrollPane pane;
	private String[] rooms = {"101", "102", "103", "104", "105", "106"};
	private final MainFrame2 frame;
	GridButton[][] grid;
	/**
	 * Create the application.
	 */
	public TimeRoomGridPanel(MainFrame2 f) {
		frame = f;
		setLayout(new GridLayout(rooms.length+1, 25));
		pane = new JScrollPane(this);
		Dimension preferredSize = new Dimension(600,600);
		pane.setPreferredSize(preferredSize);
		grid = createGrid(rooms);
		for (int b = 0 ; b < rooms.length + 1 ; b++) {
			for (int a = 0 ; a < 17 ; a++) {
				add(grid[b][a]);
			}
		}
	}
	
	public GridButton[][] createGrid(String[] rooms) {
		Font f = new Font("serif", Font.PLAIN, 18);
		GridButton[][] grid = new GridButton[rooms.length+1][17];
		grid[0][0] = new GridButton(0,0,"Back");
		grid[0][0].setBackground(Color.WHITE);
		//grid[0][0].addActionListener(new BackButtonListener(frame, frame.CALENDER_PANEL));
		
		//This loop creates the column of Rooms
		for (int k = 1 ; k <= rooms.length ; k++) {
			grid[k][0] = new GridButton(k,0,rooms[k-1]);
			grid[k][0].setBackground(Color.LIGHT_GRAY);
			grid[k][0].setActionCommand(String.valueOf(k));
			grid[k][0].addActionListener(new rowHighlight());
			grid[k][0].setFont(f);
		}
		//This one is the row of times
		for (int y = 1 ; y < 17 ; y++) {
			String timeSlot = y+7 + ":00";
			grid[0][y] = new GridButton(0,y,timeSlot);
			grid[0][y].setBackground(Color.LIGHT_GRAY);
			grid[0][y].setActionCommand(String.valueOf(y));
			grid[0][y].addActionListener(new colHighlight());
			grid[0][y].setFont(f);
		}
		
		for (int j = 1 ; j <= rooms.length ; j++) {
			for (int i = 1 ; i < 17 ; i++) {
				grid[j][i] = new GridButton(j,i/*rooms[j-1]+" "+ (i+7)+":00"*/);
				grid[j][i].setActionCommand(String.valueOf(grid[j][i].getXcoord() + " " + String.valueOf(grid[j][i].getYcoord())));
				grid[j][i].addActionListener(new GridListener());
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
	
	private class rowHighlight implements ActionListener{
		boolean isHighlighted = false;
        public void actionPerformed(ActionEvent e) {
			Border thickBorder = new LineBorder(Color.YELLOW, 2);
			Border removeBorder = new LineBorder(Color.GRAY, 1);
            System.out.println(e.getActionCommand());
            int row = Integer.parseInt(e.getActionCommand());
            if (isHighlighted == false) {
            	isHighlighted = true;
            	for (int rowH = 1 ; rowH < 17 ; rowH++) {
            		grid[row][rowH].setBorder(thickBorder);
            	}
            } else {
            	isHighlighted = false;
            	for (int rowH = 1 ; rowH < 17 ; rowH++) {
            		grid[row][rowH].setBorder(removeBorder);
            	}
            }
        }
	}
	
	private class colHighlight implements ActionListener{
		boolean isHighlighted = false;
        public void actionPerformed(ActionEvent e) {
			Border thickBorder = new LineBorder(Color.YELLOW, 2);
			Border removeBorder = new LineBorder(Color.GRAY, 1);
            System.out.println(e.getActionCommand());
            int col = Integer.parseInt(e.getActionCommand());
            if (isHighlighted == false) {
            	isHighlighted = true;
            	for (int colH = 1 ; colH < rooms.length+1 ; colH++) {
            		grid[colH][col].setBorder(thickBorder);
            	}
            } else {
            	isHighlighted = false;
            	for (int colH = 1 ; colH < rooms.length+1 ; colH++) {
            		grid[colH][col].setBorder(removeBorder);
            	}
            }
        }
	}
	
	private class GridListener implements ActionListener{
		@Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    }
	
	/*private class BackButtonListener implements ActionListener{
		@Override
        public void actionPerformed(ActionEvent e) {
            frame.back();
        }
    }
    */
}
