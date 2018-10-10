package Controller.Screen.Screens.Admin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class SetResidentStatusController implements Initializable {

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

    // Represents the active checkbox
    @FXML
    private CheckBox isActiveCheckbox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    // Set the parameters of this window
    public void setParameters(Stage stage) {
        this.stage = stage;
    }

    // Activated when the save resident status button is pressed
    @FXML
    public void saveStatusAction() {
        // TODO: Edit the selected resident's status and save it to the database

        // Close the stage
        stage.close();
    }
}
