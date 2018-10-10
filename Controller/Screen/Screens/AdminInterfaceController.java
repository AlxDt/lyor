package Controller.Screen.Screens;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controller.Dialog.AlertController;
import Controller.Dialog.ConfirmationController;
import Controller.Screen.Stage.StageController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class AdminInterfaceController implements Initializable {

    // Represents the table of the residency logs
    @FXML
    private TableView logsTable;

    // Represents the rehearsal checkbox
    @FXML
    private CheckBox setRehearsalPeriodCheckbox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    // Activated when the user clicks the logout button
    @FXML
    private void logoutAction() {
        // Show a prompt asking the user whether he/she really wants to logout
        if (ConfirmationController.showConfirmation(
                "Logout",
                "Logout as an administrator",
                "Are you sure you want to logout?"
        )) {
            // If the user was sure, then go back to the non-admin interface
            StageController.activate("residency-logs");
        }
    }

    // Activated when the user clicks the view residency report button
    @FXML
    private void viewReportAction() {
        // Display the report residency window
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/View/Interface/Admin/"
                            + "ResidenceReportInterface.fxml"
                    )
            );

            BorderPane window = loader.load();

            Scene scene = new Scene(window);

            // Style the scene
            StageController.style(scene);

            // Extract the controller from the FXML
            ResidenceReportInterfaceController residenceReportInterface
                    = loader.getController();

            Stage residenceReportStage = new Stage();

            // Window settings
            residenceReportStage.setTitle("Residency report");
            residenceReportStage.setResizable(false);
            residenceReportStage.setScene(scene);
            residenceReportStage.initModality(Modality.APPLICATION_MODAL);

            residenceReportStage.showAndWait();
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

    // Activated when the user clicks the add a resident button
    @FXML
    private void addResidentAction() {
        // Display the add resident window
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/View/Interface/Admin/"
                            + "AddResidentInterface.fxml"
                    )
            );

            GridPane window = loader.load();

            Scene scene = new Scene(window);

            // Style the scene
            StageController.style(scene);

            // Extract the controller from the FXML
            AddResidentInterfaceController addResidentInterfaceController
                    = loader.getController();

            Stage addResidentStage = new Stage();

            // Window settings
            addResidentStage.setTitle("Add a new resident");
            addResidentStage.setResizable(false);
            addResidentStage.setScene(scene);
            addResidentStage.initModality(Modality.APPLICATION_MODAL);

            // Set the parameters of this window
            addResidentInterfaceController.setParameters(addResidentStage);

            addResidentStage.showAndWait();
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
