package com.example.public_library.modul;

public class Books {

    private String title;
    private String author;
    private String genre;
    private String year;
    private String pages;
    private String age_restriction;

    public Books(String title, String author, String genre, String year, String pages, String age_restriction) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.pages = pages;
        this.age_restriction = age_restriction;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setAge_restriction(String age_restriction) {
        this.age_restriction = age_restriction;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public String getPages() {
        return pages;
    }

    public String getAge_restriction() {
        return age_restriction;
    }
}
