package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import businessLogicLayer.Address;
import businessLogicLayer.Bike;
import businessLogicLayer.Component;
import businessLogicLayer.Customer;
import businessLogicLayer.FrameSet;
import businessLogicLayer.Handlebar;
import businessLogicLayer.Order;
import businessLogicLayer.Wheel;
import ui.MainFrame;

public class ViewOrders extends DBDriver{
	
	
	
	public static ArrayList<Customer> getCustomers(){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Customer customer;
		try (Connection con = DriverManager.getConnection(URL + DBNAME, getProps()); Statement stmt = con.createStatement();) {
			String SQL = "SELECT * FROM `Customer`";
		    ResultSet rs = stmt.executeQuery(SQL);
		        
		    while(rs.next()) {
		    	customer = new Customer(rs.getString("forename"), rs.getString("surname"), rs.getInt("customerID"));
		    	customers.add(customer);
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customers;
	}
	
	
	public static ArrayList<Address> getAddresses(){
		ArrayList<Address> addresses = new ArrayList<Address>();
		Address address;
		String[] addressArray = new String[4];
		
		try (Connection con = DriverManager.getConnection(URL + DBNAME, getProps()); Statement stmt = con.createStatement();) {
		    String SQL = "SELECT * FROM `Address`";
		    ResultSet rs = stmt.executeQuery(SQL);
		        
		    while(rs.next()) {
		        addressArray[0] = String.valueOf(rs.getInt("houseNum"));
		        addressArray[1] = rs.getString("roadName");
		        addressArray[2] = rs.getString("cityName");
		        addressArray[3] = rs.getString("postCode");
		        address = new Address(addressArray);
		        addresses.add(address);
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addresses;
		
	}

	
	public static Address getAddressFromCID(int cid) {
		ArrayList<Address> addressList = getAddresses();
		Address address = null;
		String postcode = "";
		int houseNum = 0;

		try (Connection con = DriverManager.getConnection(URL + DBNAME, getProps()); Statement stmt = con.createStatement();) {
	    	String SQL = "SELECT * FROM `Customer` WHERE CustomerID = "+cid;
	        ResultSet rs = stmt.executeQuery(SQL);
	        rs.next();
	        postcode = rs.getString("postCode");
	        houseNum = rs.getInt("houseNum");
	        rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i<addressList.size(); i++) {
			if(houseNum == addressList.get(i).houseNum && postcode.equals(addressList.get(i).postcode)) {
				address = addressList.get(i);
			}
		}
		
		return address;
	}
	
	
	public static Customer getCustomerFromCID(int cid) {
		Customer customer = null;
		ArrayList<Customer> customerList = getCustomers(); 
		
		for(int i = 0; i<customerList.size();i++) {
			if (customerList.get(i).customerID == cid) {
				customer = customerList.get(i);
			}
		}
		
		return customer;
	}
	
	
	public static Bike getBikeFromNum(int num) {
		Bike bike = null;
		int wheelSerial;
		int handlebarSerial;
		int frameSetSerial;
		
		
		try (Connection con = DriverManager.getConnection(URL + DBNAME, getProps()); Statement stmt = con.createStatement();) {
	    	String SQL = "SELECT * FROM `Bicycle` WHERE orderNum = "+num;
	        ResultSet rs = stmt.executeQuery(SQL);
	        rs.next();
	        wheelSerial = rs.getInt("wheel");
	        handlebarSerial = rs.getInt("handlebar");
	        frameSetSerial = rs.getInt("frameSet");
	        
	        bike = new Bike(getWheelFromSerial(wheelSerial), getHandlebarFromSerial(handlebarSerial), getFrameSetFromSerial(frameSetSerial));
	        rs.close();
	        return bike;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bike;
	}
	
	public static Wheel getWheelFromSerial(int serial) {
		Wheel wheel = null;
		ArrayList<Component> wheels = MainFrame.wheels;
		
		for(int i = 0; i<wheels.size(); i++) {
			if(wheels.get(i).serialNum == serial) {
				wheel = (Wheel) wheels.get(i);
			}
		}
		
		return wheel;
	}
	
	public static Handlebar getHandlebarFromSerial(int serial) {
		Handlebar handlebar = null;
		ArrayList<Component> handlebars = MainFrame.handleBars;
		
		for(int i = 0; i<handlebars.size(); i++) {
			if(handlebars.get(i).serialNum == serial) {
				handlebar = (Handlebar) handlebars.get(i);
			}
		}
		
		return handlebar;
	}
		
	
	public static FrameSet getFrameSetFromSerial(int serial) {
		FrameSet frameSet = null;
		ArrayList<Component> frameSets = MainFrame.frameSets;
		
		for(int i = 0; i<frameSets.size(); i++) {
			if(frameSets.get(i).serialNum == serial) {
				frameSet = (FrameSet) frameSets.get(i);
			}
		}
		
		return frameSet;
	}
		
	
	public static String getBikeNameFromNum(int num) {
		String bikeName="";
		
		try (Connection con = DriverManager.getConnection(URL + DBNAME, getProps()); Statement stmt = con.createStatement();) {
	    	String SQL = "SELECT * FROM `Bicycle` WHERE orderNum = "+num;
	        ResultSet rs = stmt.executeQuery(SQL);
	        rs.next();
	        bikeName = rs.getString("customName");
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bikeName;
		
	}
	
	public static ArrayList<Order> viewOrders() {
		int orderNum;
		int cid;
		String status;
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		try (Connection con = DriverManager.getConnection(URL + DBNAME, getProps()); Statement stmt = con.createStatement();) {
	    	String SQL = "SELECT * FROM `Order`";
	        ResultSet rs = stmt.executeQuery(SQL);
	        while(rs.next()) {
	        	orderNum = rs.getInt("orderNum");
	        	cid = rs.getInt("customerID");
	        	status = rs.getString("status");
	        	Order order = new Order(getBikeFromNum(orderNum), Order.Status.valueOf(status.toUpperCase()), getCustomerFromCID(cid), getAddressFromCID(cid), getBikeNameFromNum(orderNum), orderNum);
	        	orderList.add(order);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return orderList;
	}

	
	
	
}
