package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controller.Dialog.AlertController;
import Controller.Screen.Stage.StageController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.text.Font;

import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Main extends Application {

    // Theme colors for different modes
    public static final String RESIDENT_THEME = "#2196f3";
    public static final String ADMIN_THEME = "#f57c00";

    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            primaryStage = stage;

            // Load the main FXML
            Parent root
                    = FXMLLoader.load(
                            getClass().getResource(
                                    "/View/Interface/Resident/"
                                    + "ResidenceInterface.fxml"
                            )
                    );

            // Use the Roboto font
            Font.loadFont(
                    Main.class.getResource(
                            "/View/Resources/Roboto-Medium.ttf")
                            .toExternalForm(),
                    10
            );

            // Extract the scene
            Scene scene = new Scene(root);

            // Style the scene
            StageController.style(scene);

            // Initialize the scene map
            StageController.setStage(stage);

            // Set this as the first scene
            StageController.addScreen("residency-logs", scene);

            // Window settings
            stage.setTitle("LYO Residency App");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            AlertController.showAlert("Error",
                    "Could not load resources",
                    "The application could not load the required internal"
                    + " resources.",
                    Alert.AlertType.ERROR, ex
            );
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
