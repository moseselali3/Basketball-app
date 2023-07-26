package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Validator;

import java.util.LinkedList;

public class ErrorController extends Controller<Validator> {
    @FXML
    private VBox errorsVBox;

    @FXML
    private Label errorMessage;

    @FXML
    public void exit() {
        stage.close();
    }

    public Validator getValidator(){
        return this.model;
    }

    @FXML
    public void initialize () {
//        LinkedList<String> tempList;
//
//        if(getValidator() != null && getValidator().errors() != null && getValidator().errors().size() > 0 ){
//            for(String error : getValidator().errors()){
//                Label errorField = new Label(error);
//                errorsVBox.getChildren().add(errorField);
//            }
//        }
//        else {
//            tempList = new LinkedList<>();
//
//            for(String error : tempList){
//                Label errorField = new Label(error);
//                errorsVBox.getChildren().add(errorField);
//            }
//        }
    }
}
