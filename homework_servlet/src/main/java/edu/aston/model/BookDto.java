package edu.aston.model;

public class BookDto {

  private String title;

  private int requested;

  public BookDto() {}

  public BookDto(String title, int requested)
  {
    this.title = title;
    this.requested = requested;
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
