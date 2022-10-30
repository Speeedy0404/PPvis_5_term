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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class FindBookController {

    @FXML
    private Button find_four;

    @FXML
    private Button find_one;

    @FXML
    private Button find_three;

    @FXML
    private Button find_two;

    @FXML
    private TextField four_age_field;

    @FXML
    private TableColumn<Books, String> four_age_restriction_table;

    @FXML
    private TableColumn<Books, String> four_age_table;

    @FXML
    private TableColumn<Books, String> four_author_table;

    @FXML
    private TableColumn<Books, String> four_genre_table;

    @FXML
    private TableColumn<Books, String> four_pages_table;

    @FXML
    private TableColumn<Books, String> four_title_table;

    @FXML
    private Button menu_page;

    @FXML
    private TableColumn<Books, String> one_age_restriction_table;

    @FXML
    private TableColumn<Books, String> one_age_table;

    @FXML
    private TableColumn<Books, String> one_author_table;

    @FXML
    private TableColumn<Books, String> one_genre_table;

    @FXML
    private TableColumn<Books, String> one_pages_table;

    @FXML
    private TextField one_title_field;

    @FXML
    private TableColumn<Books, String> one_title_table;

    @FXML
    private TableView<Books> search_four;

    @FXML
    private TableView<Books> search_one;

    @FXML
    private TableView<Books> search_three;

    @FXML
    private TableView<Books> search_two;

    @FXML
    private TableColumn<Books, String> three_age_restriction_table;

    @FXML
    private TableColumn<Books, String> three_age_table;

    @FXML
    private TextField three_author_field;

    @FXML
    private TableColumn<Books, String> three_author_table;

    @FXML
    private TableColumn<Books, String> three_genre_table;

    @FXML
    private TableColumn<Books, String> three_pages_table;

    @FXML
    private TableColumn<Books, String> three_title_table;

    @FXML
    private TableColumn<Books, String> two_age_restriction_table;

    @FXML
    private TableColumn<Books, String> two_age_table;

    @FXML
    private TableColumn<Books, String> two_author_table;

    @FXML
    private TextField two_genre_field;

    @FXML
    private TableColumn<Books, String> two_genre_table;

    @FXML
    private TableColumn<Books, String> two_pages_table;

    @FXML
    private TableColumn<Books, String> two_title_table;

    @FXML
    void initialize() {

        menu_page.setOnAction(event -> {
            menu_page.getScene().getWindow().hide();
            if (AuthorizationController.authorizationUser.getAdministrator()) {
                create_menu_administrator_widow();
            } else {
                create_menu_user_page_widow();
            }
        });

        find_one.setOnAction(event -> {
            first_search();
        });

        find_two.setOnAction(event -> {
            second_search();
        });

        find_three.setOnAction(event -> {
            third_search();
        });

        find_four.setOnAction(event -> {
            fourth_search();
        });

    }

    private void fourth_search() {
        List<Books> booksFourth = BooksDao.getInstance().findBookByYearOfRelease(four_age_field.getText());
        ObservableList<Books> observableListBooksFour = FXCollections.observableList(booksFourth);

        four_title_table.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        four_author_table.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
        four_genre_table.setCellValueFactory(new PropertyValueFactory<Books, String>("genre"));
        four_age_table.setCellValueFactory(new PropertyValueFactory<Books, String>("year"));
        four_pages_table.setCellValueFactory(new PropertyValueFactory<Books, String>("pages"));
        four_age_restriction_table.setCellValueFactory(new PropertyValueFactory<Books, String>("age_restriction"));


        search_four.setItems(observableListBooksFour);
    }

    private void third_search() {
        List<Books> booksthird = BooksDao.getInstance().findBookByAuthor(three_author_field.getText());
        ObservableList<Books> observableListBooksThree = FXCollections.observableList(booksthird);

        three_title_table.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        three_author_table.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
        three_genre_table.setCellValueFactory(new PropertyValueFactory<Books, String>("genre"));
        three_age_table.setCellValueFactory(new PropertyValueFactory<Books, String>("year"));
        three_pages_table.setCellValueFactory(new PropertyValueFactory<Books, String>("pages"));
        three_age_restriction_table.setCellValueFactory(new PropertyValueFactory<Books, String>("age_restriction"));


        search_three.setItems(observableListBooksThree);
    }

    private void second_search() {
        List<Books> booksSecond = BooksDao.getInstance().findBookByGenre(two_genre_field.getText());
        ObservableList<Books> observableListBooksTwo = FXCollections.observableList(booksSecond);

        two_title_table.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        two_author_table.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
        two_genre_table.setCellValueFactory(new PropertyValueFactory<Books, String>("genre"));
        two_age_table.setCellValueFactory(new PropertyValueFactory<Books, String>("year"));
        two_pages_table.setCellValueFactory(new PropertyValueFactory<Books, String>("pages"));
        two_age_restriction_table.setCellValueFactory(new PropertyValueFactory<Books, String>("age_restriction"));


        search_two.setItems(observableListBooksTwo);
    }

    private void first_search() {
        List<Books> booksFirs = BooksDao.getInstance().findBookByTitle(one_title_field.getText());
        ObservableList<Books> observableListBooksOne = FXCollections.observableList(booksFirs);

        one_title_table.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        one_author_table.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
        one_genre_table.setCellValueFactory(new PropertyValueFactory<Books, String>("genre"));
        one_age_table.setCellValueFactory(new PropertyValueFactory<Books, String>("year"));
        one_pages_table.setCellValueFactory(new PropertyValueFactory<Books, String>("pages"));
        one_age_restriction_table.setCellValueFactory(new PropertyValueFactory<Books, String>("age_restriction"));


        search_one.setItems(observableListBooksOne);
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
