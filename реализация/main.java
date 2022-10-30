package com.example.public_library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("main_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 500);
        stage.setTitle("public_library!");
        stage.setScene(scene);
        stage.show();
    }
}
