package edu.aston.repository;

import edu.aston.entity.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookRepository {

  public static Connection connectDB() {
    Connection connection = null;
    try {
      Class.forName("com.postgresql.jdbc.Driver");

      connection = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/booksharedb",
          "postgres", "postgres");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return connection;
  }

  public void addBook(Book book) {
    String query = "INSERT INTO books VALUES (?, ?) ON DUPLICATE KEY UPDATE requested = requested + 1";
    try (
        Connection connection = connectDB();
        PreparedStatement statement = connection.prepareStatement(query)
    ) {
      statement.setString(1, book.getTitle());
      statement.setInt(2, book.getRequested());
      statement.execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Book getBookByTitle(String title) {
    Book book = new Book();
    String query = "SELECT * FROM books WHERE title = ?";
    try (
        Connection connection = connectDB();
        PreparedStatement statement = connection.prepareStatement(query)
    ) {
      statement.setString(1, title);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        book.setTitle(resultSet.getString("title"));
        book.setRequested(resultSet.getInt("requested"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return book;
  }

  public void updateBook(Book book) {
    String query = "UPDATE books SET requested = ? WHERE title = ?";
    try (
        Connection connection = connectDB();
        PreparedStatement statement = connection.prepareStatement(query)
    ) {
      statement.setInt(1, book.getRequested());
      statement.setString(2, book.getTitle());
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void deleteBook(String title) {
    String query = "DELETE FROM books WHERE title = ?";
    try (
        Connection connection = connectDB();
        PreparedStatement statement = connection.prepareStatement(query)
    ) {
      statement.setString(1, title);
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void decrementRequested(Book book) {
    String query = "UPDATE books SET requested = requested - 1 where title = ?";
    try (
        Connection connection = connectDB();
        PreparedStatement statement = connection.prepareStatement(query)
    ) {
      statement.setString(1, book.getTitle());
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
