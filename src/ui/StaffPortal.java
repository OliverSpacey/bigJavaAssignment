package ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import businessLogicLayer.ButtonToggle;

public class StaffPortal extends JPanel {
	private static final long serialVersionUID = 1L;

	public StaffPortal() {
		GridBagLayout gbl_staffPortal = new GridBagLayout();
		gbl_staffPortal.columnWidths = new int[] {0};
		gbl_staffPortal.rowHeights = new int[] {31, 31};
		gbl_staffPortal.columnWeights = new double[]{1.0};
		gbl_staffPortal.rowWeights = new double[]{0.0, 1.0};
		setLayout(gbl_staffPortal);
		
		JPanel headerPortal = new JPanel();
		GridBagConstraints gbc_headerPortal = new GridBagConstraints();
		gbc_headerPortal.anchor = GridBagConstraints.NORTH;
		gbc_headerPortal.insets = new Insets(0, 0, 5, 0);
		gbc_headerPortal.fill = GridBagConstraints.HORIZONTAL;
		gbc_headerPortal.gridx = 0;
		gbc_headerPortal.gridy = 0;
		add(headerPortal, gbc_headerPortal);
		
		GridBagLayout gbl_headerPortal = new GridBagLayout();
		gbl_headerPortal.columnWidths = new int[] {105, 0, 0};
		gbl_headerPortal.rowHeights = new int[]{0, 0};
		gbl_headerPortal.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_headerPortal.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		headerPortal.setLayout(gbl_headerPortal);
		
		JButton customerMode2 = new JButton("Customer Mode");
		customerMode2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				reset selected components and reset the component screens
				ComponentSelectPanel.selectedFrameSet = null;
				ComponentSelectPanel.selectedHandlebar = null;
				ComponentSelectPanel.selectedWheel = null;
				ButtonToggle.enableButtons(ComponentSelectPanel.frameSetPanelList);
				ButtonToggle.enableButtons(ComponentSelectPanel.handlebarList);
				ButtonToggle.enableButtons(ComponentSelectPanel.wheelsList);
//				disable checkout buttons
				Component header = ((Container) MainFrame.cardPanel.getComponent(0)).getComponent(0);
				Component checkoutButton = ((Container) header).getComponent(((Container) header).getComponentCount()-1);
				checkoutButton.setEnabled(false);
				MainFrame.cardLayout.show(MainFrame.cardPanel, "componentSelectScreen");
			}
		});
		GridBagConstraints gbc_customerMode2 = new GridBagConstraints();
		gbc_customerMode2.insets = new Insets(0, 0, 0, 5);
		gbc_customerMode2.gridx = 0;
		gbc_customerMode2.gridy = 0;
		headerPortal.add(customerMode2, gbc_customerMode2);
		
		JLabel lblNewLabel_3 = new JLabel("Build-a-Bike Ltd. Staff Portal");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 0;
		headerPortal.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton_1 = new JButton("Add Stock");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(staffID[0]);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 9;
		gbc_btnNewButton_1.gridy = 3;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("View Orders");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel orderListStaff = new StaffViewOrders();
				MainFrame.cardPanel.add(orderListStaff,"orderListStaff");
				MainFrame.cardLayout.show(MainFrame.cardPanel, "orderListStaff");
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 10;
		gbc_btnNewButton_4.gridy = 3;
		panel_1.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Remove Stock");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 9;
		gbc_btnNewButton_3.gridy = 4;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("View Customers");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_5.gridx = 10;
		gbc_btnNewButton_5.gridy = 4;
		panel_1.add(btnNewButton_5, gbc_btnNewButton_5);
	}
}
