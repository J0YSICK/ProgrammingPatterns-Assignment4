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
 * @author 6290479
 */
public class Person {
    private int id, departmentId;
    private String firstName, lastName, title;
    private double salary;
    
    public Person(){
        
    }
    
    public Person(int id, String firstName, String lastName, String title, int departmentId, double salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
    public Person getPerson(){
        Person person = new Person();
        person.setFirstName("John");
        return person;
    }
    
    public Person getPersonById(int id){
        try {
            // Establish connection
            Connection conn = ConnectionManager.getConnection();
                    
            //Statement statement = conn.createStatement();
            //ResultSet rs = statement.executeQuery("SELECT * FROM employee WHERE id = ?");
            //Employee employee = new Employee(rs.getInt("id"),rs.getString("firstName"), rs.getString("lastName"), rs.getString("title"), rs.getInt("departmentId"));
            String sql = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                this.id = rs.getInt("id");
                this.firstName = rs.getString("firstName");
                this.lastName = rs.getString("lastName");
                this.departmentId = rs.getInt("departmentId");
                this.salary = rs.getDouble("salary");
                return new Person(id,firstName,lastName,title,departmentId, salary);
            }
            // Close connection
            conn.close();
            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }  
        return null;
    }
    
    public Person getPersonByFirstName(String firstName){
        try {
            // Establish connection
            Connection conn = ConnectionManager.getConnection();
                    
            //Statement statement = conn.createStatement();
            //ResultSet rs = statement.executeQuery("SELECT * FROM employee WHERE id = ?");
            //Employee employee = new Employee(rs.getInt("id"),rs.getString("firstName"), rs.getString("lastName"), rs.getString("title"), rs.getInt("departmentId"));
            String sql = "SELECT * FROM employees WHERE firstName = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,firstName);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                this.id = rs.getInt("id");
                this.firstName = rs.getString("firstName");
                this.lastName = rs.getString("lastName");
                this.departmentId = rs.getInt("departmentId");
                this.salary = rs.getDouble("salary");
                return new Person(id,firstName,lastName,title,departmentId, salary);
            }
            // Close connection
            conn.close();
            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            }  
        return null;
    }
}
