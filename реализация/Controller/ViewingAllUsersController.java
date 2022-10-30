package com.example.public_library;

import com.example.public_library.dao.UserDao;
import com.example.public_library.modul.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ViewingAllUsersController {

    public static User user_book_issuance;

    @FXML
    private Button book_issuance;

    @FXML
    private TableColumn<User, String> email_table;

    @FXML
    private Button menu_page;

    @FXML
    private TableColumn<User, String> middle_name_table;

    @FXML
    private TableColumn<User, String> name_table;

    @FXML
    private TableColumn<User, String> phone_table;

    @FXML
    private TableColumn<User, String> surname_table;

    @FXML
    private TableView<User> users_table;

    @FXML
    void initialize() {
        List<User> users = UserDao.getInstance().getAllUsers();
        ObservableList<User> observableListUsers = FXCollections.observableList(users);

        email_table.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        middle_name_table.setCellValueFactory(new PropertyValueFactory<User,String>("middle_name"));
        name_table.setCellValueFactory(new PropertyValueFactory<User,String>("first_name"));
        phone_table.setCellValueFactory(new PropertyValueFactory<User,String>("phone"));
        surname_table.setCellValueFactory(new PropertyValueFactory<User,String>("surname"));


        users_table.setItems(observableListUsers);

        menu_page.setOnAction(event -> {
            menu_page.getScene().getWindow().hide();
            create_menu_administrator_widow();
        });
        book_issuance.setOnAction(event -> {
            if (users_table.getSelectionModel().getSelectedItem()!=null) {
                ViewingAllUsersController.user_book_issuance = (User) users_table.getSelectionModel().getSelectedItem();
                book_issuance.getScene().getWindow().hide();
                create_book_issuance_widow();
            }
        });
    }

    public void create_book_issuance_widow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("book_issuance.fxml"));

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
