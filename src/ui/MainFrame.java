package ui;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import businessLogicLayer.Address;
import businessLogicLayer.Order;
import businessLogicLayer.User;
import dataAccessLayer.DBDriver;
import dataAccessLayer.ViewOrders;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static JPanel cardPanel;
	public static CardLayout cardLayout;
	
    public static ArrayList<businessLogicLayer.Component> wheels = DBDriver.extractDataWheels();
    public static ArrayList<businessLogicLayer.Component> handleBars = DBDriver.extractDataHandlebars();
    public static ArrayList<businessLogicLayer.Component> frameSets = DBDriver.extractDataFrameSets();

	public MainFrame(String title, ArrayList<User> users, ArrayList<businessLogicLayer.Component> frameSetList, ArrayList<businessLogicLayer.Component> handleBarSetList,
			ArrayList<businessLogicLayer.Component> wheelSetList) throws HeadlessException {
		
//		establishing metadata and positioning window
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setLocation(screenSize.width/4, screenSize.height/4);
//		setMinimumSize(new Dimension(screenSize.width/2, screenSize.height/2));
		
		Container contentPane = getContentPane();		
	
//		instantiating card panels and layout
		cardPanel = new JPanel();
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);
		
		contentPane.add(cardPanel, BorderLayout.CENTER);
		
//		create panel that holds the scroll panes to select bike components
		ComponentSelectPanel componentSelectScreen = new ComponentSelectPanel(frameSetList, handleBarSetList, wheelSetList);
		cardPanel.add(componentSelectScreen, "componentSelectScreen");

//		creates staff login panel
		StaffLogin staffLogin = new StaffLogin(users);
		cardPanel.add(staffLogin, "staffLogin");
		
//		staff landing page
		StaffPortal staffPortal = new StaffPortal();
		cardPanel.add(staffPortal, "staffPortal");
		
		setVisible(true);
		setResizable(false);
		pack();
	}

	public static void main(String[] args) throws SQLException {
		
//		load info from the database
        
        ArrayList<User> users = DBDriver.extractDataUsers();

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

        new MainFrame("Bike Builder", users, frameSets, handleBars, wheels).setSize(screenSize.width/2, screenSize.height/2);
    }
	
//	capitalises the first word of each string - makes presenting lowercase strings nicer
	public static String capitaliseString(String string) {
		  char[] charArray = string.toLowerCase().toCharArray();
		  boolean found = false;
		  for (int i = 0; i < charArray.length; i++) {
		    if (!found && Character.isLetter(charArray[i])) {
		    	charArray[i] = Character.toUpperCase(charArray[i]);
		      found = true;
		    } else if (Character.isWhitespace(charArray[i]) || charArray[i]=='.' || charArray[i]=='\'') {
			      found = false;
			    }
			  }
			  return String.valueOf(charArray);
		}	
	
//	checks to see if there exists a selected component of each type. If so, enable the basket button, if not, disable it
	public static void cartButton(Container sourceParent, boolean frame, boolean handlebar, boolean wheel) {
//		very long line but was the only way to get the header from the actionListener source
		JPanel headerSearch = (JPanel) sourceParent.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getComponent(0);
		if (frame == true && wheel == true && handlebar == true) {
			headerSearch.getComponent(3).setEnabled(true);
		} else {
			headerSearch.getComponent(3).setEnabled(false);
		}
	}
}
