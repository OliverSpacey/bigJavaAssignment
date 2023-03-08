package ui;

import javax.swing.JPanel;

import businessLogicLayer.ButtonToggle;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderThanks extends JPanel {
	private static final long serialVersionUID = 1L;

	public OrderThanks() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{31, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel header = new JPanel();
		GridBagConstraints gbc_header = new GridBagConstraints();
		gbc_header.fill = GridBagConstraints.HORIZONTAL;
		gbc_header.insets = new Insets(0, 0, 5, 0);
		gbc_header.gridx = 0;
		gbc_header.gridy = 0;
		add(header, gbc_header);
		
		JLabel lblNewLabel = new JLabel("Build-a-Bike Ltd.");
		header.add(lblNewLabel);
		
		JPanel body = new JPanel();
		GridBagConstraints gbc_body = new GridBagConstraints();
		gbc_body.fill = GridBagConstraints.HORIZONTAL;
		gbc_body.gridx = 0;
		gbc_body.gridy = 1;
		add(body, gbc_body);
		GridBagLayout gbl_body = new GridBagLayout();
		gbl_body.columnWidths = new int[]{114, 0};
		gbl_body.rowHeights = new int[]{13, 0, 0, 0};
		gbl_body.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_body.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		body.setLayout(gbl_body);
		
		JLabel lblNewLabel_1 = new JLabel("Thank you for your order");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		body.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Our staff will begin assembling your bike.");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		body.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Place New Order");
		btnNewButton.addActionListener(new ActionListener() {
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
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		body.add(btnNewButton, gbc_btnNewButton);
		
	}
}
