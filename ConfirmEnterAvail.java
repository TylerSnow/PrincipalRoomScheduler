import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmEnterAvail extends JPanel {

	private final MainFrame2 frame;
	private JPanel mainPanel;
	
	/**
	 * Create the panel.
	 */
	public ConfirmEnterAvail(MainFrame2 f) {
		frame = f;
		mainPanel = new JPanel();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gridBagLayout);
		
		JLabel lblAvailabilityInformationEntered = new JLabel("Availability Information Entered");
		lblAvailabilityInformationEntered.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAvailabilityInformationEntered = new GridBagConstraints();
		gbc_lblAvailabilityInformationEntered.insets = new Insets(0, 0, 5, 5);
		gbc_lblAvailabilityInformationEntered.gridwidth = 3;
		gbc_lblAvailabilityInformationEntered.gridx = 4;
		gbc_lblAvailabilityInformationEntered.gridy = 2;
		mainPanel.add(lblAvailabilityInformationEntered, gbc_lblAvailabilityInformationEntered);
		
		JButton btnLogout = new JButton("Logout");
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogout.gridx = 4;
		gbc_btnLogout.gridy = 6;
		mainPanel.add(btnLogout, gbc_btnLogout);
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.home();
			}
		});
		
		JButton btnEnterNewInfo = new JButton("Enter New Info");
		GridBagConstraints gbc_btnEnterNewInfo = new GridBagConstraints();
		gbc_btnEnterNewInfo.insets = new Insets(0, 0, 0, 5);
		gbc_btnEnterNewInfo.gridx = 6;
		gbc_btnEnterNewInfo.gridy = 6;
		mainPanel.add(btnEnterNewInfo, gbc_btnEnterNewInfo);
		
		btnEnterNewInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.princAgain();
			}
		});

		add(mainPanel);
	}

}
