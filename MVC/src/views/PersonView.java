/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.PersonController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.Person;

/**
 *
 * @author 2072658
 */
public class PersonView extends VBox{
    TextField firstNameTxt;
    PersonController personController;
    
    //Inject the controller object as a dependency known as dependency injection
    public PersonView(PersonController personController){
        this.personController = personController;
        buildInterface();
    }
    
    public void buildInterface(){
        
        Label firstNameLbl = new Label("First Name:");
         
        firstNameTxt = new TextField();
        firstNameTxt.setMaxWidth(180);
        
        Button searchBtn = new Button("Search");
        
        TableView tableView = new TableView();
        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
        TableColumn<Person, String> salaryCol = new TableColumn<>("Salary");
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        
        TableColumn<Person, String> deptCol = new TableColumn<>("Department ID");
        deptCol.setCellValueFactory(new PropertyValueFactory<>("deptID"));
        
        tableView.getColumns().addAll(firstNameCol, lastNameCol, salaryCol, deptCol);
        
        tableView.getItems().add(personController.getPersonById(1));
        tableView.getItems().add(personController.getPersonById(2));
        tableView.getItems().add(personController.getPersonById(3));
        
        //Note: we could an event handler in the view that interacts with the model
        // and gets the data
        // This pattern is referred to as Model-View-ViewModel (MVVM)
        
        //Another option is to use the Model View Conroller MVC pattern 
        // where each model has a controller that interfaces its actions 
        // with the views and other services
        this.getChildren().add(firstNameLbl);
        this.getChildren().add(firstNameTxt);
        this.getChildren().add(searchBtn);
        this.getChildren().add(tableView);
        
        searchBtn.setOnAction(event -> {
            tableView.getItems().clear();
            //String firstName = personController.getPerson().getFirstName();
            tableView.getItems().add(personController.getPersonByFirstName(firstNameTxt.getText()));
        });
    }
    
    
//    public VBox buildInterface(){
//         VBox rootVbox = new VBox();
//        
//        Label firstNameLbl = new Label("First Name:");
//         
//        firstNameTxt = new TextField();
//        
//        Button displayFNameBtn = new Button("Display First Name");
//        
//        rootVbox.getChildren().add(firstNameLbl);
//        rootVbox.getChildren().add(firstNameTxt);
//        rootVbox.getChildren().add(displayFNameBtn);
//        return rootVbox;
//    }
}
