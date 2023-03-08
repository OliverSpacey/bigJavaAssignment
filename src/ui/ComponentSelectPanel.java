package ui;

import java.awt.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

import businessLogicLayer.*;

public class ComponentSelectPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public static FrameSet selectedFrameSet;
	public static Handlebar selectedHandlebar;
	public static Wheel selectedWheel;
	
	public static JPanel[] frameSetPanelList;
	public static JPanel[] handlebarList;
	public static JPanel[] wheelsList;

	public ComponentSelectPanel(ArrayList<businessLogicLayer.Component> frameSetList, ArrayList<businessLogicLayer.Component> handleBarSetList,
			ArrayList<businessLogicLayer.Component> wheelSetList) {
		
		GridBagLayout selectScreenLayout = new GridBagLayout();
		selectScreenLayout.columnWidths = new int[]{754, 0};
		selectScreenLayout.rowHeights = new int[]{31, 345, 0};
		selectScreenLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		selectScreenLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(selectScreenLayout);
		
//		header creation
		JPanel header = new JPanel();
		GridBagConstraints headerConstraints = new GridBagConstraints();
		headerConstraints.fill = GridBagConstraints.HORIZONTAL;
		headerConstraints.insets = new Insets(0, 0, 5, 0);
		headerConstraints.gridx = 0;
		headerConstraints.gridy = 0;
		add(header, headerConstraints);
		
		GridBagLayout gbl_header = new GridBagLayout();
		gbl_header.columnWidths = new int[]{81, 74, 0, 99, 0};
		gbl_header.rowHeights = new int[]{31, 0};
		gbl_header.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_header.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		header.setLayout(gbl_header);
		
		// staff login button
		JButton staffLogin = new JButton("Staff Login");
		staffLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// resets text in login fields and staffID when showing panel
				StaffLogin.staffID = "";
				StaffLogin.username.setText("");
				StaffLogin.password.setText("");
				MainFrame.cardLayout.show(MainFrame.cardPanel, "staffLogin");	
			}
		});
		GridBagConstraints loginConstraints = new GridBagConstraints();
		loginConstraints.fill = GridBagConstraints.HORIZONTAL;
		loginConstraints.insets = new Insets(0, 0, 0, 5);
		loginConstraints.gridx = 0;
		loginConstraints.gridy = 0;
		header.add(staffLogin, loginConstraints);

		// title 		
		JLabel title = new JLabel("Build-a-Bike Ltd.");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints titleConstraints = new GridBagConstraints();
		titleConstraints.insets = new Insets(0, 0, 0, 5);
		titleConstraints.gridx = 1;
		titleConstraints.gridy = 0;
		header.add(title, titleConstraints);
		
		// search orders button
		JButton orderSearch = new JButton("Search Orders");
		GridBagConstraints searchConstraints = new GridBagConstraints();
		searchConstraints.insets = new Insets(0, 0, 0, 5);
		searchConstraints.gridx = 2;
		searchConstraints.gridy = 0;
		header.add(orderSearch, searchConstraints);
		
		// add to basket button
		JButton addToBasket = new JButton("Add To Basket");
		// disabled by default
		addToBasket.setEnabled(false);
		addToBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// passes selected components to order screen
				JPanel orderScreen = new OrderScreen(selectedFrameSet, selectedHandlebar, selectedWheel);
				MainFrame.cardPanel.add(orderScreen,"confirmOrderScreen");
				
				// adds actionListener to 'Edit Order' button
				JButton editOrderButton = (JButton) ((Container) orderScreen.getComponent(0)).getComponent(0);
				editOrderButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MainFrame.cardLayout.show(MainFrame.cardPanel, "componentSelectScreen");
					}
				});				
				
				MainFrame.cardLayout.show(MainFrame.cardPanel, "confirmOrderScreen");
			}
		});
		
		GridBagConstraints cartConstraints = new GridBagConstraints();
		cartConstraints.fill = GridBagConstraints.HORIZONTAL;
		cartConstraints.gridx = 3;
		cartConstraints.gridy = 0;
		header.add(addToBasket, cartConstraints);
		
