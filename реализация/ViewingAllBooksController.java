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

public class ViewingAllBooksController {


    @FXML
    private TableColumn<Books, String> age_restriction_table;

    @FXML
    private TableColumn<Books, String> age_table;

    @FXML
    private TableColumn<Books, String> author_table;

    @FXML
    private TableView<Books> books_table;

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

        List<Books> books = BooksDao.getInstance().getAllBooks();
        ObservableList<Books> observableListBooks = FXCollections.observableList(books);

        title_table.setCellValueFactory(new PropertyValueFactory<Books,String>("title"));
        author_table.setCellValueFactory(new PropertyValueFactory<Books,String>("author"));
        genre_table.setCellValueFactory(new PropertyValueFactory<Books,String>("genre"));
        age_table.setCellValueFactory(new PropertyValueFactory<Books,String>("year"));
        pages_table.setCellValueFactory(new PropertyValueFactory<Books,String>("pages"));
        age_restriction_table.setCellValueFactory(new PropertyValueFactory<Books,String>("age_restriction"));


        books_table.setItems(observableListBooks);

        menu_page.setOnAction(event -> {
            menu_page.getScene().getWindow().hide();
            create_menu_user_page_widow();
        });
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
