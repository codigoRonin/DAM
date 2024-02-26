package com.example.fxwebserviceexample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXWebServiceController {
    @FXML private Label resultLabel;
    @FXML private TextField num1;
    @FXML private TextField num2;
    @FXML private Button addButton;

    GetSumService gss;

    @FXML
    private void sumNumbers(ActionEvent event) {
        gss = new GetSumService(
                Integer.parseInt(num1.getText()),
                Integer.parseInt(num2.getText()));
        gss.start();
        addButton.setDisable(true);
        resultLabel.setVisible(false);

        gss.setOnSucceeded(e -> {
            resultLabel.setText("Result: " + gss.getValue());
            addButton.setDisable(false);
            resultLabel.setVisible(true);
        });
    }
}