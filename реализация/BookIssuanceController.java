package com.example.public_library;

import com.example.public_library.dao.BooksDao;
import com.example.public_library.dao.IssuedBooksDao;
import com.example.public_library.modul.IssuedBooks;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

public class BookIssuanceController {

    public static IssuedBooks issuedBooks;

    @FXML
    private TextField author_field;

    @FXML
    private Button give_book;

    @FXML
    private DatePicker return_date_field;

    @FXML
    private TextField title_field;

    @FXML
    private Button viewing_all_users_page;

    @FXML
    void initialize() {
        viewing_all_users_page.setOnAction(event -> {
            viewing_all_users_page.getScene().getWindow().hide();
            create_viewing_all_users_widow();
        });
        give_book.setOnAction(event -> {
            issue_a_book();
        });
    }

    private void issue_a_book() {
        issuedBooks = new IssuedBooks(title_field.getText(),author_field.getText(),
                Date.valueOf(return_date_field.getValue()));
        int id_book = BooksDao.getInstance().gotIdByTitleAndAuthor();
        if (id_book!=0){
            IssuedBooksDao.getInstance().addIssued();
        }
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
}
