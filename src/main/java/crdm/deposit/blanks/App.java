package crdm.deposit.blanks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	private final static String URL = "jdbc:mysql://localhost:3306/reagents?useSSL=false&characterEncoding=UTF-8&serverTimezone=EET";
    private final static String USER = "crdm";
    private final static String PASSWORD = "nomenCRDM";

    
    public static void main(String[] args) throws SQLException {
		testConnection();
	}
    
    public static void testConnection() throws SQLException {
        Connection c = null; 
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {    
            Class.forName("com.mysql.cj.jdbc.Driver");    
            System.out.println("Driver found");    
            System.out.println("Connecting..."); 
            c = DriverManager.getConnection(URL, USER, PASSWORD);
            
            statement = c.createStatement();
            resultSet = statement.executeQuery("Select * from producers");
            while (resultSet.next()) {
            	System.out.println(resultSet.getString("name"));
            	
            }
            
        } catch (Exception e) {    
            System.out.println("Cannot connect the database");
            e.printStackTrace();
        } finally {    
            if (c != null) {       
                c.close();        
            }    
        }    
    } 
}
