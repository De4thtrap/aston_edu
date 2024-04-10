package edu.aston.entity;

import java.util.Arrays;
import java.util.List;

public class User {

    private String username;

    private List<Book> books;

    public User() {}

    public User(String username) {
        this.username = username;
    }

    public User(String username, Book book) {
        this.username = username;
        this.books = Arrays.asList(book);
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
