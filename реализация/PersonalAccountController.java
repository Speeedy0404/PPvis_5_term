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

public class PersonalAccountController {


    @FXML
    private Button apply;

    @FXML
    private TextField email_field;

    @FXML
    private Button menu_page;

    @FXML
    private TextField middle_name_field;

    @FXML
    private TextField name_field;

    @FXML
    private TextField password_field;

    @FXML
    private TextField phone_field;

    @FXML
    private TextField surname_field;

    @FXML
    void initialize() {
        email_field.setText(AuthorizationController.authorizationUser.getEmail());
        middle_name_field.setText(AuthorizationController.authorizationUser.getMiddle_name());
        name_field.setText(AuthorizationController.authorizationUser.getFirst_name());
        password_field.setText(AuthorizationController.authorizationUser.getPassword());
        phone_field.setText(AuthorizationController.authorizationUser.getPhone());
        surname_field.setText(AuthorizationController.authorizationUser.getSurname());

        menu_page.setOnAction(event -> {
            menu_page.getScene().getWindow().hide();
            create_menu_user_page_widow();
        });
        apply.setOnAction(event -> {
            apply_changes();
        });

    }

    private void apply_changes() {
        int id = UserDao.getInstance().getIdByEmail();
        AuthorizationController.authorizationUser = new User(surname_field.getText(), name_field.getText(), middle_name_field.getText(),
                phone_field.getText(), email_field.getText(), password_field.getText());
        AuthorizationController.authorizationUser.setAdministrator(false);
        UserDao.getInstance().updateUserInformation(id);

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
}
