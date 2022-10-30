package com.example.public_library.modul;

public class User {
    private String surname;
    private String first_name;
    private String middle_name;
    private String phone;
    private String email;
    private String password;
    private Boolean administrator;

    public User(String surname, String name, String middle_name, String phone, String email) {
        this.surname = surname;
        this.first_name = name;
        this.middle_name = middle_name;
        this.phone = phone;
        this.email = email;
    }

    public User(String surname, String name, String middle_name, String phone, String email, String password) {
        this.surname = surname;
        this.first_name = name;
        this.middle_name = middle_name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAdministrator() {
        return administrator;
    }
}
