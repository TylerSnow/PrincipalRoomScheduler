package roomGUI;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingConstants;

import java.awt.Font;

public class PrincipalLogin extends JPanel {
	private JPanel mainPanel;
	private JTextField textField;
	private JPasswordField passwordField;
	private final MainFrame2 frame;

	/**
	 * Create the panel.
	 */
	public PrincipalLogin(MainFrame2 f) {
		frame = f;
		mainPanel = new JPanel();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Principal Login");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.gridwidth = 2;
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 2;
		gbc_lblWelcome.gridy = 2;
		mainPanel.add(lblWelcome, gbc_lblWelcome);
		
		JLabel lblUsername = new JLabel(" Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 5;
		mainPanel.add(lblUsername, gbc_lblUsername);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 5;
		mainPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 6;
		mainPanel.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 6;
		mainPanel.add(passwordField, gbc_passwordField);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new BackButtonListener(frame));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 7;
		mainPanel.add(backButton, gbc_btnNewButton);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new NextButtonListener(frame));
		btnEnter.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnEnter = new GridBagConstraints();
		gbc_btnEnter.anchor = GridBagConstraints.EAST;
		gbc_btnEnter.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnter.gridx = 4;
		gbc_btnEnter.gridy = 7;
		mainPanel.add(btnEnter, gbc_btnEnter);
		
		EnterListener enterListener = new EnterListener(btnEnter);
		textField.addKeyListener(enterListener);
		passwordField.addKeyListener(enterListener);
		
		add(mainPanel);
	}
	
	public void reset() {
		textField.setText("");
		passwordField.setText("");
	}

}
