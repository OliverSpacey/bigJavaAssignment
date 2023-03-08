package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import businessLogicLayer.Address;
import businessLogicLayer.Customer;

public class DetailsCheck extends DBDriver{
	
	
	
	public static Properties getProps() {
		Properties props = new Properties();
		props.put("user", USER);
		props.put("password", PASSWORD);
		props.put("useSSL", false);
		return props;
	}
	
	
	
	public static boolean addressMatch(Address address) {
		
		
		Properties props = getProps();
		
		
		try (Connection con = DriverManager.getConnection(URL + DBNAME, props); Statement stmt = con.createStatement();) {
        	String SQL = "SELECT * FROM Address";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
            	if (rs.getInt("houseNum") == address.houseNum && rs.getString("postCode").equals(address.postcode)){
            		return true;
            	}
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	
	
	public static boolean customerMatch(Customer customer) {
		
		
		Properties props = getProps();
		
		try (Connection con = DriverManager.getConnection(URL + DBNAME, props); Statement stmt = con.createStatement();) {
			String SQL = "SELECT * FROM Customer";
		    ResultSet rs = stmt.executeQuery(SQL);
		    while (rs.next()) {
		    	if (rs.getString("forename").equals(customer.forename) && rs.getString("surname").equals(customer.surname)) {
		    		return true;
		    	}
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static int findID(Customer customer) {
		int id = 0;
		Properties props = getProps();
		
		try (Connection con = DriverManager.getConnection(URL + DBNAME, props); Statement stmt = con.createStatement();) {
			String SQL = "SELECT * FROM Customer";
		    ResultSet rs = stmt.executeQuery(SQL);
		    while (rs.next()) {
		    	if (rs.getString("forename").equals(customer.forename) && rs.getString("surname").equals(customer.surname)) {
		    		id = rs.getInt("customerID");
		    	}
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return id;
	}
	
	
	
	
	
	
}
