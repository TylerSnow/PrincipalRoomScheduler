//package projectGUI;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class Calender extends JPanel {
	
	//instatiates Calender, Table, Jlabel data types
	DefaultTableModel model;
	Calendar cal = new GregorianCalendar();
	JLabel label;
	JPanel mainPanel;
	JPanel panel;
	JPanel labelPanel;
	public JTable table;
	private final MainFrame2 frame;
	private int currFirstDay;
	
	//Calender Constructor
	public Calender(MainFrame2 frame){
		
		this.frame = frame;
		
	    //Buttons to change current view month
	    JButton prevMonth = new JButton("<");
	    prevMonth.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent evt) {
	    		cal.add(Calendar.MONTH, -1);
	            checkMonth();
	    	}
	    });
	    
	    JButton nextMonth = new JButton(">");
	    nextMonth.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent evt) {
	    		cal.add(Calendar.MONTH, +1);
	            checkMonth();
	    	}
	    });		
	    
	    //Generate Table for Calender
	    String [] columns = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	    //model = new DefaultTableModel(null,columns);
	    model = new DefaultTableModel(null, columns) {

	        @Override
	        public boolean isCellEditable(int row, int column) {
	           //all cells false
	           return false;
	        }
	    };

	    table = new JTable(model);
	    JScrollPane pane = new JScrollPane(table);
	    
	    //Event Listener that displays a list of the available rooms as a drop down when hovered over.
	    table.addMouseListener(new java.awt.event.MouseAdapter() {
	        @Override
	        public void mouseClicked(java.awt.event.MouseEvent evt) {
	            int row = table.rowAtPoint(evt.getPoint());
	            int col = table.columnAtPoint(evt.getPoint());
	            //System.out.println(table.getModel().getValueAt(row, col));
	            if (row >= 0 && col >= 0 && (table.getModel().getValueAt(row, col) != null)) {
	            	frame.showPanel(MainFrame2.GRID_PANEL, MainFrame2.CALENDER_PANEL);
	            }
	        }
	    });	    
	    
	    label = new JLabel();
	    this.checkMonth();
	    
	    //Creates JPanel,sets layout and adds the label and buttons to the panel
	    mainPanel = new JPanel();
	    panel = new JPanel();
	    labelPanel = new JPanel();
	    panel.setLayout(new BorderLayout());
	    labelPanel.add(prevMonth,BorderLayout.WEST);
		labelPanel.add(label,BorderLayout.CENTER);
	    labelPanel.add(nextMonth,BorderLayout.EAST);
	    panel.add(pane, BorderLayout.CENTER);	
	    
	    panel.add(labelPanel,BorderLayout.NORTH);
		mainPanel.add(panel);
	    add(mainPanel);
	}
	
	//Method to display drop down bar of stored information in rows and cols
	public void displayAvailableRooms(int row, int col) {
		System.out.println(row+""+col);
		
	}
	
	//Method that uses built in Gregorian Calender Java class to generate the schedule each month
	public void checkMonth() {
		cal.set(Calendar.DAY_OF_MONTH, 1); 
	    String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.CANADA);
	    int year = cal.get(Calendar.YEAR);
	    label.setText(month + " " + year);
	 
	    currFirstDay = cal.get(Calendar.DAY_OF_WEEK);
	    System.out.println(currFirstDay);
	    int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
	    //Clears the scheduler
	    model.setRowCount(0);
	    //Generates required amount of new rows for the current month 
	    model.setRowCount(weeks);
	 
	    int i = currFirstDay-1;
	    for(int day=1;day<=numberOfDays;day++){
	    	model.setValueAt(day, i/7 , i%7 );    
	    	i = i + 1;
	    }
	}
	
	//Main Method
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Calender schedule = new Calender(cards);
					//schedule.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
