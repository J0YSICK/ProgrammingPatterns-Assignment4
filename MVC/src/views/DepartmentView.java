/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.DepartmentController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.Department;

/**
 *
 * @author 2072658
 */
public class DepartmentView extends VBox{
    TextField deptTxt;
    DepartmentController departmentController;
    
    //Inject the controller object as a dependency known as dependency injection
    public DepartmentView(DepartmentController departmentController){
        this.departmentController = departmentController;
        buildInterface();
    }
    
    public void buildInterface(){
        
        Label deptLbl = new Label("Department ID:");
         
        deptTxt = new TextField();
        deptTxt.setMaxWidth(180);
        
        Button searchBtn = new Button("Search");
        
        TableView tableView = new TableView();
        
        TableColumn<Department, String> deptIDCol = new TableColumn<>("Department");
        deptIDCol.setCellValueFactory(new PropertyValueFactory<>("deptID"));
        
        TableColumn<Department, String> deptNameCol = new TableColumn<>("Department Name");
        deptNameCol.setCellValueFactory(new PropertyValueFactory<>("deptName"));
        
        tableView.getColumns().addAll(deptIDCol, deptNameCol);
        
        tableView.getItems().add(departmentController.getDepartment(1));
        tableView.getItems().add(departmentController.getDepartment(2));
        tableView.getItems().add(departmentController.getDepartment(3));
        
        //Note: we could an event handler in the view that interacts with the model
        // and gets the data
        // This pattern is referred to as Model-View-ViewModel (MVVM)
        
        //Another option is to use the Model View Conroller MVC pattern 
        // where each model has a controller that interfaces its actions 
        // with the views and other services
        this.getChildren().add(deptLbl);
        this.getChildren().add(deptTxt);
        this.getChildren().add(searchBtn);
        this.getChildren().add(tableView);
        
        searchBtn.setOnAction(event -> {
            tableView.getItems().clear();
            try {
                int id = Integer.parseInt(deptTxt.getText());
                Department d = departmentController.getDepartment(id);
                if (d != null) {
                    tableView.getItems().add(d);
                }
            } catch (NumberFormatException e) {
                // if text isn't a number, show nothing
            }
        });
    }
}
