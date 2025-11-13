/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 2072658
 */
public class Department {
    private int deptID;
    String deptName;

    public Department() {
    }

    public Department(int deptID, String deptName) {
        this.deptID = deptID;
        this.deptName = deptName;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

      
    public Department getDepartment(int deptID){
        try {
            // Establish connection
            Connection conn = ConnectionManager.getConnection();
                    
            //Statement statement = conn.createStatement();
            //ResultSet rs = statement.executeQuery("SELECT * FROM employee WHERE id = ?");
            //Employee employee = new Employee(rs.getInt("id"),rs.getString("firstName"), rs.getString("lastName"), rs.getString("title"), rs.getInt("departmentId"));
            String sql = "SELECT * FROM department WHERE deptID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,deptID);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                this.deptID = rs.getInt("deptID");
                this.deptName = rs.getString("deptName");
                return new Department(deptID, deptName);
            }
            // Close connection
            conn.close();
            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }  
        return null;
    }
    
    
    
}
