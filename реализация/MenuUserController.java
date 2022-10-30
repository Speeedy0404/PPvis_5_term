package com.example.public_library;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuUserController {

    @FXML
    private Button exit;

    @FXML
    private Button find_book;

    @FXML
    private Button personal_account;

    @FXML
    private Button viewing_all_books;

    @FXML
    private Button viewing_borrowed_books;

    @FXML
    void initialize() {

        exit.setOnAction(event -> {
            exit.getScene().getWindow().hide();
            create_authorization_widow();
        });

        find_book.setOnAction(event -> {
            find_book.getScene().getWindow().hide();
            create_find_book_widow();
        });

        personal_account.setOnAction(event -> {
            personal_account.getScene().getWindow().hide();
            create_personal_account_widow();
        });

        viewing_all_books.setOnAction(event -> {
            viewing_all_books.getScene().getWindow().hide();
            create_viewing_all_books_widow();
        });

        viewing_borrowed_books.setOnAction(event -> {
            viewing_borrowed_books.getScene().getWindow().hide();
            viewing_borrowed_books_widow();
        });
    }

    public void viewing_borrowed_books_widow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("viewing_borrowed_books.fxml"));

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

    public void create_viewing_all_books_widow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("viewing_all_books.fxml"));

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

    public void create_personal_account_widow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("personal_account.fxml"));

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
