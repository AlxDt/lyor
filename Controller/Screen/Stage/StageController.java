/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Screen.Stage;

import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class StageController {

    private static final HashMap<String, Scene> SCREEN_MAP = new HashMap<>();
    private static Stage stage;

    public static void style(TextInputDialog textInputDialog) {
        textInputDialog.getDialogPane().getStylesheets().add(
                "/View/Resources/material-fx-v0_3.css"
        );

        textInputDialog.getDialogPane().getStylesheets().add(
                "/View/Resources/materialfx-toggleswitch.css"
        );
    }

    public static void style(Alert alert) {
        alert.getDialogPane().getStylesheets().add(
                "/View/Resources/material-fx-v0_3.css"
        );

        alert.getDialogPane().getStylesheets().add(
                "/View/Resources/materialfx-toggleswitch.css"
        );
    }

    public static void style(Scene scene) {
        // Style the scene
        scene.getStylesheets().add(
                "/View/Resources/material-fx-v0_3.css"
        );

        scene.getStylesheets().add(
                "/View/Resources/materialfx-toggleswitch.css"
        );
    }

    public static void setStage(Stage stage) {
        StageController.stage = stage;
    }

    public static void addScreen(String name, Scene scene) {
        SCREEN_MAP.put(name, scene);
    }

    public static void removeScreen(String name) {
        SCREEN_MAP.remove(name);
    }

    public static void activate(String name) {
        stage.setScene(SCREEN_MAP.get(name));
    }
}