//		tab pane parent
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{758, 0};
		gbl_panel.rowHeights = new int[]{359, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
			
//		tab pane creation
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		panel.add(tabbedPane, gbc_tabbedPane);
	
//		frame-sets -- first tab
		JPanel frameSets = new JPanel();
		tabbedPane.addTab("Frame-Sets", null, frameSets, null);
		GridBagLayout gbl_frameSets = new GridBagLayout();
		gbl_frameSets.columnWidths = new int[]{732, 0};
		gbl_frameSets.rowHeights = new int[]{238, 0};
		gbl_frameSets.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_frameSets.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frameSets.setLayout(gbl_frameSets);
		
		JScrollPane frameSetScrollPane = new JScrollPane();
		// increase scrolling speed, was incredibly slow
		frameSetScrollPane.getVerticalScrollBar().setUnitIncrement(12);
		frameSetScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frameSetScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_frameSetScrollPane = new GridBagConstraints();
		gbc_frameSetScrollPane.fill = GridBagConstraints.BOTH;
		gbc_frameSetScrollPane.gridx = 0;
		gbc_frameSetScrollPane.gridy = 0;
		frameSets.add(frameSetScrollPane, gbc_frameSetScrollPane);
		
		// scroll tab child
		JPanel framesetPanel = new JPanel();
		frameSetScrollPane.setViewportView(framesetPanel);
		framesetPanel.setLayout(new GridLayout(0, 4, 3, 5));		

//		create frame-set panels
		frameSetPanelList = new JPanel[frameSetList.size()];
		generateComponentPanels(frameSetPanelList, framesetPanel, frameSetList);
		
		JPanel handlebars = new JPanel();
		tabbedPane.addTab("Handlebars", null, handlebars, null);
		GridBagLayout gbl_handlebars = new GridBagLayout();
		gbl_handlebars.columnWidths = new int[]{732, 0};
		gbl_handlebars.rowHeights = new int[]{315, 0};
		gbl_handlebars.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_handlebars.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		handlebars.setLayout(gbl_handlebars);
		
		JScrollPane handlebarScrollPane = new JScrollPane();
		handlebarScrollPane.getVerticalScrollBar().setUnitIncrement(12);
		handlebarScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_handlebarScrollPane = new GridBagConstraints();
		gbc_handlebarScrollPane.fill = GridBagConstraints.BOTH;
		gbc_handlebarScrollPane.gridx = 0;
		gbc_handlebarScrollPane.gridy = 0;
		handlebars.add(handlebarScrollPane, gbc_handlebarScrollPane);
		
		JPanel handlebarPanel = new JPanel();
		handlebarScrollPane.setViewportView(handlebarPanel);
		handlebarPanel.setLayout(new GridLayout(0, 4, 3, 5));
	
//		create handlebar panels
		handlebarList = new JPanel[handleBarSetList.size()];		
		generateComponentPanels(handlebarList, handlebarPanel, handleBarSetList);
		
		JPanel wheels = new JPanel();
		tabbedPane.addTab("Wheels", null, wheels, null);
		GridBagLayout gbl_wheels = new GridBagLayout();
		gbl_wheels.columnWidths = new int[]{732, 0};
		gbl_wheels.rowHeights = new int[]{315, 0};
		gbl_wheels.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_wheels.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		wheels.setLayout(gbl_wheels);
		
		JScrollPane wheelsScrollPane = new JScrollPane();
		wheelsScrollPane.getVerticalScrollBar().setUnitIncrement(12);
		wheelsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_wheelsScrollPane = new GridBagConstraints();
		gbc_wheelsScrollPane.fill = GridBagConstraints.BOTH;
		gbc_wheelsScrollPane.gridx = 0;
		gbc_wheelsScrollPane.gridy = 0;
		wheels.add(wheelsScrollPane, gbc_wheelsScrollPane);
		
		JPanel wheelsPanel = new JPanel();
		wheelsScrollPane.setViewportView(wheelsPanel);
		wheelsPanel.setLayout(new GridLayout(0, 4, 3, 5));

//		create wheel panels
		wheelsList = new JPanel[wheelSetList.size()];
		generateComponentPanels(wheelsList, wheelsPanel, wheelSetList);
	}
	
	private void generateComponentPanels(JPanel[] panelList, JPanel parent, ArrayList<businessLogicLayer.Component> componentList) {		
		// get array type
		String type = componentList.get(0).getClass().getSimpleName();

		for (int i = 0; i < componentList.size(); i++) {
			panelList[i] = new JPanel();
			panelList[i].setBorder(new LineBorder(new Color(0, 0, 0)));
			
			GridBagLayout gbl_x = new GridBagLayout();
			gbl_x.columnWidths = new int[]{61, 0};
			gbl_x.rowHeights = new int[]{13, 13, 13, 13, 13, 21, 21, 0};
			gbl_x.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_x.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
			panelList[i].setLayout(gbl_x);

			businessLogicLayer.Component dbComponent = componentList.get(i);
			
			ImageIcon icon = null;
			FrameSet dbComponentFS = null;
			Handlebar dbComponentHB = null;
			Wheel dbComponentWH = null;
			
			// sets icon
			// icon is for illustrative purposes only. we know the same picture is shown for every component
			if (type.equals("FrameSet")) {
				icon = new ImageIcon("././images/frameset.jpg");				
			} else if (type.equals("Handlebar")) {			
				icon = new ImageIcon("././images/handlebar.jpg");	
			} else if (type.equals("Wheel")) {
				icon = new ImageIcon("././images/wheel.jpg");	
			}	
			
			JLabel image = new JLabel(icon);
			GridBagConstraints gbc_image = new GridBagConstraints();
			gbc_image.fill = GridBagConstraints.BOTH;
			gbc_image.insets = new Insets(0, 0, 5, 0);
			gbc_image.gridx = 0;
			gbc_image.gridy = 0;
			panelList[i].add(image, gbc_image);
			
			// print common info
			JLabel name = new JLabel("<HTML>" + dbComponent.brandName  + ":<BR>" + dbComponent.productName + "<HTML>");
			GridBagConstraints gbc_name = new GridBagConstraints();
			gbc_name.fill = GridBagConstraints.HORIZONTAL;
			gbc_name.insets = new Insets(0, 5, 5, 0);
			gbc_name.gridx = 0;
			gbc_name.gridy = 1;
			panelList[i].add(name, gbc_name);
			
			JLabel cost = new JLabel("\u00A3" + dbComponent.unitCost);
			GridBagConstraints gbc_cost = new GridBagConstraints();
			gbc_cost.fill = GridBagConstraints.HORIZONTAL;
			gbc_cost.insets = new Insets(0, 5, 5, 0);
			gbc_cost.gridx = 0;
			gbc_cost.gridy = 2;
			panelList[i].add(cost, gbc_cost);
			

			if (type.equals("FrameSet")) {
				// frameset specific details
				dbComponentFS = (FrameSet) componentList.get(i);
				
				JLabel size = new JLabel("Size: " + dbComponentFS.size + "cm");
				GridBagConstraints gbc_size = new GridBagConstraints();
				gbc_size.fill = GridBagConstraints.HORIZONTAL;
				gbc_size.insets = new Insets(0, 5, 5, 0);
				gbc_size.gridx = 0;
				gbc_size.gridy = 3;
				panelList[i].add(size, gbc_size);
				
				JLabel frame = new JLabel("Frame: " + dbComponentFS.frame);
				GridBagConstraints gbc_frame = new GridBagConstraints();
				gbc_frame.fill = GridBagConstraints.HORIZONTAL;
				gbc_frame.insets = new Insets(0, 5, 5, 0);
				gbc_frame.gridx = 0;
				gbc_frame.gridy = 4;
				panelList[i].add(frame, gbc_frame);
				
				JLabel forks = new JLabel("Forks: " + dbComponentFS.forks);
				GridBagConstraints gbc_forks = new GridBagConstraints();
				gbc_forks.fill = GridBagConstraints.HORIZONTAL;
				gbc_forks.insets = new Insets(0, 5, 5, 0);
				gbc_forks.gridx = 0;
				gbc_forks.gridy = 5;
				panelList[i].add(forks, gbc_forks);
				
				JLabel shocks = new JLabel("Shocks: " + FrameSet.parseShocks(dbComponentFS.shocks));
				GridBagConstraints gbc_shocks = new GridBagConstraints();
				gbc_shocks.fill = GridBagConstraints.HORIZONTAL;
				gbc_shocks.insets = new Insets(0, 5, 5, 0);
				gbc_shocks.gridx = 0;
				gbc_shocks.gridy = 6;
				panelList[i].add(shocks, gbc_shocks);
				
			} else if (type.equals("Handlebar")) {		
				// handlebar specific info
				dbComponentHB = (Handlebar) componentList.get(i);	
				
				JLabel style = new JLabel("Style: " + MainFrame.capitaliseString(dbComponentHB.style.toString()));
				GridBagConstraints gbc_style = new GridBagConstraints();
				gbc_style.fill = GridBagConstraints.HORIZONTAL;
				gbc_style.insets = new Insets(0, 5, 5, 0);
				gbc_style.gridx = 0;
				gbc_style.gridy = 3;
				panelList[i].add(style, gbc_style);
				
			} else if (type.equals("Wheel")) {
				// wheel specific info
				dbComponentWH = (Wheel) componentList.get(i);
				
				JLabel diameter = new JLabel("Diameter: " + dbComponentWH.diameter + "cm");
				GridBagConstraints gbc_size = new GridBagConstraints();
				gbc_size.fill = GridBagConstraints.HORIZONTAL;
				gbc_size.insets = new Insets(0, 5, 5, 0);
				gbc_size.gridx = 0;
				gbc_size.gridy = 3;
				panelList[i].add(diameter, gbc_size);
				
				JLabel tyreStyle = new JLabel("Style: " + MainFrame.capitaliseString(dbComponentWH.tyreStyle.toString()));
				GridBagConstraints gbc_tyres = new GridBagConstraints();
				gbc_tyres.fill = GridBagConstraints.HORIZONTAL;
				gbc_tyres.insets = new Insets(0, 5, 5, 0);
				gbc_tyres.gridx = 0;
				gbc_tyres.gridy = 4;
				panelList[i].add(tyreStyle, gbc_tyres);
				
				JLabel brakeStyle = new JLabel("Brakes: " + MainFrame.capitaliseString(dbComponentWH.brakeStyle.toString()));
				GridBagConstraints gbc_brakes = new GridBagConstraints();
				gbc_brakes.fill = GridBagConstraints.HORIZONTAL;
				gbc_brakes.insets = new Insets(0, 5, 5, 0);
				gbc_brakes.gridx = 0;
				gbc_brakes.gridy = 5;
				panelList[i].add(brakeStyle, gbc_brakes);
			}
			
			JToggleButton addToOrder = new JToggleButton("Select");
			GridBagConstraints gbc_addToOrder = new GridBagConstraints();
			gbc_addToOrder.fill = GridBagConstraints.HORIZONTAL;
			gbc_addToOrder.gridx = 0;
			gbc_addToOrder.gridy = 7;
			panelList[i].add(addToOrder, gbc_addToOrder);
			addToOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Component source = (Component)e.getSource();
					AbstractButton abstractButton = (AbstractButton) source;
					Container sourceParent = source.getParent();
					
					// returns true for specific button that is selected
					boolean selected = abstractButton.getModel().isSelected();
					
					Object selectedComponent = dbComponent;
					if (selected) {
						// stores selected component to be added to the order
						if (type.equals("FrameSet")) {
							selectedFrameSet = (FrameSet) selectedComponent;				
						} else if (type.equals("Handlebar")) {			
							selectedHandlebar = (Handlebar) selectedComponent;		
						} else if (type.equals("Wheel")) {
							selectedWheel = (Wheel) selectedComponent;		
						}
						
						// disables toggle buttons in other panels
						ButtonToggle.disableButtons(panelList, sourceParent);
					}
					else {
						// removes frameSet from selection and re-enables buttons
						if (type.equals("FrameSet")) {
							if (selectedFrameSet != null)
								selectedFrameSet = null;			
						} else if (type.equals("Handlebar")) {
							if (selectedHandlebar != null)
								selectedHandlebar = null;			
						} else if (type.equals("Wheel")) {
							if (selectedWheel != null)
								selectedWheel = null;				
						}
						ButtonToggle.enableButtons(panelList);
					}

					// checks to see if add to basket button should be enabled
					MainFrame.cartButton(sourceParent, selectedFrameSet != null, selectedHandlebar != null, selectedWheel != null);					
				}			
			});
		}

//		adds recursive panels to parent scroll pane
		for (int i = 0; i < panelList.length; i++) {
			parent.add(panelList[i]);
		}
	}
}
