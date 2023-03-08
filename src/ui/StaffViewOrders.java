package ui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.print.attribute.standard.Chromaticity;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import businessLogicLayer.Address;
import businessLogicLayer.Bike;
import businessLogicLayer.Customer;
import businessLogicLayer.Order;
import dataAccessLayer.ViewOrders;

import java.awt.Color;
import javax.swing.JCheckBox;

public class StaffViewOrders extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static JPanel orderPanelList[];

	public StaffViewOrders() {
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
		gbl_header.columnWidths = new int[]{0, 0, 0, 0};
		gbl_header.rowHeights = new int[]{0, 0};
		gbl_header.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_header.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		header.setLayout(gbl_header);
		
		JButton Return = new JButton("Return");
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.cardLayout.show(MainFrame.cardPanel, "staffPortal");
			}
		});
		GridBagConstraints gbc_Return = new GridBagConstraints();
		gbc_Return.insets = new Insets(0, 0, 0, 5);
		gbc_Return.gridx = 0;
		gbc_Return.gridy = 0;
		header.add(Return, gbc_Return);
		
		JLabel headerTitle = new JLabel("Viewing All Orders");
		GridBagConstraints gbc_headerTitle = new GridBagConstraints();
		gbc_headerTitle.insets = new Insets(0, 0, 0, 5);
		gbc_headerTitle.gridx = 1;
		gbc_headerTitle.gridy = 0;
		header.add(headerTitle, gbc_headerTitle);
		
		JButton applyChanges = new JButton("Apply Changes");
		GridBagConstraints gbc_applyChanges = new GridBagConstraints();
		gbc_applyChanges.gridx = 2;
		gbc_applyChanges.gridy = 0;
		header.add(applyChanges, gbc_applyChanges);
		
		JPanel scrollPanelParent = new JPanel();
		GridBagConstraints gbc_scrollPanelParent = new GridBagConstraints();
		gbc_scrollPanelParent.fill = GridBagConstraints.BOTH;
		gbc_scrollPanelParent.gridx = 0;
		gbc_scrollPanelParent.gridy = 1;
		add(scrollPanelParent, gbc_scrollPanelParent);
		GridBagLayout gbl_scrollPanelParent = new GridBagLayout();
		gbl_scrollPanelParent.columnWidths = new int[]{0, 0};
		gbl_scrollPanelParent.rowHeights = new int[]{0, 0};
		gbl_scrollPanelParent.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_scrollPanelParent.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		scrollPanelParent.setLayout(gbl_scrollPanelParent);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		scrollPanelParent.add(scrollPane, gbc_scrollPane);
		
		
		JPanel orderPanel = new JPanel();
		scrollPane.setViewportView(orderPanel);
		
		ArrayList<Order> orderList = ViewOrders.viewOrders();
		
		orderPanelList = new JPanel[orderList.size()];
		generateOrderListPanels(orderPanelList, orderPanel, orderList);
		orderPanel.setLayout(new GridLayout(0, 1, 0, 0));
	}
	
	private void generateOrderListPanels(JPanel[] panelList, JPanel parent, ArrayList<Order> orderList) {
		for (int i = 0; i < orderList.size(); i++) {
			panelList[i] = new JPanel();
			panelList[i].setBorder(new LineBorder(new Color(0, 0, 0)));
			panelList[i].setLayout(new GridLayout(1, 8, 0, 0));
			
			Order dbOrder = orderList.get(i);
			
			Customer customer = dbOrder.customer;
			Address address = dbOrder.address;
			Bike bike = dbOrder.bike;
			
			
			JLabel customerName = new JLabel(MainFrame.capitaliseString(customer.forename) + " " +
					MainFrame.capitaliseString(customer.surname));
			GridBagConstraints gbc_customerName = new GridBagConstraints();
			gbc_customerName.fill = GridBagConstraints.VERTICAL;
			gbc_customerName.insets = new Insets(0, 0, 0, 5);
			gbc_customerName.gridx = 0;
			gbc_customerName.gridy = 0;
			panelList[i].add(customerName, gbc_customerName);
			
			JLabel lblNewLabel_1 = new JLabel(address.houseNum + " " + MainFrame.capitaliseString(address.streetName) + ", " + 
					MainFrame.capitaliseString(address.cityName) + ", " + address.postcode.toUpperCase());
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 50);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 0;
			panelList[i].add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("<HTML>Frame: " + bike.frameSet.brandName + " - " + bike.frameSet.productName +
					"<BR>Handlebar: " + bike.handlebar.brandName + " - " + bike.handlebar.productName + 
					"<BR>Wheels: " + bike.wheel.brandName + " - " + bike.wheel.productName);
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.gridx = 2;
			gbc_lblNewLabel_2.gridy = 0;
			panelList[i].add(lblNewLabel_2, gbc_lblNewLabel_2);
						
			JLabel lblNewLabel_5 = new JLabel("\u00A3" + bike.totalCost);
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_5.gridx = 5;
			gbc_lblNewLabel_5.gridy = 0;
			panelList[i].add(lblNewLabel_5, gbc_lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel(MainFrame.capitaliseString(dbOrder.status.name()));
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_6.gridx = 6;
			gbc_lblNewLabel_6.gridy = 0;
			panelList[i].add(lblNewLabel_6, gbc_lblNewLabel_6);
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("Confirm Order");
			GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
			gbc_chckbxNewCheckBox.fill = GridBagConstraints.VERTICAL;
			gbc_chckbxNewCheckBox.gridx = 7;
			gbc_chckbxNewCheckBox.gridy = 0;
			panelList[i].add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
			
		}
//		adds recursive panels to parent scroll pane
		for (int i = 0; i < panelList.length; i++) {
			parent.add(panelList[i]);
		}
	}
	
	
}
