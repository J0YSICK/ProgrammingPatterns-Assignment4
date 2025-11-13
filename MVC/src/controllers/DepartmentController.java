/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.Department;

/**
 *
 * @author 2072658
 */
public class DepartmentController {
    
    Department department;
    
    public DepartmentController(){
        department = new Department();
    }
    
    public Department getDepartment(int deptID){
        return department.getDepartment(deptID);
    }

    

    
}
