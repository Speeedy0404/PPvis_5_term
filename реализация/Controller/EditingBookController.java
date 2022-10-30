package com.example.public_library;

import com.example.public_library.dao.BooksDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EditingBookController {


    @FXML
    private TextField age_field;

    @FXML
    private TextField age_restriction_field;

    @FXML
    private TextField author_field;

    @FXML
    private Button editing_book;

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
        title_field.setText(EditingBooksController.book.getTitle());
        author_field.setText(EditingBooksController.book.getAuthor());
        genre_field.setText(EditingBooksController.book.getGenre());
        age_field.setText(EditingBooksController.book.getYear());
        pages_field.setText(EditingBooksController.book.getPages());
        age_restriction_field.setText(EditingBooksController.book.getAge_restriction());

        editing_books_page.setOnAction(event -> {
            editing_books_page.getScene().getWindow().hide();
            create_editing_books_widow();
        });
        editing_book.setOnAction(event -> {
            edit_a_book();
        });
    }

    private void edit_a_book() {
        int id_book = BooksDao.getInstance().gotIdByTitleAndAuthor(EditingBooksController.book.getTitle(), EditingBooksController.book.getAuthor());
        EditingBooksController.book.setTitle(title_field.getText());
        EditingBooksController.book.setAuthor(author_field.getText());
        EditingBooksController.book.setGenre(genre_field.getText());
        EditingBooksController.book.setYear(age_field.getText());
        EditingBooksController.book.setPages(pages_field.getText());
        EditingBooksController.book.setAge_restriction(age_restriction_field.getText());
        BooksDao.getInstance().editBook(id_book);
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
