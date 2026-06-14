package org.example.lab1java2026vgtu.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.lab1java2026vgtu.model.ConverterModel;
import org.example.lab1java2026vgtu.util.InputValidator;

import java.net.URL;
import java.util.ResourceBundle;

public class ConverterController implements Initializable {

    @FXML
    private TextField inputField;

    @FXML
    private ComboBox<String> fromBox;

    @FXML
    private ComboBox<String> toBox;

    @FXML
    private Label resultLabel;

    @FXML
    private Label errorLabel;

    private final ConverterModel model = new ConverterModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fromBox.getItems().addAll("DATE_TIME", "UNIX", "HUMAN");
        toBox.getItems().addAll("DATE_TIME", "UNIX", "HUMAN");

        fromBox.setValue("DATE_TIME");
        toBox.setValue("UNIX");
    }

    @FXML
    public void handleConvert() {

        String input = inputField.getText();

        errorLabel.setText("");
        resultLabel.setText("");

        if (InputValidator.isEmpty(input)) {
            errorLabel.setText("Пустое поле");
            return;
        }

        try {
            String result = model.convert(
                    input,
                    fromBox.getValue(),
                    toBox.getValue()
            );

            resultLabel.setText(result);

        } catch (Exception e) {
            errorLabel.setText("Ошибка: " + e.getMessage());
        }
    }
}