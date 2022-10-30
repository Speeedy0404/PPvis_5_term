package com.example.public_library.dao;

import com.example.public_library.AuthorizationController;
import com.example.public_library.Configs;
import com.example.public_library.Const;
import com.example.public_library.RegistrationController;
import com.example.public_library.modul.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Configs {

    private static UserDao instance;
    private final static String connectionString = "jdbc:postgresql://" + dbHost + ":"
            + dbPort + "/" + dbName;

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
            return instance;
        }
        return instance;
    }

    public void addUser() {
        String insert = "INSERT INTO " + Const.USER_TABLE + "("
                + Const.USER_SURNAME + "," + Const.USER_FIRST_NAME + "," + Const.USER_MIDDLE_NAME + ","
                + Const.USER_PHONE + "," + Const.USER_EMAIL + "," + Const.USER_PASSWORD
                + "," + Const.USER_ADMINISTRATOR + ")" + "VALUES(?,?,?,?,?,?,?)";

        if (checkTheUniquenessOfTheEmail()) {
            try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
                 PreparedStatement statement = connection.prepareStatement(insert)) {

                statement.setString(1, RegistrationController.registrationUser.getSurname());
                statement.setString(2, RegistrationController.registrationUser.getFirst_name());
                statement.setString(3, RegistrationController.registrationUser.getMiddle_name());
                statement.setString(4, RegistrationController.registrationUser.getPhone());
                statement.setString(5, RegistrationController.registrationUser.getEmail());
                statement.setString(6, RegistrationController.registrationUser.getPassword());
                statement.setBoolean(7, RegistrationController.registrationUser.getAdministrator());

                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public boolean checkTheUniquenessOfTheEmail() {
        String email = RegistrationController.registrationUser.getEmail();
        String sqlString = "SELECT * FROM " + Const.USER_TABLE;

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(sqlString)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (email.equals(resultSet.getString(Const.USER_EMAIL))) {
                    return false;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return true;

    }

    public boolean getUserByPasswordAndMail() {
        String getUserByPasswordAndMail = "SELECT * FROM " + Const.USER_TABLE +
                " WHERE " + Const.USER_PASSWORD + "=" + "'" + AuthorizationController.authorizationUser.getPassword() + "'" + " and " +
                Const.USER_EMAIL + "=" + "'" + AuthorizationController.authorizationUser.getEmail() + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(getUserByPasswordAndMail)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                AuthorizationController.authorizationUser.setSurname(resultSet.getString(Const.USER_SURNAME));
                AuthorizationController.authorizationUser.setFirst_name(resultSet.getString(Const.USER_FIRST_NAME));
                AuthorizationController.authorizationUser.setMiddle_name(resultSet.getString(Const.USER_MIDDLE_NAME));
                AuthorizationController.authorizationUser.setPhone(resultSet.getString(Const.USER_PHONE));
                AuthorizationController.authorizationUser.setAdministrator(resultSet.getBoolean(Const.USER_ADMINISTRATOR));
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;

    }

    public int getIdByEmail() {
        String getUserByPasswordAndMail = "SELECT * FROM " + Const.USER_TABLE +
                " WHERE " + Const.USER_EMAIL + "=" + "'" + AuthorizationController.authorizationUser.getEmail() + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(getUserByPasswordAndMail)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt(Const.USER_ID);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 1;
    }

    public int getIdByEmail(String email) {
        String getUserByPasswordAndMail = "SELECT * FROM " + Const.USER_TABLE +
                " WHERE " + Const.USER_EMAIL + "=" + "'" + email + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(getUserByPasswordAndMail)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt(Const.USER_ID);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 1;
    }

    public void updateUserInformation(int id) {
        String update = "UPDATE " + Const.USER_TABLE + " SET "
                + Const.USER_SURNAME + "=" + "?" + ","
                + Const.USER_FIRST_NAME + "=" + "?" + ","
                + Const.USER_MIDDLE_NAME + "=" + "?" + ","
                + Const.USER_PHONE + "=" + "?" + ","
                + Const.USER_EMAIL + "=" + "?" + ","
                + Const.USER_PASSWORD + "=" + "?" + ","
                + Const.USER_ADMINISTRATOR + "=" + "?"
                + " WHERE " + Const.USER_ID + "=" + id;

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(update)) {

            statement.setString(1, AuthorizationController.authorizationUser.getSurname());
            statement.setString(2, AuthorizationController.authorizationUser.getFirst_name());
            statement.setString(3, AuthorizationController.authorizationUser.getMiddle_name());
            statement.setString(4, AuthorizationController.authorizationUser.getPhone());
            statement.setString(5, AuthorizationController.authorizationUser.getEmail());
            statement.setString(6, AuthorizationController.authorizationUser.getPassword());
            statement.setBoolean(7, AuthorizationController.authorizationUser.getAdministrator());


            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String baseUsers = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_ADMINISTRATOR + "=" + "'" + false + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(baseUsers)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User(resultSet.getString(Const.USER_SURNAME), resultSet.getString(Const.USER_FIRST_NAME),
                        resultSet.getString(Const.USER_MIDDLE_NAME), resultSet.getString(Const.USER_PHONE),
                        resultSet.getString(Const.USER_EMAIL));
                users.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    public String getSurnameById(int anInt) {
        String surname = "SELECT surname FROM " + Const.USER_TABLE +
                " WHERE " + Const.USER_ID + "=" + "'" + anInt + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(surname)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getString(Const.USER_SURNAME);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return surname;
    }

    public String getNameById(int anInt) {
        String name = "SELECT first_name FROM " + Const.USER_TABLE +
                " WHERE " + Const.USER_ID + "=" + "'" + anInt + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(name)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getString(Const.USER_FIRST_NAME);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return name;
    }

    public String getMiddleNameById(int anInt) {
        String middle_name = "SELECT middle_name FROM " + Const.USER_TABLE +
                " WHERE " + Const.USER_ID + "=" + "'" + anInt + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(middle_name)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getString(Const.USER_MIDDLE_NAME);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return middle_name;
    }

    public String getEmailById(int anInt) {
        String email = "SELECT mail FROM " + Const.USER_TABLE +
                " WHERE " + Const.USER_ID + "=" + "'" + anInt + "'";

        try (Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(email)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getString(Const.USER_EMAIL);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return email;
    }
}
