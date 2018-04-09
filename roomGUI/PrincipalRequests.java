package roomGUI;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import school.School;
import school.Semester;
import school.Request;

import java.awt.Color;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PrincipalRequests extends JPanel {

	private final MainFrame2 frame;
	private JPanel mainPanel;
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public PrincipalRequests(MainFrame2 f, String semester, String room) {
		frame = f;
		mainPanel = new JPanel();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		JLabel lblPrincipalRequests = new JLabel("Pending Requests");
		lblPrincipalRequests.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPrincipalRequests = new GridBagConstraints();
		gbc_lblPrincipalRequests.gridwidth = 4;
		gbc_lblPrincipalRequests.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrincipalRequests.gridx = 4;
		gbc_lblPrincipalRequests.gridy = 0;
		add(lblPrincipalRequests, gbc_lblPrincipalRequests);		
		
		ArrayList<Request> allPending = (ArrayList<Request>) School.getPendingRequests();
		ArrayList<Request> pendingInSemester = new ArrayList<>();
		for(int i = 0; i < allPending.size(); i++) {
			System.out.println("Hey: " + allPending.get(i).getRoom().getName().equals(room));
			if (allPending.get(i).getSemester() == Semester.toSem(semester)
					&& allPending.get(i).getRoom().getName().equals(room)) {
				//System.out.println(allPending.get(i).getApplicant().getGroup().getName());
				pendingInSemester.add(allPending.get(i));
			}
		}
		Object[] data = new String[pendingInSemester.size()];
		for(int i = 0; i < data.length; i++) {
			System.out.println(pendingInSemester.get(i).getApplicant().getGroup().getName());
			data[i] = pendingInSemester.get(i).toString();
		}
		
		JList list = new JList(data);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 3;
		gbc_list.gridwidth = 10;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 3;
		add(list, gbc_list);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new BackButtonListener(frame));
		GridBagConstraints gbc_btnDeny = new GridBagConstraints();
		gbc_btnDeny.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeny.gridx = 3;
		gbc_btnDeny.gridy = 7;
		add(btnBack, gbc_btnDeny);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() != null) {
					frame.viewRequest(pendingInSemester.get(list.getSelectedIndex()));
					
				}
			}
		});
		GridBagConstraints gbc_btnApprove = new GridBagConstraints();
		gbc_btnApprove.insets = new Insets(0, 0, 5, 5);
		gbc_btnApprove.gridx = 8;
		gbc_btnApprove.gridy = 7;
		add(btnView, gbc_btnApprove);

	}

}
