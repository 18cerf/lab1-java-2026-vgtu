package org.example.lab1java2026vgtu.converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Главный класс приложения JavaFX.
 */
public class MainApp extends Application {

    /**
     * Запуск приложения.
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ConverterView.fxml"));
        Scene scene = new Scene(loader.load(), 400, 300);

        stage.setTitle("MVC Converter");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Точка входа.
     */
    public static void main(String[] args) {
        launch();
    }
}