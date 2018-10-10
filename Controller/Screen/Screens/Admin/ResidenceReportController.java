package Controller.Screen.Screens.Admin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controller.Dialog.AlertController;
import Controller.Screen.Screens.Resident.LoginController;
import Controller.Screen.Stage.StageController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class ResidenceReportController implements Initializable {

    // Represents the table of the residency logs
    @FXML
    private TableView logsTable;

    // Represents the logging status (it'll be indicated here if it's residency
    // time or not
    @FXML
    private Text loggingStatusText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    // Activated when the user clicks the login as administrator button
    @FXML
    private void loginAction() {
        // Display the login dialog box
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/View/Interface/Admin/LoginInterface.fxml"
                    )
            );

            BorderPane window = loader.load();

            Scene scene = new Scene(window);

            // Style the scene
            StageController.style(scene);

            // Extract the controller from the FXML
            LoginController loginInterfaceController
                    = loader.getController();

            Stage loginStage = new Stage();

            // Window settings
            loginStage.setTitle("Login as an administrator");
            loginStage.setResizable(false);
            loginStage.setScene(scene);
            loginStage.initModality(Modality.APPLICATION_MODAL);

            // Set the parameters of this window
            loginInterfaceController.setParameters(loginStage);

            loginStage.showAndWait();
        } catch (Exception ex) {
            AlertController.showAlert("Error",
                    "Could not load resources",
                    "The application could not load the required"
                    + " internal resources.",
                    Alert.AlertType.ERROR,
                    ex
            );
        }
    }
}
