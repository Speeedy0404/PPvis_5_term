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

public class RegistrationController {

    public static User registrationUser;

    @FXML
    private TextField email_field;

    @FXML
    private Button main_page;

    @FXML
    private TextField middle_name_field;

    @FXML
    private TextField name_field;

    @FXML
    private TextField password_field;

    @FXML
    private TextField phone_field;

    @FXML
    private Button registration;

    @FXML
    private TextField surname_field;

    @FXML
    void initialize() {

        main_page.setOnAction(event -> {
            main_page.getScene().getWindow().hide();
            create_main_page_widow();
        });
        registration.setOnAction(event -> {
            add_user();
        });

    }

    private void add_user() {
        registrationUser = new User(surname_field.getText(), name_field.getText(), middle_name_field.getText(),
                phone_field.getText(), email_field.getText(), password_field.getText());
        registrationUser.setAdministrator(false);

        UserDao.getInstance().addUser();
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
}
