/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.Project;

/**
 *
 * @author User11
 */
public class ProjectController {
    Project project;
    
    public ProjectController(){
        Project Project = new Project();
    }    
    
    public Project getProjectById(int id){
        return project.getProjectById(id);
    }
    
}
