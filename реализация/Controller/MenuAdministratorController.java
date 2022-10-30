package com.example.public_library;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuAdministratorController {


    @FXML
    private Button editing_books;

    @FXML
    private Button exit;

    @FXML
    private Button find_book;

    @FXML
    private Button given_books;

    @FXML
    private Button viewing_all_users;

    @FXML
    void initialize() {

        exit.setOnAction(event -> {
            exit.getScene().getWindow().hide();
            create_authorization_widow();
        });

        editing_books.setOnAction(event -> {
            editing_books.getScene().getWindow().hide();
            create_editing_books_widow();
        });

        find_book.setOnAction(event -> {
            find_book.getScene().getWindow().hide();
            create_find_book_widow();
        });

        given_books.setOnAction(event -> {
            given_books.getScene().getWindow().hide();
            create_given_books_widow();
        });

        viewing_all_users.setOnAction(event -> {
            viewing_all_users.getScene().getWindow().hide();
            create_viewing_all_users_widow();
        });

    }

    public void create_find_book_widow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("find_book.fxml"));

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

    public void create_given_books_widow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("given_books.fxml"));

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

    public void create_viewing_all_users_widow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("viewing_all_users.fxml"));

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

    public void create_editing_books_widow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editing_books.fxml"));

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

}
