package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import businessLogicLayer.Order;
import businessLogicLayer.Order.Status;

public class PlaceOrder extends DBDriver {

	
	public static int serialNumGen(String table, String column) {
		int serialNum = (int) ((Math.random() * (9999999 - 1000000)) + 1000000);
		
		
		Properties props = getProps();
				
        try (Connection con = DriverManager.getConnection(URL + DBNAME, props); Statement stmt = con.createStatement();) {
        	String SQL = "SELECT * FROM "+table;
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
            	if (rs.getInt(column) == serialNum) {
            		serialNumGen(table, column);
            	}
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return serialNum;
	}
	
	
	

	public static void placeOrder(Order placeOrder) {
		
		Properties props = getProps();
	
		try(Connection conn = DriverManager.getConnection(URL+DBNAME,props);) {
			
			int id;			
			
			if(DetailsCheck.addressMatch(placeOrder.address) == false && DetailsCheck.customerMatch(placeOrder.customer) == false) {
				id = placeOrder.customer.customerID;
				pushSQL(conn, "INSERT INTO Customer (`customerID`,`forename`,`surname`,`houseNum`,`postcode`) VALUES ("+id+",'"+placeOrder.customer.forename+"','"+placeOrder.customer.surname+"',"+placeOrder.address.houseNum+",'"+placeOrder.address.postcode+"');");
				pushSQL(conn, "INSERT INTO Address (`houseNum`,`roadName`,`cityName`,`postCode`) VALUES ("+placeOrder.address.houseNum+",'"+placeOrder.address.streetName+"','"+placeOrder.address.cityName+"','"+placeOrder.address.postcode+"');");
			}
			else if(DetailsCheck.addressMatch(placeOrder.address) == true && DetailsCheck.customerMatch(placeOrder.customer) == false){
				id = placeOrder.customer.customerID;
				pushSQL(conn, "INSERT INTO Customer (`customerID`,`forename`,`surname`,`houseNum`,`postcode`) VALUES ("+id+",'"+placeOrder.customer.forename+"','"+placeOrder.customer.surname+"',"+placeOrder.address.houseNum+",'"+placeOrder.address.postcode+"');");
			}
			else if(DetailsCheck.addressMatch(placeOrder.address) == false && DetailsCheck.customerMatch(placeOrder.customer) == true) {
				id = DetailsCheck.findID(placeOrder.customer);
				pushSQL(conn, "INSERT INTO Address (`houseNum`,`roadName`,`cityName`,`postCode`) VALUES ("+placeOrder.address.houseNum+",'"+placeOrder.address.streetName+"','"+placeOrder.address.cityName+"','"+placeOrder.address.postcode+"')");
			}
			else {
				id = DetailsCheck.findID(placeOrder.customer);
			}
			
			pushSQL(conn, "INSERT INTO `Order` (`orderNum`,`status`,`customerID`) VALUES ("+placeOrder.orderNum+",'"+Status.PENDING+"',"+id+");");

			pushSQL(conn, "INSERT INTO Bicycle (`serialNum`,`brandName`,`customName`,`unitCost`, `orderNum`, `wheel`, `frameSet`, `handlebar`) VALUES ("+serialNumGen("Bicycle", "serialNum")+", '"+placeOrder.bike.customBrand+
					"', '"+placeOrder.bikeName+"', "+placeOrder.bike.totalCost+", "+placeOrder.orderNum+", "+placeOrder.bike.wheel.serialNum+", "+placeOrder.bike.frameSet.serialNum+","+placeOrder.bike.handlebar.serialNum+");");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
			
	}
}