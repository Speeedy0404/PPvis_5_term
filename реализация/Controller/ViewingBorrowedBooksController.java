package com.example.public_library;

import com.example.public_library.dao.IssuedBooksDao;
import com.example.public_library.modul.IssuedBooks;
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
import java.sql.Date;
import java.util.List;

public class ViewingBorrowedBooksController {


    @FXML
    private TableColumn<IssuedBooks, String> author_table;

    @FXML
    private TableView<IssuedBooks> borrowed_books_table;

    @FXML
    private Button menu_page;

    @FXML
    private TableColumn<IssuedBooks, Date> return_date_table;

    @FXML
    private TableColumn<IssuedBooks, String> title_table;

    @FXML
    void initialize() {
        List<IssuedBooks> issuedBooks = IssuedBooksDao.getInstance().getBorrowedBooksByUserId();
        ObservableList<IssuedBooks> observableListIssuedBooks = FXCollections.observableList(issuedBooks);

        title_table.setCellValueFactory(new PropertyValueFactory<IssuedBooks,String>("title"));
        author_table.setCellValueFactory(new PropertyValueFactory<IssuedBooks,String>("author"));
        return_date_table.setCellValueFactory(new PropertyValueFactory<IssuedBooks,Date>("return_date"));


        borrowed_books_table.setItems(observableListIssuedBooks);

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
