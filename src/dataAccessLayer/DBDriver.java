package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import businessLogicLayer.Component;
import businessLogicLayer.FrameSet;
import businessLogicLayer.Handlebar;
import businessLogicLayer.Wheel;
import businessLogicLayer.Handlebar.Style;
import businessLogicLayer.User;
import businessLogicLayer.Wheel.BrakeStyle;
import businessLogicLayer.Wheel.TyreStyle;

public class DBDriver {
	
	static String URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/";
	static String DBNAME = "team023";
	static String USER = "team023";
	static String PASSWORD = "05391b5a";
	
	public static Properties getProps() {
		Properties props = new Properties();
		props.put("user", USER);
		props.put("password", PASSWORD);
		props.put("useSSL", false);
		return props;
	}

	public static void pushSQL(Connection conn, String statement_) throws SQLException {
		Statement statement = conn.createStatement();
		statement.executeUpdate(statement_);
	}
	
	public static ArrayList<businessLogicLayer.Component> extractDataWheels() {
		
		Properties props = getProps();
				
        try (Connection con = DriverManager.getConnection(URL + DBNAME, props); Statement stmt = con.createStatement();) {
        	String SQL = "SELECT * FROM Wheel";
            ResultSet rs = stmt.executeQuery(SQL);

            ArrayList<Component> comps = new ArrayList<Component>();
            
            while (rs.next()) {
                Wheel newWheel = new Wheel(rs.getInt("serialNum"), rs.getString("brandName:"), rs.getString("productName"),
                		rs.getDouble("unitCost"), rs.getInt("diameter"), TyreStyle.valueOf(rs.getString("tyreStyle").toUpperCase()), BrakeStyle.valueOf(rs.getString("brakeStyle").toUpperCase()),
                		1);
                
                if (comps.contains(newWheel)){
                	System.out.println("Contained");
                }
                comps.add(newWheel); 
            }
            return comps;
        }
        catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static ArrayList<businessLogicLayer.Component> extractDataFrameSets() {
		
		Properties props = getProps();
		
		ArrayList<businessLogicLayer.Component> comps = new ArrayList<businessLogicLayer.Component>();

        try (Connection con = DriverManager.getConnection(URL + DBNAME, props); Statement stmt = con.createStatement();) {
        	String SQL = "SELECT * FROM FrameSet";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
            	FrameSet newFrameSet = new FrameSet(rs.getInt("serialNum"), rs.getString("brandName"), rs.getString("productName"),
                		rs.getDouble("unitCost"), rs.getInt("size"), rs.getBoolean("shocks"), rs.getString("frame"), rs.getString("forks"),
                		1);
            	
            	if (comps.contains(newFrameSet)) {
            		System.out.println("Contained");
            	}
            	comps.add(newFrameSet);
            }
            return comps;
        }
        catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<businessLogicLayer.Component> extractDataHandlebars() {
		
		Properties props = getProps();
		
		ArrayList<businessLogicLayer.Component> comps = new ArrayList<businessLogicLayer.Component>();

        try (Connection con = DriverManager.getConnection(URL + DBNAME, props); Statement stmt = con.createStatement();) {
        	String SQL = "SELECT * FROM Handlebar";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
            	Handlebar newHandlebar = new Handlebar(rs.getInt("serialNum"), rs.getString("brandName"), rs.getString("productName"),
                		rs.getDouble("unitCost"), Style.valueOf(rs.getString("style").toUpperCase()),
                		1);
            	
            	if (comps.contains(newHandlebar)) {
            		System.out.println("Contained");
            	}
            	comps.add(newHandlebar);
            }
            return comps;
        }
        catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static ArrayList<User> extractDataUsers(){
		Properties props = getProps();
		ArrayList<User> users = new ArrayList<User>();

        try (Connection con = DriverManager.getConnection(URL + DBNAME, props); Statement stmt = con.createStatement();) {
        	String SQL = "SELECT * FROM Staff";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
            	User newUser = new User(rs.getString("username"), rs.getString("password"));
            	
            	if (users.contains(newUser)) {
            		System.out.println("Contained");
            	}
            	users.add(newUser);
            }
            return users;
        }
        catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

}