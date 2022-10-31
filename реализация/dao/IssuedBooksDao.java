package com.example.public_library.dao;

import com.example.public_library.*;
import com.example.public_library.modul.IssuedBooks;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IssuedBooksDao extends Configs {

    private static IssuedBooksDao instance;
    private final String connectionString = "jdbc:postgresql://" + dbHost + ":"
            + dbPort + "/" + dbName;

    public static IssuedBooksDao getInstance() {
        if (instance == null) {
            instance = new IssuedBooksDao();
            return instance;
        }
        return instance;
    }

    public List<IssuedBooks> getBorrowedBooksByUserId() {
        int id_user = UserDao.getInstance().getIdByEmail();
        List<IssuedBooks> issuedBooks = new ArrayList<>();
        String baseIssuedBooks = "SELECT * FROM " + Const.ISSUED_BOOKS_TABLE +
                " WHERE " + Const.ISSUED_BOOKS_USER_ID + "=" + id_user;

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(baseIssuedBooks)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                IssuedBooks book = new IssuedBooks(BooksDao.getInstance().getTheTitleById(resultSet.getInt(Const.ISSUED_BOOKS_BOOKS_ID)),
                        BooksDao.getInstance().getTheAuthorById(resultSet.getInt(Const.ISSUED_BOOKS_BOOKS_ID)),
                        resultSet.getDate(Const.ISSUED_BOOKS_RETURN_DATE));
                issuedBooks.add(book);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return issuedBooks;
    }

    public void addIssued() {
        int id_book = BooksDao.getInstance().gotIdByTitleAndAuthor();
        if (id_book != 0) {
            if (checkTheAvailabilityOfTheIssueByTheUserIdAndTheBook(UserDao.getInstance().getIdByEmail(ViewingAllUsersController.user_book_issuance.getEmail()), BooksDao.getInstance().gotIdByTitleAndAuthor())) {
                String insert = "INSERT INTO " + Const.ISSUED_BOOKS_TABLE + "("
                        + Const.ISSUED_BOOKS_USER_ID + "," + Const.ISSUED_BOOKS_BOOKS_ID + "," +
                        Const.ISSUED_BOOKS_RETURN_DATE + ")" + "VALUES(?,?,?)";


                try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
                     PreparedStatement statement = connection.prepareStatement(insert)) {

                    statement.setInt(1, UserDao.getInstance().getIdByEmail(ViewingAllUsersController.user_book_issuance.getEmail()));
                    statement.setInt(2, BooksDao.getInstance().gotIdByTitleAndAuthor());
                    statement.setDate(3, BookIssuanceController.issuedBooks.getReturn_date());

                    statement.executeUpdate();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public boolean checkTheAvailabilityOfTheIssueByTheUserIdAndTheBook(int idByEmail, int gotIdByTitleAndAuthor) {
        String check_the_availability_of_the_issue = "SELECT * FROM " + Const.ISSUED_BOOKS_TABLE +
                " WHERE " + Const.ISSUED_BOOKS_BOOKS_ID + "=" + gotIdByTitleAndAuthor +
                " AND " + Const.ISSUED_BOOKS_USER_ID + "=" + idByEmail;

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(check_the_availability_of_the_issue)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return true;
    }

    public List<IssuedBooks> getIssuedBooks() {
        List<IssuedBooks> issuedBooks = new ArrayList<>();
        String baseIssuedBooks = "SELECT * FROM " + Const.ISSUED_BOOKS_TABLE;

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(baseIssuedBooks)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                IssuedBooks book = new IssuedBooks(UserDao.getInstance().getSurnameById(resultSet.getInt(Const.ISSUED_BOOKS_USER_ID)),
                        UserDao.getInstance().getNameById(resultSet.getInt(Const.ISSUED_BOOKS_USER_ID)),
                        UserDao.getInstance().getMiddleNameById(resultSet.getInt(Const.ISSUED_BOOKS_USER_ID)),
                        UserDao.getInstance().getEmailById(resultSet.getInt(Const.ISSUED_BOOKS_USER_ID)),
                        BooksDao.getInstance().getTheTitleById(resultSet.getInt(Const.ISSUED_BOOKS_BOOKS_ID)),
                        BooksDao.getInstance().getTheAuthorById(resultSet.getInt(Const.ISSUED_BOOKS_BOOKS_ID)),
                        resultSet.getDate(Const.ISSUED_BOOKS_RETURN_DATE));
                issuedBooks.add(book);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return issuedBooks;
    }

    public void deleteIssue() {
        int id_user = UserDao.getInstance().getIdByEmail(GivenBooksController.delete_issued.getEmail());
        int id_book = BooksDao.getInstance().gotIdByTitleAndAuthor(GivenBooksController.delete_issued.getTitle(), GivenBooksController.delete_issued.getAuthor());
        String del = "DELETE FROM  " + Const.ISSUED_BOOKS_TABLE
                + " WHERE " + Const.ISSUED_BOOKS_USER_ID + "=" + id_user +
                " AND " + Const.ISSUED_BOOKS_BOOKS_ID + "=" + id_book;

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(del)) {

            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
