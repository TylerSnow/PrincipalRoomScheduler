package projectGUI;

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
	//Calender Constructor
	public Calender(){
	    
	    label = new JLabel();
	    
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
	    //Creates JPanel,sets layout and adds the label and buttons to the panel
	    JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout());
	    panel.add(prevMonth,BorderLayout.WEST);
	    panel.add(nextMonth,BorderLayout.EAST);
	    panel.add(label,BorderLayout.CENTER);
		
	    
	    //Generate Table for Calender
	    String [] columns = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	    model = new DefaultTableModel(null,columns);
	    JTable table = new JTable(model);
	    JScrollPane pane = new JScrollPane(table);
		panel.add(pane, BorderLayout.CENTER);	    	   
	    this.add(panel);
	    //Event Listener that displays a list of the available rooms as a drop down when hovered over.
	    table.addMouseListener(new java.awt.event.MouseAdapter() {
	        @Override
	        public void mouseClicked(java.awt.event.MouseEvent evt) {
	            int row = table.rowAtPoint(evt.getPoint());
	            int col = table.columnAtPoint(evt.getPoint());
	            if (row >= 0 && col >= 0) {
	                displayAvailableRooms(row,col);
					panel.setVisible(false)
					TimeRoomGridPane trgPane = new TimeRoomGridPane(this);
	            }
	        }
	    });	    
	    this.checkMonth();
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
	 
	    int firstDay = cal.get(Calendar.DAY_OF_WEEK);
	    int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	    int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
	    //Clears the scheduler
	    model.setRowCount(0);
	    //Generates required amount of new rows for the current month 
	    model.setRowCount(weeks);
	 
	    int i = firstDay-1;
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
					Calender schedule = new Calender();
					schedule.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
