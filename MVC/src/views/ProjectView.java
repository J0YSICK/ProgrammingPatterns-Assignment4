/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.ProjectController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.Project;

/**
 *
 * @author User11
 */
public class ProjectView extends VBox{
    TextField projectIdTxt;
    ProjectController projectController;
    
    public ProjectView(ProjectController projectController){
        this.projectController = projectController;
        buildInterface();
    }
    public void buildInterface(){
        Label projectIdLabel = new Label("Project ID: ");
        
        projectIdTxt = new TextField();
        projectIdTxt.setMaxWidth(180);
        
        Button searchBtn = new Button("Search");
        
        TableView tableView = new TableView();
        TableColumn<Project, String> projectIdCol = new TableColumn<>("Project ID");
        projectIdCol.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        
        TableColumn<Project, String> personIdCol = new TableColumn<>("Person ID");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("personId"));
        
        TableColumn<Project, String> projectNameCol = new TableColumn<>("Project Name");
        projectNameCol.setCellValueFactory(new PropertyValueFactory<>("projectName"));
        
        tableView.getColumns().addAll(projectIdCol, personIdCol, projectNameCol);
        
        tableView.getItems().add(projectController.getProjectById(1));
        tableView.getItems().add(projectController.getProjectById(2));
        
        this.getChildren().add(projectIdLabel);
        this.getChildren().add(projectIdTxt);
        this.getChildren().add(searchBtn);
        this.getChildren().add(tableView);
        
        searchBtn.setOnAction(event -> {
            tableView.getItems().clear();
            tableView.getItems().add(projectController.getProjectById(Integer.parseInt(projectIdTxt.getText())));
        });
    }
    
}
