package edu.aston.entity;

public class Book {

    private String title;

    private int requested;

    public Book() {}

    public Book(String title)
    {
        this.title = title;
        this.requested = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRequested() {
        return requested;
    }

    public void setRequested(int requested) {
        this.requested = requested;
    }
}
