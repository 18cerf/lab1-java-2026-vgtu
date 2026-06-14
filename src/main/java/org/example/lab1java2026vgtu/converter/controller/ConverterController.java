package org.example.lab1java2026vgtu.converter.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.lab1java2026vgtu.converter.model.ConverterModel;
import org.example.lab1java2026vgtu.converter.util.InputValidator;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер конвертера.
 * Связывает интерфейс и модель.
 */
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

    /**
     * Инициализация интерфейса.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fromBox.getItems().addAll("cm", "m", "km");
        toBox.getItems().addAll("cm", "m", "km");

        fromBox.setValue("m");
        toBox.setValue("cm");
    }

    /**
     * Обработка кнопки конвертации.
     */
    @FXML
    public void handleConvert() {
        String input = inputField.getText();

        errorLabel.setText("");

        if (InputValidator.isEmpty(input)) {
            errorLabel.setText("Поле пустое");
            return;
        }

        if (!InputValidator.isNumeric(input)) {
            errorLabel.setText("Введите число");
            return;
        }

        double value = Double.parseDouble(input);

        if (!InputValidator.isPositive(input)) {
            errorLabel.setText("Число должно быть > 0");
            return;
        }

        double result = model.convert(value, fromBox.getValue(), toBox.getValue());

        resultLabel.setText("Результат: " + result);
    }
}
