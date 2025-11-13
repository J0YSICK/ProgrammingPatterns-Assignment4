/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvcapplication;

import controllers.DepartmentController;
import controllers.PersonController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.DepartmentView;
import views.PersonView;

/**
 *
 * @author 2072658
 */
public class MVCApplication extends Application{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

//    @Override
//    public void start(Stage stage) throws Exception {
//        PersonController personController = new PersonController();
//        PersonView personView = new PersonView(personController);
//        //VBox root = personView.buildInterface();
//        Scene scene = new Scene(personView, 315,200);
//       
//        stage.setScene(scene);
//        stage.show();
//    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        DepartmentController departmentController = new DepartmentController();
        DepartmentView departmentView = new DepartmentView(departmentController);
        //VBox root = personView.buildInterface();
        Scene scene = new Scene(departmentView, 205,200);
       
        stage.setScene(scene);
        stage.show();
    }
    
 
    
}
