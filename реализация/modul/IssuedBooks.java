package com.example.public_library.modul;

import java.sql.Date;

public class IssuedBooks {
    private String surname;
    private String name;
    private String middle_name;
    private String email;
    private String title;
    private String author;
    private Date return_date;

    public IssuedBooks(String surname, String name, String middle_name, String email, String title, String author, Date return_date) {
        this.surname = surname;
        this.name = name;
        this.middle_name = middle_name;
        this.email = email;
        this.title = title;
        this.author = author;
        this.return_date = return_date;
    }

    public IssuedBooks(String title, String author, Date return_date) {
        this.title = title;
        this.author = author;
        this.return_date = return_date;
    }

    public IssuedBooks(String email, String title, String author, Date return_date) {
        this.email = email;
        this.title = title;
        this.author = author;
        this.return_date = return_date;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getReturn_date() {
        return return_date;
    }
}
