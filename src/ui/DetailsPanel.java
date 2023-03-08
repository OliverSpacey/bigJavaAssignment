package ui;

import javax.swing.*;

import businessLogicLayer.*;
import businessLogicLayer.Order.Status;
import dataAccessLayer.PlaceOrder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class DetailsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField forename;
	private JTextField surname;
	private JTextField houseNum;
	private JTextField street;
	private JTextField city;
	private JTextField postcode;
	private JTextField bikeName;
	
	private JTextField[] input = new JTextField[7];


	public DetailsPanel(Bike orderedBike) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{31, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel header = new JPanel();
		GridBagConstraints gbc_header = new GridBagConstraints();
		gbc_header.insets = new Insets(0, 0, 5, 0);
		gbc_header.fill = GridBagConstraints.HORIZONTAL;
		gbc_header.gridx = 0;
		gbc_header.gridy = 0;
		add(header, gbc_header);
		GridBagLayout gbl_header = new GridBagLayout();
		gbl_header.columnWidths = new int[]{0, 0, 0};
		gbl_header.rowHeights = new int[]{0, 0};
		gbl_header.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_header.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		header.setLayout(gbl_header);
		
//		enables user to still go back and change their mind before placing their order
		JButton btnNewButton_1 = new JButton("Edit Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.cardPanel, "componentSelectScreen");
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 0;
		header.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("Build-a-Bike Ltd.");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 0;
		header.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		setMaximumSize(new Dimension(screenSize.height/3, screenSize.width/3));
		
		JPanel detailsPane = new JPanel();
		GridBagConstraints gbc_detailsPane = new GridBagConstraints();
		gbc_detailsPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_detailsPane.gridx = 0;
		gbc_detailsPane.gridy = 1;
		add(detailsPane, gbc_detailsPane);
		GridBagLayout gbl_detailsPane = new GridBagLayout();
		gbl_detailsPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_detailsPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_detailsPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_detailsPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		detailsPane.setLayout(gbl_detailsPane);
		
		JLabel lblNewLabel = new JLabel("Forename:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 200, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		detailsPane.add(lblNewLabel, gbc_lblNewLabel);
		
		forename = new JTextField();
		GridBagConstraints gbc_forename = new GridBagConstraints();
		gbc_forename.insets = new Insets(0, 0, 5, 200);
		gbc_forename.fill = GridBagConstraints.HORIZONTAL;
		gbc_forename.gridx = 2;
		gbc_forename.gridy = 2;
		detailsPane.add(forename, gbc_forename);
		forename.setColumns(10);
		input[0] = forename;
		
		JLabel lblNewLabel_1 = new JLabel("Surname:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 200, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		detailsPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		surname = new JTextField();
		GridBagConstraints gbc_surname = new GridBagConstraints();
		gbc_surname.insets = new Insets(0, 0, 5, 200);
		gbc_surname.fill = GridBagConstraints.HORIZONTAL;
		gbc_surname.gridx = 2;
		gbc_surname.gridy = 3;
		detailsPane.add(surname, gbc_surname);
		surname.setColumns(10);
		input[1] = surname;
		
		JLabel lblNewLabel_2 = new JLabel("House Number:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 200, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 5;
		detailsPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		houseNum = new JTextField();
		GridBagConstraints gbc_houseNum = new GridBagConstraints();
		gbc_houseNum.insets = new Insets(0, 0, 5, 200);
		gbc_houseNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_houseNum.gridx = 2;
		gbc_houseNum.gridy = 5;
		detailsPane.add(houseNum, gbc_houseNum);
		houseNum.setColumns(10);
		input[2] = houseNum;
		
		JLabel lblNewLabel_3 = new JLabel("Street Name:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 200, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 6;
		detailsPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		street = new JTextField();
		GridBagConstraints gbc_street = new GridBagConstraints();
		gbc_street.insets = new Insets(0, 0, 5, 200);
		gbc_street.fill = GridBagConstraints.HORIZONTAL;
		gbc_street.gridx = 2;
		gbc_street.gridy = 6;
		detailsPane.add(street, gbc_street);
		street.setColumns(10);
		input[3] = street;
		
		JLabel lblNewLabel_4 = new JLabel("City:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 200, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 7;
		detailsPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		city = new JTextField();
		GridBagConstraints gbc_city = new GridBagConstraints();
		gbc_city.insets = new Insets(0, 0, 5, 200);
		gbc_city.fill = GridBagConstraints.HORIZONTAL;
		gbc_city.gridx = 2;
		gbc_city.gridy = 7;
		detailsPane.add(city, gbc_city);
		city.setColumns(10);
		input[4] = city;
		
		JLabel lblNewLabel_5 = new JLabel("Postcode:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 200, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 8;
		detailsPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		postcode = new JTextField();
		GridBagConstraints gbc_postcode = new GridBagConstraints();
		gbc_postcode.insets = new Insets(0, 0, 5, 200);
		gbc_postcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_postcode.gridx = 2;
		gbc_postcode.gridy = 8;
//		prevents postcode being too long
		postcode.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(KeyEvent evt) {
		        if(postcode.getText().length()>=7&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		detailsPane.add(postcode, gbc_postcode);
		postcode.setColumns(10);
		input[5] = postcode;
		
		JLabel lblNewLabel_6 = new JLabel("Name your bike:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 200, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 10;
		detailsPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		bikeName = new JTextField();
		GridBagConstraints gbc_bikeName = new GridBagConstraints();
		gbc_bikeName.insets = new Insets(0, 0, 5, 200);
		gbc_bikeName.fill = GridBagConstraints.HORIZONTAL;
		gbc_bikeName.gridx = 2;
		gbc_bikeName.gridy = 10;
//		prevents name being too long for the database
		bikeName.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(KeyEvent evt) {
		        if(bikeName.getText().length()>=25&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		detailsPane.add(bikeName, gbc_bikeName);
		bikeName.setColumns(10);
		input[6] = bikeName;
		
		JButton btnNewButton = new JButton("Place Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String[] name = new String[2];
				String[] inputAddress = new String[4];
				
//				strings all made lowercase to be entered into the database
				for (int i = 0; i < name.length; i ++) {
					name[i] = input[i].getText().toLowerCase();
				}
				
				for (int i = 0; i < inputAddress.length; i++) {
					inputAddress[i] = input[i+2].getText().toLowerCase();
				}
				
				Address address = new Address(inputAddress);
				Customer customer = new Customer(name[0], name[1], PlaceOrder.serialNumGen("Customer", "customerID"));

//				generate order object to go into database
				Order placedOrder = new Order(orderedBike, Status.PENDING, customer, address, bikeName.getText(), PlaceOrder.serialNumGen("`Order`", "orderNum"));
				PlaceOrder.placeOrder(placedOrder);
				
//				if order gets added to database successfully
				JPanel orderThanks = new OrderThanks();
				
				MainFrame.cardPanel.add(orderThanks,"orderThanks");
				MainFrame.cardLayout.show(MainFrame.cardPanel, "orderThanks");		
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 200);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 11;
		detailsPane.add(btnNewButton, gbc_btnNewButton);		
	}
	
	
}
