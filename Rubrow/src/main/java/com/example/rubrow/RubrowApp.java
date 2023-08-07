package com.example.rubrow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class RubrowApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(RubrowApp.class.getResource("rubrow.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Controller controller = loader.getController();
        stage.setTitle("Rubrow");
        stage.setScene(scene);
        stage.show();

        scene.setOnKeyReleased(event -> {
            if(event.getCode().equals(KeyCode.ENTER)) {
                controller.loadPage();
            }
            if(event.getCode().equals(KeyCode.S)) {
                if(event.isControlDown()) {
                    controller.reloadPage();
                }
            }
            if(event.getCode().equals(KeyCode.H)) {
                if(event.isControlDown()) {
                    controller.displayHistory();
                }
            }
            if(event.getCode().equals(KeyCode.A)) {
                if(event.isControlDown()) {
                    controller.back();
                }
            }
            if(event.getCode().equals(KeyCode.D)) {
                if(event.isControlDown()) {
                    controller.next();
                }
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}