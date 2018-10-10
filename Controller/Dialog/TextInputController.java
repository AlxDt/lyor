/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Dialog;

import Controller.Screen.Stage.StageController;
import java.util.Optional;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author user
 */
public class TextInputController {

    public static Optional<String> showTextInput(
            String title,
            String header,
            String content) {
        TextInputDialog textInputDialog = new TextInputDialog();

        textInputDialog.setTitle(title);
        textInputDialog.setHeaderText(header);
        textInputDialog.setContentText(content);

        StageController.style(textInputDialog);

        return textInputDialog.showAndWait();
    }
}
