package com.example.public_library;

import com.example.public_library.dao.BooksDao;
import com.example.public_library.modul.Books;
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

public class EditingBooksController {

    public static Books book;

    @FXML
    private Button add_book;

    @FXML
    private TableColumn<Books, String> age_restriction_table;

    @FXML
    private TableColumn<Books, String> age_table;

    @FXML
    private TableColumn<Books, String> author_table;

    @FXML
    private TableView<Books> books_table;

    @FXML
    private Button delete_book;

    @FXML
    private Button editing_book;

    @FXML
    private TableColumn<Books, String> genre_table;

    @FXML
    private Button menu_page;

    @FXML
    private TableColumn<Books, String> pages_table;

    @FXML
    private TableColumn<Books, String> title_table;

    @FXML
    void initialize() {
        update_table();

        menu_page.setOnAction(event -> {
            menu_page.getScene().getWindow().hide();
            create_menu_administrator_widow();
        });

        editing_book.setOnAction(event -> {
            if (books_table.getSelectionModel().getSelectedItem() != null) {
                EditingBooksController.book = (Books) books_table.getSelectionModel().getSelectedItem();
                editing_book.getScene().getWindow().hide();
                create_editing_book_widow();
            }
        });

        add_book.setOnAction(event -> {
            add_book.getScene().getWindow().hide();
            create_add_book_widow();
        });

        delete_book.setOnAction(event -> {
            if (books_table.getSelectionModel().getSelectedItem() != null) {
                EditingBooksController.book = (Books) books_table.getSelectionModel().getSelectedItem();
                delete_book_from_library();
            }
        });
    }

    private void delete_book_from_library() {
        BooksDao.getInstance().deleteBook();
        update_table();
    }

    public void create_add_book_widow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("add_book.fxml"));

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

    public void create_editing_book_widow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editing_book.fxml"));

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

    private void update_table() {
        List<Books> books = BooksDao.getInstance().getAllBooks();
        ObservableList<Books> observableListBooks = FXCollections.observableList(books);

        title_table.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        author_table.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
        genre_table.setCellValueFactory(new PropertyValueFactory<Books, String>("genre"));
        age_table.setCellValueFactory(new PropertyValueFactory<Books, String>("year"));
        pages_table.setCellValueFactory(new PropertyValueFactory<Books, String>("pages"));
        age_restriction_table.setCellValueFactory(new PropertyValueFactory<Books, String>("age_restriction"));


        books_table.setItems(observableListBooks);
    }
}
