package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.LineBorder;

import businessLogicLayer.*;
import java.awt.Color;

public class OrderScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public OrderScreen(FrameSet frame, Handlebar handlebar, Wheel wheel) {
		GridBagLayout gbl_orderPanel = new GridBagLayout();
		gbl_orderPanel.columnWidths = new int[]{605, 0};
		gbl_orderPanel.rowHeights = new int[]{31, 0, 0};
		gbl_orderPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_orderPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gbl_orderPanel);
		
		JPanel headerOrder = new JPanel();
		GridBagConstraints gbc_headerOrder = new GridBagConstraints();
		gbc_headerOrder.anchor = GridBagConstraints.NORTH;
		gbc_headerOrder.insets = new Insets(0, 0, 5, 0);
		gbc_headerOrder.gridx = 0;
		gbc_headerOrder.gridy = 0;
		add(headerOrder, gbc_headerOrder);
		GridBagLayout gbl_headerOrder = new GridBagLayout();
		gbl_headerOrder.columnWidths = new int[]{0, 331, 0, 0};
		gbl_headerOrder.rowHeights = new int[]{0, 0};
		gbl_headerOrder.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_headerOrder.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		headerOrder.setLayout(gbl_headerOrder);
		
		JButton editOrder = new JButton("Edit Order");
		GridBagConstraints gbc_editOrder = new GridBagConstraints();
		gbc_editOrder.anchor = GridBagConstraints.WEST;
		gbc_editOrder.insets = new Insets(0, 0, 0, 5);
		gbc_editOrder.gridx = 0;
		gbc_editOrder.gridy = 0;
		headerOrder.add(editOrder, gbc_editOrder);
		
		JLabel lblNewLabel_4 = new JLabel("Build-a-Bike Ltd.");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 0;
		headerOrder.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{97, 177, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Your Order:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 0;
		panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel chosenFrameSet = new JLabel("Frame-Set:");
		GridBagConstraints gbc_chosenFrameSet = new GridBagConstraints();
		gbc_chosenFrameSet.anchor = GridBagConstraints.EAST;
		gbc_chosenFrameSet.insets = new Insets(0, 0, 5, 5);
		gbc_chosenFrameSet.gridx = 0;
		gbc_chosenFrameSet.gridy = 1;
		panel_4.add(chosenFrameSet, gbc_chosenFrameSet);
		
		JLabel lblNewLabel_6 = new JLabel("1x " + MainFrame.capitaliseString(frame.brandName) + " " + MainFrame.capitaliseString(frame.productName));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 1;
		panel_4.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel frameSetCostLabel = new JLabel("Price: 1x \u00A3 " + frame.unitCost);
		GridBagConstraints gbc_frameSetCostLabel = new GridBagConstraints();
		gbc_frameSetCostLabel.anchor = GridBagConstraints.WEST;
		gbc_frameSetCostLabel.insets = new Insets(0, 0, 5, 0);
		gbc_frameSetCostLabel.gridx = 2;
		gbc_frameSetCostLabel.gridy = 1;
		panel_4.add(frameSetCostLabel, gbc_frameSetCostLabel);
		
		JLabel chosenHandlebar = new JLabel("Handlebars:");
		GridBagConstraints gbc_chosenHandlebar = new GridBagConstraints();
		gbc_chosenHandlebar.anchor = GridBagConstraints.EAST;
		gbc_chosenHandlebar.insets = new Insets(0, 0, 5, 5);
		gbc_chosenHandlebar.gridx = 0;
		gbc_chosenHandlebar.gridy = 2;
		panel_4.add(chosenHandlebar, gbc_chosenHandlebar);
		
		JLabel lblNewLabel_7 = new JLabel("1x " + MainFrame.capitaliseString(handlebar.brandName) + " " + MainFrame.capitaliseString(handlebar.productName)); // 
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 2;
		panel_4.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_3 = new JLabel("Price: 1x \u00A3 " + handlebar.unitCost);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 2;
		panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel chosenWheels = new JLabel("Wheels:");
		GridBagConstraints gbc_chosenWheels = new GridBagConstraints();
		gbc_chosenWheels.anchor = GridBagConstraints.EAST;
		gbc_chosenWheels.insets = new Insets(0, 0, 5, 5);
		gbc_chosenWheels.gridx = 0;
		gbc_chosenWheels.gridy = 3;
		panel_4.add(chosenWheels, gbc_chosenWheels);
		
		JLabel lblNewLabel_8 = new JLabel("2x " + MainFrame.capitaliseString(wheel.brandName) + " " + MainFrame.capitaliseString(wheel.productName));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 3;
		panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Price: 2x \u00A3 " + wheel.unitCost);
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 3;
		panel_4.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JLabel assemblyCostLabel = new JLabel("Assembly Charge:");
		GridBagConstraints gbc_assemblyCostLabel = new GridBagConstraints();
		gbc_assemblyCostLabel.anchor = GridBagConstraints.EAST;
		gbc_assemblyCostLabel.insets = new Insets(0, 0, 5, 5);
		gbc_assemblyCostLabel.gridx = 0;
		gbc_assemblyCostLabel.gridy = 4;
		panel_4.add(assemblyCostLabel, gbc_assemblyCostLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1x");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_10 = new JLabel("Price: 1x \u00A310.00");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 2;
		gbc_lblNewLabel_10.gridy = 4;
		panel_4.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
//		formats price to 2 d.p to be displayed more nicely
		double totalCost = frame.unitCost + 2*wheel.unitCost + handlebar.unitCost;
		DecimalFormat printCost = new DecimalFormat("##.00");

		JLabel lblNewLabel = new JLabel("Total Cost:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 5;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_11 = new JLabel("          \u00A3" + printCost.format(totalCost));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 2;
		gbc_lblNewLabel_11.gridy = 5;
		panel_4.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		JButton makeOrderButton = new JButton("Place Order");
		GridBagConstraints gbc_makeOrderButton = new GridBagConstraints();
		gbc_makeOrderButton.gridx = 2;
		gbc_makeOrderButton.gridy = 6;
		makeOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				creates bike as an object
				Bike orderedBike = new Bike(wheel, handlebar, frame);
				
				JPanel customerDetails = new DetailsPanel(orderedBike);
				MainFrame.cardPanel.add(customerDetails,"customerDetailsPanel");
				
				MainFrame.cardLayout.show(MainFrame.cardPanel, "customerDetailsPanel");
			}
		});
		panel_4.add(makeOrderButton, gbc_makeOrderButton);
		
//		setVisible(true);
	}
}
