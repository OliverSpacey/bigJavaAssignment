package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import businessLogicLayer.Login;
import businessLogicLayer.User;

public class StaffLogin extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public static JTextField username;
	public static JPasswordField password;
	
	public static String staffID;

	public StaffLogin(ArrayList<User> users) {
		
		GridBagLayout gbl_staffLogin = new GridBagLayout();
		gbl_staffLogin.columnWidths = new int[]{348, 0};
		gbl_staffLogin.rowHeights = new int[]{31, 0, 0};
		gbl_staffLogin.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_staffLogin.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gbl_staffLogin);
		
		JPanel headerLogin = new JPanel();
		GridBagConstraints gbc_headerLogin = new GridBagConstraints();
		gbc_headerLogin.insets = new Insets(0, 0, 5, 0);
		gbc_headerLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_headerLogin.anchor = GridBagConstraints.NORTH;
		gbc_headerLogin.gridx = 0;
		gbc_headerLogin.gridy = 0;
		add(headerLogin, gbc_headerLogin);
		
		GridBagLayout gbl_headerLogin = new GridBagLayout();
		gbl_headerLogin.columnWidths = new int[]{105, 74, 99, 0};
		gbl_headerLogin.rowHeights = new int[]{21, 0};
		gbl_headerLogin.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_headerLogin.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		headerLogin.setLayout(gbl_headerLogin);
		
		JButton customerMode = new JButton("Customer Mode");
		customerMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.cardPanel, "componentSelectScreen");
			}
		});
		GridBagConstraints gbc_customerMode = new GridBagConstraints();
		gbc_customerMode.anchor = GridBagConstraints.WEST;
		gbc_customerMode.insets = new Insets(0, 0, 0, 5);
		gbc_customerMode.gridx = 0;
		gbc_customerMode.gridy = 0;
		headerLogin.add(customerMode, gbc_customerMode);
		
		JLabel lblNewLabel = new JLabel("Build-a-Bike Ltd.",SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		headerLogin.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Search Orders");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 0;
		headerLogin.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JPanel textFieldPanel = new JPanel();
		GridBagConstraints gbc_textFieldPanel = new GridBagConstraints();
		gbc_textFieldPanel.fill = GridBagConstraints.BOTH;
		gbc_textFieldPanel.gridx = 0;
		gbc_textFieldPanel.gridy = 1;
		add(textFieldPanel, gbc_textFieldPanel);
		
		GridBagLayout gbl_textFieldPanel = new GridBagLayout();
		gbl_textFieldPanel.columnWidths = new int[]{278, 186, 7, 0};
		gbl_textFieldPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_textFieldPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_textFieldPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		textFieldPanel.setLayout(gbl_textFieldPanel);
		
		Component verticalStrut = Box.createVerticalStrut(75);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		textFieldPanel.add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 300, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		textFieldPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		username = new JTextField();
		GridBagConstraints gbc_username = new GridBagConstraints();
		gbc_username.fill = GridBagConstraints.BOTH;
		gbc_username.insets = new Insets(0, 0, 5, 200);
		gbc_username.gridx = 1;
		gbc_username.gridy = 1;
		textFieldPanel.add(username, gbc_username);
		username.setColumns(20);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 300, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		textFieldPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		password = new JPasswordField();
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.fill = GridBagConstraints.BOTH;
		gbc_password.insets = new Insets(0, 0, 5, 200);
		gbc_password.gridx = 1;
		gbc_password.gridy = 2;
		textFieldPanel.add(password, gbc_password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				
//		        // converts password to string
//		        StringBuilder pass = new StringBuilder();
//		        for (Character ch : password.getPassword()) {
//		        	pass.append(ch);
//		        }
		        
				if (command.equals("Login")) {
					if (Login.login(username.getText(), password.getPassword(), users)) {
						staffID = username.getText();
						MainFrame.cardLayout.show(MainFrame.cardPanel, "staffPortal");
					} else {
//						resets inputs if credentials are incorrect
						username.setText("");
						password.setText("");
					}
						
				}
			}
		});
		
		
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 0, 200);
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 3;
		textFieldPanel.add(btnLogin, gbc_btnLogin);
	}
}
