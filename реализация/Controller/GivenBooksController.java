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

public class GivenBooksController {

    public static IssuedBooks delete_issued;

    @FXML
    private TableColumn<IssuedBooks, String> author_table;

    @FXML
    private Button delete_given;

    @FXML
    private TableColumn<IssuedBooks, String> email_table;

    @FXML
    private Button menu_page;

    @FXML
    private TableColumn<IssuedBooks, String> middle_name_table;

    @FXML
    private TableColumn<IssuedBooks, String> name_table;

    @FXML
    private TableColumn<IssuedBooks, Date> returne_date_table;

    @FXML
    private TableColumn<IssuedBooks, String> surname_table;

    @FXML
    private TableColumn<IssuedBooks, String> title_table;

    @FXML
    private TableView<IssuedBooks> given_books_table;

    @FXML
    void initialize() {
        update_table();

        menu_page.setOnAction(event -> {
            menu_page.getScene().getWindow().hide();
            create_menu_administrator_widow();
        });
        delete_given.setOnAction(event -> {
            if (given_books_table.getSelectionModel().getSelectedItem()!=null) {
                GivenBooksController.delete_issued = (IssuedBooks) given_books_table.getSelectionModel().getSelectedItem();
                delete_issued_of_book();
            }
        });
    }

    private void delete_issued_of_book() {
        IssuedBooksDao.getInstance().deleteIssue();
        update_table();
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

    private void update_table(){
        List<IssuedBooks> givenBooks = IssuedBooksDao.getInstance().getIssuedBooks();
        ObservableList<IssuedBooks> observableListGivenBooks = FXCollections.observableList(givenBooks);

        author_table.setCellValueFactory(new PropertyValueFactory<IssuedBooks,String>("author"));
        email_table.setCellValueFactory(new PropertyValueFactory<IssuedBooks,String>("email"));
        middle_name_table.setCellValueFactory(new PropertyValueFactory<IssuedBooks,String>("middle_name"));
        name_table.setCellValueFactory(new PropertyValueFactory<IssuedBooks,String>("name"));
        returne_date_table.setCellValueFactory(new PropertyValueFactory<IssuedBooks,Date>("return_date"));
        surname_table.setCellValueFactory(new PropertyValueFactory<IssuedBooks,String>("surname"));
        title_table.setCellValueFactory(new PropertyValueFactory<IssuedBooks,String>("title"));


        given_books_table.setItems(observableListGivenBooks);
    }
}
