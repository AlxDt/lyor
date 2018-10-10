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
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class LoginInterfaceController implements Initializable {

    // The owner stage of this window
    private Stage stage;

    // Represents the password field of the login dialog box
    @FXML
    private PasswordField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    // Set the parameters of this window
    public void setParameters(Stage stage) {
        this.stage = stage;
    }

    // Activated when the user attempts a login
    @FXML
    public void attemptLoginAction() {
        try {
            // Check if the password entered matches the actual password
            // TODO: Retrieve the actual password (maybe from a file, idk...)
            String actualPassword = "p@$$w0rd";

            if (passwordField.getText().equals(actualPassword)) {
                // Load the admin interface
                FXMLLoader loader
                        = new FXMLLoader(
                                getClass().getResource(
                                        "/View/Interface/Admin/"
                                        + "AdminInterface.fxml"
                                )
                        );

                BorderPane window = loader.load();

                Scene scene = new Scene(window);

                // Style the scene
                scene.getStylesheets().add(
                        "/View/Resources/material-fx-v0_3.css"
                );

                scene.getStylesheets().add(
                        "/View/Resources/materialfx-toggleswitch.css"
                );

                // Extract the controller from the FXML
                AdminInterfaceController adminInterfaceController
                        = loader.getController();

                StageController.addScreen("residency-logs-admin", scene);
                StageController.activate("residency-logs-admin");

                // Close the stage
                stage.close();
            } else {
                // Clear the password field
                passwordField.clear();

                // Show an error message
                AlertController.showAlert(
                        "Incorrect password",
                        "You've entered the wrong password",
                        "Please try again.",
                        Alert.AlertType.WARNING
                );
            }
        } catch (Exception ex) {
            AlertController.showAlert("Error",
                    "Could not load resources",
                    "The application could not load the required internal"
                    + " resources.",
                    Alert.AlertType.ERROR, ex
            );
        }
    }
}
