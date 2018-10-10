package Controller.Screen.Screens;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controller.Dialog.AlertController;
import Controller.Screen.Stage.StageController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class AddResidentInterfaceController implements Initializable {

    // The owner stage of this window
    private Stage stage;

    // Represents the text field to contain the resident name of the resident
    // to be added
    @FXML
    private TextField residentNameField;

    // Represents the text field to contain the ID number of the resident to be
    // added
    @FXML
    private TextField idNumberField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    // Set the parameters of this window
    public void setParameters(Stage stage) {
        this.stage = stage;
    }

    // Activated when the add resident button is pressed
    @FXML
    public void addResidentAction() {
        // TODO: Add the resident to the database

        // Close the stage
        stage.close();
    }
}
