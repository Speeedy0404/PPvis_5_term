package com.example.public_library;

import com.example.public_library.dao.BooksDao;
import com.example.public_library.modul.Books;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddBookController {

    public static Books new_book;

    @FXML
    private Button add_book;

    @FXML
    private TextField age_field;

    @FXML
    private TextField age_restriction_field;

    @FXML
    private TextField author_field;

    @FXML
    private Button editing_books_page;

    @FXML
    private TextField genre_field;

    @FXML
    private TextField pages_field;

    @FXML
    private TextField title_field;

    @FXML
    void initialize() {

        editing_books_page.setOnAction(event -> {
            editing_books_page.getScene().getWindow().hide();
            create_editing_books_widow();
        });
        add_book.setOnAction(event -> {
            add_new_book();
        });

    }

    private void add_new_book() {
        new_book = new Books(title_field.getText(), author_field.getText(), genre_field.getText(),
                age_field.getText(), pages_field.getText(), age_restriction_field.getText());
        BooksDao.getInstance().addBook();
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
}
