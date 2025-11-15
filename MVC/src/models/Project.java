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
 * @author User11
 */
public class Project {
    private int projectId, personId;
    private String projectName;

    public Project(int projectId, int personId, String projectName) {
        this.projectId = projectId;
        this.personId = personId;
        this.projectName = projectName;
    }
    
    public Project(){
    }

    public int getProjectId() {
        return projectId;
    }

    public int getPersonId() {
        return personId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setPersonId(int id) {
        this.personId = id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public Project getProjectById(int projectId){
        try{
            Connection conn = ConnectionManager.getConnection();
            String sql = "SELECT * FROM project WHERE projectId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,projectId);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                this.projectId = rs.getInt("projectId");
                this.personId = rs.getInt("id");
                this.projectName = rs.getString("projectName");
                return new Project(projectId,personId,projectName);
            }
            conn.close();
        } catch (SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
        return null;
    }
}
