package com.example.public_library;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {


    @FXML
    private Button authorization;

    @FXML
    private Button registration;

    @FXML
    void initialize() {
        authorization.setOnAction(event -> {
            authorization.getScene().getWindow().hide();
            create_authorization_widow();
        });

        registration.setOnAction(event -> {
            registration.getScene().getWindow().hide();
            create_registration_widow();
        });
    }

    public void create_authorization_widow() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("authorization.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void create_registration_widow() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("registration.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
