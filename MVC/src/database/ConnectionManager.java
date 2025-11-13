/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.*;
/**
 *
 * @author 2072658
 */
public class ConnectionManager {
    
    
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/hr";
        String user = "root";
        String password = "";
         try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (ClassNotFoundException e) {
                System.out.println("JDBC Driver not found: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }  
         return null;
    }
}
