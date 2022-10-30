package com.example.public_library;

import com.example.public_library.dao.UserDao;
import com.example.public_library.modul.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthorizationController {

    public static User authorizationUser;

    @FXML
    private TextField email_field;

    @FXML
    private Button login;

    @FXML
    private Button main_page;

    @FXML
    private TextField password_field;

    @FXML
    void initialize() {

        main_page.setOnAction(event -> {
            main_page.getScene().getWindow().hide();
            create_main_page_widow();
        });

        login.setOnAction(event -> {
            authorizationUser = new User(email_field.getText(), password_field.getText());
            if (UserDao.getInstance().getUserByPasswordAndMail()) {
                login.getScene().getWindow().hide();
                if (authorizationUser.getAdministrator()) {
                    create_menu_administrator_widow();
                } else {
                    create_menu_user_page_widow();
                }
            }
        });

    }

    public void create_main_page_widow() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main_page.fxml"));

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

    public void create_menu_user_page_widow() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("menu_user.fxml"));

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

    public void create_menu_administrator_widow() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("menu_administrator.fxml"));

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




