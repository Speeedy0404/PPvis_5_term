package com.example.public_library.dao;

import com.example.public_library.*;
import com.example.public_library.modul.Books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDao extends Configs {

    private static BooksDao instance;
    private final String connectionString = "jdbc:postgresql://" + dbHost + ":"
            + dbPort + "/" + dbName;

    public static BooksDao getInstance() {
        if (instance == null) {
            instance = new BooksDao();
            return instance;
        }
        return instance;
    }

    public List<Books> getAllBooks() {
        List<Books> books = new ArrayList<>();
        String baseBooks = "SELECT * FROM " + Const.BOOKS_TABLE;

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(baseBooks)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Books book = new Books(resultSet.getString(Const.BOOKS_TITLE), resultSet.getString(Const.BOOKS_AUTHOR),
                        resultSet.getString(Const.BOOKS_GENRE), resultSet.getString(Const.BOOKS_YEAR),
                        resultSet.getString(Const.BOOKS_PAGES), resultSet.getString(Const.BOOKS_AGE_RESTRICTION));
                books.add(book);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return books;
    }

    public List<Books> findBookByTitle(String text) {
        List<Books> books = new ArrayList<>();
        String baseBooks = "SELECT * FROM " + Const.BOOKS_TABLE +
                " WHERE " + Const.BOOKS_TITLE + "=" + "'" + text + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(baseBooks)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Books book = new Books(resultSet.getString(Const.BOOKS_TITLE), resultSet.getString(Const.BOOKS_AUTHOR),
                        resultSet.getString(Const.BOOKS_GENRE), resultSet.getString(Const.BOOKS_YEAR),
                        resultSet.getString(Const.BOOKS_PAGES), resultSet.getString(Const.BOOKS_AGE_RESTRICTION));
                books.add(book);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return books;
    }

    public List<Books> findBookByGenre(String text) {
        List<Books> books = new ArrayList<>();
        String baseBooks = "SELECT * FROM " + Const.BOOKS_TABLE +
                " WHERE " + Const.BOOKS_GENRE + "=" + "'" + text + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(baseBooks)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Books book = new Books(resultSet.getString(Const.BOOKS_TITLE), resultSet.getString(Const.BOOKS_AUTHOR),
                        resultSet.getString(Const.BOOKS_GENRE), resultSet.getString(Const.BOOKS_YEAR),
                        resultSet.getString(Const.BOOKS_PAGES), resultSet.getString(Const.BOOKS_AGE_RESTRICTION));
                books.add(book);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return books;
    }

    public List<Books> findBookByAuthor(String text) {
        List<Books> books = new ArrayList<>();
        String baseBooks = "SELECT * FROM " + Const.BOOKS_TABLE +
                " WHERE " + Const.BOOKS_AUTHOR + "=" + "'" + text + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(baseBooks)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Books book = new Books(resultSet.getString(Const.BOOKS_TITLE), resultSet.getString(Const.BOOKS_AUTHOR),
                        resultSet.getString(Const.BOOKS_GENRE), resultSet.getString(Const.BOOKS_YEAR),
                        resultSet.getString(Const.BOOKS_PAGES), resultSet.getString(Const.BOOKS_AGE_RESTRICTION));
                books.add(book);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return books;
    }

    public List<Books> findBookByYearOfRelease(String text) {
        List<Books> books = new ArrayList<>();
        String baseBooks = "SELECT * FROM " + Const.BOOKS_TABLE +
                " WHERE " + Const.BOOKS_YEAR + "=" + "'" + text + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(baseBooks)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Books book = new Books(resultSet.getString(Const.BOOKS_TITLE), resultSet.getString(Const.BOOKS_AUTHOR),
                        resultSet.getString(Const.BOOKS_GENRE), resultSet.getString(Const.BOOKS_YEAR),
                        resultSet.getString(Const.BOOKS_PAGES), resultSet.getString(Const.BOOKS_AGE_RESTRICTION));
                books.add(book);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return books;
    }

    public String getTheTitleById(int anInt) {
        String title = "SELECT title FROM " + Const.BOOKS_TABLE +
                " WHERE " + Const.BOOKS_ID + "=" + "'" + anInt + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(title)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getString(Const.BOOKS_TITLE);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return title;
    }

    public String getTheAuthorById(int anInt) {
        String author = "SELECT author FROM " + Const.BOOKS_TABLE +
                " WHERE " + Const.BOOKS_ID + "=" + "'" + anInt + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(author)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getString(Const.BOOKS_AUTHOR);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return author;
    }

    public int gotIdByTitleAndAuthor() {
        String gotId = "SELECT id FROM " + Const.BOOKS_TABLE +
                " WHERE " + Const.BOOKS_TITLE + "=" + "'" + BookIssuanceController.issuedBooks.getTitle() + "'" + " and " +
                Const.BOOKS_AUTHOR + "=" + "'" + BookIssuanceController.issuedBooks.getAuthor() + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(gotId)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt(Const.BOOKS_ID);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int gotIdByTitleAndAuthor(String title, String author) {
        String gotId = "SELECT id FROM " + Const.BOOKS_TABLE +
                " WHERE " + Const.BOOKS_TITLE + "=" + "'" + title + "'" + " and " +
                Const.BOOKS_AUTHOR + "=" + "'" + author + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(gotId)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt(Const.BOOKS_ID);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public void deleteBook() {
        int id_book = gotIdByTitleAndAuthor(EditingBooksController.book.getTitle(), EditingBooksController.book.getAuthor());
        String del = "DELETE FROM  " + Const.BOOKS_TABLE
                + " WHERE " + Const.BOOKS_ID + "=" + id_book;

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(del)) {

            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editBook(int id_book) {
        String update = "UPDATE " + Const.BOOKS_TABLE + " SET "
                + Const.BOOKS_TITLE + "=" + "?" + ","
                + Const.BOOKS_AUTHOR + "=" + "?" + ","
                + Const.BOOKS_GENRE + "=" + "?" + ","
                + Const.BOOKS_YEAR + "=" + "?" + ","
                + Const.BOOKS_PAGES + "=" + "?" + ","
                + Const.BOOKS_AGE_RESTRICTION + "=" + "?"
                + " WHERE " + Const.BOOKS_ID + "=" + id_book;

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(update)) {

            statement.setString(1, EditingBooksController.book.getTitle());
            statement.setString(2, EditingBooksController.book.getAuthor());
            statement.setString(3, EditingBooksController.book.getGenre());
            statement.setString(4, EditingBooksController.book.getYear());
            statement.setString(5, EditingBooksController.book.getPages());
            statement.setString(6, EditingBooksController.book.getAge_restriction());

            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addBook() {
        if (gotIdByTitleAndAuthor(AddBookController.new_book.getTitle(), AddBookController.new_book.getAuthor()) == 0) {
            String insert = "INSERT INTO " + Const.BOOKS_TABLE + "("
                    + Const.BOOKS_TITLE + "," + Const.BOOKS_AUTHOR + "," +
                    Const.BOOKS_GENRE + "," + Const.BOOKS_YEAR + "," + Const.BOOKS_PAGES +
                    "," + Const.BOOKS_AGE_RESTRICTION + ")" + "VALUES(?,?,?,?,?,?)";


            try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
                 PreparedStatement statement = connection.prepareStatement(insert)) {

                statement.setString(1, AddBookController.new_book.getTitle());
                statement.setString(2, AddBookController.new_book.getAuthor());
                statement.setString(3, AddBookController.new_book.getGenre());
                statement.setString(4, AddBookController.new_book.getYear());
                statement.setString(5, AddBookController.new_book.getPages());
                statement.setString(6, AddBookController.new_book.getAge_restriction());

                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
