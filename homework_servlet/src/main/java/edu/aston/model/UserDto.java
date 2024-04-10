package edu.aston.model;

import edu.aston.entity.Book;
import java.util.List;

public class UserDto {

  private String username;

  private List<String> books;

  public UserDto() {}

  public UserDto(String username, List<String> books) {
    this.username = username;
    this.books = books;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<String> getBooks() {
    return books;
  }

  public void setBooks(List<String> books) {
    this.books = books;
  }
}
